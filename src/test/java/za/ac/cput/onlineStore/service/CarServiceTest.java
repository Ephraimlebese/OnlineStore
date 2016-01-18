package za.ac.cput.onlineStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.onlineStore.OnlineStoreApplication;
import za.ac.cput.onlineStore.config.CarFactory;
import za.ac.cput.onlineStore.domain.Car;
import za.ac.cput.onlineStore.repository.CarRepo;
import za.ac.cput.onlineStore.services.CarService;

import java.util.List;

/**
 * Created by student on 2016/01/18.
 */
@SpringApplicationConfiguration(classes = OnlineStoreApplication.class)
@WebAppConfiguration

public class CarServiceTest extends AbstractTestNGSpringContextTests
{

    @Autowired
    CarService service;

    private Long id;

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @Test
    public void create() throws Exception {

        Car car =  CarFactory.createCar("1000", "5555");
        service.save(car);
        id = car.getID();
        Assert.assertNotNull(id);
    }


    @Test(dependsOnMethods = "create")
    public void read()throws Exception
    {
        Car car = service.findById(id);
        Assert.assertEquals("5555",car.getMilage());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Car car = service.findById(id);
        Car newCar = new Car.Builder("250").milage("1000").copy(car).build();

        service.update(newCar );
        Car car1  = service.findById(id);
        org.junit.Assert.assertEquals("5555", car1.getMilage());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Car car = service.findById(id);
        service.delete(car);
        Car deletedUser = service.findById(id);
        org.junit.Assert.assertNull(deletedUser);
    }

}
