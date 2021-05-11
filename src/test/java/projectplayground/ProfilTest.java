package projectplayground;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectplayground.domains.Benutzer;
import projectplayground.domains.Moderator;
import projectplayground.domains.Profil;
import projectplayground.domains.Standort;
import projectplayground.domains.exceptions.ProfilException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProfilTest {
    Standort testStandort = new Standort();

    Benutzer marvin = new Benutzer("marvin", "marvin.ruppert@fh-erfurt.de", "qwertz", 1, testStandort);
    Benutzer mark = new Benutzer("mark", "marknottrott@gmail.com", "12345", 2,testStandort);
    Benutzer fabian = new Benutzer("fabian", "", "6789", 1,testStandort);
    Benutzer roman = new Benutzer("roman", "roman.rassloff@fh-erfurt.de", "6789", 1,testStandort);
    Benutzer dominic = new Benutzer("dominic", "dominic.meyer@fh-erfurt.de", "6789", 1,testStandort);
    Moderator katja = new Moderator("katja", "katja.fischer@fh-erfurt.de", "12345", 1 , testStandort);
    Benutzer marvinNeu = new Benutzer("marvin1","marvin.ruppert@fh-erfurt.de", "qwertz", 1);
    List<Profil> benutzerListe = new ArrayList<>();


    @BeforeEach
    public void setUp()
    {
        benutzerListe.add(marvin);
        benutzerListe.add(mark);
        benutzerListe.add(fabian);
        benutzerListe.add(katja);
        benutzerListe.add(roman);
        benutzerListe.add(dominic);
    }

    @Test
    void profilVerwalten() throws ProfilException{
        marvin.login("marvin","qwertz",benutzerListe);
        marvin.profilVerwalten(marvin,marvinNeu);

        assertEquals(marvinNeu.getBenutzername(), marvin.getBenutzername());
    }

    @Test
    void loginTest() throws ProfilException {
        String ergebnis = marvin.login(marvin.getBenutzername(),marvin.getPasswort(),benutzerListe);
        System.out.println(ergebnis);
        assertEquals("Erfolgreich angemeldet.", ergebnis);
    }
    @Test
    void logoutTest() throws ProfilException{
        marvin.login("marvin","qwertz",benutzerListe);
        marvin.logout(benutzerListe);

        assertEquals(false, marvin.getIstEingeloggt());
    }
    @Test
    void passwortVergessenTest() throws ProfilException {
        marvin.passwortVergessen(benutzerListe);
        // wenn Sie zum Testen ein neues Passwort zugesendet haben wollen, folgende Zeile einkommentieren:
    }
    @Test
    void passwortAendernTest() throws ProfilException{
    marvin.passwortAendern(marvin,marvin.getPasswort(),"12345");
        assertEquals("12345",marvin.getPasswort());
    }
    @Test
    void entferneEigenesProfilTest() throws ProfilException{
        marvin.entferneEigenesProfil(mark,benutzerListe);
        assertEquals(false, benutzerListe.contains(mark));
    }

}