/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo5;

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
        PrestamoData pd = new PrestamoData();
        
        System.out.println();
        pd.eliminarPrestamo(pd.buscar(1));
        
    }
    
}
