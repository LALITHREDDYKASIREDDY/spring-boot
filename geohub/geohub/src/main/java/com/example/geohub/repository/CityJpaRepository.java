package com.example.geohub.repository;

import com.example.geohub.model.*;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CityJpaRepository extends JpaRepository<City, Integer> {
    ArrayList<City> findByCountry(Country country);
}