package za.ac.cput.onlineStore.repositoryTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.onlineStore.OnlineStoreApplication;
import za.ac.cput.onlineStore.domain.Buy;
import za.ac.cput.onlineStore.domain.Car;
import za.ac.cput.onlineStore.repository.BookingRepo;
import za.ac.cput.onlineStore.repository.BuyRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/01/18.
 */
@SpringApplicationConfiguration(classes = {OnlineStoreApplication.class})
@WebAppConfiguration
public class BuyCrudTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    BuyRepo repository;

    @Test
    public void create() throws Exception {

        List<Car> car = new ArrayList<Car>();

        Buy buy = new Buy.Builder("25").cars(car).build();

        this.repository.save(buy);
        this.id = buy.getID();
        Assert.assertNotNull(buy.getID());
    }

    @Test(dependsOnMethods = {"create"})
    public void read() throws Exception {

        Buy buy  = (Buy)this.repository.findOne(this.id);
        Assert.assertNotNull(buy);
        Assert.assertEquals("25", buy.getPrice());

    }

    @Test(dependsOnMethods = {"read"})
    public void update() throws Exception {
        List<Car> car = new ArrayList<Car>();

        Buy buy  = (Buy)this.repository.findOne(this.id);
        Buy newPrice=  new Buy.Builder(buy.getPrice()).copy(buy).cars(car).build();
        this.repository.save(newPrice);
        Buy buy1 = (Buy)this.repository.findOne(this.id);
        Assert.assertEquals("25", buy1.getPrice());
    }

    @Test(dependsOnMethods = {"update"})
    public void delete() throws Exception {
        Buy buy   = (Buy)this.repository.findOne(this.id);
        this.repository.delete(buy);
        Buy deletePrice = (Buy)this.repository.findOne(this.id);
        Assert.assertNull(deletePrice);
    }
}
