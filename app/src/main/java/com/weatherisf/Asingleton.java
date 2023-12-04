package com.weatherisf;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class Asingleton {
    private static Asingleton AInstanse;
    private RequestQueue AreRequestQueue;
    private Asingleton(Context context){
        AreRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }
    public static synchronized Asingleton getInstance(Context context){
        if(AInstanse ==null){
            AInstanse = new Asingleton(context);

        }
        return AInstanse;
    }
    public RequestQueue getRequestQueue(){
        return AreRequestQueue;
    }
}
// singleton pattern:wrote in 26/11..aban29
