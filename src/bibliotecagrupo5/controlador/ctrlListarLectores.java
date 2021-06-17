package bibliotecagrupo5.controlador;

import bibliotecagrupo5.modelo.Lector;
import bibliotecagrupo5.vistas.viewListarLectores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Laucha
 */
public class ctrlListarLectores implements ActionListener, TableModelListener {

    private viewListarLectores vll;
    private LectorData ld;
    private PrestamoData pd;
    private DefaultTableModel tabla;

    public ctrlListarLectores(viewListarLectores vll, LectorData ld, PrestamoData pd) {
        this.vll = vll;
        this.ld = ld;
        this.pd = pd;

        tabla = (DefaultTableModel) vll.getJtLectores().getModel();

        vll.getJbEliminar().addActionListener(this);
        vll.getJbCambiarEstado().addActionListener(this);
        tabla.addTableModelListener(this);

        vll.getJtLectores().setAutoCreateRowSorter(true);
        llenarTabla();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (gsc() != -1 && gsr() != -1) {
            if (ae.getSource() == vll.getJbCambiarEstado()) {
                cambiarEstado();
            } else {
                borrar();
            }
        }
    }
    
    private void cambiarEstado() {
        if (vfa(3).toString().equals("Habilitado")) {
            vll.getJtLectores().setValueAt("Deshabilitado", gsr(), 3);
        } else {
            vll.getJtLectores().setValueAt("Habilitado", gsr(), 3);
        }
    }
    
    private void borrar(){
        Lector l = ld.buscarLector((int)vfa(0));
        if (pd.prestamosActuales(l)==0){
            ld.borrarLectorFisico(l.getDni_lector());
            tabla.removeRow(gsr());
        } else {
            JOptionPane.showMessageDialog(null, "No se puede borrar.\nEl lector tiene prestamos activos.");
        }
    }

    @Override
    public void tableChanged(TableModelEvent tme) {
        if (gsc() != -1 && gsr() != -1 && tme.getType() != -1) {
            Lector l = new Lector();
            l.setDni_lector((int) vfa(0));
            l.setNombre_lector(vfa(1).toString());
            l.setApellido_lector(vfa(2).toString());
            if (vfa(3).toString().equals("Habilitado")) {
                l.setEstado_lector(true);
            } else {
                l.setEstado_lector(false);
            }
            ld.actualizarLector(l);
        }
    }

    

    private void llenarTabla() {
        String estado[] = {"Habilitado", "Deshabilitado"};
        for (Lector l : ld.listarLectores()) {
            if (l.isEstado_lector()) {
                tabla.addRow(new Object[]{l.getDni_lector(), l.getNombre_lector(), l.getApellido_lector(), estado[0]});
            } else {
                tabla.addRow(new Object[]{l.getDni_lector(), l.getNombre_lector(), l.getApellido_lector(), estado[1]});
            }
        }
    }

    //valor fila actual
    private Object vfa(int columna) {
        return vll.getJtLectores().getValueAt(gsr(), columna);
    }

    //get selected row
    private int gsr() {
        return vll.getJtLectores().getSelectedRow();
    }

    //get selected column
    private int gsc() {
        return vll.getJtLectores().getSelectedColumn();
    }
}
