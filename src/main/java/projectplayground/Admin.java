package projectplayground;

import java.util.List;

public class Admin extends Profil {
    public Admin(String benutzername, String passwort, String email)
    {
        this.zugriff = Zugriff.administrator;
        this.benutzername = benutzername;
        this.passwort = passwort;
        this.email = email;
    }
    public Moderator benutzerZuModerator(Benutzer benutzer){
        Moderator neuerModerator = new Moderator(benutzer.benutzername,benutzer.email,benutzer.passwort,benutzer.eigeneKinder,benutzer.aufenthaltsort);
        return neuerModerator;
    }

    public Benutzer moderatorZuBenutzer(Moderator moderator){
        Benutzer neuerBenutzer = new Benutzer(moderator.benutzername,moderator.email,moderator.passwort,moderator.eigeneKinder);

        return neuerBenutzer;
    }

    public void spielplatzLoeschen(List<Spielplatz> spielplatzListe,Spielplatz spielplatz){
        spielplatzListe.remove(spielplatz);
    }

    public void geraeteLoeschen(List<Geraet> geraete, Geraet geraet){
        geraete.remove(geraet);
    }

    public void removeProfil(List<Benutzer> benutzers, Benutzer benutzer)
    {
        benutzers.remove(benutzer);
    }

    // TODO: E-mail sperren (2. Semester, da DB-Verbindung notwendig ist)
    public void emailSperren(Profil profil)
    {
        // E-Mail soll nicht verwendet werden können um sich am System zu registrieren / anzumelden

    }

    public void passwortZuruecksetzen(Profil profil, List<Profil> profilListe)
    {
        profil.passwortVergessen(profilListe);
    }
}
