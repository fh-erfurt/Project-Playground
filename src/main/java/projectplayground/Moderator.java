package projectplayground;

import projectplayground.enums.GeraeteStatus;
import projectplayground.enums.Zugriff;
import projectplayground.exceptions.ModeratorException;

import java.util.ArrayList;
import java.util.List;

/**
 * Kindklasse vom Benutzer, stellt die Klasse fuer den Moderator, welcher zusaetzliche Rechte zum Benutzer besitzt
 * Bietet Funktionen um das Programm als Nutzer zu verwenden, jedoch auch zusaetzlich Spielplaetze, Geraete und
 * Erweiterungen zu verwalten. Nur durch den Admin 'erwaehlte' Nutzer erhaltet diese Zugriffsmöglichkeiten
 */
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


    /**
     * @param spielplatz Spielplatz, zu dem das Geraet hinzugefuegt werden soll
     * @param geraet Geraet, das zu dem Spielplatz hinzugefuegt werden soll
     * @throws ModeratorException
     */
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

    /**
     * @param spielplatz Spielplatz, von dem das Geraet entfernt werden soll
     * @param geraet Geraet, welches vom Spielplatz entfernt werden soll
     * @throws ModeratorException
     */
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

    /**
     * @param geraet Geraet, dessen Status geaendert werden soll
     * @param neuerGeraeteStatus Neuer Status des Geraets
     * @throws ModeratorException
     */
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

    /**
     * @param alleSpielplaetze Gesamtheit aller Spielplaetze, spaeter obsolet da DB diese Liste vorgibt
     * @param spielplatz Spielplatz, der zur Liste (spaeter DB) hinzugefuegt werden soll
     * @throws ModeratorException
     */
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

    /**
     * @param alleSpielplaetze Gesamtheit aller Spielplaetze, spaeter obsolet da DB diese Liste vorgibt
     * @param spielplatz Spielplatz, der entfernt werden soll
     * @throws ModeratorException
     */
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

    /**
     * @param erweiterung Erweiterung, die dem Spielplatz hinzugefuegt werden soll
     * @param spielplatz Spielplatz, der die Erweiterung erhaelt
     * @throws ModeratorException
     */
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

    /**
     * @param erweiterung Erweiterung, die vom Spielplatz entfernt werden soll
     * @param spielplatz Spielplatz, dessen Erweiterung entfernt wird
     * @throws ModeratorException
     */
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

    /**
     * @param spielplatz Spielplatz, dessen Daten geaendert werden sollen
     * @param neuerSpielplatzEintrag Spielplatzobjekt, welches die Daten enthaelt die geaendert werden sollen
     * @throws ModeratorException
     */
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
