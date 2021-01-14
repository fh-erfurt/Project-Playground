package projectplayground;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Profil {
    protected String benutzername;
    protected String passwort;
    protected String email;
    protected Zugriff zugriff;
    protected boolean istEingeloggt;


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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setIstEingeloggt(boolean istEingeloggt)
    {
        this.istEingeloggt = istEingeloggt;
    }

    public boolean getIstEingeloggt()
    {
        return this.istEingeloggt;
    }

    public void passwortAendern(Profil profil, String altesPasswort, String neuesPasswort) {
        try {
            if (profil.passwort.equals(altesPasswort)) {
                System.out.println("Passwort kann geändert werden");
                profil.passwort = neuesPasswort;
            } else {
                System.out.println("Falsches Passwort, kann nicht geandert werden");
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void removeProfil(Profil profil, String benutzername) {
        this.benutzername = null;
    }



    public void profilVerwalten(Profil profil, Profil neuerProfilEintrag)
    {
        try
        {
            if(profil.getIstEingeloggt() == true) {
                if (neuerProfilEintrag.getBenutzername() != null && !neuerProfilEintrag.getBenutzername().isEmpty())
                    profil.setBenutzername(neuerProfilEintrag.getBenutzername());

                if (neuerProfilEintrag.getEmail() != null && !neuerProfilEintrag.getEmail().isEmpty())
                    profil.setEmail(neuerProfilEintrag.getEmail());

                if (neuerProfilEintrag.getPasswort() != null && !neuerProfilEintrag.getPasswort().isEmpty())
                    profil.setPasswort(neuerProfilEintrag.getPasswort());
            }else{
                System.out.println("Nicht eingeloggt");
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public String login(String benutzername, String passwort, List<Profil> benutzerListe)
    {
        try
        {
            for (Profil profil : benutzerListe)
            {
                if (profil.getBenutzername() == benutzername)
                    if (profil.getPasswort() == passwort)
                    {
                        profil.setIstEingeloggt(true);
                        return "Erfolgreich angemeldet.";
                    }
            }
            return "Benutzername oder Passwort ist falsch.";
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            return "Fehler beim Login";
        }
    }

    public String logout(List<Profil> benutzerListe)
    {
        try
        {
            for(Profil profil : benutzerListe)
            {
                if (profil.getBenutzername() == this.getBenutzername())
                {
                    profil.setIstEingeloggt(false);
                    return "Erfolgreich abgemeldet.";
                }
            }
            return "Benutzer nicht gefunden. Fehler beim Ausloggen.";
        }
        catch(Exception ex)
        {
            return "Fehler beim Ausloggen.";
        }
    }
    

    public void passwortVergessen(List<Profil> profilListe)
    {
        try
        {
            for (Profil profil : profilListe)
            {
                if (profil.getBenutzername().equals(this.getBenutzername()))
                {
                    String neuesPasswort = Passwort.passwortGenerator();

                    profil.setPasswort(neuesPasswort);
                    Mail.versendeEmailPasswortVergessen(profil, neuesPasswort);
                    return;
                }
                //Keine Antwort an nicht vorhandenen Benutzernamen aus Sicherheitsaspekten
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

}