package bibliotecagrupo5.controlador;

import bibliotecagrupo5.modelo.Lector;
import bibliotecagrupo5.modelo.Prestamo;
import bibliotecagrupo5.vistas.viewPrestamos;
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
public class ctrlPrestamos implements ActionListener, PropertyChangeListener {

    private viewPrestamos vp;
    private PrestamoData pd;
    private LectorData ld;
    DefaultTableModel tabla;
    private HashMap<Object, Integer> fuente = new HashMap<>();
    private List<Prestamo> listaActual = new ArrayList<>();

    public ctrlPrestamos(viewPrestamos vp, PrestamoData pd, LectorData ld) {
        this.vp = vp;
        this.pd = pd;
        this.ld = ld;
        tabla = (DefaultTableModel) vp.getJtPrestamos().getModel();

        vp.getJdcFecha().addPropertyChangeListener(this);

        vp.getJcbLectores().addActionListener(this);
        vp.getJcbListas().addActionListener(this);
        vp.getJbRegD().addActionListener(this);
        vp.getJbEliminar().addActionListener(this);
        vp.getJrbEstado().addActionListener(this);
        vp.getJrbFecha().addActionListener(this);
        vp.getJrbLector().addActionListener(this);

        fuente.put(vp.getJbRegD(), 1);
        fuente.put(vp.getJbEliminar(), 2);
        fuente.put(vp.getJcbLectores(), 3);
        fuente.put(vp.getJcbListas(), 4);
        fuente.put(vp.getJrbLector(), 5);
        fuente.put(vp.getJrbEstado(), 6);
        fuente.put(vp.getJrbFecha(), 7);

        for (Lector l : ld.listarLectores()) {
            vp.getJcbLectores().addItem(l);
        }
        
        vp.getJcbListas().setSelectedIndex(0);
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
                        vp.getJtPrestamos().setModel(tabla);
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
                        vp.getJtPrestamos().setModel(tabla);
                    }
                }
                break;
            }
            case 3: {
                listaActual = pd.listarPrestamos((Lector) vp.getJcbLectores().getSelectedItem());
                borrarTabla();
                llenarTabla();
                break;
            }
            case 4: {
                switch ((String) vp.getJcbListas().getSelectedItem()) {
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
                vp.getJcbLectores().setEnabled(true);
                vp.getJcbListas().setEnabled(false);
                vp.getJdcFecha().setEnabled(false);
                vp.getJcbLectores().setSelectedIndex(vp.getJcbLectores().getSelectedIndex());
                break;
            }
            case 6: {
                vp.getJcbLectores().setEnabled(false);
                vp.getJcbListas().setEnabled(true);
                vp.getJdcFecha().setEnabled(false);
                vp.getJcbListas().setSelectedIndex(vp.getJcbListas().getSelectedIndex());
                break;
            }
            case 7: {
                vp.getJcbLectores().setEnabled(false);
                vp.getJcbListas().setEnabled(false);
                vp.getJdcFecha().setEnabled(true);
                vp.getJdcFecha().setDate(vp.getJdcFecha().getDate());
                break;
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        if (vp.getJdcFecha().getDate() != null) {
            LocalDate fecha = vp.getJdcFecha().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
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
    
    private Object vfa(int columna) {
        return vp.getJtPrestamos().getValueAt(gsr(), columna);
    }

    //get selected row
    private int gsr() {
        return vp.getJtPrestamos().getSelectedRow();
    }

    //get selected column
    private int gsc() {
        return vp.getJtPrestamos().getSelectedColumn();
    }

}
