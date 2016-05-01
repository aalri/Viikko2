/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.komennot;

import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

/**
 *
 * @author Riku
 */
public class Summa implements Komento {
    private Sovelluslogiikka sovelluslogiikka;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int muutos;
    
    public Summa(Sovelluslogiikka sovelluslogiikka, JTextField tuloskentta, JTextField syotekentta) {
        this.sovelluslogiikka = sovelluslogiikka;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        this.muutos = Integer.parseInt(this.syotekentta.getText());
        this.sovelluslogiikka.plus(muutos);
        this.tuloskentta.setText(String.valueOf(this.sovelluslogiikka.tulos()));
    }

    @Override
    public void peru() {
        this.sovelluslogiikka.miinus(muutos);
        this.tuloskentta.setText(String.valueOf(this.sovelluslogiikka.tulos()));
    }
}
