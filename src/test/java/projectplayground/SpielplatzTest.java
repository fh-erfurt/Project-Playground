package projectplayground;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class SpielplatzTest {
    List<Spielplatz> spielplatzListe = new ArrayList<>();

    Standort testStandort = new Standort();

    Benutzer marvin = new Benutzer("marvin", "test@gmx.de", "qwertz", 100, testStandort);
    Benutzer mark = new Benutzer("mark", "mark@gmx.de", "12345", 2,testStandort);
    Benutzer fabian = new Benutzer("fabian", "seebär@gmx.de", "6789", 1,testStandort);
    Moderator katja = new Moderator("katja", "katja@gmx.de", "12345", 0 , testStandort);
    Spielplatz spielplatz = new Spielplatz();



    @BeforeEach
    public void setUp()
    {
        spielplatz.setID(UUID.randomUUID());

        Standort standortBellaBFSpielplatz = new Standort();

        standortBellaBFSpielplatz.setStrassenname("Tettaustraße");
        standortBellaBFSpielplatz.setHausnummer(4);
        standortBellaBFSpielplatz.setPostleitzahl(99094);
        standortBellaBFSpielplatz.setStadtname("Erfurt");

        Geraet schaukel = new Geraet(spielplatz.getID(), "Schaukel", GeraeteStatus.inTaktesGeraet,
                "Bei der Schaukel handelt es sich um eine Doppelschaukel.",50);
        Geraet wippe = new Geraet(spielplatz.getID(), "Wippe", GeraeteStatus.verschmutztesGeraet,
                "Hier können sich 2 Kinder beschäftigen.", 50);
        katja.geraetHinzufuegen(spielplatz, schaukel);
        katja.geraetHinzufuegen(spielplatz,wippe);
        spielplatz.setStandort(standortBellaBFSpielplatz);
        spielplatz.setAnzahlKinder(0);
        spielplatz.setBezeichnung("BELLA barrierefreier Spielplatz");
        spielplatz.setStatus(Status.offen);

        spielplatzListe.add(spielplatz);
    }

    @Test
    void pruefeStatus() {
        System.out.println("Kapazität: " + spielplatz.getKapazitaetSpielplatz());
        System.out.println("Anzahl der Kinder vorort: " + spielplatz.getAnzahlKinder());
        spielplatz.pruefeStatus();

        marvin.spielplatzAnmeldung(spielplatz.ID, spielplatzListe);
        System.out.println("Kapazität: " + spielplatz.getKapazitaetSpielplatz());
        System.out.println("Anzahl der Kinder vorort: " + spielplatz.getAnzahlKinder());
        spielplatz.pruefeStatus();
    }
}