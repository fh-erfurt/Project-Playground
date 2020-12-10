package projectplayground;

public class Admin extends Profil {
    public Admin(String benutzername, String passwort, String email)
    {
        this.zugriff = Zugriff.administration;
        this.benutzername = benutzername;
        this.passwort = passwort;
        this.email = email;
    }
    // TODO: Benutzer zum Moderator machen -- Moderator zu Benutzer 'herabstufen'
    // TODO: Benutzer entfernen
    // TODO: E-mail sperren
    // TODO: Spielplatz löschen, Geräte löschen
    // TODO: Profil zurücksetzen (PW zurücksetzen)
}
