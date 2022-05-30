/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.Barang;
import static java.lang.Integer.parseInt;
import java.sql.*;
import java.util.logging.*;
import koneksi.koneksi;

/**
 *
 * @author Kato
 */
public class Hapus {
    public boolean delete(Barang barang){
    
        String query = "DELETE FROM `barang` WHERE `id`=?";
        PreparedStatement ps;

        try {
            koneksi koneksi = new koneksi();
            ps = koneksi.getConnection().prepareStatement(query);
            
            ps.setInt(1, parseInt(barang.getId()));

            int i = ps.executeUpdate();

            return i == 1; 

       } catch (SQLException ex) {
            Logger.getLogger(Hapus.class.getName()).log(Level.SEVERE, null, ex);
            return false;
       }
    }
    
}
