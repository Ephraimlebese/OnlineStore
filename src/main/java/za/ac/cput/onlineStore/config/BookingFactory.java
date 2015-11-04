package za.ac.cput.onlineStore.config;

import za.ac.cput.onlineStore.domain.Booking;
import za.ac.cput.onlineStore.domain.Car;
import za.ac.cput.onlineStore.domain.Invoice;

import java.util.List;

/**
 * Created by student on 2015/10/15.
 */
public class BookingFactory {
    public static Booking createBooking(String day,String month,String year,List<Car> cars,List<Invoice> invoices){
        Booking booking = new Booking
                .Builder(day)
                .month(month)
                .year(year)
                .cars(cars)
                .invoice(invoices)
                .build();
        return booking;
    }
}
