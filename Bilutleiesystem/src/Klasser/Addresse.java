package Klasser;
/*
 * Klasse for å registrere adresse
 */
public class Addresse {
    String gateAddresse;
    int postnummer;
    String poststed;

    public Addresse(String gateAddresse, int postnummer, String poststed) {
        this.gateAddresse = gateAddresse;
        this.postnummer = postnummer;
        this.poststed = poststed;
    }

    public String getGateAddresse() {
        return gateAddresse;
    }

    public void setGateAddresse(String gateAddresse) {
        this.gateAddresse = gateAddresse;
    }

    public int getPostnummer() {
        return postnummer;
    }

    public void setPostnummer(int postnummer) {
        this.postnummer = postnummer;
    }

    public String getPoststed() {
        return poststed;
    }

    public void setPoststed(String poststed) {
        this.poststed = poststed;
    }

    /*
     * samler adresse informasjon til en string
     */
    @Override
    public String toString() {
        return "Addresse{" +
                "gateAddresse='" + gateAddresse + '\'' +
                ", postnummer='" + postnummer + '\'' +
                ", poststed='" + poststed + '\'' +
                '}';
    }
}
