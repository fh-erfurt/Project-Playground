package projectplayground;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectplayground.domains.java1.Restaurant;
import projectplayground.domains.exceptions.RestaurantException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestaurantTest {
    Restaurant restaurant = new Restaurant(30, "Waldkasino","0361 3456677"
            ,false, true,true );

    @BeforeEach
    void setUp() {
        restaurant.fuegeSpeiseHinzu("Pommes", 2.22);
        restaurant.fuegeSpeiseHinzu("Burger", 5.0);
        restaurant.fuegeSpeiseHinzu("Schnitzel", 3.22);
        restaurant.fuegeSpeiseHinzu("Salat", 2.0);

    }

    @Test
    void hatWickeltischTest(){
        String restaurantWickeltisch = restaurant.wickelTisch();
        assertEquals("Hier gibt es keinen Wickeltisch", restaurantWickeltisch);
    }

    @Test
    void essenBestellenUndAbholenTest(){
        String essenBestellenUndAbholen = restaurant.essenBestellenUndAbholen();
        String erwartet = "Hier kann man Essen bestellen und abholen, unter folgender Telefonnummer: " + restaurant.getTelefonNummer();
        assertEquals(erwartet, essenBestellenUndAbholen);
    }

    @Test
    void essenLiefernTest(){
        String essenLieferbar = restaurant.essenLiefern();
        String erwartet = "Hier kann man Essen bestellen und es wird geliefert, unter folgender Telefonnummer: " + restaurant.getTelefonNummer();
        assertEquals(erwartet, essenLieferbar);
    }


    @Test
    void restaurantSpeisekarte() throws RestaurantException {
        restaurant.zeigeSpeisekarteAn();
    }

    @Test
    void entferneSpeiseTest() throws RestaurantException {
        restaurant.entferneSpeise("Schnitzel");
        assertEquals(false, restaurant.speisekarte.containsKey("Schnitzel"));
    }
}
