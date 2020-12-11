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
        Moderator neuerModerator=new Moderator(benutzer.benutzername,benutzer.email,benutzer.passwort,benutzer.eigeneKinder,benutzer.aufenthaltsort);
        return neuerModerator;
    }
    public Benutzer moderatorZuBenutzer(Moderator moderator){
        Benutzer neuerBenutzer=new Benutzer(moderator.benutzername,moderator.email,moderator.passwort,moderator.eigeneKinder);
        return neuerBenutzer;
    }
    public void passwortZuruecksetzen(Profil profil){
            profil.setPasswort(null);
    }
    public void SpielplatzLoeschen(List<Spielplatz> spielplatzListe,Spielplatz spielplatz){
        spielplatzListe.remove(spielplatz);
    }
    public void GeraeteLoeschen(List<Geraet> geraete, Geraet geraet){
        geraete.remove(geraet);
    }

    // TODO: Benutzer entfernen
    // TODO: E-mail sperren
    // TODO: Profil zurücksetzen (PW zurücksetzen)
}
