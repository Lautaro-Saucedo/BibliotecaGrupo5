package bibliotecagrupo5.controlador;

import bibliotecagrupo5.modelo.Autor;
import bibliotecagrupo5.modelo.Libro;
import bibliotecagrupo5.vistas.viewBuscarLibro;
import bibliotecagrupo5.vistas.viewIngresarLibro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/* @author @LXWeber Leandro Xavier Weber */

public class ctrlLibro implements ActionListener, TableModelListener{
    
    private viewIngresarLibro vil;
    private viewBuscarLibro vbl;
    private LibroData ld;
    private List<Libro> lista = new ArrayList<>();
    private DefaultTableModel model;
    private HashMap<Object, Integer> fuente = new HashMap<>();
    
    public ctrlLibro(viewIngresarLibro vil, LibroData ld) {
        this.vil = vil;
        this.ld = ld;
        vil.getJbIngresar().addActionListener(this);
        vil.getJbLimpiar().addActionListener(this);
        fuente.put(vil.getJbIngresar(), 1);
        fuente.put(vil.getJbLimpiar(), 2);
    }
    
    public ctrlLibro(viewBuscarLibro vbl, LibroData ld) {
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return !(column == 0 || column == 1);
            }
        };
        model.addTableModelListener(this);
        this.vbl = vbl;
        this.ld = ld;
        lista = ld.listarLibros();
        vbl.getJbBorrar().addActionListener(this);
        fuente.put(vbl.getJbBorrar(), 3);
        cabecera();
        llenarLista();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (fuente.get(ae.getSource())) {
            //-----------------viewIngresarLibro---------------------
            case 1: {
                try {
                    if (vil.getJtfIsbn().getText().equals("") || vil.getJtfNombre().getText().equals("") || vil.getJtfEditorial().getText().equals("") || vil.getJtfAño().getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Error.\nHay campos en blanco.");
                    } else {
                        Libro l = new Libro();
                        l.setIsbn(Integer.parseInt(vil.getJtfIsbn().getText()));
                        l.setAutor(vil.getJcbAutores());
                        l.setNombre(vil.getJtfNombre().getText());
                        l.setEditorial(vil.getJtfEditorial().getText());
                        l.setAño(Integer.parseInt(vil.getJtfAño().getText()));
                        l.setTipo(vil.getJcbTipo());
                        ld.ingresarLibro(l);
                    }
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Error./nISBN y Año deben ser numeros.");
                }
                break;
            }
            case 2: {
                vil.getJtfIsbn().setText("");
                vil.getJtfNombre().setText("");
                vil.getJtfEditorial().setText("");
                vil.getJtfAño().setText("");
                break;
            }
            //--------------------viewBuscarLibro--------------------------
            case 3: {
                try {
                    if (gsr() != -1 && gsc() != -1) {
                        Integer isbn = (Integer) vfa(0);
                        ld.eliminarLibro(isbn);
                        model.removeRow(gsr());
                        vbl.getJtListado().setModel(model);
                    }
                } catch (SQLException sqle) {
                    JOptionPane.showMessageDialog(vbl, "Error al eliminar Libro.\nAsegúrese de que no tenga Ejemplares antes de intentar eliminarlo permanentemente.");
                }
                break;
            }
        }
    }

    @Override
    public void tableChanged(TableModelEvent tme) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //----------------------------------------------------
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

    private void cabecera() {
        model.addColumn("ISBN");
        model.addColumn("Autor");
        model.addColumn("Titulo");
        model.addColumn("Editorial");
        model.addColumn("Año");
        model.addColumn("Tipo");
        model.addColumn("Cantidad Ejemplares");
        model.addColumn("Ejemplares Disponibles");
        vbl.getJtListado().setModel(model);
    }

    private void llenarLista() {
        for (Libro a : lista) {
            model.addRow(new Object[]{a.getIsbn(), a.getNombre(), a.getApellido(), a.getFecha_nac(), a.isEstado()});
        }
        vbl.getJtListado().setModel(model);
    }

}
