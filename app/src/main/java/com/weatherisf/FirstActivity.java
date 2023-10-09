package com.weatherisf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class FirstActivity extends AppCompatActivity {

    Button cityID, cityName,weatherID,weatherName;
    EditText InputText;
    TextView ReeadInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        cityID=findViewById(R.id.find_city_ID);
        cityName=findViewById(R.id.find_city_name);
        weatherID=findViewById(R.id.weather_by_ID);
        weatherName=findViewById(R.id.weather_by_name);
        InputText=findViewById(R.id.Input_Text);
        ReeadInfo=findViewById(R.id.read_Info);


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


// Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(FirstActivity.this);
                String url = "https://api.openweathermap.org/data/2.5/forecast?lat=25.761681&lon=-80.191788&appid=5a9b0e546a7ffaec83985026cfd7c183";

// Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // Display the first 500 characters of the response string.

                                ReeadInfo.setText(response);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(FirstActivity.this, "error occurred" , Toast.LENGTH_SHORT).show();
                        ReeadInfo.setText("Response is get error during request  " );

                    }
                });

// Add the request to the RequestQueue.
                queue.add(stringRequest);


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
                Toast.makeText(FirstActivity.this, "you clicked on " + weatherName.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

}
}