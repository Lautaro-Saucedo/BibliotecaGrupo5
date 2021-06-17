package bibliotecagrupo5.controlador;

import bibliotecagrupo5.modelo.Ejemplar;
import bibliotecagrupo5.modelo.Libro;
import bibliotecagrupo5.modelo.Prestamo;
import bibliotecagrupo5.vistas.viewListarEjemplares;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Laucha
 */
public class ctrlListarEjemplares implements ActionListener, TableModelListener {

    private viewListarEjemplares vle;
    private EjemplarData ed;
    private LibroData ld;
    private PrestamoData pd;
    private DefaultTableModel tabla;
    private HashMap<Object, Integer> fuente = new HashMap<>();

    public ctrlListarEjemplares(viewListarEjemplares vle, EjemplarData ed, LibroData ld, PrestamoData pd) {
        this.vle = vle;
        this.ed = ed;
        this.ld = ld;
        this.pd = pd;

        tabla = (DefaultTableModel) vle.getJtEjemplares().getModel();

        tabla.addTableModelListener(this);
        vle.getJbBorrar().addActionListener(this);
        vle.getJcbLibro().addActionListener(this);
        vle.getJcbLibros().addActionListener(this);
        vle.getJbCambiarEstado().addActionListener(this);

        fuente.put(vle.getJbBorrar(), 1);
        fuente.put(vle.getJcbLibro(), 2);
        fuente.put(vle.getJcbLibros(), 3);
        fuente.put(vle.getJbCambiarEstado(), 4);

        for (Libro l : ld.listarLibros()) {
            vle.getJcbLibros().addItem(l);
        }

        llenarTabla();

        vle.getJtEjemplares().setAutoCreateRowSorter(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (fuente.get(ae.getSource())) {
            case 1: {
                borrar();
                break;
            }
            case 2: {//checkbox
                checkbox();
                break;
            }
            case 3: {//combobox
                borrarTabla();
                llenarTabla((Libro) vle.getJcbLibros().getSelectedItem());
                break;
            }
            case 4: {
                cambiarEstado();
                break;
            }
        }

    }

    private void borrar() {
        if (gsr() != -1 && gsc() != -1) {
            if (vfa(2).equals("Disponible") || vfa(2).equals("Reparacion")) {
                Ejemplar e = new Ejemplar();
                e.setId_ejemplar((int) vfa(0));
                for (Prestamo p : pd.listarPrestamos(e)) {
                    pd.eliminarPrestamo(p);
                }
                ed.eliminarEjemplar(e);
                tabla.removeRow(gsr());
            }
        }
    }

    private void checkbox() {
        if (vle.getJcbLibro().isSelected()) {
            vle.getJcbLibros().setEnabled(true);
            borrarTabla();
            llenarTabla((Libro) vle.getJcbLibros().getSelectedItem());
        } else {
            vle.getJcbLibros().setEnabled(false);
            borrarTabla();
            llenarTabla();
        }
    }

    private void cambiarEstado() {
        if (gsr() != -1 && gsc() != -1) {
            switch ((String) vfa(2)) {
                case "Disponible": {
                    vle.getJtEjemplares().setValueAt("Reparacion", gsr(), 2);
                    break;
                }
                case "Reparacion": {
                    vle.getJtEjemplares().setValueAt("Disponible", gsr(), 2);
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }

    @Override
    public void tableChanged(TableModelEvent tme) {
        if (gsr() != -1 && gsc() != -1 && tme.getType() != -1) {
            Ejemplar e = new Ejemplar();
            e.setId_ejemplar((int) vfa(0));
            if (vfa(2).equals("Disponible")) {
                ed.cambiarEstado(e, 1);
            } else {
                ed.cambiarEstado(e, 3);
            }
        }
    }

    private void llenarTabla() {
        String[] estado = {"Prestado", "Disponible", "Retraso", "Reparacion"};
        for (Ejemplar e : ed.listarEjemplares()) {
            tabla.addRow(new Object[]{e.getId_ejemplar(), e.getLibro().toString(), estado[e.getEstado()]});
        }
    }

    private void llenarTabla(Libro l) {
        String[] estado = {"Prestado", "Disponible", "Retraso", "Reparacion"};
        for (Ejemplar e : ed.listarEjemplares(l)) {
            tabla.addRow(new Object[]{e.getId_ejemplar(), e.getLibro().toString(), estado[e.getEstado()]});
        }
    }

    private void borrarTabla() {
        for (int i = tabla.getRowCount() - 1; i >= 0; i--) {
            tabla.removeRow(i);
        }
    }

    //valor fila actual
    private Object vfa(int columna) {
        return vle.getJtEjemplares().getValueAt(gsr(), columna);
    }

    //get selected row
    private int gsr() {
        return vle.getJtEjemplares().getSelectedRow();
    }

    //get selected column
    private int gsc() {
        return vle.getJtEjemplares().getSelectedColumn();
    }
}
