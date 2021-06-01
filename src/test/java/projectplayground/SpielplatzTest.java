package projectplayground;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectplayground.domains.enums.GeraeteStatus;
import projectplayground.domains.enums.Status;
import projectplayground.domains.exceptions.BenutzerException;
import projectplayground.domains.exceptions.ModeratorException;
import projectplayground.domains.exceptions.SpielplatzException;
import projectplayground.domains.java1.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpielplatzTest {
    List<Spielplatz> spielplatzListe = new ArrayList<>();

    Standort testStandort = new Standort();

    Benutzer marvin = new Benutzer("marvin", "test@gmx.de", "qwertz", 1, testStandort);
    Benutzer mark = new Benutzer("mark", "mark@gmx.de", "12345", 2,testStandort);
    Benutzer fabian = new Benutzer("fabian", "seebär@gmx.de", "6789", 1,testStandort);
    Moderator katja = new Moderator("katja", "katja@gmx.de", "12345", 2 , testStandort);
    Spielplatz spielplatz = new Spielplatz();
    Geraet schaukel = new Geraet(spielplatz.getID(), "Schaukel", GeraeteStatus.inTaktesGeraet,
            "Bei der Schaukel handelt es sich um eine Doppelschaukel.",2);
    Geraet wippe = new Geraet(spielplatz.getID(), "Wippe", GeraeteStatus.verschmutztesGeraet,
            "Hier können sich 2 Kinder beschäftigen.", 2);


    @BeforeEach
    public void setUp() throws ModeratorException {
        spielplatz.setID(UUID.randomUUID());

        Standort standortBellaBFSpielplatz = new Standort();

        standortBellaBFSpielplatz.setStrassenname("Tettaustraße");
        standortBellaBFSpielplatz.setStadtteil("Teststadtteil");
        standortBellaBFSpielplatz.setHausnummer(4);
        standortBellaBFSpielplatz.setPostleitzahl(99094);
        standortBellaBFSpielplatz.setStadtname("Erfurt");


        katja.geraetHinzufuegen(spielplatz, schaukel);
        katja.geraetHinzufuegen(spielplatz,wippe);
        spielplatz.setStandort(standortBellaBFSpielplatz);
        spielplatz.setAnzahlKinder(0);
        spielplatz.setBezeichnung("BELLA barrierefreier Spielplatz");
        spielplatz.setStatus(Status.offen);
        spielplatzListe.add(spielplatz);
    }




    @Test
    void getGeraetTest() throws SpielplatzException{
        Geraet wippe = spielplatz.getGeraet("Wippe");
        assertEquals(wippe.getBezeichnung(), "Wippe");
    }

    @Test
    void pruefeStatusOffenTest() throws SpielplatzException, BenutzerException {
        System.out.println("Kapazität: " + spielplatz.getKapazitaetSpielplatz());
        spielplatz.pruefeStatus();
        assertEquals(Status.offen, spielplatz.getStatus());

    }

    @Test
    void pruefeStatusOffenGutBesuchtVollTest() throws SpielplatzException, BenutzerException {
        System.out.println("Kapazität: " + spielplatz.getKapazitaetSpielplatz());
        marvin.spielplatzAnmeldung(spielplatz.getID(), spielplatzListe);
        mark.spielplatzAnmeldung(spielplatz.getID(), spielplatzListe);
        fabian.spielplatzAnmeldung(spielplatz.getID(), spielplatzListe);
        assertEquals(Status.voll, spielplatz.getStatus());
        Toilette neu = new Toilette(2,true);
    }


    @Test
    void aktualisiereSpielplatzKapazitaetTest() throws SpielplatzException{
        spielplatz.geraete.add(wippe);
        spielplatz.geraete.add(wippe);
        spielplatz.aktualisiereSpielplatzKapazitaet();
        assertEquals(8, spielplatz.getKapazitaetSpielplatz());
    }

    @Test
    void zeigeStandortAnTest() throws SpielplatzException{
        spielplatz.zeigeStandortAn();
    }
}