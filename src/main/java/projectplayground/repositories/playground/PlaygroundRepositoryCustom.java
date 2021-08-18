package projectplayground.repositories.playground;

import projectplayground.domains.Device;
import projectplayground.domains.Expansion;
import projectplayground.domains.Playground;

import java.util.List;

public interface PlaygroundRepositoryCustom {

    List<Playground> findAllPlaygrounds(String playgroundName, String streetName);
    List<Device> findAllDevicesByPlaygroundID(long id);
    List<Expansion> findAllExpansionsByPlaygroundID(long id);
    void addPlaygroundCounter(Playground playground, int children);
    void deductPlaygroundCounter(Playground playground, int children);
}
