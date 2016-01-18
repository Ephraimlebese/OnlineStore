package za.ac.cput.onlineStore.repositoryTest;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.onlineStore.OnlineStoreApplication;
import za.ac.cput.onlineStore.config.BookingFactory;
import za.ac.cput.onlineStore.domain.Booking;
import za.ac.cput.onlineStore.domain.Car;
import za.ac.cput.onlineStore.domain.Invoice;
import za.ac.cput.onlineStore.repository.BookingRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/01/18.
 */

@SpringApplicationConfiguration(classes = {OnlineStoreApplication.class})
@WebAppConfiguration
public class BookingCrudTest extends AbstractTestNGSpringContextTests {

    private Long id;
    @Autowired
    BookingRepo repository;

    public BookingCrudTest() {
    }

    @Test
    public void creatBooking() throws Exception {

        List<Car> car = new ArrayList<Car>();
        List<Invoice> invoices = new ArrayList<Invoice>();

        Booking booking = new Booking.Builder("25").month("June").year("2015").cars(car).invoice(invoices).build();

        this.repository.save(booking);
        this.id = booking.getID();
        Assert.assertNotNull(booking.getID());
    }

    @Test(dependsOnMethods = {"creatBooking"})
    public void read() throws Exception {

        Booking booking  = (Booking)this.repository.findOne(this.id);
        Assert.assertNotNull(booking);
        Assert.assertEquals("June", booking.getMonth());
        Assert.assertEquals("25", booking.getDay());
    }

    @Test(dependsOnMethods = {"read"})
    public void update() throws Exception {
        Booking booking  = (Booking)this.repository.findOne(this.id);
        Booking newBooking=  new Booking.Builder(booking.getDay()).copy(booking).month("December").build();
        this.repository.save(newBooking);
        Booking updatedBooking = (Booking)this.repository.findOne(this.id);
        Assert.assertEquals("25", updatedBooking.getDay());
    }

    @Test(dependsOnMethods = {"update"})
    public void delete() throws Exception {
        Booking booking  = (Booking)this.repository.findOne(this.id);
        this.repository.delete(booking);
        Booking Deletebooking = (Booking)this.repository.findOne(this.id);
        Assert.assertNull(Deletebooking);
    }

}
