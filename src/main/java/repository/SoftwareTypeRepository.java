package repository;

import domain.SoftwareType;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/05/03.
 */
public interface SoftwareTypeRepository extends CrudRepository<SoftwareType, Long> {
}
