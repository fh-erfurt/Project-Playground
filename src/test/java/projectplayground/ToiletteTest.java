package projectplayground;

import org.junit.jupiter.api.Test;
import projectplayground.domains.java1.Toilette;

import static org.junit.jupiter.api.Assertions.*;

class ToiletteTest {

    Toilette toilette = new Toilette(2, true);

    @Test
    void toilettenGangTest() {
        String zuPruefen = toilette.toilettenGang();
        String erwartung = "Hier können 2 Personen auf die Toilette gehen.";
        assertEquals(erwartung, zuPruefen);
    }

    @Test
    void wickelTischTest() {
        String zuPruefen = toilette.wickelTisch();
        String erwartung = "Hier gibt es einen Wickeltisch";
        assertEquals(erwartung, zuPruefen);
    }
}