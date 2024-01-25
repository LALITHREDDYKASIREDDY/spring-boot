package com.example.geohub.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="country")
public class Country {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="countryid")
    private int countryId;
    @Column(name="countryname")
    private String countryName;
    @Column(name="currency")
    private String currency;
    @Column(name="population")
    private long population;
    @Column(name="lattitude")
    private String lattitude;
    @Column(name="longitude")
    private String longitude;

    public Country() {

    }

    public Country(int id, String countryName, String currency, long population, String lattitude, String longitude) {
        this.countryId = id;
        this.countryName = countryName;
        this.currency = currency;
        this.population = population;
        this.lattitude = lattitude;
        this.longitude = longitude;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getLattitude() {
        return lattitude;
    }

    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}