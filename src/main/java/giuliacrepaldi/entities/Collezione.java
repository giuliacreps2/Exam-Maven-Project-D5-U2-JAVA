package giuliacrepaldi.entities;

import giuliacrepaldi.exceptions.IdNotFoundExcepetion;

import java.time.LocalDate;
import java.util.*;

public abstract class Collezione {
    private static int contatore = 0;
    private long id;
    private String titolo;
    private LocalDate annoPubblicazione;
    private double prezzo;
    private TipologiaGioco tipologiaGioco;
    private int numMinGiocatori;
    private int numMaxGiocatori;

    public Collezione(long id, String titolo, LocalDate annoPubblicazione, double prezzo, TipologiaGioco tipologiaGioco) {
        this.id = ++contatore;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.prezzo = prezzo;
        this.tipologiaGioco = tipologiaGioco;
    }

    public Collezione(long id, String titolo, LocalDate annoPubblicazione, double prezzo, TipologiaGioco tipologiaGioco, int numMinGiocatori, int numMaxGiocatori) {
        this.id = ++contatore;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.prezzo = prezzo;
        this.tipologiaGioco = tipologiaGioco;
        this.numMinGiocatori = numMinGiocatori;
        this.numMaxGiocatori = numMaxGiocatori;
    }

    //2.metodo per ricerca ID
    //TODO vanno fatti i controlli se l'id esiste
    public static void ricercaId(List<Collezione> collezione, long id) throws IdNotFoundExcepetion {
        Optional<Collezione> giocoId = collezione.stream().filter(gioco -> gioco.getId() == id).findFirst();
        System.out.println("Il gioco che stai cercando è: " + giocoId);
    }

    //3.metodo per prezzo, deve ritornare quindi una lista di giochi con prezzo inferiore al prezzo inserito
    public static void prezzoInferiore(List<Collezione> collezione, double prezzo) {
        List<Collezione> listaPrezziInferiori = collezione.stream().filter(gioco -> gioco.getPrezzo() < prezzo).toList();
        System.out.println("Prezzo inferiore " + listaPrezziInferiori.size());
    }

    //4.ricerca per numero di giocatori
    public static void ricercaPerNumGiocatori(List<Collezione> collezione, int numMinGiocatori, int numMaxGiocatori) {
        if (numMinGiocatori < 0 || numMaxGiocatori < 0) {
            throw new ArrayIndexOutOfBoundsException("Numero giocatori non valido");
        }
        List<Collezione> listaGiochiPerNumGiocatori = collezione.stream().filter(gioco -> gioco.getTipologiaGioco().equals(TipologiaGioco.Gioco_da_Tavolo)
                        && gioco.getNumMinGiocatori() >= numMinGiocatori
                        && gioco.getNumMaxGiocatori() <= numMaxGiocatori)
                .toList();
    }

    /// /        return collezione.stream().filter(gioco -> gioco.getId() == id ).map(gioco.)
    /// //    //6.aggiornamento di un elemento esistente dato l'ID
    /// //    //TODO ricontrolla tutto, fai controlli per l'id uguale
    /// //    public List<Collezione> aggiornaID(List<Collezione> collezione, long id, long id2) throws IdNotFoundExcepetion {
//        return collezione.stream().map(gioco ->
//                        gioco.getId() == id)
//                .toList();
//        if (id != id2) {
//            return gioco.setId(id2);
//        } else {
//            System.out.println("Il gioco trovato");
//        }
//    }

    //7.statistiche della collezione: stampa il numero totale di videogiochi e giochi da tavolo presenti, il gioco
    //con il prezzo più alto e la medie dei prezzi di tutti gli elementi.
    public static void statisticheGiochi(List<Collezione> collezione) {
        long totaleVideogiochi = collezione.stream().filter(gioco -> gioco.getTipologiaGioco().equals(TipologiaGioco.Videogioco)).count();
        System.out.println("Il numero di videogiochi è: " + totaleVideogiochi);
        long totaleGiochiDaTavolo = collezione.stream().filter(gioco -> gioco.getTipologiaGioco().equals(TipologiaGioco.Gioco_da_Tavolo)).count();
        System.out.println("Il numero di giochi da tavola è: " + totaleGiochiDaTavolo);
        //OptionalDouble prezzoMassimo = collezione.stream().mapToDouble(Collezione::getPrezzo).max();
        //System.out.println("Il gioco con il prezzo massimo è: " + prezzoMassimo);
        Optional prezzoMassimo = collezione.stream().max(Comparator.comparingDouble(Collezione::getPrezzo));
        System.out.println("Il gioco con il prezzo massimo è: " + prezzoMassimo);
        OptionalDouble mediaPrezziGiochi = collezione.stream().mapToDouble(Collezione::getPrezzo).average();
        System.out.println("Il prezzo medio dei giochi è: " + mediaPrezziGiochi);

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId(long id) {
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

    public TipologiaGioco getTipologiaGioco() {
        return tipologiaGioco;
    }

    public int getNumMinGiocatori() {
        return numMinGiocatori;
    }

    public int getNumMaxGiocatori() {
        return numMaxGiocatori;
    }
    //System.out.println("Ecco la lista dei giochi: " + listaGiochiPerNumGiocatori.size());

    //1.metodo per aggiungere un elemento (ma non con lo stesso id)
    //TODO controllare perchè non posso mettere l'indice nell'aggiunta, mancano i controlli per lo stesso ID
    public Object aggiungiElemento(List<Collezione> collezione, Object elemento) throws IdNotFoundExcepetion {
        return collezione.add((Collezione) elemento);
    }

    //5.rimozione di un elemento dato un codice ID
    public Object cancellaElemento(List<Collezione> collezione, Object elemento) {
        return collezione.remove(this);
    }

    @Override
    public String toString() {
        return "Collezione{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", prezzo=" + prezzo +
                ", tipologiaGioco=" + tipologiaGioco +
                ", numMinGiocatori=" + numMinGiocatori +
                ", numMaxGiocatori=" + numMaxGiocatori +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Collezione that = (Collezione) o;
        return id == that.id && Double.compare(prezzo, that.prezzo) == 0 && numMinGiocatori == that.numMinGiocatori && numMaxGiocatori == that.numMaxGiocatori && Objects.equals(titolo, that.titolo) && Objects.equals(annoPubblicazione, that.annoPubblicazione) && tipologiaGioco == that.tipologiaGioco;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titolo, annoPubblicazione, prezzo, tipologiaGioco, numMinGiocatori, numMaxGiocatori);
    }
}
