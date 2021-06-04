package bibliotecagrupo5.controlador;

import bibliotecagrupo5.modelo.Conexion;
import bibliotecagrupo5.modelo.Libro;
import java.sql.Connection;

/* @author @LXWeber Leandro Xavier Weber */

public class LibroData {
    
    private Connection conexion = null;

    public LibroData(Conexion conexion) {
        this.conexion = conexion.getConexion();
    }
    
    public void ingresarLibro(Libro libro){
        String query = "INSERT INTO libro(isbn, autor, nombre, editorial, año, tipo) VALUES (?,?,?,?,?,?)";
        
    }

}
