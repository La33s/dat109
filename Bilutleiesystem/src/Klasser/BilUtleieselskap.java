package Klasser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Klasser.Bruker;

public class BilUtleieselskap {
    String navn;
    int telefonnummer;
    Addresse addresse;
    static List<Utleiekontor> utleiere;
    static List<Bruker> brukere;

    public BilUtleieselskap(String navn, int telefonnummer, Addresse addresse, List<Utleiekontor> utleiere, List<Bruker> brukere) {
        this.navn = navn;
        this.telefonnummer = telefonnummer;
        this.addresse = addresse;
        BilUtleieselskap.utleiere = utleiere;
        BilUtleieselskap.brukere = brukere;
    }

    public void utleiereTilgjengelig(){
        for (Utleiekontor utleie : utleiere){
            System.out.println(utleie.toString2());
        }
    }

    public static Utleiekontor finnUtleier(int i){
        Utleiekontor resultat = null;
        for (Utleiekontor utleiekontor : utleiere) {
            if (utleiekontor.id == i){
                resultat = utleiekontor;
            }
        }
        return resultat;
    }

    public static Bruker finnBruker(String kort){
        Bruker bruk = null;
        for (Bruker bruker : brukere){
            if (bruker.getKort().equals(kort)) bruk = bruker;
            }
        return bruk;
        }


    public static int typBeregning(Bilkategori typ) {
        int pris;
        switch (typ) {
            case LITEN:
                pris = 200;
                break;

            case MELLOMSTOR:
                pris = 350;
                break;

            case STASJONSVOGN:
                pris = 500;
                break;

            case STOR:
                pris = 650;
                break;
            default:
                pris = 100;
        }
        return pris;
    }


    public static long regning(long timer, int kilometer, Bilkategori typ){
        long sum = 150*timer;
        int ekstra = typBeregning(typ);
        sum = sum + ekstra;

        return sum;
    }
    /**
     * registrere kunder
     */
    public Bruker kundeRegistrering(){
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Skriv inn fornavn: ");
        String fornavn = scanner.nextLine();

        System.out.println("Skriv inn etternavn: ");
        String etternavn = scanner.nextLine();

        System.out.println("Skriv inn telefonnummer: ");
        int tele = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Skriv inn kort: ");
        String kort = scanner.nextLine();

        //Addressen
        System.out.println("Skriv inn gate addresse: ");
        String ga = scanner.nextLine();

        System.out.println("Skriv inn postnummer:");
        int pn = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Skriv inn poststed: ");
        String ps = scanner.nextLine();

        Addresse brukerAddresse = new Addresse(ga, pn, ps);
        Bruker lagtBruker = new Bruker(fornavn, etternavn, brukerAddresse, tele, kort);
        scanner.close();
        return lagtBruker;
    }
    
    /**
     * registere utleiekontor
     */
    public void registrereUtleiekontor() {
    	 Scanner scanner = new Scanner(System.in);
    	 
    	int nyId = utleiere.size() + 1;
    	
        System.out.println("Skriv inn det nye telefonnummeret: ");
        int tele = scanner.nextInt();
        scanner.nextLine();

        //Addressen
        System.out.println("Skriv inn gate addresse: ");
        String ga = scanner.nextLine();

        System.out.println("Skriv inn postnummer:");
        int pn = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Skriv inn poststed: ");
        String ps = scanner.nextLine();
        //lage de nye listene
        List<Utleie> nyListUtleie = new ArrayList<Utleie>();
        List<Bil> nyListBil = new ArrayList<Bil>();
        
        Addresse utleieKontorAddresse = new Addresse(ga, pn, ps);
        new Utleiekontor(nyId, utleieKontorAddresse,tele,nyListBil,nyListUtleie);
         scanner.close();
    }
    /**
     * 
     * 
     */
public void kundeInnlogging() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Skriv inn kortnummeret:");

    String kort = scanner.nextLine();

    Bruker innloggetBruker = BilUtleieselskap.finnBruker(kort);

    if (innloggetBruker != null) {
        //Skriv ut alle områdene du kan hente bil
       utleiereTilgjengelig();

        //Skriv inn ønsket plass (addresse)
        System.out.println("Skriv inn ID nummeret på utleieren du vil ha: ");

        int valgtID = scanner.nextInt();
        scanner.nextLine();

        //Skriv ut alle bilene i denne ønsket plassen (Utleiekontoret)
        Utleiekontor valgtUtleier = BilUtleieselskap.finnUtleier(valgtID);
        System.out.println("Her er alle bilene som er tilgjennelig: ");
        valgtUtleier.bilerTilgjengelig();
        

        String bilRegi = valgtUtleier.reserver(innloggetBruker);
        Bil bil = valgtUtleier.finnBil(bilRegi);

        //Send kvittering og få bruker til å returnere bil
        valgtUtleier.returner(innloggetBruker);


    } else {
        System.out.println("Finnes ingen bruker med dette kortet");
    }
    scanner.close();
}
    
    

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(int telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public Addresse getAddresse() {
        return addresse;
    }

    public void setAddresse(Addresse addresse) {
        this.addresse = addresse;
    }

    public List<Utleiekontor> getUtleiere() {
        return utleiere;
    }

    public void setUtleiere(List<Utleiekontor> utleiere) {
        this.utleiere = utleiere;
    }

    public List<Bruker> getBrukere() {
        return brukere;
    }

    public void setBrukere(List<Bruker> brukere) {
        this.brukere = brukere;
    }

    @Override
    public String toString() {
        return "BilUtleieselskap{" +
                "navn='" + navn + '\'' +
                ", telefonnummer=" + telefonnummer +
                ", addresse=" + addresse +
                ", utleiere=" + utleiere +
                ", brukere=" + brukere +
                '}';
    }
}
