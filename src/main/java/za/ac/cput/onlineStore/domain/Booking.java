package za.ac.cput.onlineStore.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/10/15.
 */
public class Booking implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String day;
    private String month;
    private String year;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="model_id")
    private List<Car> cars;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="invoice_id")
    private List<Invoice> invoices;

    public Booking() {
    }

    public Booking(Builder builder){
        id = builder.id;
        day = builder.day;
        month = builder.month;
        year = builder.year;
        cars = builder.cars;
        invoices = builder.invoices;
    }

    public Long getID() {
        return id;
    }

    public String getDay() {
        return day;
    }
    public String getMonth() {
        return month;
    }
    public String getYear() {
        return year;
    }
    public List<Car> getCars() {
        return cars;
    }
    public List<Invoice> getInvoices() {
        return invoices;
    }

    public static class Builder {
        private String day;
        private String month;
        private String year;
        private Long id;
        private List<Car> cars;
        private List<Invoice> invoices;

        public Builder(String day){
            this.day =day;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder month(String month)
        {
            this.month = month;
            return this;
        }

        public Builder year(String year)
        {
            this.year = year;
            return this;
        }

        public Builder cars(List<Car> cars)
        {
            this.cars = cars;
            return this;
        }

        public Builder invoice(List<Invoice> invoices)
        {
            this.invoices = invoices;
            return this;
        }

        public Builder copy(Booking value){
            this.id = value.id;
            this.day = value.day;
            this.month = value.month;
            this.year = value.year;
            this.cars = value.cars;
            this.invoices = value.invoices;
            return this;
        }

        public Booking build(){
            return new Booking(this);
        }
    }
}
