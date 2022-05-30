/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Kato
 */
public class Menu extends JFrame {
    JFrame window = new JFrame("Main Menu");
    JLabel ljudul = new JLabel("Main Menu");
    
    JButton btnTambah = new JButton("Tambah Barang");
    JButton btnLihat = new JButton("Lihat Barang");
  
    public Menu(){
        window.setLayout(null);
        window.setSize(300, 150);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE); 

        window.add(ljudul);
        window.add(btnTambah);
        window.add(btnLihat);
        ljudul.setBounds(100, 5, 120, 15);

        btnTambah.setBounds(60, 25, 150, 30);
        btnLihat.setBounds(60, 65, 150, 30);
        
        btnTambah.addActionListener((ActionEvent arg0) -> {
            window.dispose();
            new InputBarang();
        });
        
        btnLihat.addActionListener((ActionEvent arg0) -> {
            window.dispose();
            new Lihat();
        });
    }
}
