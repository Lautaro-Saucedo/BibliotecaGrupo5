package bibliotecagrupo5.controlador;

import bibliotecagrupo5.modelo.Conexion;
import bibliotecagrupo5.modelo.Ejemplar;
import bibliotecagrupo5.modelo.Lector;
import bibliotecagrupo5.modelo.Multa;
import bibliotecagrupo5.modelo.Prestamo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/* @author @LXWeber Leandro Xavier Weber */
public class PrestamoData {

    public Connection con;

    public PrestamoData() {
        con = Conexion.getConexion();
    }

    public void agregarPrestamo(Prestamo p) {
        String query = "INSERT INTO prestamo VALUES (null,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, p.getLector().getDni_lector());
            ps.setInt(2, p.getMulta().getId_multa());
            ps.setInt(3, p.getEjemplar().getId_ejemplar());
            ps.setDate(4, Date.valueOf(p.getFecha_inicio()));
            ps.setDate(5, Date.valueOf(p.getFecha_fin()));
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Se registro correctamente.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            p.setId_prestamo(rs.getInt(1));
            ps.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    public List<Prestamo> listarPrestamos() {
        List<Prestamo> lista = new ArrayList<>();
        String query = "SELECT * FROM prestamo WHERE fecha_fin IS NULL";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Prestamo p = new Prestamo();
                Lector l = new Lector();
                Multa m = new Multa();
                Ejemplar e = new Ejemplar();
                p.setId_prestamo(rs.getInt(1));
                l.setDni_lector(rs.getInt(2));
                m.setId_multa(rs.getInt(3));
                e.setId_ejemplar(rs.getInt(4));
                p.setFecha_inicio(rs.getDate(5).toLocalDate());
                p.setFecha_fin(rs.getDate(6).toLocalDate());
                p.setLector(l);
                p.setMulta(m);
                p.setEjemplar(e);
                lista.add(p);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public List<Prestamo> listarDevoluciones() {
        List<Prestamo> lista = new ArrayList<>();
        String query = "SELECT * FROM prestamo WHERE fecha_fin IS NOT NULL";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Prestamo p = new Prestamo();
                Lector l = new Lector();
                Multa m = new Multa();
                Ejemplar e = new Ejemplar();
                p.setId_prestamo(rs.getInt(1));
                l.setDni_lector(rs.getInt(2));
                m.setId_multa(rs.getInt(3));
                e.setId_ejemplar(rs.getInt(4));
                p.setFecha_inicio(rs.getDate(5).toLocalDate());
                p.setFecha_fin(rs.getDate(6).toLocalDate());
                p.setLector(l);
                p.setMulta(m);
                p.setEjemplar(e);
                lista.add(p);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public List<Prestamo> listarRetrasos() {
        List<Prestamo> lista = new ArrayList<>();
        String query = "SELECT * FROM prestamo WHERE id_multa != -1";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Prestamo p = new Prestamo();
                Lector l = new Lector();
                Multa m = new Multa();
                Ejemplar e = new Ejemplar();
                p.setId_prestamo(rs.getInt(1));
                l.setDni_lector(rs.getInt(2));
                m.setId_multa(rs.getInt(3));
                e.setId_ejemplar(rs.getInt(4));
                p.setFecha_inicio(rs.getDate(5).toLocalDate());
                p.setFecha_fin(rs.getDate(6).toLocalDate());
                p.setLector(l);
                p.setMulta(m);
                p.setEjemplar(e);
                lista.add(p);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public List<Prestamo> listarSinRetrasos() {
        List<Prestamo> lista = new ArrayList<>();
        String query = "SELECT * FROM prestamo WHERE id_multa = -1";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Prestamo p = new Prestamo();
                Lector l = new Lector();
                Multa m = new Multa();
                Ejemplar e = new Ejemplar();
                p.setId_prestamo(rs.getInt(1));
                l.setDni_lector(rs.getInt(2));
                m.setId_multa(rs.getInt(3));
                e.setId_ejemplar(rs.getInt(4));
                p.setFecha_inicio(rs.getDate(5).toLocalDate());
                p.setFecha_fin(rs.getDate(6).toLocalDate());
                p.setLector(l);
                p.setMulta(m);
                p.setEjemplar(e);
                lista.add(p);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public int prestamosActuales(Lector l) {
        int aux = -1;
        String query = "SELECT COUNT(*) FROM prestamo WHERE id_lector = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, l.getDni_lector());
            ResultSet rs = ps.executeQuery();
            rs.next();
            aux = rs.getInt(1);
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
    }

    public void actualizar(Prestamo p) {
        String query = "UPDATE prestamo SET id_multa=?,fecha_fin=? WHERE id_prestamo=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, p.getMulta().getId_multa());
            ps.setDate(2, Date.valueOf(p.getFecha_fin()));
            ps.setInt(3, p.getId_prestamo());
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Actualizado con exito.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizarMultas(){
        MultaData md = new MultaData();
        List<Prestamo> lista = listarSinRetrasos();
        lista.forEach(p ->{
            Prestamo aux = (Prestamo) p;
            if (aux.getFecha_inicio().plusDays(30).compareTo(LocalDate.now()) > 0 ){
                Multa m = new Multa(LocalDate.now(),null);
                md.agregarMulta(m);
                aux.setMulta(m);
                actualizar(p);
            }
        });
    }
}
