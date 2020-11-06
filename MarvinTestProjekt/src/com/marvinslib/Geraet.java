package com.marvinslib;
import java.util.UUID;

public class Geraet {
    private UUID SpielplatzID;
    private String Bezeichnung;
    private GeraeteStatus GeraeteStatus;

    public GeraeteStatus GetGeraeteStatus() {
        return GeraeteStatus;
    }

    public void SetGeraeteStatus(GeraeteStatus geraeteStatus) {
        GeraeteStatus = geraeteStatus;
    }

    public UUID GetSpielplatzID() {
        return SpielplatzID;
    }

    public void SetSpielplatzID(UUID spielplatzID) {
        SpielplatzID = spielplatzID;
    }

    public String GetBezeichnung() {
        return Bezeichnung;
    }

    public void SetBezeichnung(String bezeichnung) {
        Bezeichnung = bezeichnung;
    }
}
