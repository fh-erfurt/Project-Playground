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
        if(zugriff.equals(Zugriff.administrator)){
            this.passwort = passwort;
        }else{
            System.out.println("Keinen Zugriff");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void passwortAendern(Profil profil,String altesPasswort){
        if(profil.passwort.equals(altesPasswort)){
            profil.passwort=altesPasswort;
        }else{
            System.out.println("Falsches Passwort");
        }

    }

    // TODO: Profil verwalten
    // TODO: Anmelden
    // TODO: Email,Passwort vergessen

}