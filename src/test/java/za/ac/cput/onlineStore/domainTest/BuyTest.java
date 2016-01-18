package za.ac.cput.onlineStore.domainTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.onlineStore.config.BuyFactory;
import za.ac.cput.onlineStore.domain.Buy;
import za.ac.cput.onlineStore.domain.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/10/15.
 */
public class BuyTest {

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testcreate() throws Exception {

        List<Car> cars = new ArrayList<Car>();

        Buy buy = BuyFactory.createBuy("12000", cars);


        Assert.assertEquals("12000",buy.getPrice());
    }

    @Test
    public void updateBuy() throws Exception {

        List<Car> cars = new ArrayList<Car>();

        Buy buy = BuyFactory.createBuy("15000", cars);


        Assert.assertEquals("15000",buy.getPrice());
    }
}

