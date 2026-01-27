package com.example.listycity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;
    Button addCityButton;
    Button deleteCityButton;
    Button confirmCityButton;
    EditText cityNameEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityList = findViewById(R.id.city_list);
        addCityButton = findViewById(R.id.button_add);
        deleteCityButton = findViewById(R.id.button_delete);
        confirmCityButton = findViewById(R.id.button_confirm);
        cityNameEditText = findViewById(R.id.edit_text_name);

        String []cities = {"Edmonton", "Vancouver", "Moscow", "Sydney", "Berlin", "Vienna", "Tokyo", "Beijing", "Osaka", "New Delhi"};

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

        confirmCityButton.setOnClickListener(v -> {
            String cityName = cityNameEditText.getText().toString();
            if (!cityName.isEmpty()) {
                dataList.add(cityName); // adding to array
                cityAdapter.notifyDataSetChanged(); // telling the adapter to update the UI
                cityNameEditText.setText(""); // clearing the input
            }
        });

        // variable to keep track of selection
        final int[] selectedPosition = {-1};

        cityList.setOnItemClickListener((adapterView, view, position, id) -> {
            selectedPosition[0] = position; // clicked index
        });

        deleteCityButton.setOnClickListener(v -> {
            if (selectedPosition[0] != -1) {
                dataList.remove(selectedPosition[0]); // remove from list
                cityAdapter.notifyDataSetChanged(); // refresh UI
                selectedPosition[0] = -1; // reset selection
            }
        });

        // show input field when ADD CITY is pressed
        addCityButton.setOnClickListener(v -> {
            cityNameEditText.setVisibility(View.VISIBLE);
            confirmCityButton.setVisibility(View.VISIBLE);
        });

        // hide the input field after CONFIRM is pressed
        confirmCityButton.setOnClickListener(v -> {
            String cityName = cityNameEditText.getText().toString();
            if (!cityName.isEmpty()) {
                dataList.add(cityName); // adding array
                cityAdapter.notifyDataSetChanged(); // updating UI

                cityNameEditText.setText("");
                cityNameEditText.setVisibility(View.GONE);
                confirmCityButton.setVisibility(View.GONE);
            }
        });
    }
}