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
    Moderator katja = new Moderator("katja", "marvinruppert2@gmx.de", "12345", 0 , testStandort);

    List<Profil> benutzerListe = new ArrayList<Profil>();




    @BeforeEach
    public void setUp()
    {
        benutzerListe.add(marvin);
        benutzerListe.add(mark);
        benutzerListe.add(fabian);
        benutzerListe.add(katja);
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
        System.out.println("Versende Email an Katja");
        katja.passwortVergessen(benutzerListe);
        System.out.println("Versenden erfolgreich");
    }
}