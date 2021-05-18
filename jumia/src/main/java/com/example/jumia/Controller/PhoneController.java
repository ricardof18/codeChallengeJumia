package com.example.jumia.Controller;

import com.example.jumia.Entity.Country;
import com.example.jumia.Entity.Phone;
import com.example.jumia.Service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PhoneController {

    @Autowired
    private PhoneService service;

    @GetMapping(value = "/phones")
    public List<Phone> AllPhones() {
        return service.AllPhones();
    }

    @PostMapping(value = "/addPhone")
    public Phone AddPhone(@RequestBody Phone phone) {
        return service.AddPhone(phone);
    }

    @DeleteMapping("/deletePhone/{id}")
    public Phone removePhone(@PathVariable("id") int id){
        return service.removePhone(id);
    }

    @GetMapping(value = "/phonesByCountry")
    public List<Phone> SearchPhoneByCountry(@RequestParam("countryCode") String countryCode) {
        return service.SearchByCountry(countryCode);
    }

    @GetMapping(value = "/phonesByState")
    public List<Phone> SearchPhoneByState(@RequestParam("state") boolean state) {
        return service.SearchByState(state);
    }

    @GetMapping(value = "/phonesByCountryAndState")
    public List<Phone> SearchPhoneByCountryAndState(@RequestParam("countryCode") String countryCode, @RequestParam("state") boolean state) {
        return service.SearchByCountryCodeAndState(countryCode,state);
    }

    @PutMapping(value="/editPhone/{id}")
    public Phone EditPhone(@PathVariable("id") int id, @RequestBody Phone newPhone){
        return service.editPhone(id,newPhone);
    }
}
