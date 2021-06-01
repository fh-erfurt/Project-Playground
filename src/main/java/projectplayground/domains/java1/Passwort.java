package projectplayground.domains.java1;
import projectplayground.domains.exceptions.PasswortException;

import java.security.SecureRandom;


/**
 * Klasse, die eine statische Methode bietet, ein Passwort zufaellig zu generieren
 * Jedes Profil besitzt ein Passwort
 */
public class Passwort {
    /** Die Methode wird immer aufgerufen, wenn das Passwort eines Profils zurueckgesetzt wird
     *  die Methode generiert ein zufaelliges Passwort
     * @return Ausgabe des generierten Passworts
     * @throws PasswortException
     */
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
