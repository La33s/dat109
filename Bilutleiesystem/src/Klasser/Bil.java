package Klasser;
/**
 * Bil klassen
 */
public class Bil {
    String registreringsnummer;
    int km;
    String merke;
    String farge;
    Bilkategori bilTyp;
    boolean ledig;

    public Bil(String registreringsnummer, int km, String merke, String farge, Bilkategori bilTyp, boolean ledig) {
        this.registreringsnummer = registreringsnummer;
        this.km = km;
        this.merke = merke;
        this.farge = farge;
        this.bilTyp = bilTyp;
        this.ledig = ledig;
    }

    public String getRegistreringsnummer() {
        return registreringsnummer;
    }

    public void setRegistreringsnummer(String registreringsnummer) {
        this.registreringsnummer = registreringsnummer;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getMerke() {
        return merke;
    }

    public void setMerke(String merke) {
        this.merke = merke;
    }

    public String getFarge() {
        return farge;
    }

    public void setFarge(String farge) {
        this.farge = farge;
    }

    public Bilkategori getBilTyp() {
        return bilTyp;
    }

    public void setBilTyp(Bilkategori bilTyp) {
        this.bilTyp = bilTyp;
    }

    public boolean isLedig() {
        return ledig;
    }

    public void setLedig(boolean ledig) {
        this.ledig = ledig;
    }

    @Override
    public String toString() {
        return "Bil{" +
                "registreringsnummer='" + registreringsnummer + '\'' +
                ", km=" + km +
                ", merke='" + merke + '\'' +
                ", farge='" + farge + '\'' +
                ", bilTyp=" + bilTyp +
                ", ledig=" + ledig +
                '}';
    }
}
