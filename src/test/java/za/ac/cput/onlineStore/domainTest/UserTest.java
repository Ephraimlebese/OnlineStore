package za.ac.cput.onlineStore.domainTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.onlineStore.config.UserFactory;
import za.ac.cput.onlineStore.domain.Customer;
import za.ac.cput.onlineStore.domain.Employee;
import za.ac.cput.onlineStore.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/10/15.
 */
public class UserTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void createUser() throws Exception {
        List<Customer> customers = new ArrayList<Customer>();
        List<Employee> employees= new ArrayList<Employee>();

        User user = UserFactory.createUser("lemo@33", "Zeee@333",employees,customers);

        Assert.assertEquals("lemo@33", user.getUserName());
    }

    @Test
    public void updateUser() throws Exception {
        List<Customer> customers = new ArrayList<Customer>();
        List<Employee> employees= new ArrayList<Employee>();

        User user = UserFactory.createUser("lemo@33", "123456",employees,customers);

        Assert.assertEquals("123456", user.getPassword());
    }

    @After
    public void tearDown() throws Exception {

    }
}
