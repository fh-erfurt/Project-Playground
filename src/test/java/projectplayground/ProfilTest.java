package projectplayground;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ProfilTest {
    Standort testStandort = new Standort();

    Benutzer marvin = new Benutzer("marvin", "marvin.ruppert@fh-erfurt.de", "qwertz", 1, testStandort);
    Benutzer mark = new Benutzer("mark", "mark@gmx.de", "12345", 2,testStandort);
    Benutzer fabian = new Benutzer("fabian", "seebär@gmx.de", "6789", 1,testStandort);
    Moderator katja = new Moderator("katja", "katja@gmx.de", "12345", 0 , testStandort);

    List<Benutzer> benutzerListe = new ArrayList<Benutzer>();




    @BeforeEach
    public void setUp()
    {
        benutzerListe.add(marvin);
        benutzerListe.add(mark);
        benutzerListe.add(fabian);
    }

    @Test
    void profilVerwalten() {
    }

    @Test
    void login() {
    }

    @Test
    void passwortVergessen() {
        marvin.passwortVergessen(benutzerListe);
    }
}