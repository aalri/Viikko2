/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 *
 * @author Riku
 */
public class Ihminen implements Pelaaja {

    private Scanner scanner;
    private int numero;

    public Ihminen(int numero) {
        this.scanner = new Scanner(System.in);
        this.numero = numero;
    }

    @Override
    public String annaSiirto(String edellinenSiirto) {
        return scanner.nextLine();
    }

    @Override
    public String pelaajanTeksti() {
        if (numero == 1) {
            return "Ensimmaisen pelaajan siirto: ";
        } else {
            return "Toisen pelaajan siirto: ";
        }
    }

}
