package com.weatherisf;

import com.airbnb.lottie.LottieAnimationView;

public  class LottieCustomMtd {
    public static void myLottieDelaySlow(LottieAnimationView lottieAnimationView){
        lottieAnimationView.postDelayed(new Runnable() {

            @Override
            public void run() {
                lottieAnimationView.playAnimation();
                float range = 0.3f;
                float mayRand = (float) (Math.random() * range ) + 0.7f;
                lottieAnimationView.setSpeed(mayRand);
            }
        },(int) (Math.random()* 3000)+1);
    }
}
