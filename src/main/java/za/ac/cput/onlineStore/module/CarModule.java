package za.ac.cput.onlineStore.module;

import org.springframework.hateoas.ResourceSupport;


/**
 * Created by student on 2016/01/18.
 */
public class CarModule extends ResourceSupport {


    private Long id;
    private String model;
    private String milage;

    public CarModule() {
    }
    public CarModule(Builder builder) {
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

        public Builder copy(CarModule value) {
            this.id = value.id;
            this.model = value.model;
            this.milage = value.milage;
            return this;
        }
        public CarModule build(){
            return new CarModule(this);
        }
    }
}
