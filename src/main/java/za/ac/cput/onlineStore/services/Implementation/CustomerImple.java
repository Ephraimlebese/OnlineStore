package za.ac.cput.onlineStore.services.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.onlineStore.domain.Car;
import za.ac.cput.onlineStore.domain.Customer;
import za.ac.cput.onlineStore.repository.BuyRepo;
import za.ac.cput.onlineStore.repository.CustomerRepo;
import za.ac.cput.onlineStore.services.BuyService;
import za.ac.cput.onlineStore.services.CustomerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/01/18.
 */
@Service
public class CustomerImple  implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;



    private Long id;

    @Override
    public Customer findById(Long id) {
        return customerRepo.findOne(id);
    }

    @Override
    public Customer save(Customer entity) {return customerRepo.save(entity);}

    @Override
    public Customer update(Customer entity) {
        return customerRepo.save(entity);
    }

    @Override
    public void delete(Customer entity) {customerRepo.delete(entity);}

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public List<Customer> getCustomer()
    {
        List<Customer> allCars = new ArrayList<Customer>();

        Iterable<Customer> cars = customerRepo.findAll();

        for (Customer car : cars)
        {
            allCars.add(car);
        }

        return allCars;
    }

}
