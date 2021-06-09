package bibliotecagrupo5.controlador;

import bibliotecagrupo5.modelo.Conexion;
import bibliotecagrupo5.modelo.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.regex.*;

/* @author @LXWeber Leandro Xavier Weber */
public class LibroData {
    
    private Connection conexion = null;
    
    public LibroData() {
        this.conexion = Conexion.getConexion();
    }
    
    public void ingresarLibro(Libro libro) {
        String query = "INSERT INTO libro(isbn, id_autor, nombre, editorial, año, tipo) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, libro.getIsbn());
            ps.setInt(2, libro.getAutor().getDni_autor());
            ps.setString(3, libro.getNombre());
            ps.setString(4, libro.getEditorial());
            ps.setInt(5, libro.getAño());
            ps.setString(6, libro.getTipo());
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Libro ingresado correctamente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar libro.\nAsegurese de que el N° ISBN no esté repetido.");
            System.out.println(ex.getMessage());
        }
        
    }
    
    public Libro buscarLibro(int isbn) {
        Libro l = new Libro();
        AutorData ad = new AutorData();
        String query = "SELECT * FROM libro WHERE isbn=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setLong(1, isbn);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                l.setIsbn(rs.getInt("isbn"));
                l.setAutor(ad.buscarAutor(rs.getInt("id_autor")));
                l.setNombre(rs.getString("nombre"));
                l.setEditorial(rs.getString("editorial"));
                l.setAño(rs.getInt("año"));
                l.setTipo(rs.getString("tipo"));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar libro");
            
        }
        return l;
    }
    
    public void actualizarLibro(Libro l){
        String query = "UPDATE libro SET id_autor=?,nombre=?,editorial=?,año=?,tipo=? WHERE isbn=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, l.getAutor().getDni_autor());
            ps.setString(2, l.getNombre());
            ps.setString(3, l.getEditorial());
            ps.setInt(4, l.getAño());
            ps.setString(5, l.getTipo());
            ps.setInt(6, l.getIsbn());
            if (ps.executeUpdate() == 1){
                JOptionPane.showMessageDialog(null, "Actualizado con exito.");
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public List<Libro> listarLibros() {
        List<Libro> libros = new ArrayList<>();
        String query = "SELECT * FROM libro";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            llenarLista(ps.executeQuery(), libros);
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar libros");
        }
        return libros;
    }
    
    public List<Libro> obtenerLibrosXAutor(int id_autor) {
        List<Libro> libros = new ArrayList<>();
        String query = "SELECT * FROM libro WHERE id_autor=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id_autor);
            llenarLista(ps.executeQuery(), libros);
            ps.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "No se encontraron libros de ese autor");
        }
        return libros;
    }
    
    public List<Libro> obtenerLibrosXAño(int año) {
        List<Libro> libros = new ArrayList<>();
        String query = "SELECT * FROM libro WHERE año=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, año);
            llenarLista(ps.executeQuery(), libros);
            ps.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "No se encontraron libros de ese año");
        }
        return libros;
    }
    
    public List<Libro> obtenerLibrosXEditorial(String editorial) {
        List<Libro> libros = new ArrayList<>();
        String query = "SELECT * FROM libro WHERE editorial=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, editorial);
            llenarLista(ps.executeQuery(), libros);
            ps.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "No se encontraron libros de esa editorial");
        }
        return libros;
    }
    
    public List<Libro> obtenerLibrosXTipo(String tipo) {
        List<Libro> libros = new ArrayList<>();
        String query = "SELECT * FROM libro WHERE tipo=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, tipo);
            llenarLista(ps.executeQuery(), libros);
            ps.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "No se encontraron libros de ese tipo");
        }
        return libros;
    }
    
    public List<Libro> obtenerLibrosXTitulo(String palabras) {
        List<Libro> libros = listarLibros();
        List<Libro> encontrados = new ArrayList<>();
        for (Libro l : libros) {
            Pattern regex = Pattern.compile("\\w?" + Pattern.quote(palabras) + "\\w?", Pattern.CASE_INSENSITIVE);
            Matcher match = regex.matcher(l.getNombre());
            if (match.find()) {
                encontrados.add(l);
            }
        }
        return encontrados;
    }
    
    public void eliminarLibro(int isbn) {
        String query = "DELETE FROM libro WHERE isbn=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setLong(1, isbn);
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Libro eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Imposible eliminar libro inexistente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar libro.\nAsegurese de no tener ningún ejemplar del mismo.");
        }
    }
    
    private List<Libro> llenarLista(ResultSet rs, List<Libro> lista){
        AutorData ad = new AutorData();
        try {
            while (rs.next()) {
                Libro l = new Libro();
                l.setIsbn(rs.getInt("isbn"));
                l.setAutor(ad.buscarAutor(rs.getInt("id_autor")));
                l.setNombre(rs.getString("nombre"));
                l.setEditorial(rs.getString("editorial"));
                l.setAño(rs.getInt("año"));
                l.setTipo(rs.getString("tipo"));
                
                lista.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
