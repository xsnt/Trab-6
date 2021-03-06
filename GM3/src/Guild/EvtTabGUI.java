/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guild;

import javax.swing.JTable;

/**
 *
 * @author Jean
 */
public class EvtTabGUI extends javax.swing.JFrame {
    private EvtTabControlador controlador;
    /**
     * Creates new form EvtTabGUI
     */
    public EvtTabGUI() {
        initComponents();
        controlador = new EvtTabControlador(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabHue = new javax.swing.JTable();
        fecharTab = new javax.swing.JButton();
        partEvt = new javax.swing.JButton();
        removeEvt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe Print", 0, 11)); // NOI18N
        jLabel1.setText("Tabelinha!!! WEEEE!!!!!");

        tabHue.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabHue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabHue);

        fecharTab.setText("Fechar");
        fecharTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharTabActionPerformed(evt);
            }
        });

        partEvt.setText("Participantes");
        partEvt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partEvtActionPerformed(evt);
            }
        });

        removeEvt.setText("Remover");
        removeEvt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEvtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(fecharTab)
                .addGap(164, 164, 164)
                .addComponent(partEvt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                .addComponent(removeEvt)
                .addGap(107, 107, 107))
            .addGroup(layout.createSequentialGroup()
                .addGap(323, 323, 323)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecharTab)
                    .addComponent(partEvt)
                    .addComponent(removeEvt))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fecharTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharTabActionPerformed
      this.setVisible(false);
    }//GEN-LAST:event_fecharTabActionPerformed

    private void partEvtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partEvtActionPerformed
        controlador.listaPersonagens();
    }//GEN-LAST:event_partEvtActionPerformed

    private void removeEvtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeEvtActionPerformed
       controlador.removeEvt();
    }//GEN-LAST:event_removeEvtActionPerformed

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
            java.util.logging.Logger.getLogger(EvtTabGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EvtTabGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EvtTabGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EvtTabGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EvtTabGUI().setVisible(true);
            }
        });
    }
     private void jButtonListaPersonagemActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        controlador.listaPersonagens();
    }                                                      

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {                                              
        this.setVisible(false);
    }                                             

    private void jButtonRemoveEvtActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        controlador.removeEvt();
    }  
    public JTable getTabela(){
        return this.tabHue;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fecharTab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton partEvt;
    private javax.swing.JButton removeEvt;
    private javax.swing.JTable tabHue;
    // End of variables declaration//GEN-END:variables
}
