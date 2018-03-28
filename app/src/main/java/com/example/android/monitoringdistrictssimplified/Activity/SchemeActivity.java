package com.example.android.monitoringdistrictssimplified.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.android.monitoringdistrictssimplified.Model.LoginModel;
import com.example.android.monitoringdistrictssimplified.Model.SchemeModel;
import com.example.android.monitoringdistrictssimplified.R;
import com.example.android.monitoringdistrictssimplified.Service.RetroFitInstanceLogin;
import com.example.android.monitoringdistrictssimplified.Service.getDataService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SchemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheme);
        Intent progIntent = getIntent();
        String pid = progIntent.getStringExtra("pid");
        Log.wtf("pid",pid);

        getDataService service = RetroFitInstanceLogin.getRetrofitInstance().create(getDataService.class);

        /*Call the method with parameter in the interface */
        Call<ArrayList<SchemeModel>> call = service.getSchemes(pid);

        call.enqueue(new Callback<ArrayList<SchemeModel>>() {
            @Override
            public void onResponse(Call<ArrayList<SchemeModel>> call, Response<ArrayList<SchemeModel>> response) {
                Log.wtf("response",response.body().get(0).getName()
                );
            }

            @Override
            public void onFailure(Call<ArrayList<SchemeModel>> call, Throwable t) {
                Log.wtf("Error: ",t.toString());
                Toast.makeText(SchemeActivity.this,"Something Went Wrong!",Toast.LENGTH_LONG).show();
            }
        });
    }
}
