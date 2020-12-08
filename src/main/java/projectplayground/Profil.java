package projectplayground;

import java.util.ArrayList;
import java.util.List;

public class Profil {
    private String Benutzername;
    private String Passwort;
    private String Email;
    private int EigeneKinder;
    private Standort Aufenthaltsort;
    private List<Spielplatz> SpielplatzFavoriten;
    private List<Profil> Freunde;


    public Profil() {
        this.SpielplatzFavoriten = new ArrayList<Spielplatz>();
        this.Freunde = new ArrayList<Profil>();
    }

    public String getBenutzername() {
        return Benutzername;
    }

    public void setBenutzername(String benutzername) {
        Benutzername = benutzername;
    }

    public String getPasswort() {
        return Passwort;
    }

    public void setPasswort(String passwort) {
        Passwort = passwort;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }


    public List<Spielplatz> getSpielplatzFavoriten() {
        return SpielplatzFavoriten;
    }

    public void setSpielplatzFavoriten(List<Spielplatz> spielplatzFavoriten) {
        SpielplatzFavoriten = spielplatzFavoriten;
    }

    public int getEigeneKinder() {
        return EigeneKinder;
    }

    public void setEigeneKinder(int eigeneKinder) {
        EigeneKinder = eigeneKinder;
    }

    public Standort getAufenthaltsort() {
        return Aufenthaltsort;
    }

    public void setAufenthaltsort(Standort aufenthaltsort) {
        Aufenthaltsort = aufenthaltsort;
    }

    public List<Profil> getFreunde() {
        return Freunde;
    }

    public void setFreunde(List<Profil> freunde) {
        Freunde = freunde;
    }
}
