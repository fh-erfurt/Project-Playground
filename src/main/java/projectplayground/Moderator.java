package projectplayground;

import projectplayground.enums.GeraeteStatus;
import projectplayground.enums.Zugriff;
import projectplayground.exceptions.ModeratorException;

import java.util.ArrayList;
import java.util.List;

public class Moderator extends Benutzer
{
    public Moderator(String benutzername, String email, String passwort, int anzahlKinder)
    {
        this.benutzername = benutzername;
        this.email = email;
        this.passwort = passwort;
        this.eigeneKinder = anzahlKinder;
        this.zugriff = Zugriff.moderator;
        this.spielplatzFavoriten = new ArrayList<>();
        this.freunde = new ArrayList<>();
    }
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


    public void geraetHinzufuegen(Spielplatz spielplatz, Geraet geraet) throws ModeratorException
    {
        try
        {
            if(geraet == null)
                throw new ModeratorException("Übergebenes Gerät ist leer.");
            spielplatz.geraete.add(geraet);
            spielplatz.setKapazitaetSpielplatz(spielplatz.getKapazitaetSpielplatz() + geraet.getKapazitaetGeraet());
        }
        catch(ModeratorException ex)
        {
            throw new ModeratorException(ex.getMessage());
        }
    }

    public void geraetEntfernen(Spielplatz spielplatz, Geraet geraet) throws ModeratorException
    {
        try
        {
            if(geraet == null)
                throw new ModeratorException("Gerät ist leer und konnte nicht entfernt werden.");
            if(spielplatz.geraete.contains(geraet))
            {
                spielplatz.geraete.remove(geraet);
                spielplatz.setKapazitaetSpielplatz(spielplatz.getKapazitaetSpielplatz() - geraet.getKapazitaetGeraet());
            }
            else
                throw new ModeratorException("Gerät auf Spielplatz nicht gefunden.");
        }
        catch(ModeratorException ex)
        {
            throw new ModeratorException(ex.getMessage());
        }
    }

    public void geraeteStatusAendern(Geraet geraet, GeraeteStatus neuerGeraeteStatus) throws ModeratorException
    {
        try
        {
            if(geraet == null)
                throw new ModeratorException("Gerät ist leer, Status kann nicht geändert werden.");
            geraet.setGeraeteStatus(neuerGeraeteStatus);
        }
        catch(ModeratorException ex)
        {
            throw new ModeratorException(ex.getMessage());
        }
    }

    public void spielplatzHinzufuegen(List<Spielplatz> alleSpielplaetze, Spielplatz spielplatz) throws ModeratorException {
        try
        {
            if (spielplatz == null)
                throw new ModeratorException("Spielplatz ist leer und kann nicht hinzugefügt werden. ");

            alleSpielplaetze.add(spielplatz);
        }
        catch (ModeratorException ex)
        {
            throw new ModeratorException(ex.getMessage());
        }
    }

    public void spielplatzEntfernen(List<Spielplatz> alleSpielplaetze, Spielplatz spielplatz) throws ModeratorException
    {
        try
        {
            if(spielplatz == null)
                throw new ModeratorException("Spielplatz ist leer und wird nicht hinzugefügt.");

            if(alleSpielplaetze.contains(spielplatz))
                alleSpielplaetze.remove(spielplatz);
            else
                throw new ModeratorException("Spielplatz in DB nicht gefunden.");

        }
        catch(ModeratorException ex)
        {
            throw new ModeratorException(ex.getMessage());
        }
    }

    public void erweiterungHinzufuegen(Erweiterung erweiterung, Spielplatz spielplatz) throws ModeratorException
    {
        try
        {
            if (spielplatz == null)
                throw new ModeratorException("Spielplatz ist leer. Erweiterung hinzufügen fehlgeschlagen.");
            if (erweiterung == null)
                throw new ModeratorException("Erweiterung ist leer. Erweiterung hinzufügen fehlgeschlagen.");

            spielplatz.erweiterungen.add(erweiterung);
        }
        catch(ModeratorException ex)
        {
            throw new ModeratorException(ex.getMessage());
        }
    }
    public void erweiterungEntfernen(Erweiterung erweiterung, Spielplatz spielplatz) throws ModeratorException
    {
        try
        {
            if(!spielplatz.erweiterungen.contains(erweiterung))
                throw new ModeratorException("Erweiterung gehört nicht zum Spielplatz und kann nicht entfernt werden.");
            if(erweiterung == null)
                throw new ModeratorException("Erweiterung ist leer und kann nicht entfernt werden.");
            spielplatz.erweiterungen.remove(erweiterung);
        }
        catch(ModeratorException ex)
        {
            throw new ModeratorException(ex.getMessage());
        }
    }

    public void spielplatzVerwalten(Spielplatz spielplatz, Spielplatz neuerSpielplatzEintrag) throws ModeratorException
    {
        try
        {
            if(neuerSpielplatzEintrag == null)
                throw new ModeratorException("Änderungsdaten sind leer. Keine Veränderungen am Spielplatz durchgeführt.");

            spielplatz.setKapazitaetSpielplatz(neuerSpielplatzEintrag.getKapazitaetSpielplatz());
            spielplatz.setAnzahlKinder(neuerSpielplatzEintrag.getAnzahlKinder());

            if (neuerSpielplatzEintrag.getBezeichnung() != null)
                spielplatz.setBezeichnung(neuerSpielplatzEintrag.getBezeichnung());

            if (neuerSpielplatzEintrag.getInformation() != null)
                spielplatz.setInformation(neuerSpielplatzEintrag.getInformation());

            if (neuerSpielplatzEintrag.getSauberkeit() != null)
                spielplatz.setSauberkeit(neuerSpielplatzEintrag.getSauberkeit());

            if (neuerSpielplatzEintrag.getStatus() != null)
                spielplatz.setStatus(neuerSpielplatzEintrag.getStatus());

            if (neuerSpielplatzEintrag.getStandort() != null)
                spielplatz.setStandort(neuerSpielplatzEintrag.getStandort());
        }
        catch(ModeratorException ex)
        {
            throw new ModeratorException(ex.getMessage());
        }
    }
}
