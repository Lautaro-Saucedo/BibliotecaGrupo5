package bibliotecagrupo5.modelo;

import java.time.LocalDate;

/* @author @LXWeber Leandro Xavier Weber */

public class Prestamo {
    
    protected int id_prestamo;
    protected Lector lector;
    protected Multa multa;
    protected Ejemplar ejemplar;
    protected LocalDate fecha_inicio;
    protected LocalDate fecha_fin;
    
    public Prestamo(){}
    
    public Prestamo(Lector lector, Multa multa, Ejemplar ejemplar, LocalDate fecha_inicio, LocalDate fecha_fin) {
        this.lector = lector;
        this.multa = multa;
        this.ejemplar = ejemplar;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public Prestamo(int id_prestamo, Lector lector, Multa multa, Ejemplar ejemplar, LocalDate fecha_inicio, LocalDate fecha_fin) {
        this.id_prestamo = id_prestamo;
        this.lector = lector;
        this.multa = multa;
        this.ejemplar = ejemplar;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
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

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
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

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }
    
    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
    
}