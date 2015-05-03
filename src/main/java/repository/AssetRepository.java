package repository;
import domain.Asset;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/05/03.
 */
public interface AssetRepository extends CrudRepository<Asset, Long> {
}
