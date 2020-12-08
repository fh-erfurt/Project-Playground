package projectplayground;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Spielplatz {
    public Spielplatz() {
        this.Geraete = new ArrayList<Geraet>();
    }

    public UUID ID;
    private String Bezeichnung;
    private int AnzahlKinder;
    private Status Status;
    private Standort Standort;
    private String Information;
    public List<Geraet> Geraete;
    // TO DO: Bilder


    public void setBezeichnung(String Bezeichnung) {
        this.Bezeichnung = Bezeichnung;
    }

    public String getBezeichnung() {
        return this.Bezeichnung;
    }

    public Status getStatus() {
        return this.Status;
    }

    public void setStatus(Status Status) {
        this.Status = Status;
    }

    public void setAnzahlKinder(int AnzahlKinder) {
        this.AnzahlKinder = AnzahlKinder;
    }

    public int getAnzahlKinder() {
        return this.AnzahlKinder;
    }

    public Standort getStandort() {
        return Standort;
    }

    public void setStandort(Standort standort) {
        Standort = standort;
    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public String getInformation() {
        return Information;
    }

    public void setInformation(String information) {
        Information = information;
    }
}