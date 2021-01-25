package projectplayground;

import projectplayground.enums.Zugriff;
import projectplayground.exceptions.AdminException;
import projectplayground.exceptions.ProfilException;

import java.util.List;

public class Admin extends Profil {
    public Admin(String benutzername, String passwort, String email)
    {
        this.zugriff = Zugriff.administrator;
        this.benutzername = benutzername;
        this.passwort = passwort;
        this.email = email;
    }
    public Moderator benutzerZuModerator(Benutzer benutzer) throws AdminException {
        try
        {
            Moderator neuerModerator = new Moderator(benutzer.benutzername, benutzer.email, benutzer.passwort, benutzer.eigeneKinder, benutzer.aufenthaltsort);
            benutzer = null; // im weiteren Verlauf DB Eintrag löschen
            if (neuerModerator == null) {
                throw new AdminException("Beim Anlegen des neuen Moderators ist etwas schief gelaufen.");
            }
            return neuerModerator;
        }
        catch(AdminException ex)
        {
            throw new AdminException(ex.getMessage());
        }

    }

    public Benutzer moderatorZuBenutzer(Moderator moderator) throws AdminException {
        try
        {
            if (moderator == null)
                throw new AdminException("Beim Anlegen des neuen Benutzers ist etwas schief gelaufen.");

            Benutzer neuerBenutzer = new Benutzer(moderator.benutzername, moderator.email, moderator.passwort, moderator.eigeneKinder);
            moderator = null; // im weiteren Verlauf DB Eintrag löschen, bisher erledigt GarbageCollector den Rest

            return neuerBenutzer;
        }
        catch(AdminException ex)
        {
            throw new AdminException(ex.getMessage());
        }
    }

    public void spielplatzLoeschen(List<Spielplatz> spielplatzListe,Spielplatz spielplatz) throws AdminException{
        try
        {
            if(spielplatzListe == null || spielplatz == null)
                throw new AdminException("Spielplatz konnte nicht entfernt werden");

            spielplatzListe.remove(spielplatz);
            spielplatz = null; //im weiteren Verlauf DB Eintrag löschen, bisher erledigt GarbageCollector den Rest
        }
        catch(AdminException ex)
        {
            throw new AdminException(ex.getMessage());
        }
    }

    public void geraetLoeschen(List<Geraet> geraete, Geraet geraet) throws AdminException
    {
        try
        {
            if (geraete == null || geraet == null)
                throw new AdminException("Gerät konnte nicht entfernt werden.");

            geraete.remove(geraet);
            geraet = null; //im weiteren Verlauf DB Eintrag löschen, bisher erledigt GarbageCollector den Rest
        }
        catch(AdminException ex)
        {
            throw new AdminException(ex.getMessage());
        }
    }

    public void removeProfil(List<Profil> profile, Profil profil) throws AdminException
    {
        try
        {
            if(profile == null || profil == null)
                throw new AdminException("Profil konnte nicht entfernt werden.");

            profile.remove(profil);
            profil = null; //im weiteren Verlauf DB Eintrag löschen, bisher erledigt GarbageCollector den Rest
        }
        catch(AdminException ex)
        {
            throw new AdminException(ex.getMessage());
        }
    }

    // TODO: E-mail sperren (2. Semester, da DB-Verbindung notwendig ist)
    public void emailSperren(Profil profil)
    {
        // E-Mail soll nicht verwendet werden können um sich am System zu registrieren / anzumelden

    }

    public void passwortZuruecksetzen(Profil profil, List<Profil> profilListe) throws ProfilException {
        profil.passwortVergessen(profilListe);
    }
}
