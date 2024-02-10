package Main;

import Klasser.*;

import java.util.*;

public class Meny {

    public static void main (String[] args){

        //Generere test data
        Addresse ad = new Addresse("Herman Grans vei 12", 5162, "Laksevåg");
        Bruker bruker = new Bruker("Knut Anders", "Aabø", ad, 45284167, "4925560020204562");

        //BilUtleieselskap generere test data

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



        //Start med valg av hva en vil gjøre i menyen
        int valgtMeny = velgMeny();

        if (valgtMeny == 1) { //for kundeinnlogging
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

        } else if (valgtMeny == 2) { // for kunde registrering

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
       
        else if (valgtMeny == 3) { // for registrering av ny bil
        	//registrereBil()
             System.out.println("Velg hvilkeet utleiekontor du vil registrere bilen for: ");
             int valgtUtleieKontor = scanner.nextInt();

             registrereBil(valgtUtleieKontor);
        }
        else if (valgtMeny == 4) { // for registrering av et nytt utleiekontor
        	//autogenerere id til
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

        	
        }
        

    }

    public static int velgMeny(){
        Scanner scanner = new Scanner(System.in);
            System.out.println("1 for login for kunder" + "\n" + "2 for registrering for kunder" + "/n" + "3 for registrering av utleiekontorer" + "/n" + "4 for registering av nye biler");

            int start = scanner.nextInt();
            scanner.nextLine();
            return start;
    }

}
