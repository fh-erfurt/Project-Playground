package projectplayground;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BenutzerTest {

    List<Spielplatz> spielplatzListe = new ArrayList<Spielplatz>();
    Benutzer marvin = new Benutzer("marvin", "test@gmx.de", "qwertz", 1);
    Benutzer mark = new Benutzer("mark", "mark@gmx.de", "12345", 2);
    Benutzer fabian = new Benutzer("fabian", "seebär@gmx.de", "6789", 1);



    @BeforeEach
    public void setUp()
    {
        Spielplatz spielplatz = new Spielplatz();
        spielplatz.setID(UUID.randomUUID());

        Standort standortBellaBFSpielplatz = new Standort();

        standortBellaBFSpielplatz.setStrassenname("Tettaustraße");
        standortBellaBFSpielplatz.setHausnummer(4);
        standortBellaBFSpielplatz.setPostleitzahl(99094);
        standortBellaBFSpielplatz.setStadtname("Erfurt");

        Geraet schaukel = new Geraet(spielplatz.getID(), "Schaukel", GeraeteStatus.inTaktesGeraet, "Bei der Schaukel handelt es sich um eine Doppelschaukel.");
        Geraet wippe = new Geraet(spielplatz.getID(), "Wippe", GeraeteStatus.verschmutztesGeraet, "Hier können sich 2 Kinder beschäftigen.");

        spielplatz.geraete.add(schaukel);
        spielplatz.geraete.add(wippe);
        spielplatz.setStandort(standortBellaBFSpielplatz);
        spielplatz.setAnzahlKinder(10);
        spielplatz.setBezeichnung("BELLA barrierefreier Spielplatz");
        spielplatz.setStatus(Status.voll);

        spielplatzListe.add(spielplatz);
        marvin.setAktuellerSpielplatz(spielplatz.getID());
    }

    @Test
    void getAktuellenSpielplatz() {
        Spielplatz erwarteterSpielplatz = marvin.getAktuellenSpielplatz(spielplatzListe);
        if(erwarteterSpielplatz == null)
            System.out.println("Kein aktueller Spielplatz");
        System.out.println("Spielplatz gefunden: " + erwarteterSpielplatz.getBezeichnung());
    }

    @Test
    void geraetMelden() {
//        System.out.println("Benutzer meldet Gerät 'Schaukel' auf seinem aktuellen Spielplatz.");
        marvin.geraetMelden("Schaukel", spielplatzListe);
        Geraet geaendertesGeraet = marvin.getAktuellenSpielplatz(spielplatzListe).getGeraet("Schaukel");
        System.out.println("Schaukelstatus: " + geaendertesGeraet.getGeraeteStatus());
    }
}