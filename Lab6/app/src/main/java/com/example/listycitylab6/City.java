package com.example.listycitylab6;

import java.util.Objects;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City> {
    private String city;
    private String province;

    /**
     * Constructs a City object with a name and a province.
     * @param city     The name of the city
     * @param province The name of the province
     */
    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * This method retrieves the city name
     * @return Return the city name
     */
    String getCityName(){
        return this.city;
    }

    /**
     * This method retrieves the province name
     * @return Return the province name
     */
    String getProvinceName(){
        return this.province;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        City city1 = (City) o;
        return Objects.equals(city, city1.city) && Objects.equals(province, city1.province);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }

    /**
     * Compares this city with another city by name.
     * @param city the object to be compared.
     * @return a negative integer, zero, or a positive integer as this city name is less than, equal to, or greater than the specified city name.
     */
    @Override
    public int compareTo(City city) {
        return this.city.compareTo(city.getCityName());
    }
}
