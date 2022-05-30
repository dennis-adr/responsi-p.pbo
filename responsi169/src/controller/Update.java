/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.Barang;
import static java.lang.Integer.parseInt;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.koneksi;

/**
 *
 * @author Kato
 */
public class Update {
    public boolean edit(Barang b){
    String query = "UPDATE `barang` SET `nama`=?,`massa`=?,`harga`=? WHERE `id`=?";
    PreparedStatement ps;
    System.out.println("idEdit " + b.getId());
    
    try {
      koneksi koneksi = new koneksi();
      ps = koneksi.getConnection().prepareStatement(query);
      ps.setString(1, b.getNama());
      ps.setDouble(2, b.getMassa());
      ps.setDouble(3, b.getHarga());
      
      int id = parseInt(b.getId());
      
      ps.setInt(4, id);
      
      int i = ps.executeUpdate();

      return i == 1;
      
    } catch (SQLException ex) {
      Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
      return false;
    }
  }
}
