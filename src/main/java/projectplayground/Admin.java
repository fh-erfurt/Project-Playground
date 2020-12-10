package projectplayground;

public class Admin extends Profil {
    public Admin(String benutzername, String passwort, String email)
    {
        this.zugriff = Zugriff.administration;
        this.benutzername = benutzername;
        this.passwort = passwort;
        this.email = email;
    }
}
