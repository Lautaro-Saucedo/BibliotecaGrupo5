package bibliotecagrupo5.modelo;

import java.time.LocalDate;


/* @author @LXWeber Leandro Xavier Weber */

public class Multa {
    
    protected int id_multa;
    protected LocalDate inicio;
    
    public Multa(){}
    
    public Multa(LocalDate inicio){
        this.inicio=inicio;
    }
    
    public Multa(int id_multa, LocalDate inicio){
        this.id_multa=id_multa;
        this.inicio=inicio;
    }

    public int getId_multa() {
        return id_multa;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setId_multa(int id_multa) {
        this.id_multa = id_multa;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }
    
    
}
