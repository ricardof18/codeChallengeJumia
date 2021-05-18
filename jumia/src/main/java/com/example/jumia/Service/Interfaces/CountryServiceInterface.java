package com.example.jumia.Service.Interfaces;

import com.example.jumia.Entity.Country;
import com.example.jumia.Entity.customer;

import java.util.List;

public interface CountryServiceInterface {

    public List<Country> getAllCountry();

    public Country addCountry(Country country);

    public Country removeCountry(int id);

    public Country editCountry(int id, Country newCountry);
}
