package bibliotecagrupo5.controlador;

import bibliotecagrupo5.modelo.Ejemplar;
import bibliotecagrupo5.modelo.Libro;
import bibliotecagrupo5.vistas.viewBuscarLibro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/* @author @LXWeber Leandro Xavier Weber */

public class ctrlBuscarLibro implements ActionListener, PropertyChangeListener{
    
    private viewBuscarLibro vbl;
    private LibroData lid;
    private AutorData ad;
    private EjemplarData ed;
    DefaultTableModel tabla;
    private HashMap<Object, Integer> fuente = new HashMap<>();
    private List<Libro> lista = new ArrayList<>();
    
    public ctrlBuscarLibro(viewBuscarLibro vbl, LibroData lid, AutorData ad, EjemplarData ed){
        this.vbl = vbl;
        this.lid = lid;
        this.ad = ad;
        this.ed = ed;
        tabla = (DefaultTableModel) vbl.getJtListado().getModel();
        
        vbl.getJcbAutor().addActionListener(this);
        vbl.getJcbAño().addActionListener(this);
        vbl.getJcbEditorial().addActionListener(this);
        vbl.getJcbTipo().addActionListener(this);
        
        vbl.getJbBuscar().addActionListener(this);
        
        vbl.getJrbAutor().addActionListener(this);
        vbl.getJrbAño().addActionListener(this);
        vbl.getJrbEditorial().addActionListener(this);
        vbl.getJrbTipo().addActionListener(this);
        
        vbl.getJbBorrar().addActionListener(this);

        fuente.put(vbl.getJcbAutor(), 1);
        fuente.put(vbl.getJcbAño(), 2);
        fuente.put(vbl.getJcbEditorial(), 3);
        fuente.put(vbl.getJcbTipo(), 4);
        
        fuente.put(vbl.getJtfNombre(), 5);
        
        fuente.put(vbl.getJrbAutor(), 6);
        fuente.put(vbl.getJrbAño(), 7);
        fuente.put(vbl.getJrbEditorial(), 8);
        fuente.put(vbl.getJrbTipo(), 9);
        fuente.put(vbl.getJrbNombre(), 10);
        
        fuente.put(vbl.getJbBorrar(), 11);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (fuente.get(ae.getSource())) {
            case 1: {
                
                break;
            }
            case 2: {
                
                break;
            }
            case 3: {
            
                break;
            }
            case 4: {
                
                break;
            }
            case 5: {
                
                break;
            }
            case 6: {
                vbl.getJcbAutor().setEnabled(true);
                vbl.getJcbAño().setEnabled(false);
                vbl.getJcbEditorial().setEnabled(false);
                vbl.getJcbTipo().setEnabled(false);
                vbl.getJrbNombre().setEnabled(false);
                break;
            }
            case 7: {
                vbl.getJcbAutor().setEnabled(false);
                vbl.getJcbAño().setEnabled(true);
                vbl.getJcbEditorial().setEnabled(false);
                vbl.getJcbTipo().setEnabled(false);
                vbl.getJrbNombre().setEnabled(false);
                break;
            }
            case 8: {
                vbl.getJcbAutor().setEnabled(false);
                vbl.getJcbAño().setEnabled(false);
                vbl.getJcbEditorial().setEnabled(true);
                vbl.getJcbTipo().setEnabled(false);
                vbl.getJrbNombre().setEnabled(false);
                break;
            }
            case 9: {
                vbl.getJcbAutor().setEnabled(false);
                vbl.getJcbAño().setEnabled(false);
                vbl.getJcbEditorial().setEnabled(false);
                vbl.getJcbTipo().setEnabled(true);
                vbl.getJrbNombre().setEnabled(false);
                break;
            }
            case 10: {
                vbl.getJcbAutor().setEnabled(false);
                vbl.getJcbAño().setEnabled(false);
                vbl.getJcbEditorial().setEnabled(false);
                vbl.getJcbTipo().setEnabled(false);
                vbl.getJrbNombre().setEnabled(true);
                break;
            }
            case 11: {
                 if (gsr()!=-1 && gsc()!=-1){
                    if (vfa(5) !=null){
                        lid.eliminarLibro((int)vfa(0));
                        tabla.removeRow(gsr());
                        vbl.getJtListado().setModel(tabla);
                    }
                }
                break;
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        
    }
    
    private void llenarTabla() {
        for (Libro l : lista) {
            Vector v = new Vector();
            v.add(l.getAutor().getDni_autor());
            v.add(l.getAño());
            /*v.add(l.getEjemplar().getId_ejemplar());
            v.add(l.getFecha_inicio());
            if (l.getFecha_fin() == null) {
                v.add(null);
            } else {
                v.add(l.getFecha_fin());
            }
            tabla.addRow(v);*/
        }
        /*for (Ejemplar e : lista){*/

    }
    //valor fila actual
    private Object vfa(int columna) {
        return vbl.getJtListado().getValueAt(gsr(), columna);
    }

    //get selected row
    private int gsr() {
        return vbl.getJtListado().getSelectedRow();
    }

    //get selected column
    private int gsc() {
        return vbl.getJtListado().getSelectedColumn();
    }
}
