package projectplayground;

import java.util.ArrayList;
import java.util.List;

public class Moderator extends Benutzer
{
    public Moderator(String benutzername, String email, String passwort, int anzahlKinder, Standort aufenthaltsort)
    {
        this.benutzername = benutzername;
        this.email = email;
        this.passwort = passwort;
        this.eigeneKinder = anzahlKinder;
        this.aufenthaltsort = aufenthaltsort;
        this.zugriff = Zugriff.moderator;
        this.spielplatzFavoriten = new ArrayList<>();
        this.freunde = new ArrayList<>();
    }

    public void geraeteStatusAendern(Geraet geraet, GeraeteStatus neuerGeraeteStatus)
    {
        geraet.setGeraeteStatus(neuerGeraeteStatus);
    }

    public void geraetehinzufuegen(Geraet geraet) {

    }
    public void spielplatzHinzufuegen(List<Spielplatz> alleSpielplaetze, Spielplatz spielplatz){
        alleSpielplaetze.add(spielplatz);
    }
    public void spielplatzEntfernen(List<Spielplatz> alleSpielplaetze, Spielplatz spielplatz){
        alleSpielplaetze.remove(spielplatz);
    }
    // TODO: Gerät hinzufügen, Gerät entfernen //Fabian
    // TODO: Spielplatzdaten verwalten


}
