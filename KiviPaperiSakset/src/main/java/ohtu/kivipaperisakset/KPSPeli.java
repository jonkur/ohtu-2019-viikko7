package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class KPSPeli {
    
    protected Scanner scanner;
    
    public static KPSPeli kaksinPeli(Scanner scanner) {
        return new KPSPelaajaVsPelaaja(scanner);
    }
    
    public static KPSPeli helppoYksinPeli(Scanner scanner) {
        return new KPSTekoaly(scanner);
    }
    
    public static KPSPeli vaikeaYksinPeli(Scanner scanner, int muisti) {
        return new KPSParempiTekoaly(scanner, muisti);
    }
    
    protected KPSPeli(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        System.out.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = scanner.nextLine();
        String tokanSiirto = vastustajanSiirto(ekanSiirto);

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = scanner.nextLine();

            tokanSiirto = vastustajanSiirto(ekanSiirto);
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
    
    protected abstract String vastustajanSiirto(String ekanSiirto);
    
    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
