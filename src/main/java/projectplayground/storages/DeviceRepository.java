package projectplayground.storages;

import org.springframework.data.jpa.repository.JpaRepository;
import projectplayground.domains.Device;
import projectplayground.domains.User;

public interface DeviceRepository extends JpaRepository<Device,Long> {
}
