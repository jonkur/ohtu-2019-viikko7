package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends KPSPeli {

    protected Tekoaly tekoaly;
    
    public KPSTekoaly(Scanner scanner) {
        super(scanner);
        tekoaly = new Tekoaly();
    }

    @Override
    protected String vastustajanSiirto(String ekanSiirto) {
        String tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        tekoaly.asetaSiirto(ekanSiirto);
        return tokanSiirto;
    }
}