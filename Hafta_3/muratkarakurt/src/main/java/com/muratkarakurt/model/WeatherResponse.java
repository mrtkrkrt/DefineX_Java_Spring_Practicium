package com.muratkarakurt.model;

import java.util.Date;

public class WeatherResponse {
    private String name;
    private String country;
    private String region;
    private Date localTime;
    private double temp_c;
    private double temp_f;
    private String condition;
    private double wind;
    private String icon;

    public WeatherResponse(String name, String country, String region, Date localTime, double temp_c, double temp_f, String condition, double wind, String icon) {
        this.name = name;
        this.country = country;
        this.region = region;
        this.localTime = localTime;
        this.temp_c = temp_c;
        this.temp_f = temp_f;
        this.condition = condition;
        this.wind = wind;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Date getLocalTime() {
        return localTime;
    }

    public void setLocalTime(Date localTime) {
        this.localTime = localTime;
    }

    public double getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(double temp_c) {
        this.temp_c = temp_c;
    }

    public double getTemp_f() {
        return temp_f;
    }

    public void setTemp_f(double temp_f) {
        this.temp_f = temp_f;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public double getWind() {
        return wind;
    }

    public void setWind(double wind) {
        this.wind = wind;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
