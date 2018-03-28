package com.example.android.monitoringdistrictssimplified.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.android.monitoringdistrictssimplified.Adapters.ProgrammeAdapter;
import com.example.android.monitoringdistrictssimplified.Model.ProgrammeModel;
import com.example.android.monitoringdistrictssimplified.R;
import com.example.android.monitoringdistrictssimplified.Service.RetroFitInstanceLogin;
import com.example.android.monitoringdistrictssimplified.Service.getDataService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProgrammeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgrammeAdapter adapter;
    private ArrayList<ProgrammeModel> programmeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programme);
        getDataService service = RetroFitInstanceLogin.getRetrofitInstance().create(getDataService.class);
        Call<ArrayList<ProgrammeModel>> call = service.getProgrammeList();
        Log.wtf("URL Called", call.request().url() + "");
        call.enqueue(new Callback<ArrayList<ProgrammeModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ProgrammeModel>> call, Response<ArrayList<ProgrammeModel>> response) {
                Log.wtf("url","success!");
               generateProgrammeList(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<ProgrammeModel>> call, Throwable t) {
                Log.wtf("error: ",t.toString());
                Toast.makeText(ProgrammeActivity.this,"Something Went Wrong!",Toast.LENGTH_LONG).show();
            }
        });

    }

    public void generateProgrammeList(ArrayList<ProgrammeModel> dataList)
    {
        recyclerView = findViewById(R.id.recyclerView_programems);
        programmeList =dataList;
        adapter = new ProgrammeAdapter(programmeList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ProgrammeActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
