package za.ac.cput.onlineStore.service;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.onlineStore.OnlineStoreApplication;
import za.ac.cput.onlineStore.config.CustomerFactory;
import za.ac.cput.onlineStore.domain.Customer;
import za.ac.cput.onlineStore.services.CarService;
import za.ac.cput.onlineStore.services.CustomerService;

/**
 * Created by student on 2016/01/18.
 */

@SpringApplicationConfiguration(classes = OnlineStoreApplication.class)
@WebAppConfiguration
public class CustomerServiceTest  extends AbstractTestNGSpringContextTests {

    @Autowired
    CustomerService service;

    private Long id;

    @Test
    public void create() throws Exception {

        Customer car =  CustomerFactory.addCustomer("Sibusiso", "mnisi@gmail.com", "12000");
        service.save(car);
        id = car.getID();
        Assert.assertNotNull(id);
    }


    @Test(dependsOnMethods = "create")
    public void read()throws Exception
    {
        Customer car= service.findById(id);
        Assert.assertEquals("mnisi@gmail.com",car.getEmail());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Customer car = service.findById(id);
        Customer newCar = new Customer.Builder("250").email("1000").copy(car).build();

        service.update(newCar );
        Customer car1  = service.findById(id);
        org.junit.Assert.assertEquals("mnisi@gmail.com", car1.getEmail());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Customer car = service.findById(id);
        service.delete(car);
        Customer deletedUser = service.findById(id);
        org.junit.Assert.assertNull(deletedUser);
    }


}
