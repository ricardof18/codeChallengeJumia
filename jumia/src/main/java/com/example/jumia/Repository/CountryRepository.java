package com.example.jumia.Repository;

import com.example.jumia.Entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {

    Country findByCountrycode(String countryCode);
    Country findById(int id);
}
