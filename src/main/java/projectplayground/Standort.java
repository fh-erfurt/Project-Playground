package projectplayground;


public class Standort {

    //TODO Konstruktor ausbauen
    public Standort()
    {

    }
    private String strassenname;
    private int hausnummer;
    private int postleitzahl;
    private String stadtname;


    public String getStrassenname() {
        return strassenname;
    }

    public void setStrassenname(String strassenname) {
        this.strassenname = strassenname;
    }

    public int getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(int hausnummer) {
        this.hausnummer = hausnummer;
    }

    public int getPostleitzahl() {
        return postleitzahl;
    }

    public void setPostleitzahl(int postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

    public String getStadtname() {
        return stadtname;
    }

    public void setStadtname(String stadtname) {
        this.stadtname = stadtname;
    }
}