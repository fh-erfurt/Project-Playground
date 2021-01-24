package projectplayground;

import projectplayground.enums.SauberkeitStatus;
import projectplayground.enums.Status;
import projectplayground.exceptions.SpielplatzException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Spielplatz {
    public Spielplatz() {
        this.geraete = new ArrayList<Geraet>();
        this.angemeldeteBenutzer = new ArrayList<Benutzer>();
        this.erweiterungen = new ArrayList<Erweiterung>();

    }

    public Spielplatz(String bezeichnung, Status status, SauberkeitStatus sauberkeit, String information, int anzahlKinder) {
        this.bezeichnung = bezeichnung;
        this.status = status;
        this.sauberkeit = sauberkeit;
        this.information = information;
        this.anzahlKinder = anzahlKinder;
        this.geraete = new ArrayList<Geraet>();
        this.erweiterungen = new ArrayList<Erweiterung>();
        this.angemeldeteBenutzer = new ArrayList<Benutzer>();
    }

    public UUID ID;
    private String bezeichnung;
    private Status status;
    private SauberkeitStatus sauberkeit;
    private Standort standort;
    private String information;
    private int anzahlKinder;
    private int kapazitaetSpielplatz;
    public List<Geraet> geraete;
    public List<Erweiterung> erweiterungen;
    public List<Benutzer> angemeldeteBenutzer;


    public void setErweiterungen(List<Erweiterung> erweiterungen) {
        this.erweiterungen = erweiterungen;
    }

    public List<Erweiterung> getErweiterungen() {
        return erweiterungen;
    }

    public void setBezeichnung(String Bezeichnung) {
        this.bezeichnung = Bezeichnung;
    }

    public String getBezeichnung() {
        return this.bezeichnung;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status Status) {
        this.status = Status;
    }

    public void setAnzahlKinder(int AnzahlKinder) {
        this.anzahlKinder = AnzahlKinder;
    }

    public int getAnzahlKinder() {
        return this.anzahlKinder;
    }

    public Standort getStandort() {
        return standort;
    }

    public void setStandort(Standort standort) {
        this.standort = standort;
    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public SauberkeitStatus getSauberkeit() {
        return sauberkeit;
    }

    public void setSauberkeit(SauberkeitStatus sauberkeit) {
        this.sauberkeit = sauberkeit;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getKapazitaetSpielplatz() {
        return kapazitaetSpielplatz;
    }

    public void setKapazitaetSpielplatz(int kapazitaetSpielplatz) {
        this.kapazitaetSpielplatz = kapazitaetSpielplatz;
    }

    public Geraet getGeraet(String geraeteName) throws SpielplatzException {
        try {
            for (Geraet geraet : this.geraete) {
                if (geraet.getBezeichnung().equals(geraeteName))
                    return geraet;
            }
            throw new SpielplatzException("Gerät nicht gefunden");
        } catch (SpielplatzException ex) {
            throw new SpielplatzException("Beim Gerät abrufen ist etwas schiefgelaufen.");
        }
    }

    public void pruefeStatus() throws SpielplatzException {
        try {
            double prozentsatzKinderanzahl = this.anzahlKinder / (double) this.kapazitaetSpielplatz * 100;
            if (prozentsatzKinderanzahl < 40) // bis 40%
            {
                this.setStatus(Status.offen);
            } else if (prozentsatzKinderanzahl < 90) // bis 90%
            {
                this.setStatus(Status.gutBesucht);
            } else if (prozentsatzKinderanzahl <= 100) // bis 100%
            {
                this.setStatus(Status.voll);
            } else // > 100%
            {
                this.setStatus(Status.ueberfuellt);
            }
            if (prozentsatzKinderanzahl < 0) {
                throw new SpielplatzException("Prozentsatz unter 0, Berechnung des Status ist fehlgeschlagen.");
            }
            System.out.println("Der Status des Spielplatz ist nun: " + this.getStatus());
        } catch (SpielplatzException ex) {
            throw new SpielplatzException("Beim Überprüfen des Status ist etwas schiefgelaufen.");
        }
    }

    public void aktualisiereSpielplatzKapazitaet() throws SpielplatzException {
        try
        {
            int aktuelleKapazitaet = 0;
            for (int i = 0; i < this.geraete.size(); i++)
            {
                Geraet geraet = this.geraete.get(i);
                aktuelleKapazitaet += geraet.getKapazitaetGeraet();
            }
            if (aktuelleKapazitaet >= 0)
                this.setKapazitaetSpielplatz(aktuelleKapazitaet);
            else
            {
                throw new SpielplatzException("Spielplatzkapazität im negativen Bereich.");
            }
        }
        catch(SpielplatzException ex)
        {
        throw new SpielplatzException(ex.getMessage());
        }
}

}