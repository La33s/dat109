package Klasser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Utleiekontor {
    int id;
    Addresse addresse;
    int telefonnummer;
    List<Bil> biler;
    List<Utleie> utleieListe = new ArrayList<Utleie>();

    public Utleiekontor(int id, Addresse addresse, int telefonnummer, List<Bil> biler, List<Utleie> utleieListe) {
        this.id = id;
        this.addresse = addresse;
        this.telefonnummer = telefonnummer;
        this.biler = biler;
    }

    public Bil finnBil(String regi) {
        Bil b = null;
        for (Bil bil : biler) {
            if (bil.getRegistreringsnummer().equals(regi)) {
                b = bil;
            }
        }
        return b;

    }

    public String reserver(Bruker bruker) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Skriv inn registreningsnummer på onsket bil");
        String regiBil = scanner.nextLine();

                System.out.println("Startdato");
                System.out.println("Skriv inn: aar i format: 20**");
                int år = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Skriv inn: maaned i format: mm");
                int mm = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Skriv inn: dag i format: dd");
                int dd = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Skriv inn time i format: hh");
                int hh = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Skriv inn: minutter i format: mi");
                int min = scanner.nextInt();
                scanner.nextLine();

                Date startDato = new Date(år, mm, dd, hh, min);

                System.out.println("Sluttdato");
                System.out.println("Skriv inn: aar i format: 20**");
                int sluttår = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Skriv inn: maaned i format: mm");
                int sluttmm = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Skriv inn: dag i format: dd");
                int sluttdd = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Skriv inn: time i format: hh");
                int slutthh = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Skriv inn: minutteri format: mi");
                int sluttmin = scanner.nextInt();
                scanner.nextLine();

                Date sluttDato = new Date(sluttår, sluttmm, sluttdd, slutthh, sluttmin);

                Utleie utleie = new Utleie(bruker, regiBil, startDato, sluttDato);
                utleieListe.add(utleie);

                finnBil(regiBil).setLedig(false);
                
                //print ut en bekreftelse på bestilling ved å printe ut registreringnr om bilen og start og slutttidspunktet.
                System.out.println("Du har nå lånt bilen med registreringsnummer " + regiBil + " fra " + startDato + " til og med " + sluttDato);


                return regiBil;
    }
    /**
     * 
     * @param bruker
     * tar inn 
     */
    public void returner(Bruker bruker) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Skriv inn reginummeret på bilen du skal levere:");
        String regi = scanner.nextLine();

        System.out.println("Hvor mange KM kjorte du?");
        int kilometer = scanner.nextInt();
        scanner.nextLine();

//        utleieListe.removeIf(utleie -> utleie.getBruker().equals(bruker));
        for (Utleie utleie : utleieListe) {
//        if (utleieListe.removeIf(utleie -> utleie.getBruker().equals(bruker))) {
//            if (utleie.getBruker().getKort().equals(bruker.getKort()) && utleie.getRegisteringsnummer().equals(finnBil(regi))) {
            if (utleie.getBruker().getKort().equals(bruker.getKort())) {

                Bil bil = finnBil(regi);
                bil.setKm(bil.getKm() + kilometer);
                bil.setLedig(true);

                Date startDate = utleie.getRentalDate();
                Date endDate = utleie.getReturnDate();

                long diff = endDate.getTime() - startDate.getTime();
//            long diffMin = diff / (60*1000) % 60;
                long diffHour = diff / (60 * 60 * 1000);

                System.out.println("Regningen kommer paa: " + BilUtleieselskap.regning(diffHour, kilometer, bil.getBilTyp()));
            }
        }
        }
    /**
     * @param Listen med biler som tilhørerutleieselskapet
     * 
     * spør om all attributene til
     * lager en ny bil 
     * legger bilen i liste for dette utleiekontoret
     */
    public void registrerBil(List<Bil> Utleiekontor ) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Skriv inn registeringsnummeret: ");
        String regi = scanner.nextLine();

        System.out.println("Skriv inn antall km kjørt: ");
        int km = scanner.nextInt();
        scanner.nextLine();
        

        System.out.println("Skriv inn merke: ");
        String merke = scanner.nextLine();
        
        System.out.println("Skriv inn farge: ");
        String farge = scanner.nextLine();

        System.out.println("Skriv inn biltype; 1 for LITEN, 2 for MELLOMSTOR, 3 for STOR, 4 for STASJONSVOGN ");
        int bilKat = scanner.nextInt();
      //antar at man bare kan registrere ledige biler
        if(bilKat == 1) {
        	bilerX.add(new Bil(regi, km, merke, farge, Bilkategori.LITEN, true));
        	Bil bil = 
        }
        else if(bilKat == 2) {
        	bilerX.add(new Bil(regi, km, merke, farge, Bilkategori.MELLOMSTOR, true));
        }
        else if(bilKat == 3) {
        	bilerX.add(new Bil(regi, km, merke, farge, Bilkategori.STOR, true));
        }
        else if(bilKat == 4) {
        	bilerX.add(new Bil(regi, km, merke, farge, Bilkategori.STASJONSVOGN, true));
        }
        
    }

//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Addresse getAddresse() {
        return addresse;
    }

    public void setAddresse(Addresse addresse) {
        this.addresse = addresse;
    }

    public int getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(int telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public List<Bil> getBiler() {
        return biler;
    }

    public void setBiler(List<Bil> biler) {
        this.biler = biler;
    }

    public List<Utleie> getUtleieListe() {
        return utleieListe;
    }

    public void setUtleieListe(List<Utleie> utleieListe) {
        this.utleieListe = utleieListe;
    }

    public String toString2() {
        return "Utleiekontor{" +
                "id=" + id + " " +
                addresse +
                ", telefonnummer=" + telefonnummer;
    }

    public void bilerTilgjengelig() {
        for (Bil bil : biler) {
            if (bil.isLedig()) {
                System.out.println(bil);
            }
        }
    }
}
