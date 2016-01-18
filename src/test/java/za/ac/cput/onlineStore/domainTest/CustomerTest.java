package za.ac.cput.onlineStore.domainTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.onlineStore.config.CarFactory;
import za.ac.cput.onlineStore.config.CustomerFactory;
import za.ac.cput.onlineStore.domain.Customer;

/**
 * Created by student on 2015/10/15.
 */
public class CustomerTest {

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void createCustomer() throws Exception {

        Customer customer = CustomerFactory.addCustomer("Mvuleni", "mnisi@gmail.com","1500");

        Assert.assertEquals("Mvuleni", customer.getName());
    }

    @Test
    public void updateCustomer() throws Exception {

        Customer customer = CustomerFactory.addCustomer("Lebese", "mnisi@gmail.com","1500");

        Assert.assertEquals("Lebese", customer.getName());
    }


    @After
    public void tearDown() throws Exception {


    }
}
