package za.ac.cput.onlineStore.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/10/15.
 */
public class Buy implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String price;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="model_id")
    private List<Car> cars;

    public Buy() {
    }

    public Buy(Builder builder) {
        id = builder.id;
        price = builder.price;
        cars = builder.cars;
    }

    public Long getID() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public List<Car> getCars() {
        return cars;
    }

    public static class Builder {
        private String price;
        private Long id;
        private List<Car> cars;

        public Builder(String price){
            this.price =price;
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

        public Builder copy(Buy value) {
            this.id = value.id;
            this.price = value.price;
            this.cars = value.cars;
            return this;
        }
        public Buy build(){
            return new Buy(this);
        }
    }
}
