package projectplayground;

/**
 * Sitzgelegenheit ist eine Erweiterung eines Spielplatzes
 * Ist eine Kindklasse von Erweiterung
 */
public class Sitzgelegenheit extends Erweiterung{

    public Sitzgelegenheit(String bezeichnung, int personenAnzahl)
    {
        this.setBezeichnung(bezeichnung);
        this.setPersonenAnzahl(personenAnzahl);
    }

    public String sitzen()
    {
        return "Hier haben " + this.getPersonenAnzahl() + " Personen eine Sitzmöglichkeit.";
    }
}
