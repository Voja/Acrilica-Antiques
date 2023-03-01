/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formKlijent;

import domain.Klijent;
import forms.MainForm;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import models.TableModelKlijenti;

/**
 *
 * @author Vojislav
 */
public class FormPretragaKlijenta extends javax.swing.JDialog {

    private int goldStatus = 0;
    private int silverStatus = 0;
    private int standardStatus = 0;

    public FormPretragaKlijenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setResizable(false);
        Image logo = Toolkit.getDefaultToolkit().getImage("src/logoIkonica/logo.png");
        setIconImage(logo);
        Color pozadina = new Color(231, 249, 255);
        getContentPane().setBackground(pozadina);
        setLocationRelativeTo(null);
        TableModelKlijenti model = new TableModelKlijenti();
        Thread th = new Thread(model);
        th.start();
        tblKlijenti.setModel(model);
        setTitle("Pretraga klijenta");
        lblRezultatPretrageKlijenata.setText("");
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
        tblKlijenti = new javax.swing.JTable();
        txtPretraga = new javax.swing.JTextField();
        btnDetalji = new javax.swing.JButton();
        lblRezultatPretrageKlijenata = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rbStandardStatus = new javax.swing.JRadioButton();
        rbSilverStatus = new javax.swing.JRadioButton();
        rbGoldStatus = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Pretraga (ime/prezime):");

