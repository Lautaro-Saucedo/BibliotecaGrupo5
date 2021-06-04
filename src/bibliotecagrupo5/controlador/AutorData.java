
package bibliotecagrupo5.controlador;

import bibliotecagrupo5.modelo.Conexion;
import java.sql.Connection;


/* @author @LXWeber Leandro Xavier Weber */

public class AutorData {
    private Connection con;
    
    public AutorData(){
        con = Conexion.getConexion();
    }
}
