package projectplayground;

import org.junit.jupiter.api.Test;
import projectplayground.exceptions.PasswortException;

class PasswortTest {


    @Test
    void passwortGenerator() throws PasswortException {
        System.out.println(Passwort.passwortGenerator());
    }
}