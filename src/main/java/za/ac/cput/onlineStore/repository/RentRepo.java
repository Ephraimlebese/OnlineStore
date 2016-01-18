package za.ac.cput.onlineStore.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.onlineStore.domain.Rental;

/**
 * Created by student on 2016/01/18.
 */
public interface RentRepo extends CrudRepository<Rental, Long> {
}
