/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo5.controlador;

import bibliotecagrupo5.modelo.Lector;
import bibliotecagrupo5.vistas.viewIngresarLector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Laucha
 */
public class ctrlIngresarLector implements ActionListener {

    private viewIngresarLector vil;
    private LectorData ld;

    public ctrlIngresarLector(viewIngresarLector vil, LectorData ld) {
        this.vil = vil;
        this.ld = ld;

        vil.getJbAgregar().addActionListener(this);
        vil.getJbLimpiar().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vil.getJbAgregar()) {
            Lector l = new Lector();
            try {
                l.setDni_lector(Integer.parseInt(vil.getJtfDni().getText()));
                l.setNombre_lector(vil.getJtfNombre().getText());
                l.setApellido_lector(vil.getJtfApellido().getText());
                l.setEstado_lector(true);
                if (l.getNombre_lector().equals("") || l.getApellido_lector().equals("")) {
                    JOptionPane.showMessageDialog(null, "No puede haber campos en blanco.");
                } else {
                    ld.registrarLector(l);
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Dni solo puede contener numeros.");
            }
        }
        limpiar();

    }

    private void limpiar() {
        vil.getJtfApellido().setText("");
        vil.getJtfDni().setText("");
        vil.getJtfNombre().setText("");
    }

}
