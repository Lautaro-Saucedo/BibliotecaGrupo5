
package bibliotecagrupo5.controlador;

import bibliotecagrupo5.modelo.Conexion;
import java.sql.Connection;


/* @author @LXWeber Leandro Xavier Weber */

public class LectorData {
    private Connection con;
    
    public LectorData(){
        con = Conexion.getConexion();
    }

}
