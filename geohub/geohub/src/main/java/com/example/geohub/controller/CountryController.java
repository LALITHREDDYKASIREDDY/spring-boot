package com.example.geohub.controller;

import com.example.geohub.model.*;
import com.example.geohub.service.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.PutMapping;








@RestController
public class CountryController {
    @Autowired
    private CountryService s;
    @GetMapping("/countries")
    public ArrayList<Country> getMethodName() {
       return s.getCountries();
    }
    @PostMapping("/countries")
    public Country postMethodName(@RequestBody Country country) {
        return s.addCountry(country);
    }
    @GetMapping("/countries/{countryId}")
    public Country getMethodName(@PathVariable("countryId") int id) {
        return s.getCountryById(id);
    }
    @PutMapping("/countries/{countryId}")
    public Country putMethodName(@RequestBody Country country,@PathVariable("countryId") int id) {
       
        return s.updateCountry(country, id);
    }
    @DeleteMapping("/countries/{countryId}")
    public void deleteCountry(@PathVariable("countryId") int id)
    {
        s.deleteCountry(id);
    }
 
    
}
