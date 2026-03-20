package giuliacrepaldi.entities;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public abstract class Collezione {
    private static int contatore = 0;
    private long id;
    private String titolo;
    private LocalDate annoPubblicazione;
    private double prezzo;
    private TipologiaGioco tipologiaGioco;

    public Collezione(long id, String titolo, LocalDate annoPubblicazione, double prezzo, TipologiaGioco tipologiaGioco) {
        this.id = ++contatore;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.prezzo = prezzo;
        this.tipologiaGioco = tipologiaGioco;
    }

    public Collezione() {
        this.id = ++contatore;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.prezzo = prezzo;
        this.tipologiaGioco = tipologiaGioco;
    }

    public long getId() {
        return id;
    }

    public long getId(long id) {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    //1.metodo per aggiungere un elemento (ma non con lo stesso id)
    //TODO controllare perchè non posso mettere l'indice nell'aggiunta, mancano i controlli per lo stesso ID
    public Object aggiungiElemento(List<Collezione> collezione, Object elemento){
        return collezione.add((Collezione) elemento);
    }

    //2.metodo per ricerca ID
    //TODO vanno fatti i controlli e va verificata la giusta corrispondenza con il valore dell'id
    public void ricercaId(List<Collezione> collezione, long id) {
        String titoloId = collezione.forEach(gioco -> gioco.getId() == id);
    }

    //3.metodo per prezzo, deve ritornare quindi una lista di giochi con prezzo inferiore al prezzo inserito
    public void prezzoInferiore(List<Collezione> collezione, double prezzo) {
        List<Collezione> listaPrezziInferiori = collezione.stream().filter(gioco -> gioco.getPrezzo() < prezzo).toList();
        System.out.println("Prezzo inferiore " + listaPrezziInferiori.size());
    }

    //4.ricerca per numero di giocatori
    //TODO problema con numero di giocatori e getId
    public void ricercaPerNumGiocatori(List<Collezione> collezione, int numGiocatori) {
        List<Collezione> listaGiochiPerNumGiocatori =
                collezione.stream().filter(gioco -> gioco.getTipologiaGioco().equals(TipologiaGioco.Gioco_da_Tavolo) && gioco.getId() == numGiocatori).toList();
        System.out.println("La lista di giochi per numero di giocatori è:" + listaGiochiPerNumGiocatori.size());
    }

    //5.rimozione di un elemento dato un codice ID
    public Object cancellaElemento(List<Collezione> collezione, Object elemento) {
        return collezione.remove(this);
    }

    //6.aggiornamento di un elemento esistente dato l'ID
    //TODO ricontrolla tutto
    public List<Collezione> aggiornaID(List<Collezione> collezione, long id, long id2) {
//        return collezione.stream().filter(gioco -> gioco.getId() == id ).map(gioco.)
        return collezione.stream().map(gioco -> gioco.getId(id); gioco.setId(id2)).collect(Collectors.toList());
    }

    //7.statistiche della collezione: stampa il numero totale di videogiochi e giochi da tavolo presenti, il gioco
    //con il prezzo più alto e la medie dei prezzi di tutti gli elementi.
    //passaggi:
    //filtro l'array per tipo
    public void statisticheGiochi(List<Collezione> collezione) {
        long totaleVideogiochi = collezione.stream().filter(gioco -> gioco.getTipologiaGioco().equals(TipologiaGioco.Videogioco)).count();
        System.out.println("Il numero di videogiochi è: " + totaleVideogiochi);
        long totaleGiochiDaTavolo = collezione.stream().filter(gioco -> gioco.getTipologiaGioco().equals(TipologiaGioco.Gioco_da_Tavolo)).count();
        System.out.println("Il numero di giochi da tavola è: " + totaleGiochiDaTavolo);
        //OptionalDouble prezzoMassimo = collezione.stream().mapToDouble(Collezione::getPrezzo).max();
        //System.out.println("Il gioco con il prezzo massimo è: " + prezzoMassimo);
        List<Collezione> prezzoMassimo = collezione.stream().sorted(Comparator.comparing(Collezione::getPrezzo)).toList();
        System.out.println("Il gioco con il prezzo massimo è: " + prezzoMassimo.size());
        OptionalDouble mediaPrezziGiochi = collezione.stream().mapToDouble(Collezione::getPrezzo).average();
        System.out.println("Il prezzo medio dei giochi è: " + mediaPrezziGiochi);
    }


    @Override
    public String toString() {
        return "Collezione{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", prezzo=" + prezzo +
                ", tipologiaGioco=" + tipologiaGioco +
                '}';
    }
}
