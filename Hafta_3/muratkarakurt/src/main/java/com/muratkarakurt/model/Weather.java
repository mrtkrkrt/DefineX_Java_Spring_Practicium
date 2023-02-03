package com.muratkarakurt.model;

public class Weather {

    private String country;
    private String city;
    private String days;

    public Weather(String country, String city, String days) {
        this.country = country;
        this.city = city;
        this.days = days;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getdays() {
        return days;
    }

    public void setdays(String days) {
        this.days = days;
    }
}
