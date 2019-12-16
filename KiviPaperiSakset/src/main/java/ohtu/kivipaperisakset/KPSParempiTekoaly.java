package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSParempiTekoaly extends KPSTekoaly {
    
    public KPSParempiTekoaly(Scanner scanner, int muisti) {
        super(scanner);
        tekoaly = new TekoalyParannettu(muisti);
    }

}
