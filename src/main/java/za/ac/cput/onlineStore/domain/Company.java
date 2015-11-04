package za.ac.cput.onlineStore.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/10/15.
 */
public class Company implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String CompanyName;
    private String Address;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="employee_id")
    private List<Employee> employees;

    public Company() {
    }
    public Company(Builder builder) {
        id = builder.id;
        CompanyName = builder.CompanyName;
        Address = builder.Address;
        employees = builder.employees;
    }

    public Long getID() {
        return id;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public String getAddress() {
        return Address;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public static class Builder {
        private String CompanyName;
        private String Address;
        private Long id;
        private List<Employee> employees;

        public Builder(String CompanyName){
            this.CompanyName = CompanyName;
        }

        public Builder Address(String Address)
        {
            this.Address = Address;
            return this;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }
        public Builder employees(List<Employee> employees)
        {
            this.employees = employees;
            return this;
        }

        public Builder copy(Company value) {
            this.id = value.id;
            this.CompanyName = value.CompanyName;
            this.Address = value.Address;
            this.employees = value.employees;
            return this;
        }
        public Company build(){
            return new Company(this);
        }
    }
}
