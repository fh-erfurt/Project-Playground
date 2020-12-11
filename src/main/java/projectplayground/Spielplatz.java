package projectplayground;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Spielplatz {
    public Spielplatz() {
        this.geraete = new ArrayList<Geraet>();
    }

    public UUID ID;
    private String bezeichnung;
    private int anzahlKinder;
    private Status status;
    private SauberkeitStatus sauberkeit;
    private Standort standort;
    private String information;
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
}