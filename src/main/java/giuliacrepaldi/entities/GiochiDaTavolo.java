package giuliacrepaldi.entities;

import java.time.Duration;
import java.time.LocalDate;

public class GiochiDaTavolo extends Collezione {
    //@Min(2)
    // @Max(10)
    // private int numGiocatori;
    private Duration durataPartitaMedia;

    public GiochiDaTavolo(int i, String titolo, LocalDate annoPubblicazione, double prezzo, int numMinGiocatori, int numMaxGiocatori, TipologiaGioco tipologiaGioco, Duration durataPartitaMedia) {
        super(0, titolo, annoPubblicazione, prezzo, TipologiaGioco.Gioco_da_Tavolo, numMinGiocatori, numMaxGiocatori);
        this.durataPartitaMedia = durataPartitaMedia;
    }

    public Duration getDurataPartitaMedia() {
        return durataPartitaMedia;
    }

    @Override
    public String toString() {
        return "GiochiDaTavolo{" +
                super.toString() +
                ", durataPartitaMedia=" + durataPartitaMedia +
                "} ";
    }
}

