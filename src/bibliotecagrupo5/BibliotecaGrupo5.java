/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo5;

import bibliotecagrupo5.controlador.PrestamoData;
import bibliotecagrupo5.modelo.Ejemplar;
import bibliotecagrupo5.modelo.Lector;
import bibliotecagrupo5.modelo.Multa;

/**
 *
 * @author Laucha
 */
public class BibliotecaGrupo5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PrestamoData pd = new PrestamoData();
        
        Lector l = new Lector();
        Multa m = new Multa();
        Ejemplar e = new Ejemplar();
        
        e.setId_ejemplar(9);
        l.setDni_lector(2000);
        
        
        
    }
    
}
