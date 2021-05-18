package com.example.jumia.Controller;

import com.example.jumia.Entity.Country;
import com.example.jumia.Entity.Phone;
import com.example.jumia.Repository.CountryRepository;
import com.example.jumia.Repository.CustomerRepository;
import com.example.jumia.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryService service;


    //Get All Countries
    @GetMapping(value = "/countries")
    public List<Country> AllCountries() {
        return service.getAllCountry();
    }

    //Create Country
    @PostMapping(value = "/addCountries")
    public Country AddCountry(@RequestBody Country country) {
        return service.addCountry(country);
    }

    //Remove Country
    @DeleteMapping(value="/deleteCountry/{id}")
    public Country removeCountry(@PathVariable("id") int id){
        return service.removeCountry(id);
    }

    @PutMapping(value="/editCountry/{id}")
    public Country editCountry(@PathVariable("id") int id, @RequestBody Country newCountry){

        return service.editCountry(id,newCountry);
    }
}
