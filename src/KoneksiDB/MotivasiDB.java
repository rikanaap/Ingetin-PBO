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
 * @author ASUS
 */
public class MotivasiDB {

    Connection con;

    // Constructor
    public MotivasiDB() {
        Koneksi k = new Koneksi();
        con = k.con;
    }

    // CREATE
    public void tambahMotivasi(String name, int parameter) {

        try {

            String sql = "INSERT INTO motivasi (name, parameter) VALUES (?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setInt(2, parameter);

            ps.executeUpdate();

            System.out.println("Motivasi berhasil ditambahkan");

        } catch (Exception e) {
            System.out.println("Tambah Error : " + e.getMessage());
        }
    }

    // READ
    public ResultSet tampilMotivasi() {

        try {

            String sql = "SELECT * FROM motivasi";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            return rs;
        } catch (Exception e) {
            System.out.println("Tampil Error : " + e.getMessage());
            return null;
        }
    }

    // UPDATE
    public void updateMotivasi(int id_motivasi, String name, int parameter) {

        try {

            String sql = "UPDATE motivasi SET name=?, parameter=? WHERE id_motivasi=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setInt(2, parameter);
            ps.setInt(3, id_motivasi);

            ps.executeUpdate();

            System.out.println("Motivasi berhasil diupdate");

        } catch (Exception e) {
            System.out.println("Update Error : " + e.getMessage());
        }
    }

    // DELETE
    public void hapusMotivasi(int id_motivasi) {

        try {

            String sql = "DELETE FROM motivasi WHERE id_motivasi=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id_motivasi);

            ps.executeUpdate();

            System.out.println("Motivasi berhasil dihapus");

        } catch (Exception e) {
            System.out.println("Hapus Error : " + e.getMessage());
        }
    }

    // SEARCH
    public ResultSet cariMotivasi(int id_motivasi) {

        try {

            String sql = "SELECT * FROM motivasi WHERE id_motivasi=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id_motivasi);

            return ps.executeQuery();
            
        } catch (Exception e) {
            System.out.println("Cari Error : " + e.getMessage());
            return null;
        }
    }
}