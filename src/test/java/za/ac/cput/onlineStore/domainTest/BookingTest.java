package za.ac.cput.onlineStore.domainTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.onlineStore.config.BookingFactory;
import za.ac.cput.onlineStore.domain.Booking;
import za.ac.cput.onlineStore.domain.Car;
import za.ac.cput.onlineStore.domain.Invoice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/10/15.
 */
public class BookingTest {


    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void createBookingTest() throws Exception {
        List<Car> cars = new ArrayList<Car>();
        List<Invoice> invoices= new ArrayList<Invoice>();

        Booking booking = BookingFactory.createBooking("12","May","2015",cars, invoices);


        Assert.assertEquals("2015",booking.getYear());

    }

    @Test
    public void updateBookingtest() throws Exception {

        List<Car> cars = new ArrayList<Car>();
        List<Invoice> invoices= new ArrayList<Invoice>();

        Booking booking = BookingFactory.createBooking("12","May","2016",cars, invoices);


        Assert.assertEquals("May",booking.getMonth());
    }
}
