package za.ac.cput.onlineStore.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/10/15.
 */
public class Rental implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String rate;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="model_id")
    private List<Car> cars;

    public Rental() {
    }

    public Rental(Builder builder) {
        id = builder.id;
        rate = builder.rate;
        cars = builder.cars;
    }

    public Long getID() {
        return id;
    }

    public String getRate() {
        return rate;
    }

    public List<Car> getCars() {
        return cars;
    }

    public static class Builder {
        private String rate;
        private Long id;
        private List<Car> cars;

        public Builder(String rate){
            this.rate =rate;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder cars(List<Car> cars)
        {
            this.cars = cars;
            return this;
        }

        public Builder copy(Rental value) {
            this.id = value.id;
            this.rate = value.rate;
            this.cars = value.cars;
            return this;
        }
        public Rental build(){
            return new Rental(this);
        }
    }
}
