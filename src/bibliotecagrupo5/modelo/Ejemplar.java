package bibliotecagrupo5.modelo;


/* @author @LXWeber Leandro Xavier Weber */

public class Ejemplar {
    
    protected int id_ejemplar;
    protected Libro libro;
    protected boolean estado;
    
    public Ejemplar(){}
    
    public Ejemplar(Libro libro, boolean estado) {
        this.libro = libro;
        this.estado = estado;
    }

    public Ejemplar(int id_ejemplar, Libro libro, boolean estado) {
        this.id_ejemplar = id_ejemplar;
        this.libro = libro;
        this.estado = estado;
    }

    public int getId_ejemplar() {
        return id_ejemplar;
    }

    public Libro getLibro() {
        return libro;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setId_ejemplar(int id_ejemplar) {
        this.id_ejemplar = id_ejemplar;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}