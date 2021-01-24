package projectplayground;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErweiterungTest {
    Spielplatz spielplatz = new Spielplatz();


    @BeforeEach
    void setUp() {
        Restaurant restaurant = new Restaurant(30, "Waldkasino","0361 3456677"
                                                ,false, true,true );
        Restaurant waldhaus = new Restaurant(50, "Waldhaus","0361 3459320");
        Toilette toilette = new Toilette(10, true);
        spielplatz.erweiterungen.add(toilette);
        spielplatz.erweiterungen.add(restaurant);
        spielplatz.erweiterungen.add(waldhaus);

    }

    @Test
    void spielplatzErweiterungToilette() throws SpielplatzException{
        for (Erweiterung erweiterung : spielplatz.erweiterungen)
        {
            if(erweiterung instanceof Toilette)
            {
                System.out.println(((Toilette) erweiterung).toilettenGang());
                System.out.println(((Toilette) erweiterung).haendeWaschen());
                System.out.println(((Toilette) erweiterung).wickelTisch());
            }
        }
    }

    @Test
    void spielplatzErweiterungRestaurant() throws SpielplatzException{
        for (Erweiterung erweiterung : spielplatz.erweiterungen)
        {
            if(erweiterung instanceof Restaurant)
            {
                System.out.println("---------------------------------------");
                System.out.println(((Restaurant) erweiterung).essenGehen());
                System.out.println(((Restaurant) erweiterung).essenLiefern());
                System.out.println(((Restaurant) erweiterung).essenBestellenUndAbholen());
                System.out.println(((Restaurant) erweiterung).wickelTisch());
                System.out.println(((Restaurant) erweiterung).toilettenGang());
                System.out.println("---------------------------------------");

            }
        }
    }
}