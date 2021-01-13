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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void passwortAendern(Profil profil, String altesPasswort, String neuesPasswort) {
        if (profil.passwort.equals(altesPasswort))
        {
            System.out.println("Passwort stimmt und kann geändert werden");
            profil.passwort = neuesPasswort;
        }
        else
        {
            System.out.println("Falsches Passwort, kann nicht geandert werden");
        }
    }

    public void removeProfil(Profil profil, String benutzername) {
        this.benutzername = null;
    }



    public void profilVerwalten(Profil profil, Profil neuerProfilEintrag)
    {
        try
        {
            if (neuerProfilEintrag.getBenutzername() != null && !neuerProfilEintrag.getBenutzername().isEmpty())
                profil.setBenutzername(neuerProfilEintrag.getBenutzername());

            if (neuerProfilEintrag.getEmail() != null && !neuerProfilEintrag.getEmail().isEmpty())
                profil.setEmail(neuerProfilEintrag.getEmail());

            if (neuerProfilEintrag.getPasswort() != null && !neuerProfilEintrag.getPasswort().isEmpty())
                profil.setPasswort(neuerProfilEintrag.getPasswort());
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public String login(String benutzername, String passwort, List<Benutzer> benutzerListe)
    {
        try
        {
            for (Benutzer benutzer : benutzerListe)
            {
                if (benutzer.getBenutzername() == benutzername)
                    if (benutzer.getPasswort() == passwort)
                        return "Erfolgreich angemeldet.";
            }
            return "Benutzername oder Passwort ist falsch.";
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            return "Fehler beim Login";
        }
    }
    // TODO: Email,Passwort vergessen

    public void passwortVergessen(List<Benutzer> benutzerListe)
    {
        try
        {
            for (Benutzer benutzer : benutzerListe)
            {
                if (benutzer.getBenutzername().equals(this.getBenutzername()))
                {
                    String neuesPasswort = Passwort.passwortGenerator();

                    benutzer.setPasswort(neuesPasswort);
                    Mail.versendeEmailPasswortVergessen(benutzer, neuesPasswort);
                    return;
                }
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

}