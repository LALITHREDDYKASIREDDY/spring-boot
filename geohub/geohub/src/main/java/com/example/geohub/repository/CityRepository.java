package com.example.geohub.repository;

import java.util.ArrayList;
import com.example.geohub.model.*;

public interface CityRepository {


    ArrayList<City> getCities();
    City addCity(City city);
    City getCityById(int id);
    City updateCityById(int id,City city);
    Country getCountryByCityId(int id);
    void  deleteCity(int id);
}