package bibliotecagrupo5.modelo;

import java.time.LocalDate;


/* @author @LXWeber Leandro Xavier Weber */

public class Prestamo {
    
    protected int id_prestamo;
    protected Lector lector;
    protected Multa multa;
    protected Ejemplar ejemplar;
    protected LocalDate inicio;
    protected boolean estado;
    
    public Prestamo(){}
    
    public Prestamo(Lector lector, Multa multa, Ejemplar ejemplar, LocalDate inicio, boolean estado) {
        this.lector = lector;
        this.multa = multa;
        this.ejemplar = ejemplar;
        this.inicio = inicio;
        this.estado = estado;
    }

    public Prestamo(int id_prestamo, Lector lector, Multa multa, Ejemplar ejemplar, LocalDate inicio, boolean estado) {
        this.id_prestamo = id_prestamo;
        this.lector = lector;
        this.multa = multa;
        this.ejemplar = ejemplar;
        this.inicio = inicio;
        this.estado = estado;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public Lector getLector() {
        return lector;
    }

    public Multa getMulta() {
        return multa;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
}
