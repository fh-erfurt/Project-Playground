package projectplayground;

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
