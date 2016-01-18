package za.ac.cput.onlineStore.domainTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.onlineStore.config.EmployeeFactory;
import za.ac.cput.onlineStore.domain.Employee;

/**
 * Created by student on 2015/10/15.
 */
public class EmployeeTest {


    @Before
    public void setUp() throws Exception {


    }


    @Test
    public void createEmployee() throws Exception {

        Employee customer = EmployeeFactory.addEmployee("Sibusiso", "mnisi@gmail.com", "1500");

        Assert.assertEquals("Sibusiso", customer.getName());
    }

    @Test
    public void updateEmployee() throws Exception {

        Employee customer = EmployeeFactory.addEmployee("Ephraim", "mnisi@gmail.com", "1500");

        Assert.assertEquals("Ephraim", customer.getName());
    }


}
