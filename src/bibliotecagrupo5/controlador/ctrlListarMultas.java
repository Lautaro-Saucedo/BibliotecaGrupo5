/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo5.controlador;

import bibliotecagrupo5.modelo.Lector;
import bibliotecagrupo5.modelo.Multa;
import bibliotecagrupo5.modelo.Prestamo;
import bibliotecagrupo5.vistas.viewListarMultas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Laucha
 */
public class ctrlListarMultas implements ActionListener, PropertyChangeListener {

    private viewListarMultas vlm;
    private MultaData md;
    private PrestamoData pd;
    private LectorData ld;
    private DefaultTableModel tabla;
    private List<Lector> listaActual;

    public ctrlListarMultas(viewListarMultas vlm, MultaData md, PrestamoData pd, LectorData ld) {
        this.vlm = vlm;
        this.md = md;
        this.pd = pd;
        this.ld = ld;

        vlm.getJbEliminar().addActionListener(this);
        vlm.getJmcMes().addPropertyChangeListener(this);
        vlm.getJcbMes().addActionListener(this);

        vlm.getJmcMes().setLocale(new Locale("es", "AR"));
        tabla = (DefaultTableModel) vlm.getJtMultas().getModel();
        vlm.getJtMultas().setAutoCreateRowSorter(true);
        listaActual = pd.lectoresMultados();
        llenarTabla(1);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vlm.getJcbMes()) {
            if (vlm.getJcbMes().isSelected()) {
                vlm.getJmcMes().setEnabled(true);
                propertyChange(null);
            } else {
                vlm.getJmcMes().setEnabled(false);
                listaActual = pd.lectoresMultados();
                borrarTabla();
                llenarTabla(1);
            }
        } else {
            if (gsr() != -1 && gsc() != -1) {
                Multa m = md.buscar((int) vfa(0));
                Prestamo p = pd.buscar(m);
                p.setMulta(null);
                pd.actualizar(p);
                md.eliminarMulta(m);
                ld.estadoLector(p.getLector());
                tabla.removeRow(gsr());
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        if (pce == null || pce.getPropertyName() != "ancestor") {
            listaActual = pd.lectoresMultados(vlm.getJmcMes().getMonth() + 1);
            borrarTabla();
            llenarTabla(2);
        }
    }

    public void llenarTabla(int i) {
        switch (i) {
            case 1: {
                for (Lector l : listaActual) {
                    for (Multa m : pd.multasDeLector(l)) {
                        tabla.addRow(new Object[]{m.getId_multa(), l.toString(), m.getFecha_inicio(), m.getFecha_fin()});
                    }
                }
                break;
            }
            case 2: {
                for (Lector l : listaActual) {
                    for (Multa m : pd.multasDeLector(l)) {
                        if (m.getFecha_inicio().getMonthValue() == vlm.getJmcMes().getMonth() + 1) {
                            tabla.addRow(new Object[]{m.getId_multa(), l.toString(), m.getFecha_inicio(), m.getFecha_fin()});
                        }
                    }
                }
                break;
            }
        }
    }

    public void borrarTabla() {
        for (int i = tabla.getRowCount() - 1; i >= 0; i--) {
            tabla.removeRow(i);
        }
    }

    //valor fila actual
    private Object vfa(int columna) {
        return vlm.getJtMultas().getValueAt(gsr(), columna);
    }

    //get selected row
    private int gsr() {
        return vlm.getJtMultas().getSelectedRow();
    }

    //get selected column
    private int gsc() {
        return vlm.getJtMultas().getSelectedColumn();
    }

}
