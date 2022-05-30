/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import koneksi.koneksi;
import Model.Barang;
import controller.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Kato
 */
public class TotalHarga extends JFrame{
    koneksi koneksi = new koneksi();
    Barang barang = new Barang();
    Total tot = new Total();
    Hapus del = new Hapus();
    
    JFrame window = new JFrame("Total Harga");

    JLabel lnama = new JLabel("Nama :");
    JLabel lmassa = new JLabel("Massa (gr) :");
    JLabel lharga = new JLabel("Harga Satuan :");
    JLabel lbanyak = new JLabel("Banyak :");
    JLabel ltotal = new JLabel("Total :");
    JLabel linfonama = new JLabel(" ");
    JLabel linfomassa = new JLabel(" ");
    JLabel linfoharga = new JLabel(" ");
    JLabel linfobanyak = new JLabel(" ");
    
    public JTextField tfbanyak = new JTextField();
    
    JButton btnKembali = new JButton("Kembali");
    
    public TotalHarga(Barang barang){
        window.setLayout(null);
        window.setSize(300, 200);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        
        window.add(lnama);
        window.add(lmassa);
        window.add(lharga);
        window.add(ltotal);
        window.add(linfonama);
        window.add(linfomassa);
        window.add(linfoharga);
        window.add(linfobanyak);
        window.add(btnKembali);

        lnama.setBounds(20, 5, 200, 30);
        lmassa.setBounds(20, 35, 200, 30);
        lharga.setBounds(20, 65, 200, 30);
        ltotal.setBounds(20, 95, 200, 30);
        
        linfonama.setBounds(115, 5, 200, 30);
        linfomassa.setBounds(115, 35, 200, 30);
        linfoharga.setBounds(115, 65, 200, 30);
        linfobanyak.setBounds(115, 95, 200, 30);
        
        btnKembali.setBounds(20, 125, 100, 25);
        
        double m = barang.getMassa();
        String massa = Double.toString(m);
        double h = barang.getHarga();
        String harga = Double.toString(h);
        
        linfonama.setText(barang.getNama()); 
        linfomassa.setText(massa);
        linfoharga.setText(harga);
        linfobanyak.setText(tot.Potongan(barang.getTotalHarga(), barang.getHarga()));
        
        btnKembali.addActionListener((ActionEvent arg0) -> {
            window.dispose();
            new Menu();
        });
    }    
}
