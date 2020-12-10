package projectplayground;

import java.util.ArrayList;
import java.util.List;

public class Benutzer extends Profil {

    private int eigeneKinder;
    private Standort aufenthaltsort;
    private List<Spielplatz> spielplatzFavoriten;
    private List<Profil> freunde;

    public Benutzer() {
        this.spielplatzFavoriten = new ArrayList<Spielplatz>();
        this.freunde = new ArrayList<Profil>();
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

    public List<Profil> getFreunde() {
        return freunde;
    }

    public void setFreunde(List<Profil> freunde) {
        this.freunde = freunde;
    }
}

