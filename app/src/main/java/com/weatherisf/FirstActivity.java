package com.weatherisf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import me.tankery.lib.circularseekbar.CircularSeekBar;

public class FirstActivity extends AppCompatActivity {

    Button cityID, cityName,weatherID,weatherName;
    Button axel1,axel2,axel3,axel4;
    EditText InputText;
    TextView ReeadInfo;
    SeekBar seekBar;
    CircularSeekBar circleSeekBar;

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



                RequestQueue queue = Volley.newRequestQueue(FirstActivity.this);
                String url = "https://api.openweathermap.org/data/2.5/forecast?q="+ InputText.getText()  +"&appid=5a9b0e546a7ffaec83985026cfd7c183";

              JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                  @Override
                  public void onResponse(JSONObject response) {
                      try {
                          JSONObject city = response.getJSONObject("city");
                          String jcinyName = city.getString("name");
                          String country = city.getString("country");
                          ReeadInfo.setText(jcinyName.toString()+"\n"+country.toString());




                      } catch (JSONException e) {
                          Toast.makeText(FirstActivity.this, "the cod is error!", Toast.LENGTH_SHORT).show();
                      }


                  }
              }, new Response.ErrorListener() {
                  @Override
                  public void onErrorResponse(VolleyError error) {
                      Toast.makeText(FirstActivity.this, "Error", Toast.LENGTH_SHORT).show();
                  }
              });
              queue.add(jsonObjectRequest);




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