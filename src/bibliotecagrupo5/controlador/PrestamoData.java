package bibliotecagrupo5.controlador;

import bibliotecagrupo5.modelo.Conexion;
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

    private Connection con;

    public PrestamoData() {
        con = Conexion.getConexion();
    }

    public void agregarPrestamo(Prestamo p) {
        EjemplarData ed = new EjemplarData();
        String query = "INSERT INTO prestamo VALUES (null,?,?,?,?,?)";
        if (validarPrestamo(p)) {
            try {
                PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, p.getLector().getDni_lector());
                if (p.getMulta() != null) {
                    ps.setInt(2, p.getMulta().getId_multa());
                } else {
                    ps.setNull(2, java.sql.Types.INTEGER);
                }
                ps.setInt(3, p.getEjemplar().getId_ejemplar());
                ps.setDate(4, Date.valueOf(p.getFecha_inicio()));
                if (p.getFecha_fin() != null) {
                    ps.setDate(5, Date.valueOf(p.getFecha_fin()));
                } else {
                    ps.setNull(5, java.sql.Types.DATE);
                }
                if (ps.executeUpdate() == 1) {
                    JOptionPane.showMessageDialog(null, "Se registro correctamente.");
                }
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                p.setId_prestamo(rs.getInt(1));
                ps.close();
                ed.cambiarEstado(p.getEjemplar(), 0);
            } catch (SQLException sqle) {
                System.out.println(sqle.getMessage());
            }
        } else {
        }
    }
    
    public Prestamo buscar(int id) {
        String query = "SELECT * FROM prestamo WHERE id_prestamo=?";
        Prestamo p = null;
        EjemplarData ed = new EjemplarData();
        LectorData ld = new LectorData();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Multa m = null;
                if (rs.getInt(3) != 0) {
                    MultaData md = new MultaData();
                    m = md.buscar(rs.getInt(3));
                }
                p = new Prestamo();
                p.setId_prestamo(id);
                p.setLector(ld.buscarLector(rs.getInt(2)));
                p.setMulta(m);
                p.setEjemplar(ed.buscarEjemplar(rs.getInt(4)));
                p.setFecha_inicio(rs.getDate(5).toLocalDate());
                if (rs.getDate(6) != null) {
                    p.setFecha_fin(rs.getDate(6).toLocalDate());
                } else {
                    p.setFecha_fin(null);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro.");
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(PrestamoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    public List<Prestamo> listarPrestamos() {
        List<Prestamo> lista = new ArrayList<>();
        String query = "SELECT * FROM prestamo WHERE fecha_fin IS NULL";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            llenarlistaP(ps.executeQuery(), lista);
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public List<Prestamo> listarPrestamos(LocalDate fecha) {
        List<Prestamo> lista = new ArrayList<>();
        String query = "SELECT * FROM prestamo WHERE fecha_inicio = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDate(1, Date.valueOf(fecha));
            llenarlistaP(ps.executeQuery(), lista);
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public List<Prestamo> listarPrestamos(Lector l) {
        List<Prestamo> lista = new ArrayList<>();
        String query = "SELECT * FROM prestamo WHERE id_lector = ? AND fecha_fin IS NULL";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, l.getDni_lector());
            llenarlistaP(ps.executeQuery(), lista);
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
            llenarlistaP(ps.executeQuery(), lista);
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public List<Prestamo> listarRetrasos() {
        List<Prestamo> lista = new ArrayList<>();
        String query = "SELECT * FROM prestamo WHERE id_multa IS NOT NULL AND fecha_fin IS NULL";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            llenarlistaP(ps.executeQuery(), lista);
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public List<Prestamo> listarSinRetrasos() {
        List<Prestamo> lista = new ArrayList<>();
        String query = "SELECT * FROM prestamo WHERE id_multa IS NULL AND fecha_fin IS NULL";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            llenarlistaP(ps.executeQuery(), lista);
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public List<Lector> lectoresMultados() {
        List<Lector> lista = new ArrayList<>();
        String query = "SELECT lector.* FROM lector,prestamo WHERE dni_lector=id_lector AND id_multa IS NOT NULL";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            llenarlistaL(ps.executeQuery(), lista);
            ps.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return lista;
    }

    public List<Lector> lectoresMultados(int mes) {
        List<Lector> lista = new ArrayList<>();
        String query = "SELECT lector.* FROM lector,prestamo WHERE dni_lector=id_lector AND id_multa IS NOT NULL AND MONTH(fecha_inicio) = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, mes);
            llenarlistaL(ps.executeQuery(), lista);
            ps.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return lista;
    }
    
    public List<Multa> multasDeLector(Lector l){
        List<Multa> lista = new ArrayList<>();
        MultaData md = new MultaData();
        String query = "SELECT multa.id_multa FROM multa,prestamo WHERE prestamo.id_multa=multa.id_multa AND prestamo.id_lector=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, l.getDni_lector());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                lista.add(md.buscar(rs.getInt(1)));
            }
            ps.close();
        } catch(SQLException sqle){
            System.out.println(sqle.getMessage());
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
            if (p.getMulta() != null) {
                ps.setInt(1, p.getMulta().getId_multa());
            } else {
                ps.setNull(1, java.sql.Types.INTEGER);
            }
            if (p.getFecha_fin() != null) {
                ps.setDate(2, Date.valueOf(p.getFecha_fin()));
            } else {
                ps.setNull(2, java.sql.Types.DATE);
            }
            ps.setInt(3, p.getId_prestamo());
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Actualizado con exito.");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void generarMultas() {
        MultaData md = new MultaData();
        EjemplarData ed = new EjemplarData();
        LectorData ld = new LectorData();
        List<Prestamo> lista = listarSinRetrasos();
        for (Prestamo p : lista) {
            if ((p.getFecha_inicio().plusDays(30)).compareTo(LocalDate.now()) < 0) {
                Multa m = new Multa(p.getFecha_inicio().plusDays(30), null);
                md.agregarMulta(m);
                p.setMulta(m);
                actualizar(p);
                ed.cambiarEstado(p.getEjemplar(), 2);
                ld.borrarLectorLogico(p.getLector().getDni_lector());
            }
        }
    }

    public void registrarDevolucion(Prestamo p) {
        EjemplarData ed = new EjemplarData();
        if (p.getMulta() != null) {
            MultaData md = new MultaData();
            p.getMulta().setFecha_fin(LocalDate.now().plusDays(2));
            for (Prestamo aux : listarDevoluciones()) {
                if (aux.getMulta() != null && !aux.getMulta().equals(p.getMulta()) && aux.getLector().getDni_lector() == p.getLector().getDni_lector()) {
                    if (aux.getMulta().getFecha_fin() != null && aux.getMulta().getFecha_fin().compareTo(LocalDate.now()) > 0) {
                        aux.getMulta().setFecha_fin(aux.getMulta().getFecha_fin().plusDays(2));
                        p.getMulta().setFecha_fin(aux.getMulta().getFecha_fin());
                        md.actualizar(aux.getMulta());
                        md.actualizar(p.getMulta());
                    }
                }
            }
            md.actualizar(p.getMulta());
        }
        p.setFecha_fin(LocalDate.now());
        actualizar(p);
        ed.cambiarEstado(p.getEjemplar(), 1);
    }

    public void eliminarPrestamo(Prestamo p) {
        MultaData md = new MultaData();
        String query = "DELETE FROM prestamo WHERE id_prestamo=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, p.getId_prestamo());
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Eliminado con exito.");
                if (p.getMulta()!=null){
                    md.eliminarMulta(p.getMulta());
                }
            }
            ps.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    private List<Prestamo> llenarlistaP(ResultSet rs, List<Prestamo> lista) {
        MultaData md = new MultaData();
        LectorData ld = new LectorData();
        EjemplarData ed = new EjemplarData();
        try {
            while (rs.next()) {
                Prestamo p = new Prestamo();
                Multa m = null;
                if (rs.getInt(3) != 0) {
                    m = md.buscar(rs.getInt(3));
                }
                p.setId_prestamo(rs.getInt(1));
                p.setLector(ld.buscarLector(rs.getInt(2)));
                p.setMulta(m);
                p.setEjemplar(ed.buscarEjemplar(rs.getInt(4)));
                p.setFecha_inicio(rs.getDate(5).toLocalDate());
                if (rs.getDate(6) != null) {
                    p.setFecha_fin(rs.getDate(6).toLocalDate());
                } else {
                    p.setFecha_fin(null);
                }
                lista.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    private List<Lector> llenarlistaL(ResultSet rs, List<Lector> lista) {
        try {
            while (rs.next()) {
                Lector l = new Lector();
                l.setDni_lector(rs.getInt(1));
                l.setNombre_lector(rs.getString(2));
                l.setApellido_lector(rs.getString(3));
                l.setEstado_lector(rs.getBoolean(4));
                lista.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    private boolean validarPrestamo(Prestamo p){
        LectorData ld = new LectorData();
        if (prestamosActuales(p.getLector())>=3){
            return false;
        }
        if(lectoresMultados().contains(p.getLector())){
            return false;
        }
        if(p.getEjemplar().getEstado() != 1){
            return false;
        }
        return ld.estadoLector(p.getLector());
    }
    
    //<editor-fold defaultstate="collapsed" desc="version "logica" de agregar,ya que al momento de crear un prestamo, la fecha es hoy,no tiene multa, y tampoco fecha de entrega">
    /*
    public void agregarPrestamo(Prestamo p) {
        String query = "INSERT INTO prestamo VALUES (null,?,null,?,?,null)";
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, p.getLector().getDni_lector());
            ps.setInt(2, p.getEjemplar().getId_ejemplar());
            ps.setDate(3, Date.valueOf(LocalDate.now()));
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
     */
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="version completa de actualizar">
    /*
    public void actualizar(Prestamo p) {
        String query = "UPDATE prestamo SET id_lector = ?, id_multa = ?, id_ejemplar = ?, fecha_inicio = ?, fecha_fin = ? WHERE id_prestamo = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            if (p.getLector() != null) {
                ps.setInt(1, p.getLector().getDni_lector());
            } else {
                ps.setNull(1, java.sql.Types.INTEGER);
            }
            if (p.getMulta() != null) {
                ps.setInt(2, p.getMulta().getId_multa());
            } else {
                ps.setNull(2, java.sql.Types.INTEGER);
            }
            if (p.getEjemplar() != null) {
                ps.setInt(3, p.getEjemplar().getId_ejemplar());
            } else {
                ps.setNull(3, java.sql.Types.INTEGER);
            }
            if (p.getFecha_inicio() != null) {
                ps.setDate(4, Date.valueOf(p.getFecha_inicio()));
            } else {
                ps.setNull(4, java.sql.Types.DATE);
            }
            if (p.getFecha_fin() != null) {
                ps.setDate(5, Date.valueOf(p.getFecha_fin()));
            } else {
                ps.setNull(5, java.sql.Types.DATE);
            }
            ps.setInt(6, p.getId_prestamo());
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Actualizado con exito.");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     */
    //</editor-fold>

}
