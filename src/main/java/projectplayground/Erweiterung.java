package projectplayground;

/**
 * Ist die Grundklasse fuer alle logistischen Erweiterungen, die ein Spielplatz zusaetzlich bieten kann
 */
public abstract class Erweiterung
{
    protected String bezeichnung;
    protected int personenAnzahl;


    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public int getPersonenAnzahl() {
        return personenAnzahl;
    }

    public void setPersonenAnzahl(int personenAnzahl) {
        this.personenAnzahl = personenAnzahl;
    }
}
