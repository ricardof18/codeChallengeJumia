package com.example.jumia.Service;

import com.example.jumia.Entity.Phone;
import com.example.jumia.Entity.customer;
import com.example.jumia.Repository.PhoneRepository;
import com.example.jumia.Service.Interfaces.PhoneServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneService implements PhoneServiceInterface {

    @Autowired
    private PhoneRepository repository;

    @Override
    public List<Phone> AllPhones(){

        return repository.findAll();
    }

    @Override
    public Phone AddPhone(Phone phone){
        return repository.save(phone);
    }

    @Override
    public Phone removePhone(int id){
        repository.deleteById(id);
        return repository.findById(id);
    }

    @Override
    public List<Phone> SearchByCountry(String countryCode) {


        return repository.findByCountrycode(countryCode);

    }

    @Override
    public List<Phone> SearchByState(boolean state){
        return repository.findByState(state);
    }

    @Override
    public List<Phone> SearchByCountryCodeAndState(String countryCode, boolean state){
        return repository.findByCountrycodeAndState(countryCode, state);
    }

    @Override
    public Phone editPhone(int id, Phone newPhone) {
        Phone phone=repository.findById(id);

        phone.setCountrycode(newPhone.getCountrycode());
        phone.setCountry(newPhone.getCountry());
        phone.setName(newPhone.getName());
        phone.setNumber(newPhone.getNumber());
        phone.setState(newPhone.getState());

        return repository.save(phone);
    }


}
