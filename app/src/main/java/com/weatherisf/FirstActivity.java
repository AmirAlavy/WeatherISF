package com.weatherisf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import com.skydoves.balloon.ArrowOrientation;
import com.skydoves.balloon.ArrowPositionRules;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;
import com.skydoves.balloon.BalloonSizeSpec;

import org.json.JSONObject;

public class FirstActivity extends AppCompatActivity {
    JSONObject allRequest=null;
    Button cityName;
    EditText inputText,inputIndex;
    // design in 2023/11/27 ya 06azar
    TextView time1,time2,time3,time4,time5,time6,time7,time8;
    TextView date1,date2,date3,date4,date5,date6,date7,date8;
    TextView description1,description2,description3,description4,description5,description6,description7,description8;
    TextView temp1,temp2,temp3,temp4,temp5,temp6,temp7,temp8;
//******************
    TextView ReeadInfo;
    LottieAnimationView lo1,lo2,lo3,lo4,lo5,lo6,lo7,lo8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        cityName=findViewById(R.id.find_city_name);
        inputText =findViewById(R.id.Input_Text);
        inputIndex= findViewById(R.id.index_of_jsonArray);
        ReeadInfo=findViewById(R.id.read_Info);

        

        //Lottie List
        lo1=findViewById(R.id.lottie01);
        lo2=findViewById(R.id.lottie02);
        lo3=findViewById(R.id.lottie03);
        lo4=findViewById(R.id.lottie04);
        lo5=findViewById(R.id.lottie05);
        lo6=findViewById(R.id.lottie06);
        lo7=findViewById(R.id.lottie07);
        lo8=findViewById(R.id.lottie08);
        LottieAnimationView[] loList={lo1,lo2,lo3,lo4,lo5,lo6,lo7,lo8};

        //time List
        time1=findViewById(R.id.time1);
        time2=findViewById(R.id.time2);
        time3=findViewById(R.id.time3);
        time4=findViewById(R.id.time4);
        time5=findViewById(R.id.time5);
        time6=findViewById(R.id.time6);
        time7=findViewById(R.id.time7);
        time8=findViewById(R.id.time8);
        TextView[] timeList ={time1,time2,time3,time4,time5,time6,time7,time8};


        //date List
        date1=findViewById(R.id.date1);
        date2=findViewById(R.id.date2);
        date3=findViewById(R.id.date3);
        date4=findViewById(R.id.date4);
        date5=findViewById(R.id.date5);
        date6=findViewById(R.id.date6);
        date7=findViewById(R.id.date7);
        date8=findViewById(R.id.date8);
        TextView[] dateList = {date1,date2,date3,date4,date5,date6,date7,date8};

        //description List
        description1=findViewById(R.id.description1);
        description2=findViewById(R.id.description2);
        description3=findViewById(R.id.description3);
        description4=findViewById(R.id.description4);
        description5=findViewById(R.id.description5);
        description6=findViewById(R.id.description6);
        description7=findViewById(R.id.description7);
        description8=findViewById(R.id.description8);
        TextView descriptionList[] = {description1, description2,description3,description4,description5,description6,description7,description8};

        //temp List
         temp1 = findViewById(R.id.temp1);
         temp2 = findViewById(R.id.temp2);
         temp3 = findViewById(R.id.temp3);
         temp4 = findViewById(R.id.temp4);
         temp5 = findViewById(R.id.temp5);
         temp6 = findViewById(R.id.temp6);
         temp7 = findViewById(R.id.temp7);
         temp8 = findViewById(R.id.temp8);
        TextView[] tempList = {temp1, temp2, temp3, temp4, temp5, temp6, temp7, temp8};




        WdataSevice wdataSevice = new WdataSevice(FirstActivity.this);

        cityName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                balloon idea in 1/12 ya azar10
                if (!inputIndex.getText().toString().trim().isEmpty()){
                    if(
                    Integer.parseInt(inputIndex.getText().toString()) >= 0 &&
                    Integer.parseInt(inputIndex.getText().toString()) < 33 ) {


                    // singleton pattern:write in 26/11
//                WdataSevice refator in 27/11

                    ReeadInfo.setText("Click Accepted");

                    wdataSevice.cityID(inputText.getText().toString().trim(), new WdataSevice.VolleyResponseListener() {
                        @Override
                        public void onResponse(String s) {
                            ReeadInfo.setText(s.toString());
                        }

                        @Override
                        public void onError(String message) {

                            ReeadInfo.setText(message.toString());
                            Toast.makeText(FirstActivity.this, "Error in interFace", Toast.LENGTH_SHORT).show();


                        }
                    });
                    int jsonIndex = Integer.parseInt(inputIndex.getText().toString());
                    RequestQueue requestQueue = Asingleton.getInstance(FirstActivity.this).getRequestQueue();
                    String url = "https://api.openweathermap.org/data/2.5/forecast?q=" + inputText.getText().toString().trim() + "&appid=5a9b0e546a7ffaec83985026cfd7c183";
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            //  allRequest=response;
                            for (int i = 0; i < 8; i++) {
                                WdataSevice.setWeatherIndex(response, i +
                                        jsonIndex, timeList[i], dateList[i], descriptionList[i], tempList[i], loList[i]);

                            }


                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(FirstActivity.this, "ERROR inFitst Axtivity ", Toast.LENGTH_SHORT).show();
                        }

                    });

                    requestQueue.add(jsonObjectRequest);


//                   yesterday/:
//                WdataSevice.setWeatherIndex(InputText.getText().toString(),FirstActivity.this,1,time1,date1,description1,temp1,lo1);
//                  today : 2023/11/28 ya 7azar




                }
                    else {
                        calltooltip(getApplicationContext(), getResources().getString(R.string.balloon_hint), inputIndex);
                    }//else
                }//if 2

                else {
                    calltooltip(getApplicationContext(), getResources().getString(R.string.balloon_hint), inputIndex);
}//else
            }
        });



        LottieCustomMtd.myLottieDelaySlow(lo1);
        LottieCustomMtd.myLottieDelaySlow(lo2);
        LottieCustomMtd.myLottieDelaySlow(lo3);
        LottieCustomMtd.myLottieDelaySlow(lo4);
        LottieCustomMtd.myLottieDelaySlow(lo5);
        LottieCustomMtd.myLottieDelaySlow(lo6);
        LottieCustomMtd.myLottieDelaySlow(lo7);
        LottieCustomMtd.myLottieDelaySlow(lo8);


    }
     public static void calltooltip(Context context,String msg,EditText target){
         Balloon balloon = new Balloon.Builder(context)
                 .setArrowSize(8)
                 .setArrowOrientation(ArrowOrientation.TOP)
                 .setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR)
                 .setArrowPosition(0.5f)
                 .setWidth(BalloonSizeSpec.WRAP)
                 .setHeight(65)
                 .setTextSize(15f)
                 .setCornerRadius(4f)
                 .setAlpha(0.9f)
                 .setText(msg)
                 .setTextColor(context.getColor( R.color.white))
                 .setTextIsHtml(true)
                 .setBackgroundColor(context.getColor( R.color.darkBlue))

                 .setBalloonAnimation(BalloonAnimation.FADE)
                 .setAutoDismissDuration(5000L)
                 .setPadding(10)
                 .build();
         balloon.showAlignBottom(target);

     }
}
