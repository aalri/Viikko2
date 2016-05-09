package ohtu.kivipaperisakset;

public class Tekoaly implements Pelaaja {

    int siirto;

    public Tekoaly() {
        siirto = 0;
    }

    @Override
    public String annaSiirto(String edellinenSiirto) {
        siirto++;
        siirto = siirto % 3;

        String valinta;
        if (siirto == 0) {
            valinta = "k";
        } else if (siirto == 1) {
            valinta = "p";
        } else {
            valinta = "s";
        }
        System.out.println(valinta);
        return valinta;        
    }

    @Override
    public String pelaajanTeksti() {
        return "Tietokone valitsi: ";
    }
    
}
