package za.ac.cput.onlineStore.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.onlineStore.domain.Car;

/**
 * Created by student on 2016/01/18.
 */
public interface CarRepo extends CrudRepository<Car, Long> {
}
