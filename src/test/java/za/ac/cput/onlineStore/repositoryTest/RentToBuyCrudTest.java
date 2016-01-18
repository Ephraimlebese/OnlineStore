package za.ac.cput.onlineStore.repositoryTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.onlineStore.OnlineStoreApplication;
import za.ac.cput.onlineStore.domain.Car;
import za.ac.cput.onlineStore.domain.RentToBuy;
import za.ac.cput.onlineStore.domain.Rental;
import za.ac.cput.onlineStore.repository.RentRepo;
import za.ac.cput.onlineStore.repository.RentToBuyRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/01/18.
 */

@SpringApplicationConfiguration(classes = {OnlineStoreApplication.class})
@WebAppConfiguration

public class RentToBuyCrudTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    RentToBuyRepo repository;


    @Test
    public void create() throws Exception {

        RentToBuy rentToBuy = new RentToBuy.Builder("1500").accountHolder("Mr Zwane").build();
        this.repository.save(rentToBuy);
        this.id = rentToBuy.getID();
        Assert.assertNotNull(rentToBuy.getID());
    }


    @Test(dependsOnMethods = {"create"})
    public void read() throws Exception {

        RentToBuy rental  = (RentToBuy)this.repository.findOne(this.id);
        Assert.assertNotNull(rental);
        Assert.assertEquals("Mr Zwane", rental.getAccountHolder());

    }

    @Test(dependsOnMethods = {"read"})
    public void update() throws Exception {


        RentToBuy rental  = (RentToBuy)this.repository.findOne(this.id);
        RentToBuy rentalNew = new RentToBuy.Builder("1500").accountHolder("Mr Zwane").build();

        this.repository.save(rentalNew);
        RentToBuy rental4  = (RentToBuy)this.repository.findOne(this.id);
        Assert.assertEquals("Mr Zwane", rental4.getAccountHolder());
    }

    @Test(dependsOnMethods = {"update"})
    public void delete() throws Exception {
        RentToBuy rental  = (RentToBuy)this.repository.findOne(this.id);
        this.repository.delete(rental);
        RentToBuy rental2  = (RentToBuy)this.repository.findOne(this.id);
        Assert.assertNull(rental2);
    }
}
