package com.example.jumia.Service.Interfaces;

import com.example.jumia.Entity.Phone;

import java.util.List;

public interface PhoneServiceInterface {

    public List<Phone> AllPhones();

    public Phone AddPhone(Phone phone);

    public Phone removePhone(int id);

    public List<Phone> SearchByCountry(String countryCode);

    public List<Phone> SearchByState(boolean state);

    public List<Phone> SearchByCountryCodeAndState(String countryCode, boolean state);

    public Phone editPhone(int id, Phone newPhone);
}
