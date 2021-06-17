/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo5.controlador;

import bibliotecagrupo5.modelo.Autor;
import bibliotecagrupo5.vistas.viewListarAutores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Laucha
 */
public class ctrlListarAutores implements ActionListener, PropertyChangeListener, TableModelListener {

    private viewListarAutores vla;
    private DefaultTableModel tabla;
    private AutorData ad;

    public ctrlListarAutores(viewListarAutores vla, AutorData ad) {
        this.vla = vla;
        this.ad = ad;

        tabla = (DefaultTableModel) vla.getJtAutores().getModel();
        vla.getJtAutores().setAutoCreateRowSorter(true);

        vla.getJbEliminar().addActionListener(this);
        vla.getJdcFecha().addPropertyChangeListener(this);
        tabla.addTableModelListener(this);

        llenarTabla();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (gsr() != -1 && gsc() != -1) {
            if(ad.borrarAutorFisico((int) vfa(0))){
                tabla.removeRow(gsr());
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        if (!(pce.getPropertyName() == "ancestor")) {
            System.out.println(pce.getPropertyName());
            if (gsr() != -1 && gsc() != -1) {
                LocalDate fecha = ((Date) pce.getNewValue()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                tabla.setValueAt(fecha, gsr(), 3);
            }
        }
    }

    @Override
    public void tableChanged(TableModelEvent tme) {
        if (gsr() != -1 && gsc() != -1 && tme.getType() != -1) {
            Autor a = new Autor();
            a.setDni_autor((int) vfa(0));
            a.setNombre_autor((String) vfa(1));
            a.setApellido_autor((String) vfa(2));
            a.setFecha_nacimiento((LocalDate) vfa(3));
            a.setNacionalidad((String) vfa(4));
            if (a.getNombre_autor().equals("") || a.getApellido_autor().equals("") || a.getNacionalidad().equals("")) {
                JOptionPane.showMessageDialog(null, "No puede haber campos en blanco.");
            } else {
                ad.actualizarAutor(a);
            }
        }
    }

    private void llenarTabla() {
        for (Autor a : ad.listarAutores()) {
            tabla.addRow(new Object[]{a.getDni_autor(), a.getNombre_autor(), a.getApellido_autor(), a.getFecha_nacimiento(), a.getNacionalidad()});
        }
    }

    //valor fila actual
    private Object vfa(int columna) {
        return vla.getJtAutores().getValueAt(gsr(), columna);
    }

    //get selected row
    private int gsr() {
        return vla.getJtAutores().getSelectedRow();
    }

    //get selected column
    private int gsc() {
        return vla.getJtAutores().getSelectedColumn();
    }

}
