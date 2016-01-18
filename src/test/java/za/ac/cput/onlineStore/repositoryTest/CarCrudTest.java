package za.ac.cput.onlineStore.repositoryTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.onlineStore.OnlineStoreApplication;
import za.ac.cput.onlineStore.domain.Car;
import za.ac.cput.onlineStore.repository.BuyRepo;
import za.ac.cput.onlineStore.repository.CarRepo;

/**
 * Created by student on 2016/01/18.
 */
@SpringApplicationConfiguration(classes = {OnlineStoreApplication.class})
@WebAppConfiguration
public class CarCrudTest  extends AbstractTestNGSpringContextTests {


    private Long id;

    @Autowired
    CarRepo repository;


    @Test
    public void create() throws Exception {

        Car car = new Car.Builder("88").milage("6000KM").build();
        this.repository.save(car);
        this.id = car.getID();
        Assert.assertNotNull(car.getID());
    }

    @Test(dependsOnMethods = {"create"})
    public void read() throws Exception {

        Car car  = (Car)this.repository.findOne(this.id);
        Assert.assertNotNull(car);
        Assert.assertEquals("6000KM", car.getMilage());

    }

    @Test(dependsOnMethods = {"read"})
    public void update() throws Exception {

        Car car  = (Car)this.repository.findOne(this.id);
        Car newCar=  new Car.Builder(car.getModel()).milage("6000KM").copy(car).build();
        this.repository.save(newCar);
        Car car1 = (Car)this.repository.findOne(this.id);
        Assert.assertEquals("6000KM", car1.getMilage());
    }

    @Test(dependsOnMethods = {"update"})
    public void delete() throws Exception {
        Car car  = (Car)this.repository.findOne(this.id);
        this.repository.delete(car);
        Car deleteCar = (Car)this.repository.findOne(this.id);
        Assert.assertNull(deleteCar);
    }



}
