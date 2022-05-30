/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.koneksi;

/**
 *
 * @author Kato
 */
public class Barang {
    private String nama, id;
    public double totalHarga;
    private double harga, massa;

    public void setBarang(String nama, double massa, double harga) {
        this.nama = nama;
        this.massa = massa;
        this.harga = harga;
    }
    
    public String getNama() {
        return nama;
    }

    public double getTotalHarga() {
        return totalHarga;
    }
    
    public double getMassa() {
        return massa;
    }
    
    public double getHarga() {
        return harga;
    }
    
    public String getId() {
        return id;
    }
    
    public void getData(String id) {
        koneksi koneksi = new koneksi();
        PreparedStatement ps;
        ResultSet rs;

        String query = "Select * from `barang` WHERE id=?";

        try {
            ps = koneksi.getConnection().prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                this.id = id;
                this.nama = rs.getString(2);
                this.massa = rs.getDouble(3);
                this.harga = rs.getDouble(4);

                System.out.println(nama);
                System.out.println(massa);
                System.out.println(harga);
            }

        } catch (SQLException ex) {
            System.out.println("Data tidak ditemukan");
            Logger.getLogger(Barang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
