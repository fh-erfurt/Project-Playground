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


    // TODO: Gerät hinzufügen, Gerät entfernen //Fabian
    public void geraetHinzufuegen(List<Geraet> alleGeraete, Geraet geraet){
        alleGeraete.add(geraet);
    }

    public void geraetEntfernen(List<Geraet> alleGeraete, Geraet geraet){
        alleGeraete.remove(geraet);
    }
    
    
    // stand schon da
    
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
    
    // TODO: Spielplatzdaten verwalten
    public void spielplatzVerwalten(Spielplatz spielplatz, SpielplatzVerwalten neuerSpielplatzEintrag)
    {
        geraet.setSpielplatzVerwalten(neuerSpielplatzEintrag);
    }
}