        tblKlijenti.setBackground(new java.awt.Color(149, 210, 236));
        tblKlijenti.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblKlijenti);

        txtPretraga.setBackground(new java.awt.Color(149, 210, 236));
        txtPretraga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPretragaKeyReleased(evt);
            }
        });

        btnDetalji.setBackground(new java.awt.Color(149, 210, 236));
        btnDetalji.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnDetalji.setText("Detalji klijenta");
        btnDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetaljiActionPerformed(evt);
            }
        });

        lblRezultatPretrageKlijenata.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblRezultatPretrageKlijenata.setText("Rezultat Pretrage");
        lblRezultatPretrageKlijenata.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblRezultatPretrageKlijenata.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel2.setText("Filter (status klijenta):");

        rbStandardStatus.setFont(new java.awt.Font("SansSerif", 3, 14)); // NOI18N
        rbStandardStatus.setText("Standard");
        rbStandardStatus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rbStandardStatus.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        rbStandardStatus.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        rbStandardStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbStandardStatusActionPerformed(evt);
            }
        });

        rbSilverStatus.setFont(new java.awt.Font("SansSerif", 3, 14)); // NOI18N
        rbSilverStatus.setText("Silver");
        rbSilverStatus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rbSilverStatus.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        rbSilverStatus.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        rbSilverStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSilverStatusActionPerformed(evt);
            }
        });

        rbGoldStatus.setFont(new java.awt.Font("SansSerif", 3, 14)); // NOI18N
        rbGoldStatus.setText("Gold");
        rbGoldStatus.setBorder(null);
        rbGoldStatus.setBorderPainted(true);
        rbGoldStatus.setContentAreaFilled(false);
        rbGoldStatus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rbGoldStatus.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        rbGoldStatus.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        rbGoldStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbGoldStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPretraga))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel2)
                                .addGap(33, 33, 33)
                                .addComponent(rbStandardStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(rbSilverStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(rbGoldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnDetalji, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(291, 291, 291))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblRezultatPretrageKlijenata, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRezultatPretrageKlijenata, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rbStandardStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbSilverStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbGoldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDetalji)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPretragaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPretragaKeyReleased
        lblRezultatPretrageKlijenata.setText("");
        String param = txtPretraga.getText();
        ((TableModelKlijenti) tblKlijenti.getModel()).setParametar(param);
        TableModelKlijenti model = (TableModelKlijenti) tblKlijenti.getModel();
        if (model.getLista().isEmpty()) {
            lblRezultatPretrageKlijenata.setText("Sistem ne moze da nadje klijente po zadatoj vrednosti.");
        } else if (!model.getLista().isEmpty() && param.isEmpty()) {
            lblRezultatPretrageKlijenata.setText("");
        } else {
            lblRezultatPretrageKlijenata.setText("Sistem je nasao klijente po zadatoj vrednosti.");
        }

    }//GEN-LAST:event_txtPretragaKeyReleased

    private void btnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetaljiActionPerformed
        TableModelKlijenti model = (TableModelKlijenti) tblKlijenti.getModel();
        if (model.getLista().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Sistem ne moze da ucita klijenta.");
        }
        int row = tblKlijenti.getSelectedRow();
        if (row >= 0) {
            Klijent k = ((TableModelKlijenti) tblKlijenti.getModel()).getSelectedKlijent(row);
            JOptionPane.showMessageDialog(null, "Sistem je ucitao klijenta.");
            new FormDetaljiKlijenta(this, rootPaneCheckingEnabled, k).setVisible(true);
        }
        
        String param = txtPretraga.getText();
         if (model.getLista().isEmpty()) {
            lblRezultatPretrageKlijenata.setText("Sistem ne moze da nadje klijente po zadatoj vrednosti.");
        } else if (!model.getLista().isEmpty() && param.isEmpty()) {
            lblRezultatPretrageKlijenata.setText("");
        } else {
            lblRezultatPretrageKlijenata.setText("Sistem je nasao klijente po zadatoj vrednosti.");
        }
    }//GEN-LAST:event_btnDetaljiActionPerformed

    private void rbGoldStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbGoldStatusActionPerformed
        if (goldStatus == 1) {
            goldStatus = 0;
            rbGoldStatus.setSelected(false);
            rbGoldStatus.setIcon(null);
            String status = "";
            ((TableModelKlijenti) tblKlijenti.getModel()).setStatus(status);
            String param = txtPretraga.getText();
            ((TableModelKlijenti) tblKlijenti.getModel()).setParametar(param);
            TableModelKlijenti model = (TableModelKlijenti) tblKlijenti.getModel();
            if (model.getLista().isEmpty()) {
                lblRezultatPretrageKlijenata.setText("Sistem ne moze da nadje klijente po zadatoj vrednosti.");
            } else if (!model.getLista().isEmpty() && param.isEmpty()) {
                lblRezultatPretrageKlijenata.setText("");
            } else {
                lblRezultatPretrageKlijenata.setText("Sistem je nasao klijente po zadatoj vrednosti.");
            }
            return;
        }
        rbStandardStatus.setSelected(false);
        rbSilverStatus.setSelected(false);
        rbGoldStatus.setSelected(true);

        standardStatus = 0;
        silverStatus = 0;
        goldStatus = 1;

        ImageIcon icon = new ImageIcon("src/logoIkonica/rbGoldOznacen.png");
        rbGoldStatus.setIcon(icon);
        rbStandardStatus.setIcon(null);
        rbSilverStatus.setIcon(null);

        String status = rbGoldStatus.getText();
        ((TableModelKlijenti) tblKlijenti.getModel()).setStatus(status);
        String param = txtPretraga.getText();
        ((TableModelKlijenti) tblKlijenti.getModel()).setParametar(param);
        TableModelKlijenti model = (TableModelKlijenti) tblKlijenti.getModel();
        if (model.getLista().isEmpty()) {
            lblRezultatPretrageKlijenata.setText("Sistem ne moze da nadje klijente po zadatoj vrednosti.");
        } else if (!model.getLista().isEmpty() && param.isEmpty()) {
            lblRezultatPretrageKlijenata.setText("");
        } else {
            lblRezultatPretrageKlijenata.setText("Sistem je nasao klijente po zadatoj vrednosti.");
        }
    }//GEN-LAST:event_rbGoldStatusActionPerformed

    private void rbStandardStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbStandardStatusActionPerformed
        if (standardStatus == 1) {
            standardStatus = 0;
            rbStandardStatus.setSelected(false);
            rbStandardStatus.setIcon(null);
            String status = "";
            ((TableModelKlijenti) tblKlijenti.getModel()).setStatus(status);
            String param = txtPretraga.getText();
            ((TableModelKlijenti) tblKlijenti.getModel()).setParametar(param);
            TableModelKlijenti model = (TableModelKlijenti) tblKlijenti.getModel();
            if (model.getLista().isEmpty()) {
                lblRezultatPretrageKlijenata.setText("Sistem ne moze da nadje klijente po zadatoj vrednosti.");
            } else if (!model.getLista().isEmpty() && param.isEmpty()) {
                lblRezultatPretrageKlijenata.setText("");
            } else {
                lblRezultatPretrageKlijenata.setText("Sistem je nasao klijente po zadatoj vrednosti.");
            }
            return;
        }
        rbStandardStatus.setSelected(true);
        rbSilverStatus.setSelected(false);
        rbGoldStatus.setSelected(false);

        standardStatus = 1;
        silverStatus = 0;
        goldStatus = 0;

        ImageIcon icon = new ImageIcon("src/logoIkonica/rbStandardOznacen.png");
        rbStandardStatus.setIcon(icon);
        rbGoldStatus.setIcon(null);
        rbSilverStatus.setIcon(null);

        String status = rbStandardStatus.getText();
        ((TableModelKlijenti) tblKlijenti.getModel()).setStatus(status);
        String param = txtPretraga.getText();
        ((TableModelKlijenti) tblKlijenti.getModel()).setParametar(param);
        TableModelKlijenti model = (TableModelKlijenti) tblKlijenti.getModel();
        if (model.getLista().isEmpty()) {
            lblRezultatPretrageKlijenata.setText("Sistem ne moze da nadje klijente po zadatoj vrednosti.");
        } else if (!model.getLista().isEmpty() && param.isEmpty()) {
            lblRezultatPretrageKlijenata.setText("");
        } else {
            lblRezultatPretrageKlijenata.setText("Sistem je nasao klijente po zadatoj vrednosti.");
        }

    }//GEN-LAST:event_rbStandardStatusActionPerformed

    private void rbSilverStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSilverStatusActionPerformed
        if (silverStatus == 1) {
            silverStatus = 0;
            rbSilverStatus.setSelected(false);
            rbSilverStatus.setIcon(null);
            String status = "";
            ((TableModelKlijenti) tblKlijenti.getModel()).setStatus(status);
            String param = txtPretraga.getText();
            ((TableModelKlijenti) tblKlijenti.getModel()).setParametar(param);
            TableModelKlijenti model = (TableModelKlijenti) tblKlijenti.getModel();
            if (model.getLista().isEmpty()) {
                lblRezultatPretrageKlijenata.setText("Sistem ne moze da nadje klijente po zadatoj vrednosti.");
            } else if (!model.getLista().isEmpty() && param.isEmpty()) {
                lblRezultatPretrageKlijenata.setText("");
            } else {
                lblRezultatPretrageKlijenata.setText("Sistem je nasao klijente po zadatoj vrednosti.");
            }
            return;
        }
        rbStandardStatus.setSelected(false);
        rbSilverStatus.setSelected(true);
        rbGoldStatus.setSelected(false);

        standardStatus = 0;
        silverStatus = 1;
        goldStatus = 0;

        ImageIcon icon = new ImageIcon("src/logoIkonica/rbSilverOznacen.png");
        rbSilverStatus.setIcon(icon);
        rbGoldStatus.setIcon(null);
        rbStandardStatus.setIcon(null);

        String status = rbSilverStatus.getText();
        ((TableModelKlijenti) tblKlijenti.getModel()).setStatus(status);
        String param = txtPretraga.getText();
        ((TableModelKlijenti) tblKlijenti.getModel()).setParametar(param);
        TableModelKlijenti model = (TableModelKlijenti) tblKlijenti.getModel();
        if (model.getLista().isEmpty()) {
            lblRezultatPretrageKlijenata.setText("Sistem ne moze da nadje klijente po zadatoj vrednosti.");
        } else if (!model.getLista().isEmpty() && param.isEmpty()) {
            lblRezultatPretrageKlijenata.setText("");
        } else {
            lblRezultatPretrageKlijenata.setText("Sistem je nasao klijente po zadatoj vrednosti.");
        }
    }//GEN-LAST:event_rbSilverStatusActionPerformed

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
            java.util.logging.Logger.getLogger(FormPretragaKlijenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPretragaKlijenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPretragaKlijenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPretragaKlijenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormPretragaKlijenta dialog = new FormPretragaKlijenta(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRezultatPretrageKlijenata;
    private javax.swing.JRadioButton rbGoldStatus;
    private javax.swing.JRadioButton rbSilverStatus;
    private javax.swing.JRadioButton rbStandardStatus;
    private javax.swing.JTable tblKlijenti;
    private javax.swing.JTextField txtPretraga;
    // End of variables declaration//GEN-END:variables

    void refreshTable() {
        TableModelKlijenti tm = (TableModelKlijenti) tblKlijenti.getModel();
        tm.refreshTable();
    }

    void popuniKlijente() {
        MainForm mf = (MainForm) getParent();
        mf.popuniKlijente();
    }

}