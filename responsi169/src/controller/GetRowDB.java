/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.*;
import java.util.logging.*;
import koneksi.koneksi;
import view.Lihat;

/**
 *
 * @author Kato
 */
class GetRowDB {
    public int getRow() {
    koneksi koneksi = new koneksi();
    PreparedStatement ps;
    ResultSet rs;
    int  i = 0;
    try {
      String query = "Select * from `barang`";
      ps = koneksi.getConnection().prepareStatement(query);
      rs = ps.executeQuery();

      while (rs.next()) {
        i++;
      }
      return i ;

    } catch (SQLException ex) {
      Logger.getLogger(Lihat.class.getName()).log(Level.SEVERE, null, ex);
    }
    return -4;
  }
}
