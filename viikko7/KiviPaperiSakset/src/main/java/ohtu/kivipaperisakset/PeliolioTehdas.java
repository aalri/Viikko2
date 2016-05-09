/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

/**
 *
 * @author Riku
 */
public class PeliolioTehdas {
    
    public static Peli kaksinpeli(){
        return teePeli(new Ihminen(1), new Ihminen(2));
    }
    
    public static Peli helppoYksinpeli(){
        return teePeli(new Ihminen(1), new Tekoaly());
    }
    
    public static Peli vaikeaYksinpeli(){
        return teePeli(new Ihminen(1), new TekoalyParannettu(20));
    }
    
    public static Peli teePeli(Pelaaja pelaaja1, Pelaaja pelaaja2){
        return new Peli(pelaaja1, pelaaja2);
    }
}
