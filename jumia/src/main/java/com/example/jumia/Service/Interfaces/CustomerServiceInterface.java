package com.example.jumia.Service.Interfaces;

import com.example.jumia.Entity.Country;
import com.example.jumia.Entity.Phone;
import com.example.jumia.Entity.customer;

import java.util.ArrayList;
import java.util.List;

public interface CustomerServiceInterface {

    public List<Phone> CreateInitialTablePhones();

    public List<customer> getAllCustomers();

    public String addCustomer(customer customer);

    public String removeCustomer(int id);

    public customer editCustomer(int id, customer newCustomer);
}
