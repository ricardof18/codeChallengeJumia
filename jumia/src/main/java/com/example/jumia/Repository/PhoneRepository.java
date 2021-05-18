package com.example.jumia.Repository;

import com.example.jumia.Entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,Integer> {

    Phone findById(int id);

    List<Phone> findByCountrycode(String countryCode);

    List<Phone> findByState(boolean state);

    List<Phone> findByCountrycodeAndState(String countryCode, boolean state);
}
