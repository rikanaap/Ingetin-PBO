/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KoneksiDB;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author nabil
 */
public class Koneksi {
    Connection con;
    public Koneksi(){
        String id, pass, driver, url;
        id = "root";
        pass = "";
        driver = "com.mysql.cj.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/db_ingetin?userTimezone=true&server=UTC";
        
        try{
            Class.forName(driver).newInstance();
            con=DriverManager.getConnection(url, id, pass);
            if(con==null){
                JOptionPane.showMessageDialog(null, "Koneksi ke Database bermasalah");
            } else {
                System.out.println("Koneksi berhasil");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Koneksi ke Database bermasalah");
            System.exit(0);
        }
    }
    public static void main(String args[]){
        Koneksi k = new Koneksi();
    }
}
