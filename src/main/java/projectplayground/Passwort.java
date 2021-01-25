package projectplayground;
import projectplayground.exceptions.PasswortException;

import java.security.SecureRandom;



public class Passwort {
    public static String passwortGenerator() throws PasswortException
    {
        try
        {
            final String erlaubteZeichen = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            int anzahlZeichen = 12;
            SecureRandom zufall = new SecureRandom();
            StringBuilder pass = new StringBuilder(anzahlZeichen);
            for (int i = 0; i < 12; i++)
            {
                pass.append(erlaubteZeichen.charAt(zufall.nextInt(erlaubteZeichen.length())));
            }

            if(pass.length() != anzahlZeichen)
                throw new PasswortException("Beim Passwort generieren ist etwas schief gelaufen (Länge passt nicht)");
            return pass.toString();

        }
        catch (PasswortException ex)
        {
            throw new PasswortException(ex.getMessage());
        }
    }
}
