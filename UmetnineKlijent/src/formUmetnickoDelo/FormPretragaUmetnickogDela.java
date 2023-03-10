/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formUmetnickoDelo;

import controller.ClientController;
import domain.UmetnickoDelo;
import forms.MainForm;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import models.TableModelUmetnickaDela;

/**
 *
 * @author Vojislav
 */
public class FormPretragaUmetnickogDela extends javax.swing.JDialog {

    public FormPretragaUmetnickogDela(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setResizable(false);
        Image logo = Toolkit.getDefaultToolkit().getImage("src/logoIkonica/logo.png");
        setIconImage(logo);
        Color pozadina = new Color(231, 249, 255);
        getContentPane().setBackground(pozadina);
        setLocationRelativeTo(null);
        TableModelUmetnickaDela model = new TableModelUmetnickaDela();
        Thread th = new Thread(model);
        th.start();
        tblUmetnickaDela.setModel(model);
        setTitle("Pretraga umetnickog dela");
        lblRezultatPretrageUmetnickihDela.setText("");
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
        tblUmetnickaDela = new javax.swing.JTable();
        txtPretraga = new javax.swing.JTextField();
        btnDetalji = new javax.swing.JButton();
        lblRezultatPretrageUmetnickihDela = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Pretraga (naziv dela):");

        tblUmetnickaDela.setBackground(new java.awt.Color(149, 210, 236));
        tblUmetnickaDela.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblUmetnickaDela);

        txtPretraga.setBackground(new java.awt.Color(149, 210, 236));
        txtPretraga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPretragaKeyReleased(evt);
            }
        });

        btnDetalji.setBackground(new java.awt.Color(149, 210, 236));
        btnDetalji.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnDetalji.setText("Detalji umetnickog dela");
        btnDetalji.setOpaque(true);
        btnDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetaljiActionPerformed(evt);
            }
        });

        lblRezultatPretrageUmetnickihDela.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblRezultatPretrageUmetnickihDela.setText("Rezultat Pretrage");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPretraga)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnDetalji, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(291, 291, 291))
            .addGroup(layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(lblRezultatPretrageUmetnickihDela, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRezultatPretrageUmetnickihDela, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDetalji, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPretragaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPretragaKeyReleased
        if (lblRezultatPretrageUmetnickihDela.getText().isEmpty()) {
            lblRezultatPretrageUmetnickihDela.setText("");
        }
        String param = txtPretraga.getText();
        ((TableModelUmetnickaDela) tblUmetnickaDela.getModel()).setParametar(param);
        TableModelUmetnickaDela model = (TableModelUmetnickaDela) tblUmetnickaDela.getModel();
        if (model.getLista().isEmpty()) {
            lblRezultatPretrageUmetnickihDela.setText("Sistem ne moze da nadje umetnicka dela po zadatoj vrednosti.");
        } else if (!model.getLista().isEmpty() && param.isEmpty()) {
            lblRezultatPretrageUmetnickihDela.setText("");
        } else {
            lblRezultatPretrageUmetnickihDela.setText("Sistem je nasao umetnicka dela po zadatoj vrednosti.");
        }
    }//GEN-LAST:event_txtPretragaKeyReleased

    private void btnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetaljiActionPerformed
        int row = tblUmetnickaDela.getSelectedRow();
        if (row >= 0) {
            UmetnickoDelo ud = ((TableModelUmetnickaDela) tblUmetnickaDela.getModel()).getSelectedUmetnickoDelo(row);
            JOptionPane.showMessageDialog(null, "Sistem je ucitao umetnicko delo.");
            new FormDetaljiUmetnickogDela(this, rootPaneCheckingEnabled, ud).setVisible(true);
        }
        TableModelUmetnickaDela model = (TableModelUmetnickaDela) tblUmetnickaDela.getModel();
        if (model.getLista().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Sistem ne moze da ucita umetnicko delo.");
        }
    }//GEN-LAST:event_btnDetaljiActionPerformed

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
            java.util.logging.Logger.getLogger(FormPretragaUmetnickogDela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPretragaUmetnickogDela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPretragaUmetnickogDela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPretragaUmetnickogDela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormPretragaUmetnickogDela dialog = new FormPretragaUmetnickogDela(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalji;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRezultatPretrageUmetnickihDela;
    private javax.swing.JTable tblUmetnickaDela;
    private javax.swing.JTextField txtPretraga;
    // End of variables declaration//GEN-END:variables

    void refreshTable() {
        TableModelUmetnickaDela tm = (TableModelUmetnickaDela) tblUmetnickaDela.getModel();
        tm.refreshTable();
    }

    void popuniUmetnickaDela(UmetnickoDelo ud) {
        MainForm mf = (MainForm) getParent();
        mf.popuniUmetnickaDela(ud.getTipDela());
        mf.popuniTipoveDela();
    }


}
