package za.ac.cput.onlineStore.services;

import za.ac.cput.onlineStore.domain.Car;
import za.ac.cput.onlineStore.domain.Customer;

import java.util.List;

/**
 * Created by student on 2016/01/18.
 */
public interface CustomerService extends ServiceTester<Customer,Long>{

    public List<Customer> getCustomer();
}
