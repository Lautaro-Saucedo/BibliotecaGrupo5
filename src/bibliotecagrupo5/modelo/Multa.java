package bibliotecagrupo5.modelo;

import java.time.LocalDate;

/* @author @LXWeber Leandro Xavier Weber */

public class Multa {
    
    protected int id_multa;
    protected LocalDate fecha_inicio;
    protected LocalDate fecha_fin;
    
    public Multa(){}
    
    public Multa(LocalDate fecha_inicio, LocalDate fecha_fin){
        this.fecha_inicio=fecha_inicio;
        this.fecha_fin=fecha_fin;
    }
    
    public Multa(int id_multa, LocalDate fecha_inicio, LocalDate fecha_fin){
        this.id_multa=id_multa;
        this.fecha_inicio=fecha_inicio;
        this.fecha_fin=fecha_fin;
    }

    public int getId_multa() {
        return id_multa;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }
    
    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setId_multa(int id_multa) {
        this.id_multa = id_multa;
    }

    public void setInicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }
    
    public void setFin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
}
