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
public class Info extends JFrame{
    koneksi koneksi = new koneksi();
    Barang barang = new Barang();
    Total tot = new Total();
    Hapus del = new Hapus();
    
    JFrame window = new JFrame("Info Barang");

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
    
    JButton btnTotal = new JButton("Total Harga");
    JButton btnEdit = new JButton("Edit");
    JButton btnHapus = new JButton("Hapus");
    JButton btnKembali = new JButton("Kembali");
    
    public Info(Barang barang){
        window.setLayout(null);
        window.setSize(390, 250);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        
        window.add(lnama);
        window.add(lmassa);
        window.add(lharga);
        window.add(lbanyak);
        window.add(linfonama);
        window.add(linfomassa);
        window.add(linfoharga);
        window.add(linfobanyak);
        window.add(tfbanyak);
        window.add(btnTotal);
        window.add(btnEdit);
        window.add(btnHapus);
        window.add(btnKembali);

        lnama.setBounds(20, 5, 200, 30);
        lmassa.setBounds(20, 35, 200, 30);
        lharga.setBounds(20, 65, 200, 30);
        lbanyak.setBounds(20, 95, 200, 30);
        
        linfonama.setBounds(115, 5, 200, 30);
        linfomassa.setBounds(115, 35, 200, 30);
        linfoharga.setBounds(115, 65, 200, 30);
        linfobanyak.setBounds(115, 140, 200, 30);
        
        tfbanyak.setBounds(115, 95, 200, 30);
        
        btnKembali.setBounds(20, 170, 100, 25);
        btnEdit.setBounds(135, 170, 100, 25);
        btnHapus.setBounds(250, 170, 100, 25);
        btnTotal.setBounds(135, 140, 100, 25);
        
        btnHapus.setBackground(Color.red);
        btnEdit.setBackground(Color.blue);
        
        double m = barang.getMassa();
        String massa = Double.toString(m);
        double h = barang.getHarga();
        String harga = Double.toString(h);
        
        linfonama.setText(barang.getNama()); 
        linfomassa.setText(massa);
        linfoharga.setText(harga);
        
        btnTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    double banyak = Double.parseDouble(tfbanyak.getText());

                    if(banyak < 0){
                        throw new ArithmeticException("Bilangan Harus Positif");      
                    }
                    
                    barang.totalHarga=banyak;
                    window.dispose();
                    new TotalHarga(barang);
            
                }catch(Exception ex){
                    System.out.print(ex.getMessage());
                    if (tfbanyak.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"Harus diisi");
                    }else if ("Bilangan Harus Positif".equals(ex.getMessage())) {
                        JOptionPane.showMessageDialog(null,ex.getMessage()); 
                    }else{
                        JOptionPane.showMessageDialog(null,"Banyak Barang Harus diisi");
                    }
                    tfbanyak.setText("");
                }
            }
        });
        
        btnEdit.addActionListener((ActionEvent arg0) -> {
            window.dispose();
            new Edit(barang);
        });
        
        btnHapus.addActionListener((ActionEvent arg0) -> {
            if(del.delete(barang)){
                JOptionPane.showMessageDialog(null, "Hapus Data Berhasil","Pesan",JOptionPane.INFORMATION_MESSAGE);
            }else{
                 JOptionPane.showMessageDialog(null, "Hapus Data Gagal","Pesan",JOptionPane.INFORMATION_MESSAGE);
            }
            window.dispose();
            new Lihat();
        });
        
        btnKembali.addActionListener((ActionEvent arg0) -> {
            window.dispose();
            new Menu();
        });
    }    


}
