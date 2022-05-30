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
public class Tampil {
    public String[][] readAllData() {
    GetRowDB getRow = new GetRowDB();
    String data[][] = new String[getRow.getRow()][4];

    try {
      koneksi koneksi = new koneksi();
      PreparedStatement ps;
      ResultSet rs;

      String query = "Select * from `barang`";
      ps = koneksi.getConnection().prepareStatement(query);
      rs = ps.executeQuery();

      int n = 0;
      while (rs.next()) {
        data[n][0] = rs.getString(1);
        data[n][1] = rs.getString(2);
        data[n][2] = rs.getString(3);
        data[n][3] = rs.getString(4);
        n++;
      }
      return data;
    } catch (SQLException ex) {
      System.out.println("Read Data Gagal");
      Logger.getLogger(Lihat.class.getName()).log(Level.SEVERE, null, ex);
      return null;
    }
  }
}
