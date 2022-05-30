/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

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
public class InputBarang extends JFrame{
    Barang barang = new Barang();
    Input inputData = new Input();
    
    JFrame window = new JFrame("Input Barang");

    JLabel ljudul = new JLabel("Input Barang");
    JLabel lnama = new JLabel("Nama");
    JLabel lmassa = new JLabel("Massa (gr)");
    JLabel lharga = new JLabel("Harga Satuan");
    
    JTextField tfnama = new JTextField();
    JTextField tfmassa = new JTextField();
    JTextField tfharga = new JTextField();
    
    JButton btnSubmit = new JButton("Submit");
    JButton btnReset = new JButton("Reset");
    JButton btnKembali = new JButton("Kembali");
    
    public InputBarang(){
        window.setLayout(null);
        window.setSize(450, 250);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE); 

        window.add(ljudul);
        window.add(lnama);
        window.add(tfnama);
        window.add(lmassa);
        window.add(tfmassa);
        window.add(lharga);
        window.add(tfharga);
        window.add(btnSubmit);
        window.add(btnReset);
        window.add(btnKembali);

        ljudul.setBounds(200, 5, 200, 30);
        lnama.setBounds(20, 35, 200, 30);
        lmassa.setBounds(20, 65, 200, 30);
        lharga.setBounds(20, 95, 200, 30);
        
        tfnama.setBounds(150, 35, 270, 30);
        tfmassa.setBounds(150, 65, 270, 30);
        tfharga.setBounds(150, 95, 270, 30);
        
        btnSubmit.setBounds(100, 140, 130, 25);
        btnReset.setBounds(235, 140, 130, 25);
        btnKembali.setBounds(10, 170, 400, 30);
        
        btnReset.setBackground(Color.red);
        btnSubmit.setBackground(Color.green);
        
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String nama = tfnama.getText();
                    double massa = Double.parseDouble(tfmassa.getText());
                    double harga = Double.parseDouble(tfharga.getText());

                    if(massa < 0 || harga < 0){
                        throw new ArithmeticException("Bilangan Harus Positif");      
                    }
                    
                    barang.setBarang(nama, massa, harga);
                    
                    if(inputData.input(barang)){
                        window.dispose();
                        new Menu();
                        
                        JOptionPane.showMessageDialog(null, "Input Berhasil");
                    }else{
                        JOptionPane.showMessageDialog(null, "Input Gagal");
                    }

                }catch(Exception ex){
                    System.out.print(ex.getMessage());
                    if (tfnama.getText().equals("")||tfmassa.getText().equals("")||tfharga.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"Harus diisi");
                    }else if ("Bilangan Harus Positif".equals(ex.getMessage())) {
                        JOptionPane.showMessageDialog(null,ex.getMessage()); 
                    }else{
                        JOptionPane.showMessageDialog(null,"Massa dan Harga Harus Bilangan");
                    }
                    tfnama.setText("");
                    tfmassa.setText("");
                    tfharga.setText("");
                }
            }
        });
        
        btnReset.addActionListener((ActionEvent arg0) -> {
            tfnama.setText("");
            tfmassa.setText("");
            tfharga.setText("");
        });
        
        btnKembali.addActionListener((ActionEvent arg0) -> {
            window.dispose();
            new Menu();
        });
        
    }
}
