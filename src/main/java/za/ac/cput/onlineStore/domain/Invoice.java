package za.ac.cput.onlineStore.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/10/15.
 */
public class Invoice implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String AmountOwed;
    private String AmountPayed;

    public Invoice() {
    }
    public Invoice(Builder builder) {
        id = builder.id;
        AmountOwed = builder.AmountOwed;
        AmountPayed = builder.AmountPayed;
    }

    public Long getID() {
        return id;
    }

    public String getAmountOwed() {
        return AmountOwed;
    }

    public String getAmountPayed() {
        return AmountPayed;
    }

    public static class Builder {
        private String AmountOwed;
        private String AmountPayed;
        private Long id;

        public Builder(String AmountOwed){
            this.AmountOwed = AmountOwed;
        }

        public Builder AmountPayed(String AmountPayed)
        {
            this.AmountPayed = AmountPayed;
            return this;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(Invoice value) {
            this.id = value.id;
            this.AmountOwed = value.AmountOwed;
            this.AmountPayed = value.AmountPayed;
            return this;
        }
        public Invoice build(){
            return new Invoice(this);
        }
    }
}
