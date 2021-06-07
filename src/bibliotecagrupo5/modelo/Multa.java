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

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }
    
    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    @Override
    public int hashCode() {
        return id_multa;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Multa other = (Multa) obj;
        if (this.id_multa != other.id_multa) {
            return false;
        }
        return true;
    }
    
    
}
