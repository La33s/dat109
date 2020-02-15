package Klasser;

import java.util.Date;

public class Utleie {
    Bruker bruker;
    String registeringsnummer;
    Date rentalDate;
    Date returnDate;

    public Utleie(Bruker bruker, String registeringsnummer, Date rentalDate, Date returnDate) {
        this.bruker = bruker;
        this.registeringsnummer = registeringsnummer;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }

    public Bruker getBruker() {
        return bruker;
    }

    public void setBruker(Bruker bruker) {
        this.bruker = bruker;
    }

    public String getRegisteringsnummer() {
        return registeringsnummer;
    }

    public void setRegisteringsnummer(String registeringsnummer) {
        this.registeringsnummer = registeringsnummer;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Utleie{" +
                "bruker=" + bruker +
                ", registeringsnummer='" + registeringsnummer + '\'' +
                ", rentalDate=" + rentalDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
