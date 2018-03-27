package com.example.mansisharma.location6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mansisharma.location6.Model.LoginModel;
import com.example.mansisharma.location6.R;
import com.example.mansisharma.location6.Service.RetroFitInstanceLogin;
import com.example.mansisharma.location6.Service.getLoginDataService;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//http://localhost:8080/mavenproject1/webapi/myresource/1/ashima
//[{"designation":"desog","ans":"success"}]

public class LoginActivity extends AppCompatActivity {

    EditText username,password;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        submit=findViewById(R.id.button_submit);
        username=findViewById(R.id.edit_text_username);
        password=findViewById(R.id.edit_text_password);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //login();
                Intent toProfile = new Intent(LoginActivity.this, ProfileActivity.class);
                startActivity(toProfile);
            }
        });
    }

    private void login()
    {
        String uname = username.getText().toString();
        String passwordString = password.getText().toString();
        Log.wtf("password",passwordString);
        /*Create handle for the RetrofitInstance interface*/
        getLoginDataService service = RetroFitInstanceLogin.getRetrofitInstance().create(getLoginDataService.class);

        /*Call the method with parameter in the interface */
        Call<ArrayList<LoginModel>> call = service.getLocationList(uname,passwordString);
        //Call<ArrayList<LoginModel>> call = service.getLocationList(uname,passwordString);
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<ArrayList<LoginModel>>() {
            @Override
            public void onResponse(Call<ArrayList<LoginModel>> call, Response<ArrayList<LoginModel>> response) {
                Log.wtf("response",response.body().toString());
                String desig = response.body().get(0).getDesignation();
                String ans = response.body().get(0).getAns();
                Log.wtf("on response", desig);
                Log.wtf("on response", ans);
                Toast.makeText(LoginActivity.this,"designation: " + desig + "  " + ans ,Toast.LENGTH_LONG).show();
                if(ans.equals("success")) {
                    Intent toProfile = new Intent(LoginActivity.this, ProfileActivity.class);
                    startActivity(toProfile);
                }
            }
            @Override
            public void onFailure(Call<ArrayList<LoginModel>> call, Throwable t) {
                Log.wtf("on response Failure",t.toString());
                Toast.makeText(LoginActivity.this, "Something went wrong.", Toast.LENGTH_SHORT).show();

            }
        });
    }


}
