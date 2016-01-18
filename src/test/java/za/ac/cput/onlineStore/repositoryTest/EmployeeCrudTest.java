package za.ac.cput.onlineStore.repositoryTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.onlineStore.OnlineStoreApplication;
import za.ac.cput.onlineStore.domain.Customer;
import za.ac.cput.onlineStore.domain.Employee;
import za.ac.cput.onlineStore.repository.CustomerRepo;
import za.ac.cput.onlineStore.repository.EmployeeRepo;

/**
 * Created by student on 2016/01/18.
 */
@SpringApplicationConfiguration(classes = {OnlineStoreApplication.class})
@WebAppConfiguration

public class EmployeeCrudTest  extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    EmployeeRepo repository;

    @Test
    public void create() throws Exception {

        Employee employee = new Employee.Builder("Mnisi").email("mnisisibusiso@gmail.com").Salary("522252").build();
        this.repository.save(employee);
        this.id = employee.getID();
        Assert.assertNotNull(employee.getID());
    }

    @Test(dependsOnMethods = {"create"})
    public void read() throws Exception {

        Employee employee  = (Employee)this.repository.findOne(this.id);
        Assert.assertNotNull(employee);
        Assert.assertEquals("mnisisibusiso@gmail.com", employee.getEmail());

    }

    @Test(dependsOnMethods = {"read"})
    public void update() throws Exception {

        Employee employee  = (Employee)this.repository.findOne(this.id);
        Employee employee1 = new Employee.Builder("Mnisi").email("v@gmail.com").Salary("522252").build();

        this.repository.save(employee1);
        Employee customer2  = (Employee)this.repository.findOne(this.id);
        Assert.assertEquals("v@gmail.com", employee1.getEmail());
    }

    @Test(dependsOnMethods = {"update"})
    public void delete() throws Exception {
        Employee employee  = (Employee)this.repository.findOne(this.id);
        this.repository.delete(employee);
        Employee deleteEmplyee = (Employee)this.repository.findOne(this.id);
        Assert.assertNull(deleteEmplyee);
    }

}
