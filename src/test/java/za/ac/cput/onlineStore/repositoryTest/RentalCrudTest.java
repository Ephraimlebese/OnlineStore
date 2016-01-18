package za.ac.cput.onlineStore.repositoryTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.onlineStore.OnlineStoreApplication;
import za.ac.cput.onlineStore.domain.Car;
import za.ac.cput.onlineStore.domain.Invoice;
import za.ac.cput.onlineStore.domain.Rental;
import za.ac.cput.onlineStore.repository.InvoiceRepo;
import za.ac.cput.onlineStore.repository.RentRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/01/18.
 */
@SpringApplicationConfiguration(classes = {OnlineStoreApplication.class})
@WebAppConfiguration

public class RentalCrudTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    RentRepo repository;

    @Test
    public void create() throws Exception {

        List<Car> car = new ArrayList<Car>();
        Rental rental = new Rental.Builder("150Rate").cars(car).build();
        this.repository.save(rental);
        this.id = rental.getID();
        Assert.assertNotNull(rental.getID());
    }

    @Test(dependsOnMethods = {"create"})
    public void read() throws Exception {

        Rental rental  = (Rental)this.repository.findOne(this.id);
        Assert.assertNotNull(rental);
        Assert.assertEquals("150Rate", rental.getRate());

    }

    @Test(dependsOnMethods = {"read"})
    public void update() throws Exception {

        List<Car> car = new ArrayList<Car>();
        Rental rental  = (Rental)this.repository.findOne(this.id);
        Rental rentalNew = new Rental.Builder("160Rate").cars(car).build();

        this.repository.save(rentalNew);
        Rental rental4  = (Rental)this.repository.findOne(this.id);
        Assert.assertEquals("150Rate", rental4.getRate());
    }

    @Test(dependsOnMethods = {"update"})
    public void delete() throws Exception {
        Rental rental  = (Rental)this.repository.findOne(this.id);
        this.repository.delete(rental);
        Rental rental2  = (Rental)this.repository.findOne(this.id);
        Assert.assertNull(rental2);
    }

}
