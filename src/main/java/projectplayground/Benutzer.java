package projectplayground;

import projectplayground.enums.GeraeteStatus;
import projectplayground.enums.Zugriff;
import projectplayground.exceptions.BenutzerException;
import projectplayground.exceptions.SpielplatzException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Benutzer extends Profil {

    protected int eigeneKinder;
    protected Standort aufenthaltsort;
    protected List<Spielplatz> spielplatzFavoriten;
    protected List<Benutzer> freunde;
    protected UUID aktuellerSpielplatz;


    public Benutzer()
    {
        this.spielplatzFavoriten = new ArrayList<Spielplatz>();
        this.freunde = new ArrayList<Benutzer>();
    }

    public Benutzer(String benutzername, String email, String passwort, int anzahlKinder)
    {
        if(anzahlKinder>0)
        {
            this.benutzername = benutzername;
            this.email = email;
            this.passwort = passwort;
            this.eigeneKinder = anzahlKinder;
            this.zugriff = Zugriff.benutzer;
            this.spielplatzFavoriten = new ArrayList<Spielplatz>();
            this.freunde = new ArrayList<Benutzer>();}
        else
        {
            System.out.println("Es muss mindestens ein Kind angegeben werden");
        }
    }

    public Benutzer(String benutzername, String email, String passwort, int anzahlKinder, Standort aufenthaltsort)
    {
        if(anzahlKinder>0)
        {
            this.benutzername = benutzername;
            this.email = email;
            this.passwort = passwort;
            this.eigeneKinder = anzahlKinder;
            this.zugriff = Zugriff.benutzer;
            this.aufenthaltsort = aufenthaltsort;
            this.spielplatzFavoriten = new ArrayList<Spielplatz>();
            this.freunde = new ArrayList<Benutzer>();
        }
        else
        {
            System.out.println("Es muss mindestens ein Kind angegeben werden");
        }
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

    public void spielplatzFavoritHinzufuegen(Spielplatz neuerSpielplatz)
    {
        this.spielplatzFavoriten.add(neuerSpielplatz);
    }

    public void spielplatzFavoritEntfernen(Spielplatz spielplatz)
    {
        this.spielplatzFavoriten.remove(spielplatz);
    }

    public Spielplatz getAktuellenSpielplatz(List<Spielplatz> alleSpielplaetze)
    {
        for (Spielplatz spielplatz: alleSpielplaetze)
        {
            if(spielplatz.getID() == this.aktuellerSpielplatz)
                return spielplatz;
        }
        return null;
    }

    //TODO Exceptionhandling wie folgt bei allen komplexen Funktionen einfügen
    public void spielplatzAnmeldung(UUID spielplatzID, List<Spielplatz> alleSpielplaetze) throws BenutzerException
    {
        try
        {
            if(this.aktuellerSpielplatz == null)
            {
                this.aktuellerSpielplatz = spielplatzID;
                Spielplatz spielplatz = this.getAktuellenSpielplatz(alleSpielplaetze);
                spielplatz.setAnzahlKinder(spielplatz.getAnzahlKinder() + this.eigeneKinder);
                spielplatz.angemeldeteBenutzer.add(this);
                spielplatz.pruefeStatus();
            }
            else
            {
                throw new BenutzerException("Benutzer ist bereits an einem Spielplatz angemeldet.");
            }
        }
        catch(BenutzerException | SpielplatzException ex)
        {
            throw new BenutzerException(ex.getMessage());
        }
    }

    public void spielplatzAnmeldung(UUID spielplatzID, List<Spielplatz> alleSpielplaetze, int anzahlKinder) throws BenutzerException
    {
        try
        {
            if(anzahlKinder == 0)
            {
                throw new BenutzerException("Mindestens ein Kind zur Anmeldung notwendig");
            }
            if(this.aktuellerSpielplatz == null)
            {
                this.aktuellerSpielplatz = spielplatzID;
                Spielplatz spielplatz = this.getAktuellenSpielplatz(alleSpielplaetze);
                spielplatz.setAnzahlKinder(spielplatz.getAnzahlKinder() + anzahlKinder);
                spielplatz.angemeldeteBenutzer.add(this);
                spielplatz.pruefeStatus();
            }
            else
            {
                System.out.println("Benutzer ist bereits an einem Spielplatz angemeldet.");
            }
        }
        catch(BenutzerException | SpielplatzException ex)
        {
            throw new BenutzerException(ex.getMessage());
        }
    }

    public void spielplatzAbmeldung(List<Spielplatz> alleSpielplaetze) throws BenutzerException
    {
        try
        {
            Spielplatz spielplatz = this.getAktuellenSpielplatz(alleSpielplaetze);
            if(spielplatz != null)
            {
                this.aktuellerSpielplatz = null;
                spielplatz.setAnzahlKinder(spielplatz.getAnzahlKinder() - this.eigeneKinder);
                spielplatz.angemeldeteBenutzer.remove(this);
                spielplatz.pruefeStatus();
            }
            else
            {
                throw new BenutzerException("Der Benutzer ist an keinem Spielplatz angemeldet. Abmeldung fehlgeschlagen.");
            }
        }
        catch(BenutzerException | SpielplatzException ex)
        {
            throw new BenutzerException(ex.getMessage());
        }
    }



    public void geraetMelden(String geraetName, List<Spielplatz> alleSpielplaetze)
    {
        try
        {
            Spielplatz spielplatz = this.getAktuellenSpielplatz(alleSpielplaetze);
            Geraet geraet = spielplatz.getGeraet(geraetName);
            if (geraet != null)
                geraet.setGeraeteStatus(GeraeteStatus.zuPruefen);
            else
                System.out.println("Gerät nicht vorhanden.");
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

}

