/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.Barang;
import java.sql.*;
import java.util.logging.*;
import koneksi.koneksi;

/**
 *
 * @author Kato
 */
public class Input {
    public boolean input(Barang barang){
    
    koneksi koneksi = new koneksi();
    PreparedStatement ps;    
    
    String query = "INSERT INTO `barang`(`nama`, `massa`, `harga`) VALUES (?,?,?)";
    
    try {
      ps = koneksi.getConnection().prepareStatement(query);
      ps.setString(1, barang.getNama());
      ps.setDouble(2, barang.getMassa());
      ps.setDouble(3, barang.getHarga());

      if (ps.executeUpdate() > 0) {        
        System.out.println("Input berhasil");
        return true;
      }
    } catch (SQLException ex) {
      Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
      return false;
    }
    return false;
  }
}