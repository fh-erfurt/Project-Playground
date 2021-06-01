package projectplayground;

import org.junit.jupiter.api.Test;
import projectplayground.domains.java1.Passwort;
import projectplayground.domains.exceptions.PasswortException;

class PasswortTest {


    @Test
    void passwortGenerator() throws PasswortException {
        System.out.println(Passwort.passwortGenerator());
    }
}