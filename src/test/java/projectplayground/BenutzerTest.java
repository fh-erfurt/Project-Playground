package projectplayground;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectplayground.domains.*;
import projectplayground.domains.enums.GeraeteStatus;
import projectplayground.domains.enums.Status;
import projectplayground.domains.exceptions.BenutzerException;
import projectplayground.domains.exceptions.ModeratorException;
import projectplayground.domains.exceptions.SpielplatzException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BenutzerTest  {

    List<Spielplatz> spielplatzListe = new ArrayList<>();

    Standort testStandort = new Standort();

    Benutzer marvin = new Benutzer("marvin", "test@gmx.de", "qwertz", 10, testStandort);
    Benutzer mark = new Benutzer("mark", "mark@gmx.de", "12345", 2,testStandort);
    Benutzer fabian = new Benutzer("fabian", "seebär@gmx.de", "6789", 1,testStandort);
    Moderator katja = new Moderator("katja", "katja@gmx.de", "12345", 0,testStandort );
    Spielplatz spielplatz = new Spielplatz();



    @BeforeEach
    public void setUp () throws ModeratorException, BenutzerException {
        spielplatz.setID(UUID.randomUUID());

        Standort standortBellaBFSpielplatz = new Standort();
        standortBellaBFSpielplatz.setStrassenname("Tettaustraße");
        standortBellaBFSpielplatz.setHausnummer(4);
        standortBellaBFSpielplatz.setPostleitzahl(99094);
        standortBellaBFSpielplatz.setStadtname("Erfurt");

        Geraet schaukel = new Geraet(spielplatz.getID(), "Schaukel", GeraeteStatus.inTaktesGeraet,
                        "Bei der Schaukel handelt es sich um eine Doppelschaukel.",2);
        Geraet wippe = new Geraet(spielplatz.getID(), "Wippe", GeraeteStatus.verschmutztesGeraet,
                        "Hier können sich 2 Kinder beschäftigen.", 2);
        katja.geraetHinzufuegen(spielplatz, schaukel);
        katja.geraetHinzufuegen(spielplatz,wippe);
        spielplatz.setStandort(standortBellaBFSpielplatz);
        spielplatz.setAnzahlKinder(0);
        spielplatz.setBezeichnung("BELLA barrierefreier Spielplatz");
        spielplatz.setStatus(Status.offen);

        spielplatzListe.add(spielplatz);

    }

    @Test
    void getAktuellenSpielplatzTest() throws BenutzerException {
        marvin.spielplatzAnmeldung(spielplatz.getID(), spielplatzListe);
        Spielplatz angemeldeterSpielplatz = marvin.getAktuellenSpielplatz(spielplatzListe);
        assertEquals(spielplatz, angemeldeterSpielplatz);
    }

    @Test
    void geraetMeldenTest() throws SpielplatzException, BenutzerException {
        marvin.spielplatzAnmeldung(spielplatz.getID(), spielplatzListe);
        marvin.geraetMelden("Schaukel", spielplatzListe);
        Geraet geaendertesGeraet = marvin.getAktuellenSpielplatz(spielplatzListe).getGeraet("Schaukel");
        System.out.println("Schaukelstatus: " + geaendertesGeraet.getGeraeteStatus());
        assertEquals(GeraeteStatus.zuPruefen,geaendertesGeraet.getGeraeteStatus());
    }

    @Test
    void spielplatzAnmeldungTest() throws BenutzerException, SpielplatzException {
        System.out.println("Spielplatzkinderanzahl vor Anmeldung: " + spielplatz.getAnzahlKinder());
        marvin.spielplatzAnmeldung(spielplatz.getID(), spielplatzListe);
        System.out.println("Spielplatzkinderanzahl nach Anmeldung: " + spielplatz.getAnzahlKinder());
        assertEquals(spielplatz,marvin.getAktuellenSpielplatz(spielplatzListe));
    }

    @Test
    void spielplatzAnmeldungTestMitAnzahlKinder() throws BenutzerException, SpielplatzException {
        System.out.println("Spielplatzkinderanzahl vor Anmeldung: " + spielplatz.getAnzahlKinder());
        marvin.spielplatzAnmeldung(spielplatz.getID(), spielplatzListe, 20);
        System.out.println("Spielplatzkinderanzahl nach Anmeldung: " + spielplatz.getAnzahlKinder());
        assertEquals(spielplatz,marvin.getAktuellenSpielplatz(spielplatzListe));
    }

    @Test
    void spielplatzAbmeldungTest() throws BenutzerException{
        marvin.spielplatzAnmeldung(spielplatz.getID(), spielplatzListe);
        System.out.println("Spielplatzkinderanzahl vor Abmeldung: " + spielplatz.getAnzahlKinder());
        marvin.spielplatzAbmeldung(spielplatzListe);
        System.out.println("Spielplatzkinderanzahl nach Abmeldung: " + spielplatz.getAnzahlKinder());
        assertEquals(null,marvin.getAktuellenSpielplatz(spielplatzListe));
    }

    @Test
    void freundHinzufuegenTest() throws BenutzerException {
        marvin.freundHinzufuegen(mark);
        assertEquals(true,marvin.getFreunde().contains(mark));
    }
    @Test
    void freundEntfernenTest() throws BenutzerException {
        marvin.freundHinzufuegen(mark);
        marvin.freundEntfernen(mark);
        assertEquals(false,marvin.getFreunde().contains(mark));
    }
    @Test
    void spielplatzFavoritHinzufuegenTest() throws BenutzerException {
        marvin.spielplatzFavoritHinzufuegen(spielplatz);
        assertEquals(true,marvin.getSpielplatzFavoriten().contains(spielplatz));
    }
    @Test
    void spielplatzFavoritEntfernenTest() throws BenutzerException {
        marvin.spielplatzFavoritHinzufuegen(spielplatz);
        marvin.spielplatzFavoritEntfernen(spielplatz);
        assertEquals(false,marvin.getSpielplatzFavoriten().contains(spielplatz));
    }

}