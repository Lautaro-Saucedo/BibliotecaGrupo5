package bibliotecagrupo5.controlador;

import bibliotecagrupo5.modelo.Autor;
import bibliotecagrupo5.vistas.viewIngresarAutor;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;


/* @author @LXWeber Leandro Xavier Weber */
public class ctrlIngresarAutor implements ActionListener {

    private viewIngresarAutor via;
    private AutorData ad;
    private HashMap<Object, Integer> fuente = new HashMap<>();

    public ctrlIngresarAutor(viewIngresarAutor via, AutorData ad) {
        this.ad = ad;
        this.via = via;
        via.getJbIngresar().addActionListener(this);
        via.getJbLimpiar().addActionListener(this);
        fuente.put(via.getJbIngresar(), 1);
        fuente.put(via.getJdcFecha(), 2);
        fuente.put(via.getJbLimpiar(), 3);

        JTextFieldDateEditor a = (JTextFieldDateEditor) via.getJdcFecha().getDateEditor();
        a.setEditable(false);
        via.getJdcFecha().setDate(new Date());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (fuente.get(ae.getSource())) {
            case 1: {
                try {
                    if (via.getJtfDni().getText().equals("") || via.getJtfNombre().getText().equals("") || via.getJtfApellido().getText().equals("") || via.getJtfNacionalidad().getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Error.\nHay campos en blanco.");
                    } else {
                        Autor a = new Autor();
                        a.setDni_autor(Integer.parseInt(via.getJtfDni().getText()));
                        a.setNombre_autor(via.getJtfNombre().getText());
                        a.setApellido_autor(via.getJtfApellido().getText());
                        a.setFecha_nacimiento(via.getJdcFecha().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                        a.setNacionalidad(via.getJtfNacionalidad().getText());
                        ad.registrarAutor(a);
                    }
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Error.\nEl DNI debe ser un dato numérico.");
                }
                break;
            }
            case 3: {
                via.getJtfDni().setText("");
                via.getJtfNombre().setText("");
                via.getJtfApellido().setText("");
                via.getJdcFecha().setDate(new Date());
                via.getJtfNacionalidad().setText("");
                break;
            }
        }
    }
}
