package projectplayground;

import projectplayground.enums.SauberkeitStatus;
import projectplayground.enums.Status;
import projectplayground.exceptions.SpielplatzException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * Bietet die Grundklasse zum Abbilden eines Spielplatzes
 * Dient vor Allem als Datengrundlage zum Zugriff durch die Nutzer des Programms
 */
public class Spielplatz {
    public Spielplatz() {
        this.geraete = new ArrayList<Geraet>();
        this.angemeldeteBenutzer = new ArrayList<Benutzer>();
        this.erweiterungen = new ArrayList<Erweiterung>();
        this.anzahlKinder = 0;
    }

    public Spielplatz(String bezeichnung, Status status, SauberkeitStatus sauberkeit, String information, int anzahlKinder) {
        this.bezeichnung = bezeichnung;
        this.status = status;
        this.sauberkeit = sauberkeit;
        this.information = information;
        this.anzahlKinder = anzahlKinder;
        this.geraete = new ArrayList<Geraet>();
        this.erweiterungen = new ArrayList<Erweiterung>();
        this.angemeldeteBenutzer = new ArrayList<Benutzer>();
    }

    public UUID ID;
    private String bezeichnung;
    private Status status;
    private SauberkeitStatus sauberkeit;
    private Standort standort;
    private String information;
    private int anzahlKinder;
    private int kapazitaetSpielplatz;
    public List<Geraet> geraete;
    public List<Erweiterung> erweiterungen;
    public List<Benutzer> angemeldeteBenutzer;


    public void setErweiterungen(List<Erweiterung> erweiterungen) {
        this.erweiterungen = erweiterungen;
    }

    public List<Erweiterung> getErweiterungen() {
        return erweiterungen;
    }

    public void setBezeichnung(String Bezeichnung) {
        this.bezeichnung = Bezeichnung;
    }

    public String getBezeichnung() {
        return this.bezeichnung;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status Status) {
        this.status = Status;
    }

    public void setAnzahlKinder(int AnzahlKinder) {
        this.anzahlKinder = AnzahlKinder;
    }

    public int getAnzahlKinder() {
        return this.anzahlKinder;
    }

    public Standort getStandort() {
        return standort;
    }

