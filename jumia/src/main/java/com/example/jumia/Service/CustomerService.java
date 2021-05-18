package com.example.jumia.Service;

import com.example.jumia.Entity.Country;
import com.example.jumia.Entity.Phone;
import com.example.jumia.Entity.customer;
import com.example.jumia.Repository.CountryRepository;
import com.example.jumia.Repository.CustomerRepository;
import com.example.jumia.Repository.PhoneRepository;
import com.example.jumia.Service.Interfaces.CustomerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements CustomerServiceInterface {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private PhoneRepository repositoryPhone;

    @Autowired
    private CountryRepository countryRepository;


    @Override
    public List<Phone> CreateInitialTablePhones() {
        List<Phone> phones= new ArrayList<>();
        List <customer> customers= repository.findAll();

        for( customer i : customers) {

            String countryCode = i.getPhone().split(" ")[0];

            Country country = countryRepository.findByCountrycode(countryCode);

            Phone newPhone = new Phone();
            newPhone.setName(i.getName());
            newPhone.setCountrycode(countryCode);
            newPhone.setNumber(i.getPhone());
            newPhone.setCountry(country.getCountryname());
            newPhone.setState(i.getPhone().matches(country.getCountryregex()));
            phones.add(newPhone);
            repositoryPhone.save(newPhone);

        }


        return phones;

    }

    @Override
    public List<customer> getAllCustomers(){
        return repository.findAll();
    }

    @Override
    public String addCustomer(customer customer){

        repository.save(customer);

        String countryCode=customer.getPhone().split(" ")[0];

        Country country = countryRepository.findByCountrycode(countryCode);

        Phone newPhone = new Phone();
        newPhone.setName(customer.getName());
        newPhone.setCountrycode(countryCode);
        newPhone.setNumber(customer.getPhone());
        newPhone.setCountry(country.getCountryname());
        newPhone.setState(customer.getPhone().matches(country.getCountryregex()));
        repositoryPhone.save(newPhone);
        return customer.toString();

    }


    @Override
    public String removeCustomer(int id){
        repository.deleteById(id);
        return Integer.toString(id);
    }


    @Override
    public customer editCustomer(int id, customer newCustomer){
        customer customer= repository.findById(id);
        customer.setName(newCustomer.getName());
        customer.setPhone(newCustomer.getPhone());



        return repository.save(customer);
    }

}
