package bibliotecagrupo5.controlador;

import bibliotecagrupo5.modelo.Autor;
import bibliotecagrupo5.modelo.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/* @author @LXWeber Leandro Xavier Weber */
public class AutorData {

    private Connection con;

    public AutorData() {
        con = Conexion.getConexion();
    }

    public void registrarAutor(Autor autor) {
        String query = "INSERT INTO autor(dni_autor, nombre_autor, apellido_autor, fecha_nacimiento, nacionalidad) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, autor.getDni_autor());
            ps.setString(2, autor.getNombre_autor());
            ps.setString(3, autor.getApellido_autor());
            ps.setDate(4, Date.valueOf(autor.getFecha_nacimiento()));
            ps.setString(5, autor.getNacionalidad());
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Autor guardado correctamente");
            }
            ps.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error al guardar autor, asegurese que el dni no este repetido");
        }
    }

    public List<Autor> listarAutores() {
        List<Autor> autores = new ArrayList<>();
        String query = "SELECT * FROM autor";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Autor a = new Autor();
                a.setDni_autor(rs.getInt("dni_autor"));
                a.setNombre_autor(rs.getString("nombre_autor"));
                a.setApellido_autor(rs.getString("apellido_autor"));
                a.setFecha_nacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                a.setNacionalidad(rs.getString("nacionalidad"));
                autores.add(a);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar autores");
        }

        return autores;
    }

    public boolean borrarAutorFisico(int dni) {
        boolean retorno=true;
        String query = "DELETE FROM autor WHERE dni_autor=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, dni);

            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Borrado exitosamente");
                retorno= true;
            } else {
                JOptionPane.showMessageDialog(null, "El autor que se desea borrar no existe");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al borrar autor, el autor tiene libros publicados");
            retorno= false;
        }
        return retorno;
    }

    public void actualizarAutor(Autor a) {
        String query = "UPDATE autor SET nombre_autor=?,apellido_autor=?,fecha_nacimiento=?,nacionalidad=? WHERE dni_autor=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, a.getNombre_autor());
            ps.setString(2, a.getApellido_autor());
            ps.setDate(3, Date.valueOf(a.getFecha_nacimiento()));
            ps.setString(4, a.getNacionalidad());
            ps.setInt(5, a.getDni_autor());
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "El autor se modifico correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se actualizo el autor");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar autor");
        }
    }

    public Autor buscarAutor(int dni) {
        Autor a = new Autor();
        String query = "SELECT dni_autor, nombre_autor, apellido_autor, fecha_nacimiento, nacionalidad FROM autor WHERE dni_autor=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                a.setDni_autor(rs.getInt("dni_autor"));
                a.setNombre_autor(rs.getString("nombre_autor"));
                a.setApellido_autor(rs.getString("apellido_autor"));
                a.setFecha_nacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                a.setNacionalidad("nacionalidad");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar autor");
        }
        return a;
    }
}
