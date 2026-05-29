/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Karina Kaprodi
 */
public class Setel_alarm_1 extends javax.swing.JFrame {
    private KoneksiDB.AlarmDB database_alarm;

    public Setel_alarm_1() {
    initComponents();
 
    database_alarm = new KoneksiDB.AlarmDB(); 
    setJanji(); 
    }
    
    private void setJanji() {
    CB_Janji.removeAllItems();
    
    try {
        //Ambil data dari database 
        java.sql.ResultSet rs = database_alarm.ambilSemuaJanji();
        //Masukkan data satu perdatu ke ComboBox
        while (rs != null && rs.next()) {
            String namaJanji = rs.getString("appointment"); 
            CB_Janji.addItem(namaJanji);
        }
    } catch (Exception e) {
        System.out.println("Error saat mengisi JComboBox: " + e.getMessage());
    }
    }
    
    private int ambilIDJanji() {
    //Ambil janji yangdipilih user di ComboBox
    String janjiDipilih = CB_Janji.getSelectedItem().toString();
    //Oper ke fungsi yang di AlarmDB
    return database_alarm.cariIDJanji(janjiDipilih);
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Navbar = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        L_Hour = new javax.swing.JLabel();
        L_Tanggal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CB_Janji = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        TF_Musik = new javax.swing.JTextField();
        BTN_SetelAlarm = new javax.swing.JButton();
        BTN_Batal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(234, 226, 226));

        Navbar.setBackground(new java.awt.Color(215, 182, 244));
        Navbar.setMaximumSize(null);
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 18);
        flowLayout1.setAlignOnBaseline(true);
        Navbar.setLayout(flowLayout1);

        jPanel2.setMaximumSize(null);
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING, 13, 0));

        jLabel5.setFont(new java.awt.Font("Garamond", 1, 15)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel5);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("INGETIN");
        jLabel6.setToolTipText("");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel6);

        L_Hour.setBackground(new java.awt.Color(0, 0, 0));
        L_Hour.setFont(new java.awt.Font("Corbel", 1, 17)); // NOI18N
        L_Hour.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        L_Hour.setText("21 Mei, 09:00");
        L_Hour.setPreferredSize(new java.awt.Dimension(260, 20));
        jPanel2.add(L_Hour);

        Navbar.add(jPanel2);

        L_Tanggal.setBackground(new java.awt.Color(0, 0, 0));
        L_Tanggal.setFont(new java.awt.Font("Corbel", 1, 17)); // NOI18N
        L_Tanggal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_Tanggal.setText("27 Mei 2026");

        jLabel4.setFont(new java.awt.Font("Corbel", 1, 15)); // NOI18N
        jLabel4.setText("Pilih janji");

        CB_Janji.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih janji 1", "Pilih janji 2", "Pilih janji 3", "Pilih janji 4" }));

        jLabel7.setFont(new java.awt.Font("Corbel", 1, 15)); // NOI18N
        jLabel7.setText("Masukan path musik");

        TF_Musik.setText("Path musiknya tulis disini");
        TF_Musik.addActionListener(this::TF_MusikActionPerformed);

        BTN_SetelAlarm.setText("Setel alarm");
        BTN_SetelAlarm.addActionListener(this::BTN_SetelAlarmActionPerformed);

        BTN_Batal.setText("Batal");
        BTN_Batal.addActionListener(this::BTN_BatalActionPerformed);

        jLabel3.setText("Hah! Penting banget ya ini");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Navbar, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(L_Tanggal))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(CB_Janji, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(TF_Musik)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(BTN_SetelAlarm)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel3))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel2)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(BTN_Batal)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addGap(4, 4, 4)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Navbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(L_Tanggal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CB_Janji, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TF_Musik, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BTN_SetelAlarm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BTN_Batal)
                            .addComponent(jLabel1)))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked

    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked

    }//GEN-LAST:event_jLabel6MouseClicked

    private void BTN_BatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_BatalActionPerformed
        this.dispose();
    }//GEN-LAST:event_BTN_BatalActionPerformed

    private void BTN_SetelAlarmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_SetelAlarmActionPerformed
       try {
        //Ambil path musik
        String pathMusik = TF_Musik.getText(); 
        int idJanji = ambilIDJanji();
        //Validasi kalo lum pilih janji
        if (idJanji == 0) {
            JOptionPane.showMessageDialog(this, "Pilih janji dulu", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }      
        //Masukkan ke database
        String catatan = "Alarm untuk janji ID " + idJanji;
        database_alarm.tambahAlarm(pathMusik, idJanji, catatan);
        JOptionPane.showMessageDialog(this, "Alarm berhasil disetel dengan musik!");
        //tutup frame
        this.dispose();
       } catch (Exception e) {
           JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
       }
    }//GEN-LAST:event_BTN_SetelAlarmActionPerformed

    private void TF_MusikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_MusikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_MusikActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Setel_alarm_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Setel_alarm_1().setVisible(true);
            }
        });
    } 


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Batal;
    private javax.swing.JButton BTN_SetelAlarm;
    private javax.swing.JComboBox<String> CB_Janji;
    private javax.swing.JLabel L_Hour;
    private javax.swing.JLabel L_Tanggal;
    private javax.swing.JPanel Navbar;
    private javax.swing.JTextField TF_Musik;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
