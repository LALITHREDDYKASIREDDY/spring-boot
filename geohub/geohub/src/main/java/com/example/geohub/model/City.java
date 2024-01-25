package com.example.geohub.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cityid")
    private int cityId;
    @Column(name="cityname")
    private String cityName;
    @Column(name="currency")
    private String currency;
    @Column(name="population")
    private long population;
    @Column(name="lattitude")
    private String lattitude;
    @Column(name="longitude")
    private String longitude;


    @ManyToOne
    @JoinColumn(name="countryId")
    private Country country;

    public City() {

    }

    public City(int id, String cityName, String currency, long population, String lattitude, String longitude) {
        this.cityId = id;
        this.cityName = cityName;
        this.currency = currency;
        this.population = population;
        this.lattitude = lattitude;
        this.longitude = longitude;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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

    public Country getCountry(){
        return country;
    }
    public void setCountry(Country country){
        this.country=country;
    }
}
