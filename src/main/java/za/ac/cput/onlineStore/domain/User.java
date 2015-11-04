package za.ac.cput.onlineStore.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/10/15.
 */
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String UserName;
    private String Password;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="customer_id")
    private List<Customer> customers;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="employee_id")
    private List<Employee> employees;

    public User() {
    }
    public User(Builder builder) {
        id = builder.id;
        UserName = builder.UserName;
        Password = builder.Password;
        customers = builder.customers;
        employees = builder.employees;
    }

    public Long getID() {
        return id;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public static class Builder {
        private String UserName;
        private String Password;
        private Long id;
        private List<Employee> employees;
        private List<Customer> customers;

        public Builder(String UserName){
            this.UserName = UserName;
        }

        public Builder Password(String Password)
        {
            this.Password = Password;
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

        public Builder customers(List<Customer> customers)
        {
            this.customers = customers;
            return this;
        }

        public Builder copy(User value) {
            this.id = value.id;
            this.UserName = value.UserName;
            this.Password = value.Password;
            this.employees = value.employees;
            this.customers = value.customers;
            return this;
        }
        public User build(){
            return new User(this);
        }
    }
}
