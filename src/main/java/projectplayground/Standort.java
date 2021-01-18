package projectplayground;


public class Standort {

    public Standort()
    {
        
    }

    public Standort(int hausnummer, String strassenname, int postleitzahl, String stadtname, String name, String stadtteil)
    {
        this.name = name;
        this.hausnummer = hausnummer;
        this.strassenname = strassenname;
        this.postleitzahl = postleitzahl;
        this.stadtname = stadtname;
        this.stadtteil = stadtteil;
    }

    private String name;
    private String strassenname;
    private int hausnummer;
    private int postleitzahl;
    private String stadtname;
    private String stadtteil;

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

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getStadtteil() { return stadtteil; }

    public void setStadtteil(String stadtteil) { this.stadtteil = stadtteil; }
}