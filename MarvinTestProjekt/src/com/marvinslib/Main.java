package com.marvinslib;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.UUID;

public class Main {

    public static void main(String[] args) throws IOException
    {
	    System.out.println("ich gebe etwas aus juhu");
        Spielplatz spielplatz = new Spielplatz();
        spielplatz.SetID(UUID.randomUUID());

        Standort standortBellaBFSpielplatz = new Standort();

        standortBellaBFSpielplatz.SetStrassenname("Tettaustraße");
        standortBellaBFSpielplatz.SetHausnummer(4);
        standortBellaBFSpielplatz.SetPostleitzahl(99094);
        standortBellaBFSpielplatz.SetStadtname("Erfurt");

        Geraet schaukel = new Geraet();
        schaukel.SetGeraeteStatus(GeraeteStatus.InTakt);
        schaukel.SetSpielplatzID(spielplatz.ID);
        schaukel.SetBezeichnung("Schaukel");

        Geraet wippe = new Geraet();
        wippe.SetGeraeteStatus(GeraeteStatus.Dreckig);
        wippe.SetBezeichnung("Wippe");
        wippe.SetSpielplatzID(spielplatz.ID);

        spielplatz.Geraete.add(schaukel);
        spielplatz.Geraete.add(wippe);
        spielplatz.SetStandort(standortBellaBFSpielplatz);
        spielplatz.SetAnzahlKinder(10);
        spielplatz.SetBezeichnung("BELLA barrierefreier Spielplatz");
        spielplatz.SetStatus(Status.Voll);

        System.out.println("Der erste Spielplatz wurde angelegt:");
        System.out.println("Name: " + spielplatz.GetBezeichnung());
        System.out.println("Anzahl anwesender Kinder: " + spielplatz.GetAnzahlKinder());
        System.out.println("Aktueller Status: " + spielplatz.GetStatus());


        switch (spielplatz.GetStatus()) {
            case GutBesucht -> System.out.println("Der Spielplatz ist wirklich gut besucht, schnell bevor er zu voll wird!");
            case Ueberfuellt -> System.out.println("Hier solltest du auf gar keinen Fall hin!!!");
            case Offen -> System.out.println("Schnell hin, da ist nix los!");
            case Voll -> System.out.println("Der Spielplatz ist voll...aber immerhin hat dein Kind Spielkameraden :D");
        }

        System.out.println("Jetzt zeige ich dir noch welche Geräte es dort so gibt: ");
        System.out.println("____________________________________________________");
        int geraeteZaehler = 1;
        for (Geraet geraet : spielplatz.Geraete)
        {
            System.out.println(geraeteZaehler);
            System.out.println("Gerätebezeichnung: " + geraet.GetBezeichnung());
            System.out.println("Zustand des Geräts: " + geraet.GetGeraeteStatus());
            System.out.println("____________________________________________________");
            geraeteZaehler++;
        }
        System.out.println("____________________________________________________\"");
        System.out.println("Willst Du diesen Spielplatz besuchen?");
        System.out.println("Wenn ja, bestätige mit 'Ja'. Falls nicht, lehne ab mit 'Nein'");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        if (input.equals("Ja") || input.equals("ja") || input.equals("j") ||input.equals("J"))
        {
            System.out.println("Alles klar, hier ist die Adresse: ");
            System.out.println("Ort: " + spielplatz.GetStandort().GetStadtname());
            System.out.println("Postleitzahl: " + spielplatz.GetStandort().GetPostleitzahl());
            System.out.println("Straße: " + spielplatz.GetStandort().GetStrassenname() + " " + spielplatz.GetStandort().GetHausnummer());
            System.out.println("____________________________________________________\"");
            System.out.println("Viel Spaß auf Deinem Ausflug!");
        }
        else
        {
            System.out.println("Nagut, dann vielleicht nächstes Mal. Auf Wiedersehen.");
        }

    }
}
