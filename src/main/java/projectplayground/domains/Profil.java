package projectplayground.domains;

import projectplayground.domains.enums.Zugriff;
import projectplayground.domains.exceptions.ProfilException;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.List;

/**
 * Ist die Grundklasse fuer alle Benutzer, Moderatoren und Admins
 */
@Entity
@Getter
@Setter
public abstract class Profil extends BaseEntity {
    @Column
    protected String benutzername;
    @Column
    protected String passwort;
    @Column
    protected String email;
    @Column
    protected Zugriff zugriff;
    @Column
    protected boolean istEingeloggt;


    public void setIstEingeloggt(boolean istEingeloggt)
    {
        this.istEingeloggt = istEingeloggt;
    }

    public boolean getIstEingeloggt()
    {
        return this.istEingeloggt;
    }

    /**
     * @param profil Profil, dessen Passwort geaendert werden soll
     * @param altesPasswort Altes Passwort des Users
     * @param neuesPasswort Neues Passwort, welches der User kuenftig zum Anmelden nutzen will
     * @throws ProfilException
     */
    public void passwortAendern(Profil profil, String altesPasswort, String neuesPasswort) throws ProfilException
    {
        try
        {
            if(!profil.passwort.equals(altesPasswort))
                throw new ProfilException("Falsches Passwort, kann nicht geaendert werden");

            profil.passwort = neuesPasswort;
        }
        catch(ProfilException ex)
        {
            throw new ProfilException(ex.getMessage());
        }
    }

    /**
     * @param profil Profil, welches entfernt werden soll
     * @param alleProfile Liste von allen Profilen(spaeter Datenbank)
     * @throws ProfilException
     */
    public void entferneEigenesProfil(Profil profil, List<Profil> alleProfile) throws ProfilException
    {
        try
        {
            if(profil == null)
                throw new ProfilException("Profil ist leer und kann nicht gelöscht werden.");
            if(!alleProfile.contains(profil))
                throw new ProfilException("Profil nicht in DB vorhanden, kann nicht gelöscht werden.");

            alleProfile.remove(profil);
        }
        catch(ProfilException ex)
        {
            throw new ProfilException(ex.getMessage());
        }
    }


    /**
     * @param profil Profil, welches geaendert werden soll
     * @param neuerProfilEintrag Neues Profil mit geanderten Eintraegen
     * @throws ProfilException
     */
    public void profilVerwalten(Profil profil, Profil neuerProfilEintrag) throws ProfilException
    {
        try
        {
            if(!profil.getIstEingeloggt())
                throw new ProfilException("Benutzer ist nicht eingeloggt. Änderungen verworfen.");
            if(profil == null)
                throw new ProfilException("Profil ist leer, Änderungen nicht durchgeführt.");
            if(neuerProfilEintrag == null)
                throw new ProfilException("Neue Daten sind leer. Keine Änderungen durchgeführt.");


            if (neuerProfilEintrag.getBenutzername() != null && !neuerProfilEintrag.getBenutzername().isEmpty())
                profil.setBenutzername(neuerProfilEintrag.getBenutzername());

            if (neuerProfilEintrag.getEmail() != null && !neuerProfilEintrag.getEmail().isEmpty())
                profil.setEmail(neuerProfilEintrag.getEmail());

            if (neuerProfilEintrag.getPasswort() != null && !neuerProfilEintrag.getPasswort().isEmpty())
                    profil.setPasswort(neuerProfilEintrag.getPasswort());

        }
        catch(ProfilException ex)
        {
            throw new ProfilException(ex.getMessage());
        }
    }

    /**
     * @param benutzername Benutzername des Profils, welcher sich einloggen moechte
     * @param passwort Passwort des Profils, welcher sich einloggen moechte
     * @param benutzerListe Liste von allen Profilen(spaeter Datenbank)
     * @return
     * @throws ProfilException
     */
    public String login(String benutzername, String passwort, List<Profil> benutzerListe) throws ProfilException
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
            throw new ProfilException("Benutzername oder Passwort ist falsch.");
        }
        catch(ProfilException ex)
        {
            throw new ProfilException(ex.getMessage());
        }
    }

    /**
     * @param benutzerListe Liste von allen Benutzern(spaeter Datenbank)
     * @return Wenn der Benutzer erfolgreich abgemeldet ist, kommt die Ausgabe "Erfolgreich abgemeldet"
     * @throws ProfilException
     */
    public String logout(List<Profil> benutzerListe) throws ProfilException
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
            throw new ProfilException("Benutzer nicht gefunden. Fehler beim Ausloggen.");
        }
        catch(ProfilException ex)
        {
            throw new ProfilException(ex.getMessage());
        }
    }


    /**
     * @param profilListe Liste von allen Profilen (spaeter Datenbank)
     * @throws ProfilException
     */
    public void passwortVergessen(List<Profil> profilListe) throws ProfilException
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
            throw new ProfilException("Passwort konnte nicht zurückgesetzt werden.");
        }
        catch(Exception ex)
        {
            throw new ProfilException(ex.getMessage());
        }
    }

}