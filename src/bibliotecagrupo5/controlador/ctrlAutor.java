
package bibliotecagrupo5.controlador;

import bibliotecagrupo5.modelo.Autor;
import bibliotecagrupo5.vistas.viewIngresarAutor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/* @author @LXWeber Leandro Xavier Weber */

public class ctrlAutor implements ActionListener, PropertyChangeListener{
    
    private viewIngresarAutor via;
    private AutorData ad;
    private HashMap<Object, Integer> fuente = new HashMap<>();
    
    public ctrlAutor(viewIngresarAutor via, AutorData ad){
        this.ad=ad;
        this.via=via;
        via.getJbIngresar().addActionListener(this);
        via.getJdcFecha().addPropertyChangeListener(this);
        fuente.put(via.getJbIngresar(), 1);
        fuente.put(via.getJdcFecha(), 2);
        fuente.put(via.getJbLimpiar(), 3);
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
                        a.setFecha_nacimiento(LocalDate.parse(via.getJtfFecha().getText()));
                        a.setNacionalidad(via.getJtfNacionalidad().getText());
                        ad.registrarAutor(a);
                    }
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Error.\nEl DNI debe ser un dato numérico.");
                } catch (DateTimeParseException dpe) {
                    JOptionPane.showMessageDialog(null, "Error.\nFecha de nacimiento no puede estar en blanco");
                }
                break;
            }
        case 3: {
            via.getJtfDni().setText("");
            via.getJtfNombre().setText("");
            via.getJtfApellido().setText("");
            via.getJtfFecha().setText("");
            via.getJtfNacionalidad().setText("");
        }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        if (!(pce.getNewValue() instanceof JPanel)&&fuente.get(pce.getSource())==2) {
            java.util.Date aux = (java.util.Date) pce.getNewValue();
            if (aux != null) {
                String aux2 = aux.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
                via.getJtfFecha().setText(aux2);
            }
        }
    }

}
