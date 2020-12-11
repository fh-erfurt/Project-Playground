package projectplayground;

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

    }

    public Benutzer(String benutzername, String email, String passwort, int anzahlKinder)
    {
        if(anzahlKinder>0){
        this.benutzername = benutzername;
        this.email = email;
        this.passwort = passwort;
        this.eigeneKinder = anzahlKinder;
        this.zugriff = Zugriff.benutzer;
        this.spielplatzFavoriten = new ArrayList<Spielplatz>();
        this.freunde = new ArrayList<Benutzer>();}
        else{
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

    public void setAktuellerSpielplatz(UUID spielplatzID)
    {
        //TODO erweitern siehe Spielplatzanmeldung
        this.aktuellerSpielplatz = spielplatzID;
    }

    public void geraetMelden(String geraetName, List<Spielplatz> alleSpielplaetze)
    {
            Spielplatz spielplatz = this.getAktuellenSpielplatz(alleSpielplaetze);
            Geraet geraet = spielplatz.getGeraet(geraetName);
            if (geraet != null)
                geraet.setGeraeteStatus(GeraeteStatus.zuPruefen);
            else
                System.out.println("Gerät nicht vorhanden.");
    }

    // TODO: Am Spielplatz anmelden (mit Kinderanzahl) / abmelden
}

