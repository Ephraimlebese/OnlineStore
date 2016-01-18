package za.ac.cput.onlineStore.domainTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.onlineStore.config.RentToBuyFactory;
import za.ac.cput.onlineStore.domain.RentToBuy;

/**
 * Created by student on 2015/10/15.
 */
public class RentToBuyTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void createRentToBuy() throws Exception {

        RentToBuy rentToBuy = RentToBuyFactory.rentCar("2000","Riyaaz");

        Assert.assertEquals("Riyaaz", rentToBuy.getAccountHolder());
    }


    @Test
    public void updateRentToBuy() throws Exception {

        RentToBuy rentToBuy = RentToBuyFactory.rentCar("2000","Zeee");

        Assert.assertEquals("Zeee", rentToBuy.getAccountHolder());
    }

    @After

    public void tearDown() throws Exception {

    }
}
