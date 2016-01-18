package za.ac.cput.onlineStore.repositoryTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.onlineStore.OnlineStoreApplication;
import za.ac.cput.onlineStore.domain.Customer;
import za.ac.cput.onlineStore.repository.CompanyRepo;
import za.ac.cput.onlineStore.repository.CustomerRepo;

/**
 * Created by student on 2016/01/18.
 */
@SpringApplicationConfiguration(classes = {OnlineStoreApplication.class})
@WebAppConfiguration

public class CustomerCrudTest extends AbstractTestNGSpringContextTests {


    private Long id;

    @Autowired
    CustomerRepo repository;

    @Test
    public void create() throws Exception {

        Customer customer = new Customer.Builder("Victor").email("123@gmail.com").Salary("180000,0000").build();
        this.repository.save(customer);
        this.id = customer.getID();
        Assert.assertNotNull(customer.getID());
    }

    @Test(dependsOnMethods = {"create"})
    public void read() throws Exception {

        Customer customer  = (Customer)this.repository.findOne(this.id);
        Assert.assertNotNull(customer);
        Assert.assertEquals("123@gmail.com", customer.getEmail());

    }

    @Test(dependsOnMethods = {"read"})
    public void update() throws Exception {

        Customer customer  = (Customer)this.repository.findOne(this.id);
        Customer customer1 = new Customer.Builder("Victor").email("1234@gmail.com").Salary("180000,0000").build();

        this.repository.save(customer1);
        Customer customer2  = (Customer)this.repository.findOne(this.id);
        Assert.assertEquals("1234@gmail.com", customer1.getEmail());
    }

    @Test(dependsOnMethods = {"update"})
    public void delete() throws Exception {
        Customer customer  = (Customer)this.repository.findOne(this.id);
        this.repository.delete(customer);
        Customer deleteCustomer = (Customer)this.repository.findOne(this.id);
        Assert.assertNull(deleteCustomer);
    }



}
