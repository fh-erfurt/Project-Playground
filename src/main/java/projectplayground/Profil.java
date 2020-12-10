package projectplayground;

import java.util.ArrayList;
import java.util.List;

public class Profil {
    private String benutzername;
    private String passwort;
    private String email;
    private Zugriff zugriff;


    public String getBenutzername() {
        return benutzername;
    }

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}