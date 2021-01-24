package projectplayground;

import projectplayground.interfaces.IToilette;
import projectplayground.interfaces.IWickeltisch;

public class Toilette extends Erweiterung implements IToilette, IWickeltisch {

    public boolean hatWickeltisch;

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

    public boolean getHatWickeltisch() {
        return hatWickeltisch;
    }

    public void setHatWickeltisch(boolean hatWickeltisch) {
        this.hatWickeltisch = hatWickeltisch;
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
