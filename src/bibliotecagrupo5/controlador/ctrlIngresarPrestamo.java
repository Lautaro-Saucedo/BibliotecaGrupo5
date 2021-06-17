package bibliotecagrupo5.controlador;

import bibliotecagrupo5.modelo.Ejemplar;
import bibliotecagrupo5.modelo.Lector;
import bibliotecagrupo5.modelo.Prestamo;
import bibliotecagrupo5.vistas.viewIngresarPrestamo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author Laucha
 */
public class ctrlIngresarPrestamo implements ActionListener{

    private viewIngresarPrestamo vap;
    private PrestamoData pd;
    private LectorData ld;
    private EjemplarData ed;

    public ctrlIngresarPrestamo(viewIngresarPrestamo vap, PrestamoData pd, LectorData ld, EjemplarData ed) {
        this.vap = vap;
        this.pd = pd;
        this.ld = ld;
        this.ed = ed;

        vap.getJbAgregar().addActionListener(this);
        vap.getJdcFecha().setDate(new Date());
        
        refrescar();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Prestamo p = new Prestamo();
        p.setEjemplar((Ejemplar)vap.getJcbEjemplar().getSelectedItem());
        p.setLector((Lector)vap.getJcbLector().getSelectedItem());
        if (vap.getJdcFecha().getDate()!=null){
            p.setFecha_inicio(vap.getJdcFecha().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        }
        p.setFecha_fin(null);
        p.setMulta(null);
        pd.agregarPrestamo(p);
        refrescar();
    }

    private void refrescar(){
        vap.getJcbLector().removeAllItems();
        vap.getJcbEjemplar().removeAllItems();
        for (Lector l : ld.listarLectores()) {
            if (l.isEstado_lector() && (pd.prestamosActuales(l)!=3)) {
                vap.getJcbLector().addItem(l);
            }
        }

        for (Ejemplar e : ed.listarEjemplares()) {
            if (e.getEstado() == 1) {
                vap.getJcbEjemplar().addItem(e);
            }
        }
    }
}
