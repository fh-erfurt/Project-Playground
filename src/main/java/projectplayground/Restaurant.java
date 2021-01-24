package projectplayground;

import projectplayground.interfaces.IRestaurant;
import projectplayground.interfaces.IToilette;
import projectplayground.interfaces.IWickeltisch;

import java.util.HashMap;
import java.util.Map;

public class Restaurant extends Erweiterung implements IToilette, IWickeltisch, IRestaurant
{
    public Restaurant(int anzahlPersonen, String bezeichnung,String telefonNummer)
    {
        this.setBezeichnung("Restaurant - " + bezeichnung);
        this.setPersonenAnzahl(anzahlPersonen);
        this.setHatWickeltisch(false);
        this.setEssenAbholbar(false);
        this.setEssenLieferbar(false);
        this.setTelefonNummer(telefonNummer);
        this.speisekarte = new HashMap<String, Double>();
    }

    public Restaurant(int anzahlPersonen, String bezeichnung,String telefonNummer, boolean hatWickeltisch
                      ,boolean essenAbholbar,boolean essenLieferbar)
    {
        this.setBezeichnung("Restaurant - " + bezeichnung);
        this.setPersonenAnzahl(anzahlPersonen);
        this.setHatWickeltisch(hatWickeltisch);
        this.setEssenAbholbar(essenAbholbar);
        this.setEssenLieferbar(essenLieferbar);
        this.setTelefonNummer(telefonNummer);
        this.speisekarte = new HashMap<String, Double>();
    }

    public HashMap<String, Double> speisekarte;
    public String telefonNummer;
    public boolean hatWickeltisch;
    public boolean essenAbholbar;
    public boolean essenLieferbar;


    public void fuegeSpeiseHinzu(String speisenName, Double preis)
    {
        this.speisekarte.put(speisenName, preis);
    }

    public void entferneSpeise(String speisenName )
    {
        this.speisekarte.remove(speisenName);
    }

    public void zeigeSpeisekarteAn()
    {
        for(Map.Entry<String, Double> speisenEintrag : this.speisekarte.entrySet()) {
            String speisenName = speisenEintrag.getKey();
            Double preis = speisenEintrag.getValue();

            System.out.println(speisenName + ": " + preis.toString());
        }
    }
    public boolean getHatWickeltisch() {
        return hatWickeltisch;
    }

    public void setHatWickeltisch(boolean hatWickeltisch) {
        this.hatWickeltisch = hatWickeltisch;
    }

    public boolean getEssenAbholbar() {
        return essenAbholbar;
    }

    public void setEssenAbholbar(boolean essenAbholbar) {
        this.essenAbholbar = essenAbholbar;
    }

    public boolean getEssenLieferbar() {
        return essenLieferbar;
    }

    public void setEssenLieferbar(boolean essenLieferbar) {
        this.essenLieferbar = essenLieferbar;
    }

    public String getTelefonNummer() {
        return telefonNummer;
    }

    public void setTelefonNummer(String telefonNummer) {
        this.telefonNummer = telefonNummer;
    }

    @Override
    public String wickelTisch()
    {
        if(hatWickeltisch == true)
            return "Hier gibt es einen Wickeltisch.";
        return "Hier gibt es keinen Wickeltisch";
    }

    @Override
    public String toilettenGang()
    {
        return "Hier kann man auf die Toilette gehen";
    }

    @Override
    public String haendeWaschen()
    {
        return "Hier kann man sich die Hände waschen.";
    }


    @Override
    public String essenGehen() {
        return "Hier können " + this.getPersonenAnzahl() + " Personen gleichzeitig essen.";
    }

    @Override
    public String essenBestellenUndAbholen()
    {
        if(essenAbholbar == true)
        {
            if(this.getTelefonNummer() != null)
                return "Hier kann man Essen bestellen und abholen, unter folgender Telefonnummer: " + this.getTelefonNummer();
            return "Hier kann man Essen bestellen und abholen.";
        }
        return "Hier kann nur vorort gegessen werden.";
    }

    @Override
    public String essenLiefern()
    {
        if(essenLieferbar == true)
        {
            if(this.getTelefonNummer() != null)
                return "Hier kann man Essen bestellen und es wird geliefert, unter folgender Telefonnummer: " + this.getTelefonNummer();
            return "Hier kann man Essen bestellen und es wird geliefert.";
        }
        return "Hier kann nur vorort gegessen werden.";
    }
}
