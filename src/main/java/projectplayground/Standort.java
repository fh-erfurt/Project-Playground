package projectplayground;


public class Standort {

    public Standort()
    {

    }
    private String Strassenname;
    private int Hausnummer;
    private int Postleitzahl;
    private String Stadtname;


    public String getStrassenname() {
        return Strassenname;
    }

    public void setStrassenname(String strassenname) {
        Strassenname = strassenname;
    }

    public int getHausnummer() {
        return Hausnummer;
    }

    public void setHausnummer(int hausnummer) {
        Hausnummer = hausnummer;
    }

    public int getPostleitzahl() {
        return Postleitzahl;
    }

    public void setPostleitzahl(int postleitzahl) {
        Postleitzahl = postleitzahl;
    }


    public String getStadtname() {
        return Stadtname;
    }

    public void setStadtname(String stadtname) {
        Stadtname = stadtname;
    }
}