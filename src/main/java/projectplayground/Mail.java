package projectplayground;


import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * Klasse, welche eine statische Funktion bietet um die E-Mail zum Passwortzurücksetzen zu versenden
 * Logindaten sind hardcoded, im weiteren Verlauf evtl. verschluesselt in eine Konfigdatei auslagern
 */
public class Mail {
    public static void versendeEmailPasswortVergessen(Profil profil, String neuesPasswort)
    {
        final String benutzername = "projectplayground2021@gmail.com";
        final String passwort = "Versandmail2021";

        Properties einstellungen = new Properties();
        einstellungen.put("mail.smtp.starttls.enable", "true");
        einstellungen.put("mail.smtp.auth", "true");
        einstellungen.put("mail.smtp.host", "smtp.gmail.com");
        einstellungen.put("mail.smtp.port", "25");

        Session session = Session.getInstance(einstellungen,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(benutzername, passwort);
                    }
                });

        try
        {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(benutzername));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(profil.getEmail()));
            message.setSubject("Ihr neues Passwort für die ProjectPlaygroundApp");
            message.setText("Sehr geehrte/r " + profil.getBenutzername() + ","
                    + "\n\nsie haben ihr Passwort vergessen und eine Passwortzurücksetzung angefordert."
                    + "\n\nDazu haben wir Ihnen ein neues Passwort generiert und Ihr Passwort auf dieses festgelegt."
                    + "\n\nBitte ändern Sie Ihr Passwort nach dem Login für die optimale Sicherheit."
                    + "\n\nAnbei Ihr neues, sicheres Passwort: "
                    + "\n\n" + neuesPasswort
                    + "\n\n"
                    + "\n\n" + "Mit freundlichen Grüßen"
                    + "\n\n" + "Team ProjectPlayground");

            Transport.send(message);

            System.out.println("Passwortvergessen Email versendet.");

        }
        catch (MessagingException ex)
        {
            throw new RuntimeException(ex);
        }
    }
}
