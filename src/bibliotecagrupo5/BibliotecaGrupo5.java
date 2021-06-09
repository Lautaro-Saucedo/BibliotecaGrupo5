/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    /**
     * @param args the command line arguments
     */
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
