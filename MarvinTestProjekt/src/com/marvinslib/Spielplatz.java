package com.marvinslib;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Spielplatz {
    public Spielplatz() {
        this.Geraete = new ArrayList<>();
    }
    public UUID ID;
    private String Bezeichnung;
    private int AnzahlKinder;
    private Status Status;
    private Standort Standort;
    public List<Geraet> Geraete;


    public void SetBezeichnung(String Bezeichnung) {
        this.Bezeichnung = Bezeichnung;
    }

    public String GetBezeichnung() {
        return this.Bezeichnung;
    }

    public Status GetStatus() {
        return this.Status;
    }

    public void SetStatus(Status Status) {
        this.Status = Status;
    }

    public void SetAnzahlKinder(int AnzahlKinder) {
        this.AnzahlKinder = AnzahlKinder;
    }

    public int GetAnzahlKinder() {
        return this.AnzahlKinder;
    }

    public Standort GetStandort() {
        return Standort;
    }

    public void SetStandort(Standort standort) {
        Standort = standort;
    }

    public UUID GetID() {
        return ID;
    }

    public void SetID(UUID ID) {
        this.ID = ID;
    }
}
