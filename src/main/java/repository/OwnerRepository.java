package repository;

import org.springframework.data.repository.CrudRepository;

import java.security.acl.Owner;

/**
 * Created by student on 2015/05/03.
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
