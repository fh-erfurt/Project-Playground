package com.company;

public class Spielplatz {
    public Spielplatz()
    {

    }

    private String Bezeichnung;
    private int AnzahlKinder;
    private Status Status;


    public void SetBezeichnung(String Bezeichnung)
    {
        this.Bezeichnung = Bezeichnung;
    }

    public String GetBezeichnung()
    {
        return this.Bezeichnung;
    }

    public Status GetStatus()
    {
        return this.Status;
    }

    public void SetStatus(Status Status)
    {
        this.Status = Status;
    }

    public void SetAnzahlKinder(int AnzahlKinder)
    {
        this.AnzahlKinder = AnzahlKinder;
    }

    public int GetAnzahlKinder()
    {
        return this.AnzahlKinder;
    }
}
