package bibliotecagrupo5.controlador;

import bibliotecagrupo5.modelo.Conexion;
import bibliotecagrupo5.modelo.Ejemplar;
import bibliotecagrupo5.modelo.Libro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/* @author @LXWeber Leandro Xavier Weber */
public class EjemplarData {
    
    private Connection conexion;
    
    public EjemplarData() {
        conexion = Conexion.getConexion();
    }
    
    public void ingresarEjemplar(Ejemplar ejemplar) {
        String query = "INSERT INTO ejemplar(id_ejemplar, id_libro, estado) VALUES (NULL,?,1)";
        try {
            PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, ejemplar.getLibro().getIsbn());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                ejemplar.setId_ejemplar(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Ejemplar ingresado correctamente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar Ejemplar.\nAsegurese de que el N° ID no esté repetido.");
        }
    }
    
    public void ingresarEjemplares(Ejemplar ejemplar, int cant) {
        String query = "INSERT INTO ejemplar(id_ejemplar, id_libro, estado) VALUES (NULL,?,1)";
        String x = ", (NULL,?,1)";
        for (int i = 1; i < cant; i++) {
            query += x;
        }
        try {
            PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            for (int i = 1; i <= cant; i++) {
                ps.setInt(i, ejemplar.getLibro().getIsbn());
            }
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                ejemplar.setId_ejemplar(rs.getInt(1));
            }
            JOptionPane.showMessageDialog(null, cant + " Ejemplares ingresados correctamente");
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar Ejemplar.\nAsegurese de que el N° ID no esté repetido.");
            System.out.println(ex.getMessage());
        }
    }
    
    public Ejemplar buscarEjemplar(int id) {
        Ejemplar e = new Ejemplar();
        LibroData ld = new LibroData();
        String query = "SELECT * FROM ejemplar WHERE id_ejemplar=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setId_ejemplar(rs.getInt("id_ejemplar"));
                e.setLibro(ld.buscarLibro(rs.getInt("id_libro")));
                e.setEstado(rs.getInt("estado"));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar ejemplar");
            
        }
        return e;
    }
    
    public List<Ejemplar> listarEjemplares() {
        List<Ejemplar> ejemplares = new ArrayList<>();
        String query = "SELECT * FROM ejemplar";
        LibroData ld = new LibroData();
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ejemplar e = new Ejemplar();
                e.setId_ejemplar(rs.getInt("id_ejemplar"));
                e.setLibro(ld.buscarLibro(rs.getInt("id_libro")));
                e.setEstado(rs.getInt("estado"));
                
                ejemplares.add(e);
            }
            ps.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "No se encontraron ejemplares");
        }
        return ejemplares;
    }
    
    public List<Ejemplar> listarEjemplares(Libro libro) {
        List<Ejemplar> ejemplares = new ArrayList<>();
        String query = "SELECT * FROM ejemplar WHERE id_libro=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, libro.getIsbn());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ejemplar e = new Ejemplar();
                e.setId_ejemplar(rs.getInt("id_ejemplar"));
                e.setLibro(libro);
                e.setEstado(rs.getInt("estado"));
                
                ejemplares.add(e);
            }
            ps.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "No se encontraron ejemplares de ese libro");
        }
        return ejemplares;
    }
    
    public int cantEjemplares(Libro libro) {
        int cantidad = 0;
        String query = "SELECT * FROM ejemplar WHERE id_libro=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, libro.getIsbn());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cantidad++;
            }
            ps.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error al contar cantidad de ejemplares");
        }
        return cantidad;
    }
    
    public int cantEjemDisp(Libro libro) {
        int cantidad = 0;
        String query = "SELECT * FROM ejemplar WHERE id_libro=? AND estado=1";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, libro.getIsbn());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cantidad++;
            }
            ps.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error al contar cantidad de ejemplares disponibles");
        }
        return cantidad;
    }
    
    public void cambiarEstado(Ejemplar e, int estado){
        if (estado>-1 && estado<4) {
            String query = "UPDATE ejemplar SET estado=? WHERE id_ejemplar=?";
            try {
                PreparedStatement ps = conexion.prepareStatement(query);
                ps.setInt(1, estado);
                ps.setInt(2, e.getId_ejemplar());
                if (ps.executeUpdate() == 1) {
                    JOptionPane.showMessageDialog(null, "Estado actualizado.");
                }
                ps.close();
            } catch (SQLException sqle) {
                System.out.println(sqle.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Estado invalido.");
        }
    }
    
    public void eliminarEjemplar(Ejemplar e){
        String query = "DELETE FROM ejemplar WHERE id_ejemplar=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, e.getId_ejemplar());
            if (ps.executeUpdate() == 1){
                JOptionPane.showMessageDialog(null, "Ejemplar eliminado con exito");
            }
            ps.close();
        } catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }
}
