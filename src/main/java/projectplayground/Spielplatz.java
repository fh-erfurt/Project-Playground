package projectplayground;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Spielplatz {
    public Spielplatz() {
        this.geraete = new ArrayList<Geraet>();
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
    public List<Benutzer> angemeldeteBenutzer;
    // TODO: Bilder


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

    public Geraet getGeraet(String geraeteName)
    {
        for (Geraet geraet: this.geraete)
        {
            if(geraet.getBezeichnung().equals(geraeteName))
                return geraet;
        }
        return null;
    }

    public void pruefeStatus()
    {
        if(this.anzahlKinder/(double)this.kapazitaetSpielplatz*100 < 40) // bis 40%
        {
            this.setStatus(Status.offen);
        }
        else if(this.anzahlKinder/(double)this.kapazitaetSpielplatz*100 < 90) // bis 90%
        {
            this.setStatus(Status.gutBesucht);
        }
        else if(this.anzahlKinder/(double)this.kapazitaetSpielplatz*100 <= 100) // bis 100%
        {
            this.setStatus(Status.voll);
        }
        else // > 100%
        {
            this.setStatus(Status.ueberfuellt);
        }
        System.out.println("Der Status des Spielplatz ist nun: " + this.getStatus());
    }

    public int getKapazitaetSpielplatz() {
        return kapazitaetSpielplatz;
    }

    public void setKapazitaetSpielplatz(int kapazitaetSpielplatz) {
        this.kapazitaetSpielplatz = kapazitaetSpielplatz;
    }

    public void aktualisiereSpielplatzKapazitaet()
    {
        int kapazitaet = 0;
        for (int i=0; i < this.geraete.size(); i++)
        {
            Geraet geraet = this.geraete.get(i);
            kapazitaet += geraet.getKapazitaetGeraet();
        }
        this.setKapazitaetSpielplatz(kapazitaet);
    }

}