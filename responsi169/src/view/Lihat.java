/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Model.Barang;
import controller.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kato
 */
public class Lihat {
    Barang barang = new Barang();
    Tampil read = new Tampil();
    
    JFrame window = new JFrame("Lihat Data");
    
    JTable tabel;
    DefaultTableModel tableModel;
    Object namaKolom[] = {"ID", "Nama", "Massa (gr)", "Harga Satuan"};
    
    JScrollPane scrollPane;
    
    JButton btnKembali = new JButton("Kembali");
    
    public Lihat(){
        window.setLayout(null);
        window.setSize(850, 600);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
       
        window.add(btnKembali);

        if(read.readAllData() == null){
            JOptionPane.showMessageDialog(null, "Tidak Ada Data");
            tabel = new JTable(null, namaKolom); 
        }else{
            tabel = new JTable(read.readAllData(), namaKolom); 
        }
        
        scrollPane = new JScrollPane(tabel);
        window.add(scrollPane);

        scrollPane.setBounds(10, 5, 815, 500);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        btnKembali.setBounds(10, 520, 810, 30);
        
        tabel.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                String id = tabel.getValueAt(tabel.getSelectedRow(), 0).toString();
                barang.getData(id);
                window.dispose();
                new Info(barang);
            }
        });
        
        btnKembali.addActionListener((ActionEvent arg0) -> {
            window.dispose();
            new Menu();
        });
    }
}
