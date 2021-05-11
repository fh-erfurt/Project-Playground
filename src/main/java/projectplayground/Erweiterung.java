package projectplayground;

import lombok.*;

/**
 * Ist die Grundklasse fuer alle logistischen Erweiterungen, die ein Spielplatz zusaetzlich bieten kann
 */
@Setter
@Getter
public abstract class Erweiterung
{
    protected String bezeichnung;
    protected int personenAnzahl;
}
