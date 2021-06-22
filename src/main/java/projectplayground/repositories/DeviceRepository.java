package projectplayground.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projectplayground.domains.Device;

public interface DeviceRepository extends JpaRepository<Device,Long> {
}
