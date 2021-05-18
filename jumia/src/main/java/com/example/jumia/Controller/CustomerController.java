package com.example.jumia.Controller;

import com.example.jumia.Entity.customer;
import com.example.jumia.Entity.Phone;
import com.example.jumia.Repository.CustomerRepository;
import com.example.jumia.Service.CustomerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;


    @GetMapping(value = "/createTablePhones")
    public List<Phone> CreateTableInicialPhones() {
       return service.CreateInitialTablePhones();

    }

    @GetMapping(value = "/customers")
    public List<customer> GetAllCustomers() {
        return service.getAllCustomers();

    }

    //For add and update person both
    @PostMapping(value= "/customers/add")
    public String addCustomer(@RequestBody customer customer){

       return service.addCustomer(customer);

    }

    @DeleteMapping("/deleteCustomer/{id}")
    public String removeCustomer(@PathVariable("id") int id){
        return service.removeCustomer(id);
    }

    @PutMapping("/editCustomer/{id}")
    public customer editCustomer(@PathVariable("id") int id,@RequestBody customer newCustomer){

        return service.editCustomer(id,newCustomer);
    }


}
