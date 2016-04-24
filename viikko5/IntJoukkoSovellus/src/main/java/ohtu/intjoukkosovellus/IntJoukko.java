package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;    // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] lukuTaulukko;  // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);

    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti ei saa olla negatiivinen");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kasvukoko ei saa olla negatiivinen");
        }
        lukuTaulukko = new int[kapasiteetti];
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (kuuluu(luku))return false;
        if (alkioidenLkm == lukuTaulukko.length)kasvataTaulukkoa();
        lukuTaulukko[alkioidenLkm] = luku;
        alkioidenLkm++;
        return true;
    }

    public boolean kuuluu(int luku) {
        return luvunSijainti(luku) != -1;
    }

    public int luvunSijainti(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukuTaulukko[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean poista(int luku) {
        int kohta = luvunSijainti(luku);
        if (kohta != -1) {
            poistaPaikasta(kohta);
            return true;
        }
        return false;
    }

    public void poistaPaikasta(int i) {
        int apu;
        for (int j = i; j < alkioidenLkm - 1; j++) {
            apu = lukuTaulukko[j];
            lukuTaulukko[j] = lukuTaulukko[j + 1];
            lukuTaulukko[j + 1] = apu;
        }
        alkioidenLkm--;
    }

    private void kasvataTaulukkoa() {
        int[] uusi = new int[this.lukuTaulukko.length + kasvatuskoko];
        kopioiTaulukkoSisalto(this.lukuTaulukko, uusi);
    }

    private void kopioiTaulukkoSisalto(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
        vanha = uusi;
    }

    public int alkioidenMaara() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        String tuotos = "{";
        for (int i = 0; i < alkioidenLkm; i++) {
            tuotos += lukuTaulukko[i];
            tuotos += ", ";
        }
        tuotos += "}";
        return tuotos;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = lukuTaulukko[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko tulos = new IntJoukko();
        for (int i : a.toIntArray())tulos.lisaa(i);
        for (int i : b.toIntArray())tulos.lisaa(i);
        return tulos;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko tulos = new IntJoukko();
        for (int i : a.toIntArray()) {
            if(b.kuuluu(i)) tulos.lisaa(i);
        }
        return tulos;

    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko tulos = new IntJoukko();
        for (int i : a.toIntArray())tulos.lisaa(i);
        for (int i : b.toIntArray())tulos.poista(i);
        return tulos;
    }

}
