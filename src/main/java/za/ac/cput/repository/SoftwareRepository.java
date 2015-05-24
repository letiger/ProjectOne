package za.ac.cput.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.domain.Software;

/**
 * Created by student on 2015/05/03.
 */
public interface SoftwareRepository extends CrudRepository<Software, Long> {
}
