package za.ac.cput.onlineStore.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.onlineStore.domain.Employee;

/**
 * Created by student on 2016/01/18.
 */
public interface EmployeeRepo extends CrudRepository<Employee, Long> {
}
