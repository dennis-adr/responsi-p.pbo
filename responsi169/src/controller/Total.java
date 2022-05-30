/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Kato
 */
public class Total {
    public String Potongan(double banyak,double harga){
        if(banyak < 12){
            harga = harga * banyak;
        } else if (banyak < 20) {
            harga = banyak * harga - (banyak * harga * 5 / 100);
        } else if (banyak < 144) {
            harga = banyak * harga - (banyak * harga * 10 / 100);
        } else {
            harga = banyak * harga - (banyak * harga * 25 / 100);
        }
        return Double.toString(harga);
    }
}
