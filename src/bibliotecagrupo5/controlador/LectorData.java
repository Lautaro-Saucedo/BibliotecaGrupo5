
package bibliotecagrupo5.controlador;

import bibliotecagrupo5.modelo.Conexion;
import bibliotecagrupo5.modelo.Lector;
import bibliotecagrupo5.modelo.Multa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/* @author @LXWeber Leandro Xavier Weber */

public class LectorData {
    private Connection con;
    
    public LectorData(){
        con = Conexion.getConexion();
    }
    
    public void registrarLector(Lector lector){
        String query = "INSERT INTO lector(dni_lector, nombre_lector, apellido_lector, estado) VALUES (?,?,?,?)";
        try{
            
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, lector.getDni_lector());
            ps.setString(2, lector.getNombre_lector());
            ps.setString(3, lector.getApellido_lector());
            ps.setBoolean(4, lector.isEstado_lector());
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Lector guardado correctamente");
            }
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al guardar lector, asgurese que el dni no este repetido");         
        }
    }
    
    public List<Lector> listarLectores(){
        List<Lector> lectores = new ArrayList<>();
        String query = "SELECT * FROM lector";
        try {
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Lector l = new Lector();
                l.setDni_lector(rs.getInt("dni_lector"));
                l.setNombre_lector(rs.getString("nombre_lector"));
                l.setApellido_lector(rs.getString("apellido_lector"));
                l.setEstado_lector(rs.getBoolean("estado"));
                lectores.add(l);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar lectores");
        }
        
        return lectores;
    }
    
    public void borrarLectorFisico(int dni){
         String query = "DELETE FROM lector WHERE dni_lector=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, dni);

            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Borrado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "El lector que se desea borrar no existe");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al borrar lector, el lector tiene prestamos activos");
        }
    }
    
    public void borrarLectorLogico(int dni){
        String query = "UPDATE lector SET estado=false WHERE dni_lector=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setLong(1, dni);
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Lector deshabilitado.");
            } else {
                JOptionPane.showMessageDialog(null, "No existe un lector con el dni pasado por parametro.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar estado del lector.");
        }
    }
    
    public void restaurarLector(int dni) {
        String query = "UPDATE lector SET estado=true WHERE dni_lector=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setLong(1, dni);
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Lector Habilitado.");
            } else {
                JOptionPane.showMessageDialog(null, "No existe un lector con ese dni.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar estado del lector.");
        }
    }
    
    public void actualizarLector(Lector l) {
        String query = "UPDATE lector SET nombre_lector=?,apellido_lector=?,estado=? WHERE dni_lector=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, l.getNombre_lector());
            ps.setString(2, l.getApellido_lector());
            ps.setBoolean(3, l.isEstado_lector());
            ps.setInt(4, l.getDni_lector());

            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "El lector se modifico correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se actualizo el lector");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar lector");
        }
    }
    
    public Lector buscarLector(int dni) {
        Lector l = new Lector();
        String query ="SELECT dni_lector, nombre_lector, apellido_lector, estado FROM lector WHERE dni_lector=?"; 
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                l.setDni_lector(rs.getInt("dni_lector"));
                l.setNombre_lector(rs.getString("nombre_lector"));
                l.setApellido_lector(rs.getString("apellido_lector"));
                l.setEstado_lector(rs.getBoolean("estado"));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar lector");

        }
        return l;
    }
    
    public boolean estadoLector(Lector l){
        PrestamoData pd = new PrestamoData();
        for (Multa m: pd.multasDeLector(l)){
            if (m.getFecha_fin().equals(null) || m.getFecha_fin().compareTo(LocalDate.now()) > 0){
                borrarLectorLogico(l.getDni_lector());
                return false;
            }
        }
        restaurarLector(l.getDni_lector());
        return true;
    }
    
}
