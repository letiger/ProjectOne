package repository;

import domain.Hardware;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/05/03.
 */
public interface HardwareRepository extends CrudRepository<Hardware, Long> {
}
