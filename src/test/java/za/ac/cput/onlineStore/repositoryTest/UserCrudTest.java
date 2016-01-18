package za.ac.cput.onlineStore.repositoryTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.onlineStore.OnlineStoreApplication;
import za.ac.cput.onlineStore.domain.*;
import za.ac.cput.onlineStore.repository.RentToBuyRepo;
import za.ac.cput.onlineStore.repository.UserRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/01/18.
 */

@SpringApplicationConfiguration(classes = {OnlineStoreApplication.class})
@WebAppConfiguration

public class UserCrudTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    UserRepo repository;

    @Test
    public void create() throws Exception {

        List<Employee> employees = new ArrayList<Employee>();
        List<Customer> customers = new ArrayList<Customer>();

        User user1 = new User.Builder("mcu@123").Password("123456").customers(customers).employees(employees).build();
        this.repository.save(user1);
        this.id = user1.getID();
        Assert.assertNotNull(user1.getID());
    }


    @Test(dependsOnMethods = {"create"})
    public void read() throws Exception {

        User rental  = (User)this.repository.findOne(this.id);
        Assert.assertNotNull(rental);
        Assert.assertEquals("123456", rental.getPassword());

    }

    @Test(dependsOnMethods = {"read"})
    public void update() throws Exception {


        List<Employee> employees = new ArrayList<Employee>();
        List<Customer> customers = new ArrayList<Customer>();

        User rental  = (User)this.repository.findOne(this.id);
        User user1 = new User.Builder("mcu@123").Password("123456").customers(customers).employees(employees).build();


        this.repository.save(user1);
        User rental3  = (User)this.repository.findOne(this.id);
        Assert.assertEquals("123456", rental3.getPassword());
    }

    @Test(dependsOnMethods = {"update"})
    public void delete() throws Exception {
        User rental  = (User)this.repository.findOne(this.id);
        this.repository.delete(rental);
        User rental2  = (User)this.repository.findOne(this.id);
        Assert.assertNull(rental2);
    }
}
