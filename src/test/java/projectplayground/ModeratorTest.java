package projectplayground;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ModeratorTest {

    List<Spielplatz> spielplatzListe = new ArrayList<>();
    Standort testStandort = new Standort();

    Benutzer marvin = new Benutzer("marvin", "test@gmx.de", "qwertz", 1, testStandort);
    Benutzer mark = new Benutzer("mark", "mark@gmx.de", "12345", 2,testStandort);
    Benutzer fabian = new Benutzer("fabian", "seebär@gmx.de", "6789", 1,testStandort);
    Moderator katja = new Moderator("katja", "katja@gmx.de", "12345", 0 , testStandort);
    Spielplatz spielplatz = new Spielplatz();

    Geraet schaukel = new Geraet();
    Geraet wippe = new Geraet();



    @BeforeEach
    void setUp() {
        spielplatz.setID(UUID.randomUUID());

        Standort standortBellaBFSpielplatz = new Standort();

        standortBellaBFSpielplatz.setStrassenname("Tettaustraße");
        standortBellaBFSpielplatz.setHausnummer(4);
        standortBellaBFSpielplatz.setPostleitzahl(99094);
        standortBellaBFSpielplatz.setStadtname("Erfurt");

        schaukel = new Geraet(spielplatz.getID(), "Schaukel", GeraeteStatus.inTaktesGeraet,
                        "Bei der Schaukel handelt es sich um eine Doppelschaukel.", 2);
        wippe = new Geraet(spielplatz.getID(), "Wippe", GeraeteStatus.verschmutztesGeraet,
                        "Hier können sich 2 Kinder beschäftigen.", 2);

        spielplatz.setStandort(standortBellaBFSpielplatz);
        spielplatz.setAnzahlKinder(10);
        spielplatz.setBezeichnung("BELLA barrierefreier Spielplatz");
        spielplatz.setStatus(Status.voll);

        spielplatzListe.add(spielplatz);
    }

    @Test
    void geraetHinzufuegen() {
        System.out.println("Spielplatzkapazität vor dem Hinzufügen eines Geräts: " + spielplatz.getKapazitaetSpielplatz());
        katja.geraetHinzufuegen(spielplatz, wippe);
        System.out.println("Spielplatzkapazität nach dem Hinzufügen eines Geräts: " + spielplatz.getKapazitaetSpielplatz());
        katja.geraetHinzufuegen(spielplatz, schaukel);
        System.out.println("Spielplatzkapazität nach dem Hinzufügen eines weiteren Geräts: " + spielplatz.getKapazitaetSpielplatz());
    }

    @Test
    void geraetEntfernen() {
        System.out.println("Spielplatzkapazität vor dem Entfernen eines Geräts: " + spielplatz.getKapazitaetSpielplatz());
        katja.geraetEntfernen(spielplatz, wippe);
        System.out.println("Spielplatzkapazität nach dem Entfernen eines Geräts: " + spielplatz.getKapazitaetSpielplatz());
        katja.geraetEntfernen(spielplatz, schaukel);
        System.out.println("Spielplatzkapazität nach dem Entfernen eines weiteren Geräts: " + spielplatz.getKapazitaetSpielplatz());
    }

    @Test
    void geraetHinzufuegenUndEntfernen() {
        System.out.println("Spielplatzkapazität vor dem Hinzufügen eines Geräts: " + spielplatz.getKapazitaetSpielplatz());
        katja.geraetHinzufuegen(spielplatz, wippe);
        System.out.println("Spielplatzkapazität nach dem Hinzufügen eines Geräts: " + spielplatz.getKapazitaetSpielplatz());
        katja.geraetEntfernen(spielplatz, wippe);
        System.out.println("Spielplatzkapazität nach dem Entfernen eines Geräts: " + spielplatz.getKapazitaetSpielplatz());
        katja.geraetEntfernen(spielplatz, schaukel);
        System.out.println("Spielplatzkapazität nach dem Entfernen eines weiteren Geräts: " + spielplatz.getKapazitaetSpielplatz());
    }
}