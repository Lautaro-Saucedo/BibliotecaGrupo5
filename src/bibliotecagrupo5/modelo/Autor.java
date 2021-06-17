package bibliotecagrupo5.modelo;

import java.time.LocalDate;

/* @author @LXWeber Leandro Xavier Weber */

public class Autor {

    protected int dni_autor;
    protected String nombre_autor;
    protected String apellido_autor;
    protected LocalDate fecha_nacimiento;
    protected String nacionalidad;
    
    public Autor(){}

    public Autor(int dni_autor, String nombre_autor, String apellido_autor, LocalDate fecha_nacimiento, String nacionalidad) {
        this.dni_autor = dni_autor;
        this.nombre_autor = nombre_autor;
        this.apellido_autor = apellido_autor;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nacionalidad = nacionalidad;
    }

    public int getDni_autor() {
        return dni_autor;
    }

    public String getNombre_autor() {
        return nombre_autor;
    }

    public String getApellido_autor() {
        return apellido_autor;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setDni_autor(int dni_autor) {
        this.dni_autor = dni_autor;
    }

    public void setNombre_autor(String nombre_autor) {
        this.nombre_autor = nombre_autor;
    }

    public void setApellido_autor(String apellido_autor) {
        this.apellido_autor = apellido_autor;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return nombre_autor + " " + apellido_autor;
    }

    @Override
    public int hashCode() {
        return dni_autor;
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
        final Autor other = (Autor) obj;
        if (this.dni_autor != other.dni_autor) {
            return false;
        }
        return true;
    }
    
    
    
}
