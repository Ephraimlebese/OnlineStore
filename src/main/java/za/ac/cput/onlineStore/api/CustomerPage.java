package za.ac.cput.onlineStore.api;

import org.hibernate.validator.internal.util.Contracts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.onlineStore.domain.Customer;
import za.ac.cput.onlineStore.services.CustomerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/01/18.
 */

@RestController
@RequestMapping(value="/customer/**")
public class CustomerPage {


    @Autowired
    private CustomerService serivce;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public List<Customer> getUserCompany(@PathVariable Long id) {return serivce.getCustomer();}

    @RequestMapping(value="/customer", method=RequestMethod.GET)
    public List<Customer> getCustomer() {

        List<Customer> hateoas = new ArrayList();
        List<Customer> users = serivce.getCustomer();


        for (Customer c : users) {

            Customer res = new Customer
                    .Builder(c.getName())
                    .email(c.getEmail())
                    .Salary(c.getSalary())
                    .build();

            Link sheet = new Link("http://localhost:8080/user" + res.getName() + res.toString())
                    .withRel("userRegistration");
           // res.add(sheet);
            hateoas.add(res);
        }
        return hateoas;
    }

    //-------------------------Retrieve all users--------------------//
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getSubject(@PathVariable("id") long id) {
        System.out.println("Fetching Subject with id " + id);
        Customer client = serivce.findById(id);
        if (client == null) {
            System.out.println("Subject with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Customer>(client, HttpStatus.OK);
    }


    //-------------------Create a customer--------------------------------------------------------

    @RequestMapping(value = "/customer/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createSubject(@RequestBody Customer users, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating user " + users.getName());

//     USE THIS IF YOU WANT TO CHECK UNIQUE OBJECT
//      if (SubjectService.isSubjectExist(Subject)) {
//            System.out.println("A Subject with name " + Subject.getName() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }

        serivce.save(users);


        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(users.getID()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a User --------------------------------------------------------

    @RequestMapping(value = "/customer/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Customer> updateSubject(@PathVariable("id") long id, @RequestBody Customer users) {
        System.out.println("Updating Subject " + id);

        Customer currentUser = serivce.findById(id);

        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

        Customer updatedUser = new Customer
                .Builder(currentUser.getName())
                .email(currentUser.getEmail())
                .Salary(currentUser.getSalary())
                .build();
        serivce.update(updatedUser);

        return new ResponseEntity<Customer>(updatedUser, HttpStatus.OK);

    }


    //------------------- Delete a User --------------------------------------------------------

    @RequestMapping(value = "/customer/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Customer> deleteSubject(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting user with id " + id);

        Customer users = serivce.findById(id);
        if (users == null) {
            System.out.println("Unable to delete. Subject with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

        serivce.delete(users);
        return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
    }

}
