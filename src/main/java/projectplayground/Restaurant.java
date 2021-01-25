package projectplayground;

import projectplayground.exceptions.RestaurantException;
import projectplayground.interfaces.IRestaurant;
import projectplayground.interfaces.IToilette;
import projectplayground.interfaces.IWickeltisch;

import java.util.HashMap;
import java.util.Map;

/**
 * Restaurant ist eine Erweiterung eines Spielplatzes
 * Ist eine Kindklasse von Erweiterung
 * Implementiert die Interfaces IToilette, IWickeltisch und IRestaurant
 */
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
    private String telefonNummer;
    private boolean hatWickeltisch;
    private boolean essenAbholbar;
    private boolean essenLieferbar;


    /**
     * @param speisenName Bezeichnung der Speise, die der Speisekarte hinzugefuegt werden soll
     * @param preis Preis der Speise, die hinzugefuegt werden soll
     */
    public void fuegeSpeiseHinzu(String speisenName, Double preis)
    {
        this.speisekarte.put(speisenName, preis);
    }

    /**
     * @param speisenName Bezeichnung der Speise, die aus der Speisekarte geloescht wird
     */
    public void entferneSpeise(String speisenName)
    {
        this.speisekarte.remove(speisenName);
    }


    public void zeigeSpeisekarteAn() throws RestaurantException
    {
        try
        {
            if (this.speisekarte == null)
                throw new RestaurantException("Speisekarte ist leer und kann nicht angezeigt werden.");

            for (Map.Entry<String, Double> speisenEintrag : this.speisekarte.entrySet()) {
                String speisenName = speisenEintrag.getKey();
                Double preis = speisenEintrag.getValue();
                System.out.println(speisenName + ": " + preis.toString() + "€");
            }
        }
        catch(RestaurantException ex)
        {
            throw new RestaurantException(ex.getMessage());
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
        if(hatWickeltisch)
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
        if(essenAbholbar)
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
        if(essenLieferbar)
        {
            if(this.getTelefonNummer() != null)
                return "Hier kann man Essen bestellen und es wird geliefert, unter folgender Telefonnummer: " + this.getTelefonNummer();
            return "Hier kann man Essen bestellen und es wird geliefert.";
        }
        return "Hier kann nur vorort gegessen werden.";
    }
}
