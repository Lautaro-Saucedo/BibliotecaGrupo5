package bibliotecagrupo5;

import bibliotecagrupo5.controlador.AutorData;
import bibliotecagrupo5.controlador.EjemplarData;
import bibliotecagrupo5.controlador.LectorData;
import bibliotecagrupo5.controlador.LibroData;
import bibliotecagrupo5.controlador.MultaData;
import bibliotecagrupo5.controlador.PrestamoData;

/**
 *
 * @author Laucha
 */

public class BibliotecaGrupo5 {

    public static void main(String[] args) {
        
        //Buenas profe! le recomiendo cargar de nuevo el script de la DB 
        //la anterior tenia datos invalidos en las tablas, la nueva deberia estar limpia.
        //dejamos la tabla de multas vacia para que pruebe generarMultas()
        //por ultimo, los controles no son demasiado rigurosos, nuestra intencion
        //es validar todo desde las vistas en la proxima entrega
        
        AutorData ad = new AutorData();
        EjemplarData ed = new EjemplarData();
        LectorData lecd = new LectorData();
        LibroData libd = new LibroData();
        MultaData md = new MultaData();
        PrestamoData pd = new PrestamoData();
        
        //pd.generarMultas();
    }
}