package bibliotecagrupo5.modelo;


/* @author @LXWeber Leandro Xavier Weber */

// Unicos posibles estados de los ejemplares
// 0 prestado
// 1 disponible
// 2 retraso
// 3 reparacion

public class Ejemplar {
    
    protected int id_ejemplar;
    protected Libro libro;
    protected int estado;
    
    public Ejemplar(){}
    
    public Ejemplar(Libro libro, int estado) {
        this.libro = libro;
        this.estado = estado;
    }

    public Ejemplar(int id_ejemplar, Libro libro, int estado) {
        this.id_ejemplar = id_ejemplar;
        this.libro = libro;
        this.estado = estado;
    }
        
    public int cambiarEstado(int e){
        if(e>-1&&e<4){
            this.estado=e;
            return estado;
        } else {
            return -1;
        }
    }
    
    public int getId_ejemplar() {
        return id_ejemplar;
    }

    public Libro getLibro() {
        return libro;
    }

    public int getEstado() {
        return estado;
    }

    public void setId_ejemplar(int id_ejemplar) {
        this.id_ejemplar = id_ejemplar;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}