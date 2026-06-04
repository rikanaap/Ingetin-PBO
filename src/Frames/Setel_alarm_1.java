/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Karina Kaprodi
 */
public class Setel_alarm_1 extends javax.swing.JFrame {
    private KoneksiDB.AlarmDB database_alarm;
    private janji Frame_Janji;
    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd MMMM, HH:mm");
    public LocalTime waktu;
    
    /*Membuka halaman ini di java*/
    public Setel_alarm_1() {
        initComponents();
 
        database_alarm = new KoneksiDB.AlarmDB(); 
        setJanji(); 
        setUkuranLokasi();
        updateWaktu();
        Timer timer = new Timer(60000, e -> updateWaktu());
        timer.start();
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
        // Validasi jika item kosong agar tidak error null pointer
        if (CB_Janji.getSelectedItem() == null) {
            return 0;
        }
        //Ambil janji yangdipilih user di ComboBox
        String janjiDipilih = CB_Janji.getSelectedItem().toString();
        //Oper ke fungsi yang di AlarmDB
        return database_alarm.cariIDJanji(janjiDipilih);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
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
        BTN_SetelAlarm = new javax.swing.JButton();
        BTN_Batal = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        CB_Musik = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Setel Alarm");
        setAlwaysOnTop(true);
        setSize(new java.awt.Dimension(412, 592));

        jPanel1.setBackground(new java.awt.Color(234, 226, 226));
        jPanel1.setMinimumSize(new java.awt.Dimension(412, 592));

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
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frames/images/BTN_Back.png"))); // NOI18N
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

        L_Hour.setFont(new java.awt.Font("Corbel", 1, 17)); // NOI18N
        L_Hour.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        L_Hour.setText("21 Mei, 09:00");
        L_Hour.setPreferredSize(new java.awt.Dimension(260, 20));
        jPanel2.add(L_Hour);

        Navbar.add(jPanel2);

        L_Tanggal.setFont(new java.awt.Font("Corbel", 1, 17)); // NOI18N
        L_Tanggal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_Tanggal.setText("27 Mei 2026");

        jLabel4.setFont(new java.awt.Font("Corbel", 1, 15)); // NOI18N
        jLabel4.setText("Pilih janji");

        CB_Janji.addActionListener(this::CB_JanjiActionPerformed);

        jLabel7.setFont(new java.awt.Font("Corbel", 1, 15)); // NOI18N
        jLabel7.setText("Pilih musik alarm");

        BTN_SetelAlarm.setText("Setel alarm");
        BTN_SetelAlarm.addActionListener(this::BTN_SetelAlarmActionPerformed);

        BTN_Batal.setText("Batal");
        BTN_Batal.addActionListener(this::BTN_BatalActionPerformed);

        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 200));
        jPanel3.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 0, 88));
        jLabel9.setText("<html>HAHH?? PENTING \nBANGET YA INI?</html>");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel9);
        jLabel9.setBounds(120, 20, 110, 40);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frames/images/IMG_Bubble3.png"))); // NOI18N
        jPanel3.add(jLabel10);
        jLabel10.setBounds(100, 10, 139, 75);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frames/images/IMG_Form Alarm.png"))); // NOI18N
        jPanel3.add(jLabel11);
        jLabel11.setBounds(20, 50, 90, 80);

        // DAFTAR MUSIK WAV YANG ADA DI FOLDER RESOURCE-MU
        CB_Musik.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "alarm1.wav", "alarm2.wav", "alarm3.wav" }));
        CB_Musik.addActionListener(this::CB_MusikActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel2))
                .addGap(418, 418, 418))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BTN_SetelAlarm, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BTN_Batal, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(L_Tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7)
                                    .addComponent(CB_Janji, 0, 386, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(26, 26, 26))))
                    .addComponent(Navbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CB_Musik, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Navbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(L_Tanggal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CB_Janji, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CB_Musik, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BTN_SetelAlarm, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTN_Batal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {                                     
        back();
    }                                    

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {                                     
        back();
    }                                    

    private void BTN_BatalActionPerformed(java.awt.event.ActionEvent evt) {                                          
        this.dispose();
        if (Frame_Janji != null) {
            Frame_Janji.loadCard();
        }
    }                                         

    private void BTN_SetelAlarmActionPerformed(java.awt.event.ActionEvent evt) {                                               
       try {
            // FIX BUG UTAMA: Mengambil pilihan string dari JComboBox dengan benar, bukan .getText()
            if (CB_Musik.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Silakan pilih musik terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            String musikTerpilih = CB_Musik.getSelectedItem().toString(); 
            // Kita bungkus nama file mentah menjadi full path package resource
            String pathMusik = "/Musik/" + musikTerpilih; 
            
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
            if (Frame_Janji != null) {
                Frame_Janji.loadCard();
            }
       } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
       }
    }                                              

    private void CB_JanjiActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void CB_MusikActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // BONUS FITUR: Putar musik otomatis sebagai preview saat user memilih opsi di ComboBox
        try {
            if (CB_Musik.getSelectedItem() == null) return;
            
            String musikTerpilih = CB_Musik.getSelectedItem().toString();
            String pathMusik = "/Musik/" + musikTerpilih; // Sesuaikan dengan nama package musikmu (M kapital/kecil)
            java.net.URL url = getClass().getResource(pathMusik);
            
            if (url != null) {
                javax.sound.sampled.AudioInputStream audioStream = javax.sound.sampled.AudioSystem.getAudioInputStream(url);
                javax.sound.sampled.Clip clip = javax.sound.sampled.AudioSystem.getClip();
                clip.open(audioStream);
                clip.start(); // Test putar musik audio
            } else {
                System.out.println("File musik '" + musikTerpilih + "' tidak ditemukan di folder /Musik/");
            }
        } catch (Exception e) {
            System.out.println("Gagal memutar preview musik: " + e.getMessage());
        }
    }                                        

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
    
    private void setUkuranLokasi(){
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.pack();
        
        int frameWidth = this.getSize().width;
        int x = screenSize.width - frameWidth;
        int y = 0; // 0 berarti mepet ke atas

        this.setLocation(x, y);
    }
    
    public void setJanjiForm(janji FJanji){
        Frame_Janji = FJanji;
    }
    
    private void back(){
        janji FJanji = new janji();
        FJanji.setVisible(true);
        this.dispose();
    }
     
    private void updateWaktu(){
         LocalDateTime sekarang = LocalDateTime.now();
         L_Hour.setText(sekarang.format(fmt));
         
         // SINKRONISASI TANGGAL UTK TAHUN 2026: Mengubah teks L_Tanggal secara dinamis otomatis mengikuti hari ini
         DateTimeFormatter fmtTanggalLayar = DateTimeFormatter.ofPattern("dd MMMM yyyy");
         L_Tanggal.setText(sekarang.format(fmtTanggalLayar));
         
         waktu = LocalTime.now();
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton BTN_Batal;
    private javax.swing.JButton BTN_SetelAlarm;
    private javax.swing.JComboBox<String> CB_Janji;
    private javax.swing.JComboBox<String> CB_Musik;
    private javax.swing.JLabel L_Hour;
    private javax.swing.JLabel L_Tanggal;
    private javax.swing.JPanel Navbar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration                   
}
