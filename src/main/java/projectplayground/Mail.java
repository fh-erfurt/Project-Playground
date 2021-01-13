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


public class Mail {
    public static void versendeEmailPasswortVergessen(Benutzer benutzer, String neuesPasswort)
    {
        final String username = "projectplayground2021@gmail.com";
        final String password = "Versandmail2021";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try
        {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(benutzer.getEmail()));
            message.setSubject("Ihr neues Passwort für die ProjectPlaygroundApp");
            message.setText("Sehr geehrte/r " + benutzer.getBenutzername() + ","
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
        catch (MessagingException e)
        {
            throw new RuntimeException(e);
        }
    }
}
