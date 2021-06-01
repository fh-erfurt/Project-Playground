package projectplayground.domains.java1;

import lombok.*;
import projectplayground.domains.interfaces.IToilette;
import projectplayground.domains.interfaces.IWickeltisch;
import projectplayground.domains.java1.Erweiterung;

/**
 * Toilette ist eine Erweiterung von Spielplatz
 * Ist eine Kindklasse von Erweiterung
 * Implementiert die Interfaces IToilette und IWickeltisch
 */
@Getter
@Setter
public class Toilette extends Erweiterung implements IToilette, IWickeltisch {

    private boolean hatWickeltisch;

    public Toilette(int anzahlPersonen)
    {
        this.setHatWickeltisch(false);
        this.setBezeichnung("Toilette");
        this.setPersonenAnzahl(anzahlPersonen);
    }
    public Toilette(int anzahlPersonen, boolean hatWickeltisch)
    {
        this.setHatWickeltisch(hatWickeltisch);
        this.setBezeichnung("Toilette");
        this.setPersonenAnzahl(anzahlPersonen);
    }


    @Override
    public String toilettenGang()
    {
        return "Hier können " + getPersonenAnzahl() + " Personen auf die Toilette gehen." ;
    }

    @Override
    public String haendeWaschen()
    {
        return "Hier kann man sich die Hände waschen";
    }

    @Override
    public String wickelTisch()
    {
        if(hatWickeltisch)
            return "Hier gibt es einen Wickeltisch";
        return "Hier gibt es keinen Wickeltisch";
    }
}