    public void setStandort(Standort standort) {
        this.standort = standort;
    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public SauberkeitStatus getSauberkeit() {
        return sauberkeit;
    }

    public void setSauberkeit(SauberkeitStatus sauberkeit) {
        this.sauberkeit = sauberkeit;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getKapazitaetSpielplatz() {
        return kapazitaetSpielplatz;
    }

    public void setKapazitaetSpielplatz(int kapazitaetSpielplatz) {
        this.kapazitaetSpielplatz = kapazitaetSpielplatz;
    }

    public Geraet getGeraet(String geraeteName) throws SpielplatzException
    {
        try
        {
            for (Geraet geraet : this.geraete) {
                if (geraet.getBezeichnung().equals(geraeteName))
                    return geraet;
            }
            throw new SpielplatzException("Gerät nicht gefunden");
        }
        catch (SpielplatzException ex)
        {
            throw new SpielplatzException(ex.getMessage());
        }
    }


    /** Prueft den Status des Spielplatzes
     * Bis 40% gilt der Spielplatz als 'Offen'
     * Bis 90% gilt der Spielplatz als 'Gut besucht'
     * Bis 100% gilt der Spielplatz als 'Voll'
     * Ab 100% gilt der Spielplatz als 'Ueberfuellt'
     * @throws SpielplatzException
     */
    public void pruefeStatus() throws SpielplatzException {
        try
        {
            double prozentsatzKinderanzahl = this.anzahlKinder / (double) this.kapazitaetSpielplatz * 100;
            if (prozentsatzKinderanzahl < 40) // bis 40%
            {
                this.setStatus(Status.offen);
            }
            else if (prozentsatzKinderanzahl < 90) // bis 90%
            {
                this.setStatus(Status.gutBesucht);
            }
            else if (prozentsatzKinderanzahl <= 100) // bis 100%
            {
                this.setStatus(Status.voll);
            }
            else // > 100%
            {
                this.setStatus(Status.ueberfuellt);
            }
            if (prozentsatzKinderanzahl < 0)
            {
                throw new SpielplatzException("Prozentsatz unter 0, Berechnung des Status ist fehlgeschlagen.");
            }
            System.out.println("Der Status des Spielplatz ist nun: " + this.getStatus());
        }
        catch (SpielplatzException ex)
        {
            throw new SpielplatzException(ex.getMessage());
        }
    }

    /** Gibt alle Erweiterungen eines einzelnen Spielplatzes aus
     * @throws SpielplatzException
     */
    public void zeigeErweiterungenAn() throws SpielplatzException
    {
        try
        {
            if(this.erweiterungen == null)
                throw new SpielplatzException("Keine Erweiterungen für den Spielplatz vorhanden.");
            for (Erweiterung erweiterung : this.erweiterungen)
            {
                if(erweiterung instanceof Restaurant)
                {
                    System.out.println("---------------------------------------");
                    System.out.println(((Restaurant) erweiterung).essenGehen());
                    System.out.println(((Restaurant) erweiterung).essenLiefern());
                    System.out.println(((Restaurant) erweiterung).essenBestellenUndAbholen());
                    System.out.println(((Restaurant) erweiterung).wickelTisch());
                    System.out.println(((Restaurant) erweiterung).toilettenGang());
                    System.out.println("---------------------------------------");
                }
                if(erweiterung instanceof Toilette)
                {
                    System.out.println("---------------------------------------");
                    System.out.println(((Toilette) erweiterung).toilettenGang());
                    System.out.println(((Toilette) erweiterung).haendeWaschen());
                    System.out.println(((Toilette) erweiterung).wickelTisch());
                    System.out.println("---------------------------------------");
                }
                if(erweiterung instanceof Sitzgelegenheit)
                {
                    System.out.println("---------------------------------------");
                    System.out.println(((Sitzgelegenheit) erweiterung).sitzen());
                    System.out.println("---------------------------------------");
                }
            }
        }
        catch(SpielplatzException ex)
        {
            throw new SpielplatzException(ex.getMessage());
        }
    }

    /** Aktualisiert die Spielplatzkapazitaet, indem alle Kapazitaeten der einzelnen Geraete eines Spielplatzes
     * iteriert und aufgerechnet werden.
     * @throws SpielplatzException
     */
    public void aktualisiereSpielplatzKapazitaet() throws SpielplatzException
    {
        try
        {
            int aktuelleKapazitaet = 0;
            for (int i = 0; i < this.geraete.size(); i++)
            {
                Geraet geraet = this.geraete.get(i);
                aktuelleKapazitaet += geraet.getKapazitaetGeraet();
            }
            if (aktuelleKapazitaet >= 0)
                this.setKapazitaetSpielplatz(aktuelleKapazitaet);
            else
            {
                throw new SpielplatzException("Spielplatzkapazität im negativen Bereich.");
            }
        }
        catch(SpielplatzException ex)
        {
        throw new SpielplatzException(ex.getMessage());
        }
    }

    /** Gibt den Standort des Spielplatzes aus
     * @throws SpielplatzException
     */
    public void zeigeStandortAn() throws SpielplatzException
    {
        try
        {
            if (this.getStandort() == null)
                throw new SpielplatzException("Standort ist leer und kann nicht angezeigt werden.");

            System.out.println("Stadtname: " + this.getStandort().getStadtname());
            System.out.println("Stadtteil: " + this.getStandort().getStadtteil());
            System.out.println("PLZ: " + this.getStandort().getPostleitzahl());
            System.out.println("Strassenname: " + this.getStandort().getStrassenname());
            System.out.println("Hausnummer: " + this.getStandort().getHausnummer());
        }
        catch(SpielplatzException ex)
        {
            throw new SpielplatzException(ex.getMessage());
        }
    }







}