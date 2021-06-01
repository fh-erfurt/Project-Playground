package projectplayground.domains;

import java.security.SecureRandom;


/**
 * class which gives the possibility to generate a random password for the user
 * every profile has one password
 */
public class Password {
    /** will be called when the password of a user ist resetted
     *  generates a random password
     * @return output the generated password
     * @throws Exception
     */
    public static String passwortGenerator() throws Exception
    {
        try
        {
            final String allowedCharacters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            int numberOfCharacters = 12;
            SecureRandom zufall = new SecureRandom();
            StringBuilder pass = new StringBuilder(numberOfCharacters);
            for (int i = 0; i < 12; i++)
            {
                pass.append(allowedCharacters.charAt(zufall.nextInt(allowedCharacters.length())));
            }

            if(pass.length() != numberOfCharacters)
                throw new Exception("an error has occurred by generating the password (not enough characters)");
            return pass.toString();

        }
        catch (Exception ex)
        {
            throw new Exception(ex.getMessage());
        }
    }
}
