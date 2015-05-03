package repository;

import domain.Equipment;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/05/03.
 */
public interface EquipmentRepository extends CrudRepository<Equipment, Long> {
}
