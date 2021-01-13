package projectplayground;

import org.junit.jupiter.api.Test;

class PasswortTest {
    Passwort neuesPasswort = new Passwort();
    @Test
    void passwortGenerator() {
        System.out.println(neuesPasswort.passwortGenerator());
    }
}