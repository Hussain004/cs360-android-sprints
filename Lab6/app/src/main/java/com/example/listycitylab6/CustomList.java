package com.example.listycitylab6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.content, parent, false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;
    }

    /**
     * this function will get the size of list
     * @return
     */
    public int getCount(){
        return cities.size();
    }

    /**
     * This function will add a city object into the list
     * @param city The city to add
     * @throws IllegalArgumentException if the city already exists in the list
     */
    public void addCity(City city){
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This checks if a city is in the list
     * @param city
     * @return
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * This deletes a city from the list if it exists
     * @param city
     */
    public void delete(City city) {
        if (cities.contains(city)) {
            cities.remove(city);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This counts the cities in the list
     * @return
     */
    public int countCities() {
        return cities.size();
    }

    /**
     * This returns a sorted list of cities
     * @return Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }
}
