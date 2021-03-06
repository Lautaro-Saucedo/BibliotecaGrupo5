/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo5.vistas;

import bibliotecagrupo5.modelo.Libro;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author @LXWeber Leandro Xavier Weber
 */
public class viewListarEjemplares extends javax.swing.JInternalFrame {

    /**
     * Creates new form viewIngresarEjemplar
     */
    public viewListarEjemplares() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlLibro1 = new javax.swing.JLabel();
        jcbLibros = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEjemplares = new javax.swing.JTable();
        jbBorrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jlTituloIngresar = new javax.swing.JLabel();
        jcbLibro = new javax.swing.JCheckBox();
        jbCambiarEstado = new javax.swing.JButton();

        setClosable(true);

        jlLibro1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jlLibro1.setText("Libro:");

        jcbLibros.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jcbLibros.setEnabled(false);

        jtEjemplares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Ejemplar", "Nombre", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtEjemplares.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtEjemplares);
        if (jtEjemplares.getColumnModel().getColumnCount() > 0) {
            jtEjemplares.getColumnModel().getColumn(0).setMinWidth(100);
            jtEjemplares.getColumnModel().getColumn(0).setPreferredWidth(100);
            jtEjemplares.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        jbBorrar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jbBorrar.setText("Borrar");
        jbBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("(Estados: 0 prestado / 1 disponible / 2 retraso / 3 en reparación)");

        jlTituloIngresar.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        jlTituloIngresar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTituloIngresar.setText("Ejemplares");

        jcbLibro.setText("Por Libro");

        jbCambiarEstado.setText("Cambiar Estado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jlLibro1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jcbLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jcbLibro))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlTituloIngresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(jbBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(167, 167, 167)
                        .addComponent(jbCambiarEstado)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTituloIngresar)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlLibro1)
                    .addComponent(jcbLibros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbLibro))
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbBorrar)
                    .addComponent(jbCambiarEstado))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbBorrarActionPerformed

    public JButton getJbBorrar() {
        return jbBorrar;
    }

    public JCheckBox getJcbLibro() {
        return jcbLibro;
    }

    public JComboBox<Libro> getJcbLibros() {
        return jcbLibros;
    }

    public JTable getJtEjemplares() {
        return jtEjemplares;
    }

    public JButton getJbCambiarEstado() {
        return jbCambiarEstado;
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBorrar;
    private javax.swing.JButton jbCambiarEstado;
    private javax.swing.JCheckBox jcbLibro;
    private javax.swing.JComboBox<Libro> jcbLibros;
    private javax.swing.JLabel jlLibro1;
    private javax.swing.JLabel jlTituloIngresar;
    private javax.swing.JTable jtEjemplares;
    // End of variables declaration//GEN-END:variables
}
