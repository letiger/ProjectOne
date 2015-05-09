package za.ac.cput.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.domain.HardwareType;

/**
 * Created by student on 2015/05/03.
 */
public interface HardwareTypeRepository extends CrudRepository<HardwareType, Long> {
}
