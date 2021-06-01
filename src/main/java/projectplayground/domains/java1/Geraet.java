package projectplayground.domains.java1;
import lombok.*;
import projectplayground.domains.enums.GeraeteStatus;

import java.util.UUID;

/**
 * Klasse um das Geraet eines Spielplatzes abzubilden
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Geraet {
    private UUID spielplatzID;
    private String bezeichnung;
    private GeraeteStatus geraeteStatus;
    private String beschreibung;
    private int kapazitaetGeraet;
}