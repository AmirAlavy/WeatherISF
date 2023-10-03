package com.weatherisf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    Button cityID, cityName,weatherID,weatherName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        cityID=findViewById(R.id.find_city_ID);
        cityName=findViewById(R.id.find_city_name);
        weatherID=findViewById(R.id.weather_by_ID);
        weatherName=findViewById(R.id.weather_by_name);


//button method for read cityId from Json
        cityID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //codes of read cityId from Json
                Toast.makeText(FirstActivity.this, "you clicked on  "+ cityID.getText().toString() , Toast.LENGTH_SHORT).show();
            }
        });

//button method for read city name
        cityName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //codes of read city name from Json
                Toast.makeText(FirstActivity.this, "you clicked on " + cityName.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

//button method for weather by city
        weatherID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //codes of read weather by city id from Json
                Toast.makeText(FirstActivity.this, "you clicked on "+ weatherID.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

//button method for weather by cityId
        weatherName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //codes of read weather by cityId from Json
                Toast.makeText(FirstActivity.this, "you clicked on "+weatherName.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

}
}