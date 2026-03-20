package giuliacrepaldi;

import giuliacrepaldi.entities.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        Videogiochi vg1 = new Videogiochi(0, "Tekken 5", LocalDate.of(2006, 1, 1), 62.00, PiattaformaVideogiochi.PS5, Duration.ofHours(5), GenereVideogiochi.Picchiaduro);
        Videogiochi vg2 = new Videogiochi(0, "Crash Bandicoot", LocalDate.of(1996, 1, 1), 30.00, PiattaformaVideogiochi.PS4, Duration.ofHours(6), GenereVideogiochi.Platform);
        Videogiochi vg3 = new Videogiochi(0, "Animal Crossing: New Horizons", LocalDate.of(2020, 1, 1), 49.99, PiattaformaVideogiochi.Nintendo_Switch, Duration.ofHours(200), GenereVideogiochi.Simulazione);
        Videogiochi vg4 = new Videogiochi(0, "Grand Theft Auto V", LocalDate.of(2013, 1, 1), 19.99, PiattaformaVideogiochi.XBox, Duration.ofHours(80), GenereVideogiochi.Azione);
        Videogiochi vg5 = new Videogiochi(0, "Super Mario Odyssey", LocalDate.of(2017, 1, 1), 49.99, PiattaformaVideogiochi.Nintendo_Switch, Duration.ofHours(15), GenereVideogiochi.Platform);

        GiochiDaTavolo gt1 = new GiochiDaTavolo(0, "Taboo", LocalDate.of(1989, 1, 1), 30.99, 4, 12, Duration.ofMinutes(30));
        GiochiDaTavolo gt2 = new GiochiDaTavolo(0, "Scarabeo", LocalDate.of(1963, 1, 1), 29.99, 2, 4, Duration.ofMinutes(60));
        GiochiDaTavolo gt3 = new GiochiDaTavolo(0, "Monopoly", LocalDate.of(1935, 1, 1), 26.00, 2, 6, Duration.ofMinutes(120));
        GiochiDaTavolo gt4 = new GiochiDaTavolo(0, "Pictionary", LocalDate.of(1985, 1, 1), 24.99, 3, 20, Duration.ofMinutes(30));
        GiochiDaTavolo gt5 = new GiochiDaTavolo(0, "Trivial Pursuit", LocalDate.of(1981, 1, 1), 44.99, 2, 6, Duration.ofMinutes(90));

        List<Collezione> listaGiochi = new ArrayList<>();
        listaGiochi.add(gt1);
        listaGiochi.add(gt2);
        listaGiochi.add(gt3);
        listaGiochi.add(gt4);
        listaGiochi.add(gt5);
        listaGiochi.add(vg1);
        listaGiochi.add(vg2);
        listaGiochi.add(vg3);
        listaGiochi.add(vg4);
        listaGiochi.add(vg5);

        System.out.println(vg1);
        System.out.println(vg2);
        System.out.println(gt1);
        System.out.println(gt5);


    }
}
