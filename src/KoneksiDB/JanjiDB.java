/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KoneksiDB;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Edella
 */
public class JanjiDB {
    Connection con;

    // Constructor
    public JanjiDB() {
        Koneksi k = new Koneksi();
        con = k.con;
    }

    // CREATE
    public void tambahJanji(String appointment, String date,
                            int hour, int minute,
                            boolean finished, int id_mood) {

        try {

            String sql = "INSERT INTO janji "
                    + "(appointment, date, hour, minute, finished, id_mood) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, appointment);
            ps.setDate(2, java.sql.Date.valueOf(date));
            ps.setInt(3, hour);
            ps.setInt(4, minute);
            ps.setBoolean(5, finished);
            ps.setInt(6, id_mood);

            ps.executeUpdate();

            System.out.println("Data janji berhasil ditambahkan");

        } catch (Exception e) {
            System.out.println("Tambah Error : " + e.getMessage());
        }
    }

    // READ
    public ResultSet tampilJanji() {

        try {

            String sql = "SELECT janji.*, mood.icon AS icon, " +
                 "EXISTS(SELECT 1 FROM alarm WHERE alarm.id_janji = janji.id_janji) AS alarm " +
                 "FROM janji " +
                 "JOIN mood ON janji.id_mood = mood.id_mood " +
                 "WHERE date = '" + Global.tanggal + "' " +
                 "ORDER BY hour DESC";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            
            return rs;

        } catch (Exception e) {
            System.out.println("Tampil Error : " + e.getMessage());
            return null;
        }
    }
    
    public boolean toggleFinish(int id_janji){
        try {
        ResultSet data = cariJanji(id_janji);
        
        // Cek dan pindahkan kursor ke baris pertama data
        if (data != null && data.next()) {
            // Ambil nilai status finished saat ini
            boolean currentStatus = data.getBoolean("finished");
            System.out.println("Status saat ini: " + currentStatus);
            
            // Balik nilainya (toggle)
            boolean newStatus = !currentStatus;

            String sql = "UPDATE janji SET finished=? WHERE id_janji=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setBoolean(1, newStatus);
            ps.setInt(2, id_janji);

            ps.executeUpdate();
            return newStatus; // Kembalikan status yang baru
        } else {
            System.out.println("Data janji dengan ID " + id_janji + " tidak ditemukan.");
            return false;
        }
    } catch(Exception e) {
        System.out.println("Toggle Error : " + e.getMessage());
        e.printStackTrace(); // Bagus untuk debugging melihat baris error detail
        return false;
    }
    }

    // UPDATE
    public void updateJanji(int id_janji,
                            String appointment,
                            String date,
                            int hour,
                            int minute,
                            int finished,
                            int id_mood) {

        try {

            String sql = "UPDATE janji SET "
                    + "appointment=?, "
                    + "date=?, "
                    + "hour=?, "
                    + "minute=?, "
                    + "finished=?, "
                    + "id_mood=? "
                    + "WHERE id_janji=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, appointment);
            ps.setString(2, date);
            ps.setInt(3, hour);
            ps.setInt(4, minute);
            ps.setInt(5, finished);
            ps.setInt(6, id_mood);
            ps.setInt(7, id_janji);

            ps.executeUpdate();

            System.out.println("Data janji berhasil diupdate");

        } catch (Exception e) {
            System.out.println("Update Error : " + e.getMessage());
        }
    }

    // DELETE
    public void hapusJanji(int id_janji) {

        try {

            String sql = "DELETE FROM janji WHERE id_janji=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id_janji);

            ps.executeUpdate();

            System.out.println("Data janji berhasil dihapus");

        } catch (Exception e) {
            System.out.println("Hapus Error : " + e.getMessage());
        }
    }

    // SEARCH BY ID
    public ResultSet cariJanji(int id_janji) {

        try {

            String sql = "SELECT * FROM janji WHERE id_janji=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id_janji);

            return ps.executeQuery();

        } catch (Exception e) {
            System.out.println("Cari Error : " + e.getMessage());
            return null;
        }
    }
}
