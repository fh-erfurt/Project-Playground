package projectplayground;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectplayground.enums.Zugriff;
import projectplayground.exceptions.AdminException;
import projectplayground.exceptions.ProfilException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AdminTest{
    List<Spielplatz> spielplatzListe = new ArrayList<>();
    List<Geraet> geraeteListe = new ArrayList<>();
    Geraet geraet = new Geraet();
    Spielplatz spielplatz = new Spielplatz();
    List<Profil> profilListe = new ArrayList<>();

    Benutzer mark = new Benutzer("mark", "mark@gmx.de", "12345", 2);
    Admin marvin = new Admin("marvin","qwertz","marvin@fh-erfurt.de");
    Benutzer fabian = new Moderator("fabian","fabian@fh-erfurt.de","1234",2);

    @BeforeEach
    void setUp() {
        profilListe.add(mark);
    }

    @Test
    void benutzerZuModeratorTest() throws AdminException{
        mark = marvin.benutzerZuModerator(mark);
        assertEquals(true,mark instanceof Moderator);
    }

    @Test
    void moderatorZuBenutzerTest() throws AdminException{
        fabian=marvin.moderatorZuBenutzer((Moderator)fabian);
        assertEquals(true,fabian instanceof Benutzer);
    }

    @Test
    void spielplatzLoeschenTest() throws AdminException{
        marvin.spielplatzLoeschen(spielplatzListe,spielplatz);
        assertEquals(false,spielplatzListe.contains(spielplatz));
    }

    @Test
    void geraetLoeschenTest() throws AdminException{
        marvin.geraetLoeschen(geraeteListe,geraet);
        assertEquals(false,geraeteListe.contains(geraet));
    }

    @Test
    void removeProfilTest()throws AdminException {
        marvin.removeProfil(profilListe,mark);
        assertEquals(false,profilListe.contains(mark));
    }
}