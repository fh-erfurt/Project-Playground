package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException
    {
	    System.out.println("ich gebe etwas aus juhu");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String testInput = reader.readLine();

        System.out.println(testInput);

        Spielplatz spielplatz = new Spielplatz();

        spielplatz.SetAnzahlKinder(10);
        spielplatz.SetBezeichnung("Erster Spielplatz");
        spielplatz.SetStatus(Status.GutBesucht);

        System.out.println("Der erste Spielplatz wurde angelegt:");
        System.out.println("Name: " + spielplatz.GetBezeichnung());
        System.out.println("Anzahl anwesender Kinder: " + spielplatz.GetAnzahlKinder());
        System.out.println("Aktueller Status: " + spielplatz.GetStatus());


        

    }
}
