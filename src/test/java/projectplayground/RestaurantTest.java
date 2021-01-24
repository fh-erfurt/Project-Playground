package projectplayground;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RestaurantTest {
    Restaurant restaurant = new Restaurant(30, "Waldkasino","0361 3456677"
            ,false, true,true );

    @BeforeEach
    void setUp() {

        restaurant.fuegeSpeiseHinzu("Pommes", 1.22);
        restaurant.fuegeSpeiseHinzu("Burger", 5.0);
        restaurant.fuegeSpeiseHinzu("Senfschnuller", 3.22);
        restaurant.fuegeSpeiseHinzu("Schnibrö", 5.0);


    }

    @Test
    void restaurantSpeisekarte(){
        restaurant.zeigeSpeisekarteAn();
        System.out.println("---------------------------------------");
        restaurant.entferneSpeise("Schnibrö");
        System.out.println("Entferne Schnibrö");
        System.out.println("---------------------------------------");
        restaurant.zeigeSpeisekarteAn();

    }
}
