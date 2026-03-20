package giuliacrepaldi.entities;

import java.time.LocalDate;

public abstract class Collezione {
    private static int contatore = 0;
    private long id;
    private String titolo;
    private LocalDate annoPubblicazione;
    private double prezzo;

    public Collezione(long id, String titolo, LocalDate annoPubblicazione, double prezzo) {
        this.id = ++contatore;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.prezzo = prezzo;
    }

    public Collezione() {
        this.id = ++contatore;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.prezzo = prezzo;
    }

    public long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }
    
    public LocalDate getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public double getPrezzo() {
        return prezzo;
    }
}
