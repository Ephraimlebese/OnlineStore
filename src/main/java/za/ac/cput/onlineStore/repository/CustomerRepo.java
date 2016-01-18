package za.ac.cput.onlineStore.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.onlineStore.domain.Customer;

/**
 * Created by student on 2016/01/18.
 */
public interface CustomerRepo extends CrudRepository<Customer, Long> {
}
