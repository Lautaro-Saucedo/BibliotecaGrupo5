/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo5.vistas;

import bibliotecagrupo5.controlador.AutorData;
import bibliotecagrupo5.controlador.EjemplarData;
import bibliotecagrupo5.controlador.LectorData;
import bibliotecagrupo5.controlador.LibroData;
import bibliotecagrupo5.controlador.MultaData;
import bibliotecagrupo5.controlador.PrestamoData;
import bibliotecagrupo5.controlador.ctrlAgregarPrestamo;

import bibliotecagrupo5.controlador.ctrlAutor;
import bibliotecagrupo5.controlador.ctrlIngresarLibro;
import bibliotecagrupo5.controlador.ctrlListarAutores;

import bibliotecagrupo5.controlador.ctrlListarMultas;

import bibliotecagrupo5.controlador.ctrlListarPrestamos;
import javax.swing.JFrame;

/**
 *
 * @author @LXWeber Leandro Xavier Weber
 */
public class viewMenu extends javax.swing.JFrame {
    private AutorData ad = new AutorData();
    private EjemplarData ed = new EjemplarData();
    private LectorData led = new LectorData();
    private LibroData lid = new LibroData();
    private MultaData md = new MultaData();
    private PrestamoData pd = new PrestamoData();
    /**
     * Creates new form viewMenu
     */
    public viewMenu() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmAutor = new javax.swing.JMenu();
        jmiIngresarAutor = new javax.swing.JMenuItem();
        jmiListarAutores = new javax.swing.JMenuItem();
        jmLibro = new javax.swing.JMenu();
        jmiIngresarLibro = new javax.swing.JMenuItem();
        jmiBuscarLibro = new javax.swing.JMenuItem();
        jmEjemplar = new javax.swing.JMenu();
        jmiIngrModifEjemplares = new javax.swing.JMenuItem();
        jmiBuscarBorrar = new javax.swing.JMenuItem();
        jmLector = new javax.swing.JMenu();
        jmiIngresarLector = new javax.swing.JMenuItem();
        jmPrestamo = new javax.swing.JMenu();
        jmiAgregarPrestamo = new javax.swing.JMenuItem();
        jmiListarPrestamos = new javax.swing.JMenuItem();
        jmMulta = new javax.swing.JMenu();
        jmiListarMultas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 479, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        jMenuBar1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jmAutor.setText("Autor");
        jmAutor.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jmiIngresarAutor.setText("Ingresar Autor");
        jmiIngresarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiIngresarAutorActionPerformed(evt);
            }
        });
        jmAutor.add(jmiIngresarAutor);

        jmiListarAutores.setText("Listar Autores");
        jmiListarAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiListarAutoresActionPerformed(evt);
            }
        });
        jmAutor.add(jmiListarAutores);

        jMenuBar1.add(jmAutor);

        jmLibro.setText("Libro");
        jmLibro.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jmiIngresarLibro.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jmiIngresarLibro.setText("Ingresar Libro");
        jmiIngresarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiIngresarLibroActionPerformed(evt);
            }
        });
        jmLibro.add(jmiIngresarLibro);

        jmiBuscarLibro.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jmiBuscarLibro.setText("Buscar Libro");
        jmiBuscarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiBuscarLibroActionPerformed(evt);
            }
        });
        jmLibro.add(jmiBuscarLibro);

        jMenuBar1.add(jmLibro);

        jmEjemplar.setText("Ejemplar");
        jmEjemplar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jmEjemplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEjemplarActionPerformed(evt);
            }
        });

        jmiIngrModifEjemplares.setText("Ingresar / Modificar");
        jmEjemplar.add(jmiIngrModifEjemplares);

        jmiBuscarBorrar.setText("Buscar / Borrar");
        jmEjemplar.add(jmiBuscarBorrar);

        jMenuBar1.add(jmEjemplar);

        jmLector.setText("Lector");
        jmLector.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jmiIngresarLector.setText("Ingresar Lector");
        jmLector.add(jmiIngresarLector);

        jMenuBar1.add(jmLector);

        jmPrestamo.setText("Prestamo");
        jmPrestamo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jmiAgregarPrestamo.setText("Agregar Prestamo");
        jmiAgregarPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAgregarPrestamoActionPerformed(evt);
            }
        });
        jmPrestamo.add(jmiAgregarPrestamo);

        jmiListarPrestamos.setText("Listar Prestamos");
        jmiListarPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiListarPrestamosActionPerformed(evt);
            }
        });
        jmPrestamo.add(jmiListarPrestamos);

        jMenuBar1.add(jmPrestamo);

        jmMulta.setText("Multa");
        jmMulta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jmiListarMultas.setText("Listar Multas");
        jmiListarMultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiListarMultasActionPerformed(evt);
            }
        });
        jmMulta.add(jmiListarMultas);

        jMenuBar1.add(jmMulta);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiBuscarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiBuscarLibroActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        viewBuscarLibro vbl = new viewBuscarLibro();
        escritorio.add(vbl);
        vbl.setVisible(true);
    }//GEN-LAST:event_jmiBuscarLibroActionPerformed

    private void jmEjemplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEjemplarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmEjemplarActionPerformed

    private void jmiListarPrestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiListarPrestamosActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        viewListarPrestamos vp = new viewListarPrestamos();
        ctrlListarPrestamos ctrlP = new ctrlListarPrestamos(vp,pd,led);
        escritorio.add(vp);
        vp.setVisible(true); 
        
    }//GEN-LAST:event_jmiListarPrestamosActionPerformed

    private void jmiAgregarPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAgregarPrestamoActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        viewAgregarPrestamo vap = new viewAgregarPrestamo();
        ctrlAgregarPrestamo cap = new ctrlAgregarPrestamo(vap,pd,led,ed);
        escritorio.add(vap);
        vap.setVisible(true);
    }//GEN-LAST:event_jmiAgregarPrestamoActionPerformed


    private void jmiIngresarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiIngresarAutorActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        viewIngresarAutor via = new viewIngresarAutor();
        ctrlAutor ctrlA = new ctrlAutor(via,ad);
        escritorio.add(via);
        via.setVisible(true);
    }//GEN-LAST:event_jmiIngresarAutorActionPerformed

    private void jmiIngresarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiIngresarLibroActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        viewIngresarLibro vil = new viewIngresarLibro();
        ctrlIngresarLibro ctrlL = new ctrlIngresarLibro(vil,lid,ad);
        escritorio.add(vil);
        vil.setVisible(true);
    }//GEN-LAST:event_jmiIngresarLibroActionPerformed

    private void jmiListarMultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiListarMultasActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        viewListarMultas vlm = new viewListarMultas();
        ctrlListarMultas clm = new ctrlListarMultas(vlm,md,pd,led);
        escritorio.add(vlm);
        vlm.setVisible(true);
    }//GEN-LAST:event_jmiListarMultasActionPerformed

    private void jmiListarAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiListarAutoresActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        viewListarAutores vla = new viewListarAutores();
        ctrlListarAutores cla = new ctrlListarAutores(vla,ad);
        escritorio.add(vla);
        vla.setVisible(true);
    }//GEN-LAST:event_jmiListarAutoresActionPerformed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(viewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu jmAutor;
    private javax.swing.JMenu jmEjemplar;
    private javax.swing.JMenu jmLector;
    private javax.swing.JMenu jmLibro;
    private javax.swing.JMenu jmMulta;
    private javax.swing.JMenu jmPrestamo;
    private javax.swing.JMenuItem jmiAgregarPrestamo;
    private javax.swing.JMenuItem jmiBuscarBorrar;
    private javax.swing.JMenuItem jmiBuscarLibro;
    private javax.swing.JMenuItem jmiIngrModifEjemplares;
    private javax.swing.JMenuItem jmiIngresarAutor;
    private javax.swing.JMenuItem jmiIngresarLector;
    private javax.swing.JMenuItem jmiIngresarLibro;
    private javax.swing.JMenuItem jmiListarAutores;
    private javax.swing.JMenuItem jmiListarMultas;
    private javax.swing.JMenuItem jmiListarPrestamos;
    // End of variables declaration//GEN-END:variables
}
