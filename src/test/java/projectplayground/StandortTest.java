package projectplayground;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StandortTest {

    Standort spielplatzLuisenparkStandort = new Standort(20, "Robert-Koch-Straße",
            99096, "Erfurt", "Luisenpark", "Stadtpark");
    Standort spielplatzStadtparkStandort = new Standort(29, "Robert-Koch-Straße",
            99096, "Erfurt", "Stadtpark", "Stadtpark");

    ArrayList<Standort> adressenListe = new ArrayList<Standort>();






    @BeforeEach
    void setUp() {

        //Eingabe der Liste
        adressenListe.add(spielplatzLuisenparkStandort);
        adressenListe.add(spielplatzStadtparkStandort);


    }
    @Test
    void zeigeStandorteAn(){
        //Ausgabe der Liste
        for (Standort adresse : adressenListe) {
            System.out.println("Spielplatzname: " + adresse.getName() + " Straße: " + adresse.getStrassenname() + " Hausnummer: " + adresse.getHausnummer()
                    + " Stadtname: " + adresse.getStadtname() + " Postleitzahl: " + adresse.getPostleitzahl() + " Stadtteil: " + adresse.getStadtteil() );
        }
    }
}