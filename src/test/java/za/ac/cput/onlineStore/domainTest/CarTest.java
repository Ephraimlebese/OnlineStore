package za.ac.cput.onlineStore.domainTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.onlineStore.config.CarFactory;
import za.ac.cput.onlineStore.domain.Car;

/**
 * Created by student on 2015/10/15.
 */
public class CarTest {

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void createCar() throws Exception {

        Car car = CarFactory.createCar("BMW", "1500KM");
        Assert.assertEquals("BMW", car.getModel());
    }

    @Test
    public void updateCar() throws Exception {

        Car car = CarFactory.createCar("Audi", "1500KM");
        Assert.assertEquals("Audi", car.getModel());
    }

}
