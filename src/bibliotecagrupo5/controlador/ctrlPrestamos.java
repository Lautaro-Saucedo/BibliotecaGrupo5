package bibliotecagrupo5.controlador;

import bibliotecagrupo5.vistas.viewPrestamos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;

/**
 *
 * @author Laucha
 */
public class ctrlPrestamos implements ActionListener, PropertyChangeListener{
    viewPrestamos vp;
    PrestamoData pd;
    LectorData ld;
    HashMap<Object,Integer> fuente = new HashMap<>();
    
    ctrlPrestamos(viewPrestamos vp, PrestamoData pd, LectorData ld){
        this.vp=vp;
        this.pd=pd;
        this.ld=ld;
        vp.getJcbLectores().addActionListener(this);
        vp.getJbRegD().addActionListener(this);
        vp.getJbRegP().addActionListener(this);
        vp.getJbEliminar().addActionListener(this);
        vp.getJdcFecha().addPropertyChangeListener(this);
        fuente.put(vp.getJbRegD(), 1);
        fuente.put(vp.getJbRegP(), 2);
        fuente.put(vp.getJbEliminar(), 3);
        fuente.put(vp.getJcbLectores(), 4);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (fuente.get(ae.getSource())){
            case 1:{
                System.out.println("click en Devolucion");
            }
            case 2:{
                System.out.println("click en Prestamo");
            }
            case 3:{
                System.out.println("click en Eliminar");
            }
            case 4:{
                System.out.println("combobox");
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
