package com.marvinslib;

public class Standort {

    public Standort()
    {

    }
    private String Strassenname;
    private int Hausnummer;
    private int Postleitzahl;
    private String Stadtname;


    public String GetStrassenname() {
        return Strassenname;
    }

    public void SetStrassenname(String strassenname) {
        Strassenname = strassenname;
    }

    public int GetHausnummer() {
        return Hausnummer;
    }

    public void SetHausnummer(int hausnummer) {
        Hausnummer = hausnummer;
    }

    public int GetPostleitzahl() {
        return Postleitzahl;
    }

    public void SetPostleitzahl(int postleitzahl) {
        Postleitzahl = postleitzahl;
    }


    public String GetStadtname() {
        return Stadtname;
    }

    public void SetStadtname(String stadtname) {
        Stadtname = stadtname;
    }
}
