package projectplayground;

import org.junit.jupiter.api.Test;
import projectplayground.domains.java1.Benutzer;
import projectplayground.domains.java1.Mail;
import projectplayground.domains.java1.Spielplatz;
import projectplayground.domains.java1.Standort;

import java.util.ArrayList;
import java.util.List;

class MailTest {
    List<Spielplatz> spielplatzListe = new ArrayList<>();

    Standort testStandort = new Standort();

    Benutzer marvin = new Benutzer("marvin", "marvin.ruppert@fh-erfurt.de", "qwertz", 100, testStandort);
    Spielplatz spielplatz = new Spielplatz();

    @Test
    void versendeEmailTest() {
        Mail.versendeEmailPasswortVergessen(marvin, "123");
        // wenn Sie sich ein neues Passwort zum Testen zuschicken lassen wollen, folgende Zeile einkommentieren:
        // Mail.versendeEmailPasswortVergessen(jonasHecht, "dasNeuePasswort");

    }
}