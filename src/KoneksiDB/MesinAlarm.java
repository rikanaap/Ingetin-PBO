/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KoneksiDB;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Timer;
import javax.swing.JOptionPane;

/**
 *
 * @author Karina Kaprodi
 */
public class MesinAlarm {
    private static Timer timer;
    private static final AlarmDB db_alarm = new AlarmDB();
    private static final DateTimeFormatter fmtDB = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void hidupkan() {
        //Mencegah mesin membuat timer ganda agar suara tidak tumpang tindih
        if (timer != null && timer.isRunning()) {
            return; 
        }

        //Timer otomatis menyala setiap 1 menit
        timer = new Timer(60000, e -> {
            //Ambil waktu sekarang lalu MAJUIN 1 JAM (+1)
            LocalDateTime waktuMaju = LocalDateTime.now().plusHours(1);
            
            String tglTarget = waktuMaju.format(fmtDB);
            int jamTarget = waktuMaju.getHour();
            int menitTarget = waktuMaju.getMinute();
            
            //Cek database lewat AlarmDB
            String pathMusik = db_alarm.cekAlarmAktif(tglTarget, jamTarget, menitTarget);
            
            //Hasilnya, kalau cocok play musik dan muncul popup
            if (pathMusik != null && !pathMusik.isEmpty()) {
                System.out.println("ALARM MATCH! Memutar: " + pathMusik);
                
                //ogika Pemutar Audio otomatis (.wav) di background
                try {
                    File fileSuara = new File(pathMusik);
                    if (fileSuara.exists()) {
                        AudioInputStream audioStream = AudioSystem.getAudioInputStream(fileSuara);
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioStream);
                        clip.start();
                    } else {
                        System.out.println("File musik tidak ditemukan di path: " + pathMusik);
                    }
                } catch (Exception ex) {
                    System.out.println("Gagal memutar musik: " + ex.getMessage());
                } JOptionPane.showMessageDialog(null, 
                    "PENGINGAT OTOMATIS INGETIN!\n\n1 Jam lagi kamu ada janji penting.\nSegera bersiap-siap ya, Bung!", 
                    "Ingetin - Alarm System", 
                    JOptionPane.WARNING_MESSAGE);
            }
        });

        //Nyalakan alarmnya 
        timer.start();
        System.out.println("Sistem Penjaga Alarm Berhasil Dihidupkan di Background...");
    }   
}
