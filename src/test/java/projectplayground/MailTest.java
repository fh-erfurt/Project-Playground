package projectplayground;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MailTest {
    List<Spielplatz> spielplatzListe = new ArrayList<>();

    Standort testStandort = new Standort();

    Benutzer marvin = new Benutzer("marvin", "marvin.ruppert@fh-erfurt.de", "qwertz", 100, testStandort);
    Benutzer jonasHecht = new Benutzer("JonasHackt", "jonas.hecht@fh-erfurt.de","123456", 2 );
    Spielplatz spielplatz = new Spielplatz();


    @Test
    void versendeEmailTest() {
        Mail.versendeEmailPasswortVergessen(marvin, "123");
        // wenn Sie sich ein neues Passwort zum Testen zuschicken lassen wollen, folgende Zeile einkommentieren:
        // Mail.versendeEmailPasswortVergessen(jonasHecht, "dasNeuePasswort");

    }
}