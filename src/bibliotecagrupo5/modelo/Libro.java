package bibliotecagrupo5.modelo;

/* @author @LXWeber Leandro Xavier Weber */

public class Libro {

    protected int isbn;
    protected Autor autor;
    protected String nombre;
    protected String editorial;
    protected int año;
    protected String tipo;
    
    public Libro(){}

    public Libro(int isbn, Autor autor, String nombre, String editorial, int año, String tipo) {
        this.isbn = isbn;
        this.autor = autor;
        this.nombre = nombre;
        this.editorial = editorial;
        this.año = año;
        this.tipo = tipo;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIsbn() {
        return isbn;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getAño() {
        return año;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
    
}
