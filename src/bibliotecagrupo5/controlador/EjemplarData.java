package bibliotecagrupo5.controlador;

import bibliotecagrupo5.modelo.Conexion;
import bibliotecagrupo5.modelo.Ejemplar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.Connection;

/* @author @LXWeber Leandro Xavier Weber */

public class EjemplarData {
    
    private Connection conexion;
    
    public EjemplarData(){
        conexion = Conexion.getConexion();
    }
    
    public void ingresarEjemplar(Ejemplar ejemplar){
        String query = "INSERT INTO ejemplar(id_ejemplar, id_libro, estado) VALUES (NULL,?,1)";
        try{
            PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,ejemplar.getLibro().getIsbn());
            ps.execute();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()){
                ejemplar.setId_ejemplar(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Ejemplar ingresado correctamente");
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al ingresar Ejemplar.\nAsegurese de que el N° ID no esté repetido.");
        }
    }
    
    public void ingresarEjemplares(Ejemplar ejemplar, int cant){
            String query = "INSERT INTO ejemplar(id_ejemplar, id_libro, estado) VALUES (NULL,?,1)";
            String x = ", (NULL,?,1)";
        for(int i=1;i<cant;i++){
            query+=x;
        }
        try{
            PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            for(int i=1;i<=cant;i++){
                ps.setInt(i,ejemplar.getLibro().getIsbn());
            }
            ps.execute();
            ResultSet rs=ps.getGeneratedKeys();
            while (rs.next()){
                ejemplar.setId_ejemplar(rs.getInt(1));
            }
            JOptionPane.showMessageDialog(null,cant+" Ejemplares ingresados correctamente");
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al ingresar Ejemplar.\nAsegurese de que el N° ID no esté repetido.");
            System.out.println(ex.getMessage());
        }
    }
    
}
