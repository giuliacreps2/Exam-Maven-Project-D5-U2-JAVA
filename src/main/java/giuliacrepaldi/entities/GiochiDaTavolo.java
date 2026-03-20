package giuliacrepaldi.entities;

import java.time.Duration;
import java.time.LocalDate;

public class GiochiDaTavolo extends Collezione {
    //@Min(2)
    // @Max(10)
    // private int numGiocatori;
    private int numMinGiocatori;
    private int numMaxGiocatori;
    private Duration durataPartitaMedia;

    public GiochiDaTavolo(int i, String titolo, LocalDate annoPubblicazione, double prezzo, TipologiaGioco tipologiaGioco, int numMinGiocatori, int numMaxGiocatori, Duration durataPartitaMedia) {
        super(0, titolo, annoPubblicazione, prezzo, TipologiaGioco.Gioco_da_Tavolo);
        this.numMinGiocatori = numMinGiocatori;
        this.numMaxGiocatori = numMaxGiocatori;
        this.durataPartitaMedia = durataPartitaMedia;
    }

    public GiochiDaTavolo() {
        this.numMinGiocatori = numMinGiocatori;
        this.numMaxGiocatori = numMaxGiocatori;
        this.durataPartitaMedia = durataPartitaMedia;
    }

    public int getNumMinGiocatori() {
        return numMinGiocatori;
    }

    public int getNumMaxGiocatori() {
        return numMaxGiocatori;
    }

    public Duration getDurataPartitaMedia() {
        return durataPartitaMedia;
    }

    @Override
    public String toString() {
        return "GiochiDaTavolo{" +
                super.toString() +
                "numMinGiocatori=" + numMinGiocatori +
                ", numMaxGiocatori=" + numMaxGiocatori +
                ", durataPartitaMedia=" + durataPartitaMedia +
                "} ";
    }
}

