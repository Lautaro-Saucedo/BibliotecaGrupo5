package bibliotecagrupo5.controlador;

import bibliotecagrupo5.modelo.Autor;
import bibliotecagrupo5.modelo.Conexion;
import bibliotecagrupo5.modelo.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/* @author @LXWeber Leandro Xavier Weber */

public class LibroData {
    
    private Connection conexion = null;

    public LibroData() {
        this.conexion = Conexion.getConexion();
    }
    
    public void ingresarLibro(Libro libro){
        String query = "INSERT INTO libro(isbn, autor, nombre, editorial, año, tipo) VALUES (?,?,?,?,?,?)";
        try{
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
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al ingresar libro.\nAsegurese de que el N° ISBN no esté repetido.");
        }
        
    }
    
    public List<Libro> listarLibro(Libro libro){
        List<Libro> libros = new ArrayList<>();
        String query = "SELECT * FROM libro";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Libro l = new Libro();
                Autor a = new Autor();
                l.setIsbn(rs.getInt("isbn"));
                a.setDni_autor(rs.getInt("dni"));
                l.setAutor(a);
                l.setNombre(rs.getString("nombre"));
                l.setEditorial(rs.getString("editorial"));
                l.setAño(rs.getInt("año"));
                l.setTipo(rs.getString("tipo"));

                libros.add(l);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al listar libros");
        }
        return libros;
    }
    
    public List<Libro> obtenerLibrosXAutor(int dni_autor){
        List<Libro> libros = new ArrayList<>();
        String query = "SELECT * FROM libro WHERE dni_autor=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, dni_autor);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Libro l = new Libro();
                Autor a = new Autor();
                l.setIsbn(rs.getInt("isbn"));
                a.setDni_autor(rs.getInt("dni"));
                l.setAutor(a);
                l.setNombre(rs.getString("nombre"));
                l.setEditorial(rs.getString("editorial"));
                l.setAño(rs.getInt("año"));
                l.setTipo(rs.getString("tipo"));

                libros.add(l);
            }
            ps.close();
        } catch (SQLException sqle){
            JOptionPane.showMessageDialog(null, "No se encontraron libros de ese autor");
        }
        
        return libros;
    }
    
    public void eliminarLibro(int isbn){
        String query = "DELETE FROM libro WHERE isbn=?";
        try{
            PreparedStatement ps= conexion.prepareStatement(query);
            ps.setLong(1,isbn);
            if(ps.executeUpdate() == 1){
                JOptionPane.showMessageDialog(null, "Libro eliminado");
            }else{
                JOptionPane.showMessageDialog(null, "Imposible eliminar libro inexistente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar libro.\nAsegurese de no tener ningún ejemplar del mismo.");
        }
    }
}
