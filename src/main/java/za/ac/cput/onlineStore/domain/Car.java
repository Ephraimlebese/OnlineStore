package za.ac.cput.onlineStore.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/10/15.
 */
public class Car implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String model;
    private String milage;

    public Car() {
    }
    public Car(Builder builder) {
        id = builder.id;
        model = builder.model;
        milage = builder.milage;
    }

    public Long getID() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getMilage() {
        return milage;
    }

    public static class Builder {
        private String model;
        private String milage;
        private Long id;

        public Builder(String model){
            this.model = model;
        }

        public Builder milage(String milage)
        {
            this.milage = milage;
            return this;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(Car value) {
            this.id = value.id;
            this.model = value.model;
            this.milage = value.milage;
            return this;
        }
        public Car build(){
            return new Car(this);
        }
    }
}
