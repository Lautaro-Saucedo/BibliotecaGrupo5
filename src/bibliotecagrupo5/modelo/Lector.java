package bibliotecagrupo5.modelo;

/* @author @LXWeber Leandro Xavier Weber */

public class Lector {
    
    protected long dni_lector;
    protected String nombre_lector;
    protected String apellido_lector;
    protected boolean estado_lector;
    
    public Lector(){}
    
    public Lector(long dni_lector, String nombre_lector, String apellido_lector, boolean estado_lector) {
        this.dni_lector = dni_lector;
        this.nombre_lector = nombre_lector;
        this.apellido_lector = apellido_lector;
        this.estado_lector = estado_lector;
    }

    public long getDni_lector() {
        return dni_lector;
    }

    public String getNombre_lector() {
        return nombre_lector;
    }

    public String getApellido_lector() {
        return apellido_lector;
    }

    public boolean isEstado_lector() {
        return estado_lector;
    }

    public void setDni_lector(long dni_lector) {
        this.dni_lector = dni_lector;
    }

    public void setNombre_lector(String nombre_lector) {
        this.nombre_lector = nombre_lector;
    }

    public void setApellido_lector(String apellido_lector) {
        this.apellido_lector = apellido_lector;
    }

    public void setEstado_lector(boolean estado_lector) {
        this.estado_lector = estado_lector;
    }
    
}