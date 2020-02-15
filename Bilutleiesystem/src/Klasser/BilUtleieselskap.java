package Klasser;

import java.util.List;

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
        this.brukere = brukere;
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
