package com.example.listycitylab6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList mockCityList() {
        CustomList list = new CustomList(null, new ArrayList<>());
        list.addCity(mockCity());
        return list;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    private CustomList list;

    @BeforeEach
    public void createList() {
        list = new CustomList(null, new ArrayList<>());
    }

    @Test
    public void addCityTest() {
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(listSize + 1, list.getCount());
    }

    @Test
    public void hasCityTest() {
        City city = new City("Regina", "SK");
        assertFalse(list.hasCity(city));
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    @Test
    public void deleteCityTest() {
        City city = new City("Saskatoon", "SK");
        list.addCity(city);
        assertEquals(1, list.getCount());
        list.delete(city);
        assertEquals(0, list.getCount());
        assertFalse(list.hasCity(city));
    }

    @Test
    public void deleteCityExceptionTest() {
        City city = new City("Yellowknife", "NT");
        assertThrows(IllegalArgumentException.class, () -> {
            list.delete(city);
        });
    }

    @Test
    public void countCitiesTest() {
        assertEquals(0, list.countCities());
        list.addCity(new City("Calgary", "AB"));
        assertEquals(1, list.countCities());
        list.addCity(new City("Edmonton", "AB"));
        assertEquals(2, list.countCities());
    }

    @Test
    public void testGetCities() {
        CustomList cityList = mockCityList();
        
        // this checks if the first city in the cityList is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        
        // this pushes down the original city 
        City city = new City("Charlottetown", "PE");
        cityList.addCity(city);
        
        // now the original city should be at position 1 and the new city at 0
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }
}
