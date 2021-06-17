package bibliotecagrupo5.controlador;

import bibliotecagrupo5.modelo.Autor;
import bibliotecagrupo5.modelo.Libro;
import bibliotecagrupo5.vistas.viewIngresarLibro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JOptionPane;

/* @author @LXWeber Leandro Xavier Weber */
public class ctrlIngresarLibro implements ActionListener {

    private viewIngresarLibro vil;
    private LibroData ld;
    private AutorData ad;
    private HashSet<String> tipos = new HashSet<>();
    private HashMap<Object, Integer> fuente = new HashMap<>();

    public ctrlIngresarLibro(viewIngresarLibro vil, LibroData ld, AutorData ad) {
        this.vil = vil;
        this.ld = ld;
        this.ad = ad;
        vil.getJbIngresar().addActionListener(this);
        vil.getJbLimpiar().addActionListener(this);
        vil.getJbAgregarTipo().addActionListener(this);

        fuente.put(vil.getJbIngresar(), 1);
        fuente.put(vil.getJbLimpiar(), 2);
        fuente.put(vil.getJbAgregarTipo(), 3);

        for (Autor a : ad.listarAutores()) {
            vil.getJcbAutores().addItem(a);
        }
        listaTipos();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (fuente.get(ae.getSource())) {
            case 1: {
                agregarLibro();
                break;
            }
            case 2: {
                limpiar();
                break;
            }
            case 3: {
                agregarTipo();
                break;
            }
        }
    }
    
    private void agregarLibro() {
        try {
            if (vil.getJtfIsbn().getText().equals("") || vil.getJtfNombre().getText().equals("") || vil.getJtfEditorial().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Error.\nHay campos en blanco.");
            } else {
                Libro l = new Libro();
                l.setIsbn(Integer.parseInt(vil.getJtfIsbn().getText()));
                l.setAutor((Autor) vil.getJcbAutores().getSelectedItem());
                l.setNombre(vil.getJtfNombre().getText());
                l.setEditorial(vil.getJtfEditorial().getText());
                l.setAño(vil.getJycAño().getYear());
                l.setTipo((String) vil.getJcbTipo().getSelectedItem());
                ld.ingresarLibro(l);
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Error./nISBN y Año deben ser numeros.");
        }
    }

    private void limpiar() {
        vil.getJtfIsbn().setText("");
        vil.getJtfNombre().setText("");
        vil.getJtfEditorial().setText("");
        vil.getJtfAgregarTipo().setText("");
        vil.getJcbTipo().setSelectedIndex(0);
        vil.getJcbAutores().setSelectedIndex(0);
    }
    
    private void listaTipos() {
        for (Libro l : ld.listarLibros()) {
            tipos.add(l.getTipo());
        }
        for (String s : tipos) {
            vil.getJcbTipo().addItem(s);
        }
    }

    private void agregarTipo() {
        tipos.add(vil.getJtfAgregarTipo().getText());
        vil.getJcbTipo().removeAllItems();
        for (String s : tipos) {
            vil.getJcbTipo().addItem(s);
        }
    }
}
