package za.ac.cput.onlineStore.repositoryTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.onlineStore.OnlineStoreApplication;
import za.ac.cput.onlineStore.domain.Car;
import za.ac.cput.onlineStore.domain.Company;
import za.ac.cput.onlineStore.domain.Employee;
import za.ac.cput.onlineStore.domain.Invoice;
import za.ac.cput.onlineStore.repository.CarRepo;
import za.ac.cput.onlineStore.repository.CompanyRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/01/18.
 */
@SpringApplicationConfiguration(classes = {OnlineStoreApplication.class})
@WebAppConfiguration

public class CompanyTestCrud  extends AbstractTestNGSpringContextTests {


    private Long id;

    @Autowired
    CompanyRepo repository;

    @Test
    public void create() throws Exception {
        List<Employee> employees2 = new ArrayList<Employee>();

        Company company = new Company.Builder("88").Address("10 Dorset Street").employees(employees2).build();
        this.repository.save(company);
        this.id = company.getID();
        Assert.assertNotNull(company.getID());
    }

    @Test(dependsOnMethods = {"create"})
    public void read() throws Exception {

        Company company  = (Company)this.repository.findOne(this.id);
        Assert.assertNotNull(company);
        Assert.assertEquals("10 Dorset Street", company.getAddress());

    }

    @Test(dependsOnMethods = {"read"})
    public void update() throws Exception {
        List<Employee> employees2 = new ArrayList<Employee>();

        Company company  = (Company)this.repository.findOne(this.id);
        Company company3 = new Company.Builder("88").Address("10 Plain Street").employees(employees2).build();

        this.repository.save(company3);
        Company company1  = (Company)this.repository.findOne(this.id);
        Assert.assertEquals("10 Plain Street", company3.getAddress());
    }

    @Test(dependsOnMethods = {"update"})
    public void delete() throws Exception {
        Company company  = (Company)this.repository.findOne(this.id);
        this.repository.delete(company);
        Company deleteCompany = (Company)this.repository.findOne(this.id);
        Assert.assertNull(deleteCompany);
    }

}
