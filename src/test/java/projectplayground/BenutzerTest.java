package projectplayground;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BenutzerTest  {

    List<Spielplatz> spielplatzListe = new ArrayList<>();

    Standort testStandort = new Standort();

    Benutzer marvin = new Benutzer("marvin", "test@gmx.de", "qwertz", 1, testStandort);
    Benutzer mark = new Benutzer("mark", "mark@gmx.de", "12345", 2,testStandort);
    Benutzer fabian = new Benutzer("fabian", "seebär@gmx.de", "6789", 1,testStandort);
    Moderator katja = new Moderator("katja", "katja@gmx.de", "12345", 0 , testStandort);
    Spielplatz spielplatz = new Spielplatz();



    @BeforeEach
    public void setUp () throws ModeratorException {
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
    void getAktuellenSpielplatz() {
        Spielplatz erwarteterSpielplatz = marvin.getAktuellenSpielplatz(spielplatzListe);
        if(erwarteterSpielplatz == null)
            System.out.println("Kein aktueller Spielplatz");
        System.out.println("Spielplatz gefunden: " + erwarteterSpielplatz.getBezeichnung());
    }

    @Test
    void geraetMelden() throws SpielplatzException {
        marvin.geraetMelden("Schaukel", spielplatzListe);
        Geraet geaendertesGeraet = marvin.getAktuellenSpielplatz(spielplatzListe).getGeraet("Schaukel");
        System.out.println("Schaukelstatus: " + geaendertesGeraet.getGeraeteStatus());
    }

    @Test
    void spielplatzAnmeldung() throws BenutzerException{
        System.out.println("Spielplatzkinderanzahl vor Anmeldung: " + spielplatz.getAnzahlKinder());
        marvin.spielplatzAnmeldung(spielplatz.getID(), spielplatzListe);
        System.out.println("Spielplatzkinderanzahl nach Anmeldung: " + spielplatz.getAnzahlKinder());
    }

    @Test
    void spielplatzAbmeldung() throws BenutzerException{
        System.out.println("Spielplatzkinderanzahl vor Abmeldung: " + spielplatz.getAnzahlKinder());
        marvin.spielplatzAbmeldung(spielplatzListe);
        System.out.println("Spielplatzkinderanzahl nach Abmeldung: " + spielplatz.getAnzahlKinder());
    }
}