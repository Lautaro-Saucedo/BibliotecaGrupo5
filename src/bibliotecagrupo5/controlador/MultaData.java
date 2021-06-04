package bibliotecagrupo5.controlador;

import bibliotecagrupo5.modelo.Conexion;
import bibliotecagrupo5.modelo.Multa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/* @author @LXWeber Leandro Xavier Weber */

public class MultaData {
    private Connection con;
    
    public MultaData(Conexion conexion){
        con = conexion.getConexion();
    }
    
    public void agregarMulta(Multa m){
        String query = "INSERT INTO multa VALUES (NULL,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(m.getFecha_inicio()));
            ps.setDate(2, Date.valueOf(m.getFecha_fin()));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                m.setId_multa(rs.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null, "No se genero ID.");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MultaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public List<Multa> ListarMultas(){
        List<Multa> lista = new ArrayList<>();
        String query = "SELECT * FROM multa";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Multa m = new Multa();
                m.setId_multa(rs.getInt(1));
                m.setFecha_inicio(rs.getDate(2).toLocalDate());
                m.setFecha_fin(rs.getDate(2).toLocalDate());
                lista.add(m);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MultaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
