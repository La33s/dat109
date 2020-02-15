package Klasser;

public class Bruker {
    String fornavn;
    String etternavn;
    Addresse addresse;
    int telefonnummer;
    String kort;

    public Bruker (String fornavn, String etternavn, Addresse addresse, int telefonnummer, String kort){
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.addresse = addresse;
        this.telefonnummer = telefonnummer;
        this.kort = kort;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
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

    public String getKort() {
        return kort;
    }

    public void setKort(String kort) {
        this.kort = kort;
    }

    @Override
    public String toString() {
        return "Bruker{" +
                "fornavn='" + fornavn + '\'' +
                ", etternavn='" + etternavn + '\'' +
                ", addresse=" + addresse +
                ", telefonnummer=" + telefonnummer +
                ", kort='" + kort + '\'' +
                '}';
    }
}


