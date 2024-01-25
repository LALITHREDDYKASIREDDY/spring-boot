package com.example.geohub.repository;

import com.example.geohub.model.*;
import java.util.ArrayList;

public interface CountryRepository {
  ArrayList<Country> getCountries();
  Country addCountry(Country country);
  Country getCountryById(int id);
  Country updateCountry(Country country, int id);
  void deleteCountry(int id);
} 

