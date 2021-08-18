package projectplayground;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import projectplayground.domains.Location;
import projectplayground.domains.Playground;
import projectplayground.domains.enums.Cleanliness;
import projectplayground.repositories.playground.PlaygroundRepository;



@DataJpaTest
class PlaygroundRepositoryTest {
    @Autowired
    private PlaygroundRepository playgroundRepository;

    @BeforeEach
    public void beforeEach() {

    }
    @AfterEach
    public void afterEach() {
        playgroundRepository.deleteAll();
    }

    @Test
    void save() {

        Location kikaninchen = LocationTestEntityBuilder.of().build();

        Playground given = new Playground(
                "Kikaninchen",
                Cleanliness.clean,
                kikaninchen,
                "Neuer Spielplatz",
                0,
                50,
                null,
                null,
                null,
                null);

         Playground playground = playgroundRepository.save(given);
         Assertions.assertThat(playground.getId()).isNotNull();

        Playground secondGiven = new Playground(
                "Zweiter",
                Cleanliness.clean,
                kikaninchen,
                "Zweiter Neuer Spielplatz",
                0,
                50,
                null,
                null,
                null,
                null);

        Playground secondPlayground = playgroundRepository.save(secondGiven);
        Assertions.assertThat(secondPlayground.getId()).isGreaterThan(1);
    }

}

