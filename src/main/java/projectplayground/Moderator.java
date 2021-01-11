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


    // TODO: Gerät hinzufügen, Gerät entfernen
    public void geraetHinzufuegen(Spielplatz spielplatz, Geraet geraet)
    {
        spielplatz.geraete.add(geraet);
    }

    public void geraetEntfernen(Spielplatz spielplatz, Geraet geraet)
    {
        spielplatz.geraete.remove(geraet);
    }

    public void geraeteStatusAendern(Geraet geraet, GeraeteStatus neuerGeraeteStatus)
    {
        geraet.setGeraeteStatus(neuerGeraeteStatus);
    }

    public void spielplatzHinzufuegen(List<Spielplatz> alleSpielplaetze, Spielplatz spielplatz){
        alleSpielplaetze.add(spielplatz);
    }
    public void spielplatzEntfernen(List<Spielplatz> alleSpielplaetze, Spielplatz spielplatz){
        alleSpielplaetze.remove(spielplatz);
    }
    
    // TODO: Spielplatzdaten verwalten
}
