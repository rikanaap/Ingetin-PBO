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
public class MoodDB {

    Connection con;

    // Constructor
    public MoodDB() {
        Koneksi k = new Koneksi();
        con = k.con;
    }

    // CREATE
    public void tambahMood(String icon, String title) {

        try {

            String sql = "INSERT INTO mood (icon, title) VALUES (?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, icon);
            ps.setString(2, title);

            ps.executeUpdate();

            System.out.println("Mood berhasil ditambahkan");

        } catch (Exception e) {
            System.out.println("Tambah Error : " + e.getMessage());
        }
    }

    // READ
    public ResultSet tampilMood() {

        try {

            String sql = "SELECT * FROM mood";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            return rs;
        } catch (Exception e) {
            System.out.println("Tampil Error : " + e.getMessage());
            return null;
        }
    }

    // UPDATE
    public void updateMood(int id_mood, String icon, String title) {

        try {

            String sql = "UPDATE mood SET icon=?, title=? WHERE id_mood=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, icon);
            ps.setString(2, title);
            ps.setInt(3, id_mood);

            ps.executeUpdate();

            System.out.println("Mood berhasil diupdate");

        } catch (Exception e) {
            System.out.println("Update Error : " + e.getMessage());
        }
    }

    // DELETE
    public void hapusMood(int id_mood) {

        try {

            String sql = "DELETE FROM mood WHERE id_mood=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id_mood);

            ps.executeUpdate();

            System.out.println("Mood berhasil dihapus");

        } catch (Exception e) {
            System.out.println("Hapus Error : " + e.getMessage());
        }
    }

    // SEARCH
    public ResultSet cariMood(int id_mood) {

        try {

            String sql = "SELECT * FROM mood WHERE id_mood=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id_mood);

            return ps.executeQuery();
        } catch (Exception e) {
            System.out.println("Cari Error : " + e.getMessage());
            return null;
        }
    }
}