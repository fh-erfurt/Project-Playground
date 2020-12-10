package projectplayground;

import java.util.ArrayList;
import java.util.List;

public abstract class Profil {
    protected String benutzername;
    protected String passwort;
    protected String email;
    protected Zugriff zugriff;


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