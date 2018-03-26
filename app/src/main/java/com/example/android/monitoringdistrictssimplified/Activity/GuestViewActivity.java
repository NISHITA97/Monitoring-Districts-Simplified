package com.example.android.monitoringdistrictssimplified.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.monitoringdistrictssimplified.R;

public class GuestViewActivity extends AppCompatActivity {

    private Button button_view_programme, button_view_map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_view);
        button_view_map=findViewById(R.id.button_view_map);
        button_view_programme=findViewById(R.id.button_view_programmes);
        button_view_programme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent programmeActivity = new Intent(GuestViewActivity.this,ProgrammeActivity.class);
                startActivity(programmeActivity);
            }
        });
    }
}
