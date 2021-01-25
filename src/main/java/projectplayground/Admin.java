package projectplayground;

import projectplayground.enums.Zugriff;
import projectplayground.exceptions.AdminException;
import projectplayground.exceptions.ProfilException;

import java.util.List;

/**
 * Der Admin ist ein Nutzer, welche besondere Rechte beinhaltet um das spaetere Programm zu verwalten.
 * Er verwaltet Nutzer und hat außerdem die Moeglichkeit Spielplaetze und Geraete zu loeschen
 */
public class Admin extends Profil {
    public Admin(String benutzername, String passwort, String email)
    {
        this.zugriff = Zugriff.administrator;
        this.benutzername = benutzername;
        this.passwort = passwort;
        this.email = email;
    }

    /**
     * @param benutzer Benutzer, der zum Moderator 'aufgewertet' werden soll
     * @return Moderatorobjekt, das aus den Daten des Benutzers erzeugt wird
     * Im spaeteren Verlauf: Benutzer aus DB loeschen + Moderator anlegen oder Zugriffsrechte des DB Eintrags aendern
     * @throws AdminException
     */
    public Moderator benutzerZuModerator(Benutzer benutzer) throws AdminException {
        try
        {
            Moderator neuerModerator = new Moderator(benutzer.benutzername, benutzer.email, benutzer.passwort, benutzer.eigeneKinder, benutzer.aufenthaltsort);
            benutzer = null;
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


    /**
     * @param moderator Moderator, der zum Benutzer 'herabgestuft' werden soll
     * @return Benutzerobjekt, das aus den Daten des Moderators erzeugt wird
     * Im spaeteren Verlauf: Moderator aus DB loeschen + Benutzer anlegen oder Zugriffsrechte des DB Eintrags aendern
     * @throws AdminException
     */
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

    /**
     * @param spielplatzListe Gesamtheit aller vorhandenen Spielplaetze (spaeter in der DB)
     * @param spielplatz Der Spielplatz, der entfernt werden soll
     * @throws AdminException
     */
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

    /**
     * @param geraete Gesamtheit aller vorhandenen Geraete
     * @param geraet Geraet, das entfernt werden soll
     * @throws AdminException
     */
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

    /**
     * @param profile Gesamtheit aller vorhandenen Profile
     * @param profil Profil, das entfernt werden soll
     * @throws AdminException
     */
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

    /**
     * @param profil Profil, dessen Passwort zurueckgesetzt werden soll
     * @param profilListe Gesamtheit aller Profile
     * @throws ProfilException
     */
    public void passwortZuruecksetzen(Profil profil, List<Profil> profilListe) throws ProfilException {
        profil.passwortVergessen(profilListe);
    }
}
