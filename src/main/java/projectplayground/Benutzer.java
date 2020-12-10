package projectplayground;

import java.util.ArrayList;
import java.util.List;

public class Benutzer extends Profil {

    private int eigeneKinder;
    private Standort aufenthaltsort;
    private List<Spielplatz> spielplatzFavoriten;
    private List<Benutzer> freunde;

    public Benutzer(String benutzername, String email, String passwort, int anzahlKinder, Standort aufenthaltsort) {
        this.benutzername = benutzername;
        this.email = email;
        this.passwort = passwort;
        this.eigeneKinder = anzahlKinder;
        this.aufenthaltsort = aufenthaltsort;
        this.zugriff = Zugriff.benutzer;
        this.spielplatzFavoriten = new ArrayList<Spielplatz>();
        this.freunde = new ArrayList<Benutzer>();
    }

    public List<Spielplatz> getSpielplatzFavoriten() {
        return spielplatzFavoriten;
    }

    public void setSpielplatzFavoriten(List<Spielplatz> spielplatzFavoriten) {
        this.spielplatzFavoriten = spielplatzFavoriten;
    }

    public int getEigeneKinder() {
        return eigeneKinder;
    }

    public void setEigeneKinder(int eigeneKinder) {
        this.eigeneKinder = eigeneKinder;
    }

    public Standort getAufenthaltsort() {
        return aufenthaltsort;
    }

    public void setAufenthaltsort(Standort aufenthaltsort) {
        this.aufenthaltsort = aufenthaltsort;
    }

    public List<Benutzer> getFreunde() {
        return freunde;
    }

    public void setFreunde(List<Benutzer> freunde) {
        this.freunde = freunde;
    }


    public void freundHinzufuegen(Benutzer neuerFreund)
    {
        this.freunde.add(neuerFreund);
    }
    public void freundEntfernen(Benutzer freund)
    {
        this.freunde.remove(freund);
    }
}

