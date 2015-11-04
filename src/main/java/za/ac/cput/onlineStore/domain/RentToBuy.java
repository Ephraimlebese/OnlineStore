package za.ac.cput.onlineStore.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/10/15.
 */
public class RentToBuy implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Instalment;

    public RentToBuy() {
    }

    public RentToBuy(Builder builder) {
        id = builder.id;
        Instalment = builder.Instalment;
    }

    public Long getID() {
        return id;
    }

    public String getInstalment() {
        return Instalment;
    }

    public static class Builder {
        private String Instalment;
        private Long id;

        public Builder(String Instalment){
            this.Instalment =Instalment;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(RentToBuy value) {
            this.id = value.id;
            this.Instalment = value.Instalment;
            return this;
        }
        public RentToBuy build(){
            return new RentToBuy(this);
        }
    }
}
