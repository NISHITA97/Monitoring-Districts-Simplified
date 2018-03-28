package com.example.mansisharma.location6.Service;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nishita Aggarwal on 22-03-2018.
 */

public class RetroFitInstanceLogin {
        private static Retrofit retrofit;
        static String url="https://sih-login-api.herokuapp.com/webapi/";
        static String url2= "http://192.168.0.3:8080/mavenproject1/webapi/";
        public static Retrofit getRetrofitInstance() {
            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(url2)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            Log.wtf("url==",retrofit.baseUrl().toString());
            return retrofit;
        }


}
