package bibliotecagrupo5.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    private String url="jdbc:mysql://localhost/bibliotecagrupo5";
    private String user="root";
    private String pass="";
    private Connection con=null;
    
    public Conexion(){
        try {
            
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException cnte){
            JOptionPane.showMessageDialog(null, "Clase Driver no encontrada.");
        }
    }
    
    public Connection getConexion(){
        if (con==null){
            try {
                con=DriverManager.getConnection(url,user,pass);
            } catch(SQLException sqle){
                JOptionPane.showMessageDialog(null, "Error de conexion.");
            }
        }
        return con;
    }

}
