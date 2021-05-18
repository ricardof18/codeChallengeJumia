package com.example.jumia.Service;

import com.example.jumia.Entity.Country;
import com.example.jumia.Entity.customer;
import com.example.jumia.Repository.CountryRepository;
import com.example.jumia.Repository.CustomerRepository;
import com.example.jumia.Service.Interfaces.CountryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService implements CountryServiceInterface {

    @Autowired
    private CountryRepository repository;

    @Override
    public List<Country> getAllCountry(){
        return repository.findAll();
    }
    @Override
    public Country addCountry(Country country){

        return repository.save(country);
    }
    @Override
    public Country removeCountry(int id){
        repository.deleteById(id);

        return repository.findById(id);
    }

    @Override
    public Country editCountry(int id, Country newCountry){

        Country country= repository.findById(id);

        country.setCountrycode(newCountry.getCountrycode());
        country.setCountryname(newCountry.getCountryname());
        country.setCountryregex(newCountry.getCountryregex());

        return repository.save(country);
    }
}
