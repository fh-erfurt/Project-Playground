package projectplayground;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        if (zugriff.equals(Zugriff.administrator)) {
            this.passwort = passwort;
        } else {
            System.out.println("Keinen Zugriff");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void PasswortAendern(Profil profil, String altesPasswort) {
        if (profil.passwort.equals(altesPasswort)) {
            profil.passwort = altesPasswort;
            System.out.println("Passwort stimmt und kann geändert werden");
            System.out.println("Bitte neues Passwort eingeben ...");
            Scanner scan = new Scanner(System.in);
            String newPw = scan.nextLine();
            this.passwort = newPw;
        } else {
            System.out.println("Falsches Passwort, kann nicht geandert werden");
        }
    }

    //TODO: remove Profil -> Admin
    public void removeProfil(Profil profil, String benutzername) {
        this.benutzername = null;
    }


    // TODO: Profil verwalten -> Passwort ändern per Benutzereingabe hinzugefügt
    // TODO: Anmelden
    // TODO: Email,Passwort vergessen

}