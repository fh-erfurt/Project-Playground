package projectplayground;
import java.security.SecureRandom;



public class Passwort {
    public static String passwortGenerator()
    {
        try
        {
            final String allowedChars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            SecureRandom random = new SecureRandom();
            StringBuilder pass = new StringBuilder(12);
            for (int i = 0; i < 12; i++)
            {
                pass.append(allowedChars.charAt(random.nextInt(allowedChars.length())));
            }
            return pass.toString();

        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return "Fehler beim Passwort generieren.";
        }
    }
}
