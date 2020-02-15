package Main;

import Klasser.*;

import java.util.*;

public class Meny {

    public static void main (String[] args){

        //Bruker test
        Addresse ad = new Addresse("Herman Grans vei 12", 5162, "Laksevåg");
        Bruker bruker = new Bruker("Knut Anders", "Aabø", ad, 45284167, "4925560020204562");

        //BilUtleieselskap test

        List<Bil> biler1 = new ArrayList<Bil>(Arrays.asList((new Bil("ER455266", 150000, "VW", "Space gray", Bilkategori.MELLOMSTOR, true)),
                                                         (new Bil("ER19547", 2000, "Volvo", "Svart", Bilkategori.STASJONSVOGN, true))));
        Addresse ad1 = new Addresse("Danmarksplass 12", 5054, "Bergen");

        List<Bil> biler2 = new ArrayList<Bil>(Arrays.asList((new Bil("ER99666", 35000, "Opel", "Mørkeblå", Bilkategori.LITEN, true)),
                                                            (new Bil("ER66999", 40000, "Opel", "Grønn", Bilkategori.MELLOMSTOR, true))));
        Addresse ad2 = new Addresse("Åsane Storsenter", 5116, "Ulset");


            Addresse adSelskap = new Addresse("90 Bedford St", 10014, "New York");
            List<Utleie> utleie1 = new ArrayList<Utleie>();
            List<Utleie> utleie2 = new ArrayList<Utleie>();
            Utleiekontor utleier1 = new Utleiekontor(1, ad1, 47506020, biler1, utleie1);
            Utleiekontor utleier2 = new Utleiekontor(2, ad2, 47505080, biler2, utleie2);
            BilUtleieselskap selskap = new BilUtleieselskap("MurielsRental", 20212150, adSelskap, new ArrayList<Utleiekontor>(Arrays.asList(utleier1, utleier2)), new ArrayList<Bruker>(Arrays.asList(bruker)));

        Scanner scanner = new Scanner(System.in);



        //Start med innlogging/oppretting av bruker
        int start = start();

        if (start == 1) {
            System.out.println("Skriv inn kortnummeret:");

            String kort = scanner.nextLine();

            Bruker bruk = BilUtleieselskap.finnBruker(kort);

            if (bruk != null) {
                //Skriv ut alle områdene du kan hente bil
                selskap.utleiereTilgjengelig();

                //Skriv inn ønsket plass (addresse)
                System.out.println("Skriv inn ID nummeret på utleieren du vil ha: ");

                int valgtID = scanner.nextInt();
                scanner.nextLine();

                //Skriv ut alle bilene i denne ønsket plassen (Utleiekontoret)
                Utleiekontor valgtUtleier = BilUtleieselskap.finnUtleier(valgtID);
                System.out.println("Her er alle bilene som er tilgjennelig: ");
                valgtUtleier.bilerTilgjengelig();
                

                String bilRegi = valgtUtleier.reserver(bruker);
                Bil bil = valgtUtleier.finnBil(bilRegi);

                //Send kvittering og få bruker til å returnere bil
                valgtUtleier.returner(bruker);
  

            } else {
                System.out.println("Finnes ingen bruker med dette kortet");
            }

        } else if (start == 2) {

        //Ny bruker
        System.out.println("Skriv inn fornavn: ");
        String fn = scanner.nextLine();

        System.out.println("Skriv inn etternavn: ");
        String en = scanner.nextLine();

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
        Bruker lagtBruker = new Bruker(fn, en, brukerAddresse, pn, kort);

            //Skriv ut alle områdene du kan hente bil
            selskap.utleiereTilgjengelig();

            //Skriv inn ønsket plass (addresse)
            System.out.println("Skriv inn ID nummeret på utleieren du vil ha: ");

            int valgtID = scanner.nextInt();
            scanner.nextLine();

            //Skriv ut alle bilene i denne ønsket plassen (Utleiekontoret)
            Utleiekontor valgtUtleier = BilUtleieselskap.finnUtleier(valgtID);
            System.out.println("Her er alle bilene som er tilgjennelig: ");
            valgtUtleier.bilerTilgjengelig();

            //Reservere bil
            String bilRegi = valgtUtleier.reserver(bruker);
            Bil bil = valgtUtleier.finnBil(bilRegi);

            //Send kvittering og få bruker til å returnere bil
            valgtUtleier.returner(bruker);

        }

    }

    public static int start(){
        Scanner scanner = new Scanner(System.in);
            System.out.println("1 for login" + "\n" + "2 for registrering");

            int start = scanner.nextInt();
            scanner.nextLine();
            return start;
    }

}
