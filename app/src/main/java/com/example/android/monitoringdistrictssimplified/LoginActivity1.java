package com.example.android.monitoringdistrictssimplified;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Nishita Aggarwal on 15-03-2018.
 */

public class LoginActivity1 extends AppCompatActivity  {
    EditText username,password;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("onCretae","cfjjd");
        super.onCreate(savedInstanceState);


        Log.e("supe","rres");
        Intent intent=getIntent();
        Log.e("creating Activity", "login1");
        setContentView(R.layout.activity_login1);

        submit=findViewById(R.id.button_submit);
        username=findViewById(R.id.edit_text_username);
        password=findViewById(R.id.edit_text_password);
        Log.e("created Activity", "login1");
    }

}
