package com.example.geohub.service;

import java.util.*;
import com.example.geohub.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.geohub.repository.*;

@Service
public class CityService implements CityRepository{
    @Autowired
    CityJpaRepository cityJpaRepository;

    @Autowired
    CountryJpaRepository countryJpaRepository;
    
    @Override
    public ArrayList<City> getCities(){

        List<City> cities= cityJpaRepository.findAll();
        ArrayList<City>  citylist= new ArrayList<>(cities);
        return citylist;
    } 
    @Override
    public City addCity(City city){
        try{
            System.out.println("3");
            int id=city.getCountry().getCountryId();
            System.out.println(id);
            Country country=countryJpaRepository.findById(id).get();
            System.out.println(country);
            city.setCountry(country);
            System.out.println(5);
            cityJpaRepository.save(city);
           return city;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public City getCityById(int id){
        try{
            City city=cityJpaRepository.findById(id).get();
           return city;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public City updateCityById(int id, City city){
        try{
            City orginal=cityJpaRepository.findById(id).get();
            if(city.getCityName()!=null){
                orginal.setCityName(city.getCityName());
            }
          
            if(city.getLatitude()!=null){
                orginal.setLatitude(city.getLatitude());
            }
            if(city.getLongitude()!=null){
                orginal.setLongitude(city.getLongitude());
            }
             if(city.getPopulation()!=0){
                orginal.setPopulation(city.getPopulation());
             }
             if(city.getCountry()!=null){
                int countryId=city.getCountry().getCountryId();
                Country country=countryJpaRepository.findById(countryId).get();
                orginal.setCountry(country);
                
             }
             cityJpaRepository.save(orginal);
           
           return orginal;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
  @Override
  public Country getCountryByCityId(int id){
    try{
          City city=cityJpaRepository.findById(id).get();
          int countryId=city.getCountry().getCountryId();
          Country country=countryJpaRepository.findById(countryId).get();
          return country;
    }
    catch(Exception e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }

  @Override 
  public void  deleteCity(int id){
      try{
         City city=cityJpaRepository.findById(id).get();
         cityJpaRepository.deleteById(id);
      }
      catch(Exception e){
          throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }
  }

}