
package bibliotecagrupo5.controlador;

import bibliotecagrupo5.modelo.Conexion;
import bibliotecagrupo5.modelo.Lector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public List<Lector> listarLectoresMorosos(){
        List<Lector> deudores = new ArrayList<>();
        String query = "no se";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lector l = new Lector();
                l.setDni_lector(rs.getInt("dni_lector"));
                l.setNombre_lector(rs.getString("nombre_lector"));
                l.setApellido_lector(rs.getString("apellido_lector"));
                l.setEstado_lector(rs.getBoolean("estado"));
                deudores.add(l);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al listar deudores");
        }
        return deudores;
    }

}
