package bibliotecagrupo5.controlador;

import bibliotecagrupo5.modelo.Autor;
import bibliotecagrupo5.modelo.Libro;
import bibliotecagrupo5.vistas.viewListarLibros;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/* @author @LXWeber Leandro Xavier Weber */
public class ctrlListarLibros implements ActionListener, TableModelListener {

    private viewListarLibros vll;
    private LibroData ld;
    private EjemplarData ed;
    DefaultTableModel tabla;

    private HashMap<Object, Integer> fuente = new HashMap<>();
    private List<JComponent> rbuttons = new ArrayList<>();
    private List<Libro> libros= new ArrayList<>();

    public ctrlListarLibros(viewListarLibros vll, LibroData ld, EjemplarData ed) {
        this.vll = vll;
        this.ld = ld;
        this.ed = ed;
        libros = ld.listarLibros();
        tabla = (DefaultTableModel) vll.getJtListado().getModel();
        
        tabla.addTableModelListener(this);

        vll.getJbBorrar().addActionListener(this);
        vll.getJbBuscar().addActionListener(this);

        vll.getJcbAutor().addActionListener(this);
        vll.getJcbAño().addActionListener(this);
        vll.getJcbEditorial().addActionListener(this);
        vll.getJcbTipo().addActionListener(this);

        vll.getJrbAutor().addActionListener(this);
        vll.getJrbAño().addActionListener(this);
        vll.getJrbEditorial().addActionListener(this);
        vll.getJrbTipo().addActionListener(this);
        vll.getJrbNombre().addActionListener(this);

        fuente.put(vll.getJcbAutor(), 1);
        fuente.put(vll.getJcbAño(), 2);
        fuente.put(vll.getJcbEditorial(), 3);
        fuente.put(vll.getJcbTipo(), 4);

        fuente.put(vll.getJrbAutor(), 5);
        fuente.put(vll.getJrbAño(), 6);
        fuente.put(vll.getJrbEditorial(), 7);
        fuente.put(vll.getJrbTipo(), 8);
        fuente.put(vll.getJrbNombre(), 9);

        rbuttons.add(vll.getJcbAutor());
        rbuttons.add(vll.getJcbAño());
        rbuttons.add(vll.getJcbEditorial());
        rbuttons.add(vll.getJcbTipo());
        rbuttons.add(vll.getJtfNombre());

        fuente.put(vll.getJbBorrar(), 10);
        fuente.put(vll.getJbBuscar(), 11);

        
        vll.getJtListado().setAutoCreateRowSorter(true);
        cargarComboBox();
        llenarTabla();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (fuente.get(ae.getSource())) {
            case 1: {//cb autor
                filtros(1);
                break;
            }
            case 2: {//cb año
                filtros(2);
                break;
            }
            case 3: {//cb editorial
                filtros(3);
                break;
            }
            case 4: {//cb tipo
                filtros(4);
                break;
            }
            case 5: {//rb autor
                radiobuttons(0);
                filtros(1);
                break;
            }
            case 6: {//rb año
                radiobuttons(1);
                filtros(2);
                break;
            }
            case 7: {//rb editorial
                radiobuttons(2);
                filtros(3);
                break;
            }
            case 8: {//rb tipo
                radiobuttons(3);
                filtros(4);
                break;
            }
            case 9: {//rb titulo
                radiobuttons(4);
                filtros(5);
                break;
            }
            case 10: {
                borrar();
                break;
            }
            case 11: {
                filtros(5);
                break;
            }
            default:{
                break;
            }
        }
    }

    @Override
    public void tableChanged(TableModelEvent tme) {
        if (gsr() != -1 && gsc() != -1 && tme.getType() != -1) {
            Libro l = ld.buscarLibro((int) vfa(0));
            l.setNombre(vfa(2).toString());
            l.setEditorial(vfa(3).toString());
            l.setAño((int) vfa(4));
            l.setTipo(vfa(5).toString());
            ld.actualizarLibro(l);
        }
    }

    private void radiobuttons(int i) {
        for (JComponent jc : rbuttons) {
            if (jc.equals(rbuttons.get(i))) {
                jc.setEnabled(true);
            } else {
                jc.setEnabled(false);
            }
        }
    }

    private void filtros(int i) {
        borrarTabla();
        switch (i) {
            case 1: {
                llenarTabla(libros.stream().filter(l -> l.getAutor().equals(vll.getJcbAutor().getSelectedItem())).collect(Collectors.toList()));
                break;
            }
            case 2: {
                llenarTabla(libros.stream().filter(l -> l.getAño() == (int) vll.getJcbAño().getSelectedItem()).collect(Collectors.toList()));
                break;
            }
            case 3: {
                llenarTabla(libros.stream().filter(l -> l.getEditorial().equals(vll.getJcbEditorial().getSelectedItem())).collect(Collectors.toList()));
                break;
            }
            case 4: {
                llenarTabla(libros.stream().filter(l -> l.getTipo().equals(vll.getJcbTipo().getSelectedItem())).collect(Collectors.toList()));
                break;
            }
            case 5: {
                llenarTabla(ld.obtenerLibrosXTitulo(vll.getJtfNombre().getText()));
                break;
            }
        }
    }

    private void borrar() {
        if (gsr() != -1 && gsc() != -1) {
            if ((int) vfa(6) == 0) {
                Libro l = new Libro();
                l.setIsbn((int) vfa(0));
                libros.remove(l);
                ld.eliminarLibro((int) vfa(0));
                tabla.removeRow(gsr());

            } else {
                JOptionPane.showMessageDialog(null, "No se puede eliminar un libro con ejemplares registrados.");
            }
        }
    }

    private void llenarTabla() {
        for (Libro l : libros) {
            tabla.addRow(new Object[]{l.getIsbn(), l.getAutor().toString(), l.getNombre(), l.getEditorial(), l.getAño(), l.getTipo(), ed.cantEjemplares(l)});
        }
    }

    private void llenarTabla(List<Libro> lista) {
        for (Libro l : lista) {
            tabla.addRow(new Object[]{l.getIsbn(), l.getAutor().toString(), l.getNombre(), l.getEditorial(), l.getAño(), l.getTipo(), ed.cantEjemplares(l)});
        }
    }

    private void borrarTabla() {
        for (int i = tabla.getRowCount() - 1; i >= 0; i--) {
            tabla.removeRow(i);
        }
    }

    private void cargarComboBox() {
        HashSet<String> tipos = new HashSet<>();
        HashSet<Integer> años = new HashSet<>();
        HashSet<String> editoriales = new HashSet<>();
        HashSet<Autor> autores = new HashSet<>();

        for (Libro l : ld.listarLibros()) {
            autores.add(l.getAutor());
            tipos.add(l.getTipo());
            años.add(l.getAño());
            editoriales.add(l.getEditorial());
        }
        for (Autor a : autores) {
            vll.getJcbAutor().addItem(a);
        }
        for (String s : tipos) {
            vll.getJcbTipo().addItem(s);
        }
        for (Integer i : años) {
            vll.getJcbAño().addItem(i);
        }
        for (String s : editoriales) {
            vll.getJcbEditorial().addItem(s);
        }

    }

    //valor fila actual
    private Object vfa(int columna) {
        return vll.getJtListado().getValueAt(gsr(), columna);
    }

    //get selected row
    private int gsr() {
        return vll.getJtListado().getSelectedRow();
    }

    //get selected column
    private int gsc() {
        return vll.getJtListado().getSelectedColumn();
    }

}
