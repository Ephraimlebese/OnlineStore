package za.ac.cput.onlineStore.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/10/15.
 */
public class Employee implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Name;
    private String Salary;
    private String Email;

    public Employee() {
    }

    public Employee(Builder builder){
        id = builder.id;
        Name = builder.Name;
        Salary = builder.Salary;
        Email = builder.Email;
    }

    public Long getID() {
        return id;
    }

    public String getName() {
        return Name;
    }
    public String getSalary() {
        return Salary;
    }
    public String getEmail() {
        return Email;
    }

    public static class Builder {
        private String Name;
        private String Salary;
        private String Email;
        private Long id;

        public Builder(String Name){
            this.Name =Name;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder Salary(String Salary)
        {
            this.Salary = Salary;
            return this;
        }

        public Builder year(String Email)
        {
            this.Email = Email;
            return this;
        }

        public Builder copy(Employee value){
            this.id = value.id;
            this.Name = value.Name;
            this.Salary = value.Salary;
            this.Email = value.Email;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }
}
