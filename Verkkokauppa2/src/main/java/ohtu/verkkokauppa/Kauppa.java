package ohtu.verkkokauppa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Kauppa {

    private Sailytys s;
    private Rahat r;
    private Ostoskori ostoskori;
    private Viitteet v;
    private String kaupanTili;

    @Autowired
    public Kauppa(Sailytys s, Rahat r, Viitteet v) {
        this.s = s;
        this.r = r;
        this.v = v;
        kaupanTili = "33333-44455";
    }

    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    public void poistaKorista(int id) {
        Tuote t = s.haeTuote(id); 
        ostoskori.poista(t);
        s.palautaVarastoon(t);      
    }

    public void lisaaKoriin(int id) {
        if (s.saldo(id)>0) {
            Tuote t = s.haeTuote(id);             
            ostoskori.lisaa(t);
            s.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = v.uusi();
        int summa = ostoskori.hinta();
        
        return r.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}
