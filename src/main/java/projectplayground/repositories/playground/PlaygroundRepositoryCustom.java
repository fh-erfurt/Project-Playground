package projectplayground.repositories.playground;

import projectplayground.domains.Playground;

import java.util.List;

public interface PlaygroundRepositoryCustom {

    List<Playground> findAllPlaygrounds(String playgroundName, String streetName);
}
