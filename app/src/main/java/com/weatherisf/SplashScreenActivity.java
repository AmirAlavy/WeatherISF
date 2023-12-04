package com.weatherisf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.weatherisf.databinding.ActivityFirstBinding;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Handler handler= new Handler();
        Intent intent = new Intent(getApplicationContext(), FirstActivity.class);


        setContentView(R.layout.activity_splash_screen);
        ConstraintLayout constraintLayout = findViewById(R.id.SlashLayout);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{intent});
                finish();
            }
        });

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivities(new Intent[]{intent});
                finish();
            }
        },5000);
    }
}