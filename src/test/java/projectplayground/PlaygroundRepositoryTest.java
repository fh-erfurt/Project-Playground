package projectplayground;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import projectplayground.domains.Location;
import projectplayground.domains.Playground;
import projectplayground.domains.enums.Cleanliness;
import projectplayground.domains.enums.Status;
import projectplayground.repositories.LocationRepository;
import projectplayground.repositories.playground.PlaygroundRepository;
import projectplayground.repositories.user.UserRepository;

import javax.persistence.EntityManager;
import javax.sql.DataSource;


@SpringBootTest
class PlaygroundRepositoryTest {
    @Autowired private DataSource dataSource;
    @Autowired private JdbcTemplate jdbcTemplate;
    @Autowired private EntityManager entityManager;
    @Autowired private UserRepository userRepository;
    @Autowired private PlaygroundRepository playgroundRepository;
    @Autowired private LocationRepository locationRepository;

    @BeforeEach
    public void beforeEach() {

    }
    @AfterEach
    public void afterEach() {
    }


    @Test
    void injectedComponentsAreNotNull(){
        Assertions.assertThat(dataSource).isNotNull();
        Assertions.assertThat(jdbcTemplate).isNotNull();
        Assertions.assertThat(entityManager).isNotNull();
        Assertions.assertThat(userRepository).isNotNull();
    }

    @Test
    void statusValueVoll() {

        Location location = new Location();
            location.setStreetname("Hütergasse");
            location.setHouseNumber(4);
            location.setPostCode(99084);
            location.setCityname("Erfurt");
            location.setDistrict("Andreasviertel");

        Playground playground = new Playground(
                "Kikaninchen",
                Cleanliness.clean,
                location,
                "Neuer Spielplatz",
                50,
                50,
                null,
                null,
                null,
                null);

        Assertions.assertThat(playground.statusValue()).isEqualTo("Voll");
    }

    @Test
    void statusValueUeberfuellt() {

        Location location = new Location();
        location.setStreetname("Hütergasse");
        location.setHouseNumber(4);
        location.setPostCode(99084);
        location.setCityname("Erfurt");
        location.setDistrict("Andreasviertel");

        Playground playground = new Playground(
                "Kikaninchen",
                Cleanliness.clean,
                location,
                "Neuer Spielplatz",
                110,
                100,
                null,
                null,
                null,
                null);

        Assertions.assertThat(playground.statusValue()).isEqualTo("Überfüllt");
    }

    @Test
    void statusValueOffen() {

        Location location = new Location();
        location.setStreetname("Hütergasse");
        location.setHouseNumber(4);
        location.setPostCode(99084);
        location.setCityname("Erfurt");
        location.setDistrict("Andreasviertel");

        Playground playground = new Playground(
                "Kikaninchen",
                Cleanliness.clean,
                location,
                "Neuer Spielplatz",
                0,
                100,
                null,
                null,
                null,
                null);

        Assertions.assertThat(playground.statusValue()).isEqualTo("Offen");
    }

    @Test
    void statusValueGutBesucht() {

        Location location = new Location();
        location.setStreetname("Hütergasse");
        location.setHouseNumber(4);
        location.setPostCode(99084);
        location.setCityname("Erfurt");
        location.setDistrict("Andreasviertel");

        Playground playground = new Playground(
                "Kikaninchen",
                Cleanliness.clean,
                location,
                "Neuer Spielplatz",
                80,
                100,
                null,
                null,
                null,
                null);

        Assertions.assertThat(playground.statusValue()).isEqualTo("Gut besucht");
    }

}

