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
    public void spielplatzLoeschen(List<Spielplatz> spielplatzListe,Spielplatz spielplatz){
        spielplatzListe.remove(spielplatz);
    }
    public void geraeteLoeschen(List<Geraet> geraete, Geraet geraet){
        geraete.remove(geraet);
    }
    //TODO: Benutzer entfernen will mal hoffen das passt so irgendwie
    public void removeProfil(List<Benutzer> benutzers, Benutzer benutzer) {this.benutzername=null;}

    // TODO: E-mail sperren
    public void emailSperren(Profil profil) {setEmail(null);}
    // TODO: Profil zurücksetzen (PW zurücksetzen)
    public void zuruekSetzen(Profil profil) {profil.setEmail(null);profil.setPasswort(null);profil.setBenutzername(null);}
}
