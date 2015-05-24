package za.ac.cput.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.domain.Owner;


/**
 * Created by student on 2015/05/03.
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
