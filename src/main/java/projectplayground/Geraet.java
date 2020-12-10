package projectplayground;
import java.util.UUID;

public class Geraet {
    private UUID spielplatzID;
    private String bezeichnung;
    private GeraeteStatus geraeteStatus;
    private String beschreibung;

    public Geraet(UUID spielplatzID, String bezeichnung, GeraeteStatus status, String beschreibung)
    {
        this.spielplatzID = spielplatzID;
        this.bezeichnung = bezeichnung;
        this.geraeteStatus = status;
        this.beschreibung = beschreibung;
    }

    public GeraeteStatus getGeraeteStatus() {
        return geraeteStatus;
    }

    public void setGeraeteStatus(GeraeteStatus geraeteStatus) {
        this.geraeteStatus = geraeteStatus;
    }

    public UUID getSpielplatzID() {
        return spielplatzID;
    }

    public void setSpielplatzID(UUID spielplatzID) {
        this.spielplatzID = spielplatzID;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

}