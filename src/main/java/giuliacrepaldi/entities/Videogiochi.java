package giuliacrepaldi.entities;

import java.time.Duration;
import java.time.LocalDate;

public class Videogiochi extends Collezione {
    private PiattaformaVideogiochi piattaforma;
    private Duration durata;
    private GenereVideogiochi genere;

    public Videogiochi(int i, String titolo, LocalDate annoPubblicazione, double prezzo, PiattaformaVideogiochi piattaforma, Duration durata, GenereVideogiochi genere) {
        super(0, titolo, annoPubblicazione, prezzo);
        this.piattaforma = piattaforma;
        this.durata = durata;
        this.genere = genere;
    }

    public Videogiochi() {
        this.piattaforma = piattaforma;
        this.durata = durata;
        this.genere = genere;
    }

    public PiattaformaVideogiochi getPiattaforma() {
        return piattaforma;
    }

    public Duration getDurata() {
        return durata;
    }

    public GenereVideogiochi getGenere() {
        return genere;
    }

    @Override
    public String toString() {
        return "Videogiochi{" +
                super.toString() +
                ", piattaforma=" + piattaforma +
                ", durata=" + durata +
                ", genere=" + genere +
                "} ";
    }
}
