package za.ac.cput.onlineStore.domainTest;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.onlineStore.config.RentalFactory;
import za.ac.cput.onlineStore.domain.Car;
import za.ac.cput.onlineStore.domain.Rental;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/10/15.
 */
public class RentalTest {

    @Test
    public void createRental() throws Exception {

        List<Car> cars = new ArrayList<Car>();
        Rental rental = RentalFactory.rentCar("8000",cars);

        Assert.assertEquals("8000", rental.getRate());
    }


    @Test
    public void updateRental() throws Exception {

        List<Car> cars = new ArrayList<Car>();
        Rental rental = RentalFactory.rentCar("2000",cars);

        Assert.assertEquals("2000", rental.getRate());
    }

}
