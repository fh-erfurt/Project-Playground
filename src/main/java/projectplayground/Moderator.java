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


    public void geraetHinzufuegen(Spielplatz spielplatz, Geraet geraet)
    {
        try
        {
            spielplatz.geraete.add(geraet);
            spielplatz.setKapazitaetSpielplatz(spielplatz.getKapazitaetSpielplatz() + geraet.getKapazitaetGeraet());
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void geraetEntfernen(Spielplatz spielplatz, Geraet geraet)
    {
        try
        {
            if(spielplatz.geraete.contains(geraet))
            {
                spielplatz.geraete.remove(geraet);
                spielplatz.setKapazitaetSpielplatz(spielplatz.getKapazitaetSpielplatz() - geraet.getKapazitaetGeraet());
            }
            else
            {
                System.out.println("Gerät auf Spielplatz nicht gefunden.");
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
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

    public void spielplatzVerwalten(Spielplatz spielplatz, Spielplatz neuerSpielplatzEintrag)
    {
        spielplatz.setKapazitaetSpielplatz(neuerSpielplatzEintrag.getKapazitaetSpielplatz());
        spielplatz.setAnzahlKinder(neuerSpielplatzEintrag.getAnzahlKinder());

        if(neuerSpielplatzEintrag.getBezeichnung() != null)
            spielplatz.setBezeichnung(neuerSpielplatzEintrag.getBezeichnung());

        if(neuerSpielplatzEintrag.getInformation() != null)
            spielplatz.setInformation(neuerSpielplatzEintrag.getInformation());

        if(neuerSpielplatzEintrag.getSauberkeit() != null)
            spielplatz.setSauberkeit(neuerSpielplatzEintrag.getSauberkeit());

        if(neuerSpielplatzEintrag.getStatus() != null)
            spielplatz.setStatus(neuerSpielplatzEintrag.getStatus());

        if(neuerSpielplatzEintrag.getStandort() != null)
            spielplatz.setStandort(neuerSpielplatzEintrag.getStandort());
    }
}
