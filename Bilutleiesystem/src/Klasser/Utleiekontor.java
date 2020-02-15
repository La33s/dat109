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

        System.out.println("Skriv inn registreningsnummer på ønsket bil");
        String regiBil = scanner.nextLine();

                System.out.println("Stardato");
                System.out.println("Skriv inn: åååå");
                int år = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Skriv inn: mm");
                int mm = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Skriv inn: dd");
                int dd = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Skriv inn: hh");
                int hh = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Skriv inn: minutter");
                int min = scanner.nextInt();
                scanner.nextLine();

                Date startDato = new Date(år, mm, dd, hh, min);

                System.out.println("Sluttdato");
                System.out.println("Skriv inn: åååå");
                int sluttår = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Skriv inn: mm");
                int sluttmm = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Skriv inn: dd");
                int sluttdd = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Skriv inn: hh");
                int slutthh = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Skriv inn: minutter");
                int sluttmin = scanner.nextInt();
                scanner.nextLine();

                Date sluttDato = new Date(sluttår, sluttmm, sluttdd, slutthh, sluttmin);

                Utleie utleie = new Utleie(bruker, regiBil, startDato, sluttDato);
                utleieListe.add(utleie);

                finnBil(regiBil).setLedig(false);

                return regiBil;
    }

    public void returner(Bruker bruker) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Skriv inn reginummeret på bilen du skal levere:");
        String regi = scanner.nextLine();

        System.out.println("Hvor mange KM kjørte du?");
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

                System.out.println("Regningen kommer på: " + BilUtleieselskap.regning(diffHour, kilometer, bil.getBilTyp()));
            }
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
