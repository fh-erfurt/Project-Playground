package projectplayground;
import java.util.UUID;

public class Geraet {
    private UUID SpielplatzID;
    private String Bezeichnung;
    private GeraeteStatus GeraeteStatus;
    private String Beschreibung;

    public GeraeteStatus getGeraeteStatus() {
        return GeraeteStatus;
    }

    public void setGeraeteStatus(GeraeteStatus geraeteStatus) {
        GeraeteStatus = geraeteStatus;
    }

    public UUID getSpielplatzID() {
        return SpielplatzID;
    }

    public void setSpielplatzID(UUID spielplatzID) {
        SpielplatzID = spielplatzID;
    }

    public String getBezeichnung() {
        return Bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        Bezeichnung = bezeichnung;
    }

    public String getBeschreibung() {
        return Beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        Beschreibung = beschreibung;
    }
}