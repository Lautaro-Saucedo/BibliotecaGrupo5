package bibliotecagrupo5.controlador;

import bibliotecagrupo5.modelo.Lector;
import bibliotecagrupo5.modelo.Prestamo;
import bibliotecagrupo5.vistas.viewListarPrestamos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Laucha
 */
public class ctrlListarPrestamos implements ActionListener, PropertyChangeListener {

    private viewListarPrestamos vlp;
    private PrestamoData pd;
    private LectorData ld;
    DefaultTableModel tabla;
    private HashMap<Object, Integer> fuente = new HashMap<>();
    private List<Prestamo> listaActual = new ArrayList<>();

    public ctrlListarPrestamos(viewListarPrestamos vlp, PrestamoData pd, LectorData ld) {
        this.vlp = vlp;
        this.pd = pd;
        this.ld = ld;
        tabla = (DefaultTableModel) vlp.getJtPrestamos().getModel();

        vlp.getJdcFecha().addPropertyChangeListener(this);

        vlp.getJcbLectores().addActionListener(this);
        vlp.getJcbListas().addActionListener(this);
        vlp.getJbRegD().addActionListener(this);
        vlp.getJbEliminar().addActionListener(this);
        vlp.getJrbEstado().addActionListener(this);
        vlp.getJrbFecha().addActionListener(this);
        vlp.getJrbLector().addActionListener(this);

        fuente.put(vlp.getJbRegD(), 1);
        fuente.put(vlp.getJbEliminar(), 2);
        fuente.put(vlp.getJcbLectores(), 3);
        fuente.put(vlp.getJcbListas(), 4);
        fuente.put(vlp.getJrbLector(), 5);
        fuente.put(vlp.getJrbEstado(), 6);
        fuente.put(vlp.getJrbFecha(), 7);

        for (Lector l : ld.listarLectores()) {
            if (pd.prestamosActuales(l)!=0){
                vlp.getJcbLectores().addItem(l);
            }
        }
        
        vlp.getJcbListas().setSelectedIndex(2);
        vlp.getJrbEstado().setSelected(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (fuente.get(ae.getSource())) {
            case 1: {//boton devolucion
                if (gsr()!=-1 && gsc()!=-1){
                    if(vfa(5) == null){
                        Prestamo p = pd.buscar((int)vfa(0));
                        pd.registrarDevolucion(p);
                        tabla.removeRow(gsr());
                        vlp.getJtPrestamos().setModel(tabla);
                    }
                }
                break;
            }
            case 2: {//boton eliminar
                if (gsr()!=-1 && gsc()!=-1){
                    if (vfa(5) !=null){
                        Prestamo p = pd.buscar((int)vfa(0));
                        pd.eliminarPrestamo(p);
                        tabla.removeRow(gsr());
                        vlp.getJtPrestamos().setModel(tabla);
                    }
                }
                break;
            }
            case 3: {
                listaActual = pd.listarPrestamos((Lector) vlp.getJcbLectores().getSelectedItem());
                borrarTabla();
                llenarTabla();
                break;
            }
            case 4: {
                switch ((String) vlp.getJcbListas().getSelectedItem()) {
                    case "Vigentes": {
                        listaActual = pd.listarSinRetrasos();
                        borrarTabla();
                        llenarTabla();
                        break;
                    }
                    case "Retrasos": {
                        listaActual = pd.listarRetrasos();
                        borrarTabla();
                        llenarTabla();
                        break;
                    }
                    case "Historial": {
                        listaActual = pd.listarDevoluciones();
                        borrarTabla();
                        llenarTabla();
                        break;
                    }
                }
                break;
            }
            case 5: {
                vlp.getJcbLectores().setEnabled(true);
                vlp.getJcbListas().setEnabled(false);
                vlp.getJdcFecha().setEnabled(false);
                vlp.getJcbLectores().setSelectedIndex(vlp.getJcbLectores().getSelectedIndex());
                break;
            }
            case 6: {
                vlp.getJcbLectores().setEnabled(false);
                vlp.getJcbListas().setEnabled(true);
                vlp.getJdcFecha().setEnabled(false);
                vlp.getJcbListas().setSelectedIndex(vlp.getJcbListas().getSelectedIndex());
                break;
            }
            case 7: {
                vlp.getJcbLectores().setEnabled(false);
                vlp.getJcbListas().setEnabled(false);
                vlp.getJdcFecha().setEnabled(true);
                vlp.getJdcFecha().setDate(vlp.getJdcFecha().getDate());
                break;
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        if (vlp.getJdcFecha().getDate() != null) {
            LocalDate fecha = vlp.getJdcFecha().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            listaActual = pd.listarPrestamos(fecha);
            borrarTabla();
            llenarTabla();
        }
    }

    private void llenarTabla() {
        for (Prestamo p : listaActual) {
            Vector v = new Vector();
            v.add(p.getId_prestamo());
            v.add(p.getLector().getDni_lector());
            if (p.getMulta() == null) {
                v.add(null);
            } else {
                v.add(p.getMulta().getId_multa());
            }
            v.add(p.getEjemplar().getId_ejemplar());
            v.add(p.getFecha_inicio());
            if (p.getFecha_fin() == null) {
                v.add(null);
            } else {
                v.add(p.getFecha_fin());
            }
            tabla.addRow(v);
        }
    }

    private void borrarTabla() {
        for (int i = tabla.getRowCount() - 1; i >= 0; i--) {
            tabla.removeRow(i);
        }
    }
    //valor fila actual
    private Object vfa(int columna) {
        return vlp.getJtPrestamos().getValueAt(gsr(), columna);
    }

    //get selected row
    private int gsr() {
        return vlp.getJtPrestamos().getSelectedRow();
    }

    //get selected column
    private int gsc() {
        return vlp.getJtPrestamos().getSelectedColumn();
    }

}
