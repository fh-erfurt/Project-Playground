package projectplayground;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectplayground.enums.GeraeteStatus;
import projectplayground.enums.Status;
import projectplayground.exceptions.BenutzerException;
import projectplayground.exceptions.ModeratorException;
import projectplayground.exceptions.SpielplatzException;

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

        marvin.freundHinzufuegen(mark);
    }

    @Test
    void getAktuellenSpielplatzTest() {
        Spielplatz erwarteterSpielplatz = marvin.getAktuellenSpielplatz(spielplatzListe);
        if(erwarteterSpielplatz == null)
            System.out.println("Kein aktueller Spielplatz");
        System.out.println("Spielplatz gefunden: " + erwarteterSpielplatz.getBezeichnung());
    }

    @Test
    void geraetMeldenTest() throws SpielplatzException, BenutzerException {
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
    void spielplatzAbmeldungTest() throws BenutzerException{
        marvin.spielplatzAnmeldung(spielplatz.getID(), spielplatzListe);
        System.out.println("Spielplatzkinderanzahl vor Abmeldung: " + spielplatz.getAnzahlKinder());
        marvin.spielplatzAbmeldung(spielplatzListe);
        System.out.println("Spielplatzkinderanzahl nach Abmeldung: " + spielplatz.getAnzahlKinder());
        assertEquals(null,marvin.getAktuellenSpielplatz(spielplatzListe));
    }

    void freundHinzufuegenTest() throws BenutzerException {
        marvin.freundHinzufuegen(mark);
        assertEquals(true,marvin.getFreunde().contains(mark));
    }
    @Test
    void freundEntfernenTest() throws BenutzerException {
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
        marvin.spielplatzFavoritEntfernen(spielplatz);
        assertEquals(false,marvin.getSpielplatzFavoriten().contains(spielplatz));
    }
    //ToDO bestehende Testfunktionen auch überprüfen
    //Todo Testdaten überprüfen
    //ToDo Exception Benutzer

}