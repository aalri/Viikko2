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
public class Peli {
    
    private final Pelaaja pelaaja1;
    private final Pelaaja pelaaja2;

    public Peli(Pelaaja pelaaja1, Pelaaja pelaaja2) {
        this.pelaaja1 = pelaaja1;
        this.pelaaja2 = pelaaja2;
    }

    public void pelaa() {
        Tuomari tuomari = new Tuomari();
        System.out.print(pelaaja1.pelaajanTeksti());
        String ekanSiirto = pelaaja1.annaSiirto(null);
        String tokanSiirto;

        
        System.out.print(pelaaja2.pelaajanTeksti());
        tokanSiirto = pelaaja2.annaSiirto(ekanSiirto);

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.print(pelaaja1.pelaajanTeksti());
            ekanSiirto = pelaaja1.annaSiirto(tokanSiirto);
            
            System.out.print(pelaaja2.pelaajanTeksti());
            tokanSiirto = pelaaja2.annaSiirto(ekanSiirto);

        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
