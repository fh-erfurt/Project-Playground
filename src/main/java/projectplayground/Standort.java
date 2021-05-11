package projectplayground;


import lombok.*;

/**
 * Jedes Profil und jeder Spielplatz hat einen Standort
 * Der Standort beinhaltet alle geografischen Informationen die noetig sind,
 * um eine Adresse zu identifizieren
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Standort {
    private String strassenname;
    private int hausnummer;
    private int postleitzahl;
    private String stadtname;
    private String stadtteil;
}