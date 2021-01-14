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
    Benutzer mark = new Benutzer("mark", "marknottrott@gmail.com", "12345", 2,testStandort);
    Benutzer fabian = new Benutzer("fabian", "", "6789", 1,testStandort);
    Benutzer roman = new Benutzer("roman", "roman.rassloff@fh-erfurt.de", "6789", 1,testStandort);
    Benutzer jonas = new Benutzer("Jonas alte Rakete", "jonas.waldhelm@fh-erfurt.de", "6789", 1,testStandort);

    Moderator katja = new Moderator("katja", "katja.fischer@fh-erfurt.de", "12345", 0 , testStandort);

    List<Profil> benutzerListe = new ArrayList<Profil>();




    @BeforeEach
    public void setUp()
    {
        benutzerListe.add(marvin);
        benutzerListe.add(mark);
        benutzerListe.add(fabian);
        benutzerListe.add(katja);
        benutzerListe.add(roman);
        benutzerListe.add(jonas);
    }

    @Test
    void profilVerwalten() {
    }

    @Test
    void login() {
        String ergebnis = marvin.login(marvin.getBenutzername(),marvin.getPasswort(),benutzerListe);
        System.out.println(ergebnis);
    }

    @Test
    void passwortVergessen() {
        //marvin.passwortVergessen(benutzerListe);
        //katja.passwortVergessen(benutzerListe);
        //mark.passwortVergessen(benutzerListe);
        //fabian.passwortVergessen(benutzerListe);
        roman.passwortVergessen(benutzerListe);
        jonas.passwortVergessen(benutzerListe);

        System.out.println(jonas.getPasswort());
    }
}