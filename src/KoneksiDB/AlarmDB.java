/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KoneksiDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Karina Kaprodi
 */

public class AlarmDB {
    private Connection con;

public AlarmDB() {
   Koneksi konek = new Koneksi();
   this.con = konek.con;
}

public java.sql.ResultSet ambilSemuaJanji() {
    java.sql.ResultSet rs = null;
    try {
        String sql = "SELECT appointment FROM janji WHERE date='"+ Global.tanggal +"'"; 
        java.sql.Statement stmt = con.createStatement(); 
        rs = stmt.executeQuery(sql);
    } catch (Exception e) {
        System.out.println("Gagal tarik data janji: " + e.getMessage());
    }
    return rs;
}

//Untuk menyimpan data alarm baru
public boolean tambahAlarm(String filePath, int idJanji, String notes) {
    String sql = "INSERT INTO alarm (file_path, id_janji, notes) VALUES (?, ?, ?)";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, filePath);
        ps.setInt(2, idJanji);
        ps.setString(3, notes);
        
        int rows = ps.executeUpdate();
        ps.close();
        return rows > 0;
    } catch (Exception e) {
        System.out.println("Error tambahAlarm: " + e.getMessage());
        return false;
    }
}

public int cariIDJanji(String teksJanji) {
    int id = 0;
    try {
        String sql = "SELECT id_janji FROM janji WHERE appointment = '" + teksJanji + "'";
        java.sql.Statement stmt = this.con.createStatement();
        java.sql.ResultSet rs = stmt.executeQuery(sql);
        
        if (rs.next()) {
            id = rs.getInt("id_janji");
        }
    } catch (Exception e) {
        System.out.println("Gagal cari ID Janji di database: " + e.getMessage());
    }
    return id;
}

    public void hapusAlarm(int id_janji) {

        try {

            String sql = "DELETE FROM alarm WHERE id_janji=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_janji);
            ps.executeUpdate();
            System.out.println("Alarm berhasil dihapus");

        } catch (Exception e) {
            System.out.println("Hapus Error : " + e.getMessage());
        }
    }
   
  public String cekAlarmAktif(String tanggal, int jam, int menit) {
    String filePathMusik = null;
    try {
        String sql = "SELECT a.file_path FROM alarm a " +
                     "JOIN janji j ON a.id_janji = j.id_janji " +
                     "WHERE j.date = ? AND j.hour = ? AND j.minute = ?";
        
        java.sql.PreparedStatement ps = this.con.prepareStatement(sql);
        ps.setString(1, tanggal);
        ps.setInt(2, jam);
        ps.setInt(3, menit);
        
        java.sql.ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            filePathMusik = rs.getString("file_path");
        }
    } catch (Exception e) {
        System.out.println("Error cek alarm otomatis: " + e.getMessage());
    }
    return filePathMusik;
}

}
    
