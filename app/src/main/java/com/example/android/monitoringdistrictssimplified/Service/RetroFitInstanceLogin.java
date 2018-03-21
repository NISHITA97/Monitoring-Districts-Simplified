package com.example.android.monitoringdistrictssimplified.Service;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nishita Aggarwal on 22-03-2018.
 */

public class RetroFitInstanceLogin {
        private static Retrofit retrofit;
        static String url="https://sih-login-api.herokuapp.com/webapi/";
        public static Retrofit getRetrofitInstance() {
            if (retrofit == null) {
                retrofit = new retrofit2.Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            Log.wtf("url==",retrofit.baseUrl().toString());
            return retrofit;
        }


}
