package bibliotecagrupo5.controlador;

import bibliotecagrupo5.modelo.Ejemplar;
import bibliotecagrupo5.modelo.Libro;
import bibliotecagrupo5.vistas.viewIngresarEjemplares;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Laucha
 */
public class ctrlIngresarEjemplares implements ActionListener {

    private viewIngresarEjemplares vie;
    private LibroData ld;
    private EjemplarData ed;

    public ctrlIngresarEjemplares(viewIngresarEjemplares vie, LibroData ld, EjemplarData ed) {
        this.vie = vie;
        this.ld = ld;
        this.ed = ed;

        vie.getJbGuardar().addActionListener(this);

        for (Libro l : ld.listarLibros()) {
            vie.getJcbLibros().addItem(l);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Ejemplar e = new Ejemplar();
        e.setLibro((Libro) vie.getJcbLibros().getSelectedItem());
        ed.ingresarEjemplares(e, (int)vie.getJsCantidad().getValue());
    }

}
