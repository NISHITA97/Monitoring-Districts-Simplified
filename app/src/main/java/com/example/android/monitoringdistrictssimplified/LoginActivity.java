package com.example.android.monitoringdistrictssimplified;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.monitoringdistrictssimplified.Model.LoginModel;
import com.example.android.monitoringdistrictssimplified.Service.RetroFitInstanceLogin;
import com.example.android.monitoringdistrictssimplified.Service.getLoginDataService;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;

public class LoginActivity extends AppCompatActivity {

    EditText username,password;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        setContentView(R.layout.activity_login);

        submit=findViewById(R.id.button_submit);
        username=findViewById(R.id.edit_text_username);
        password=findViewById(R.id.edit_text_password);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(isValidUser()) {
//                    Intent toProfile = new Intent(LoginActivity.this, ProfileActivity.class);
//                    startActivity(toProfile);
//                }
//                else{
//                    Toast.makeText(LoginActivity.this, "Invalid Username or passsowrd.", Toast.LENGTH_SHORT).show();
//                }
                isValidUser();
                Intent toProfile = new Intent(LoginActivity.this, ProfileActivity.class);
                startActivity(toProfile);
            }
        });
    }
   // boolean chkgloabal;
    boolean isValidUser()
    {
        String uname = username.getText().toString();
        String passwordString = password.getText().toString();
        Log.wtf("password",passwordString);
        //chkgloabal=false;
        /*Create handle for the RetrofitInstance interface*/
        getLoginDataService service = RetroFitInstanceLogin.getRetrofitInstance().create(getLoginDataService.class);

        /*Call the method with parameter in the interface */
        Call<ArrayList<LoginModel>> call = service.getLocationList(uname,passwordString);
        Log.wtf("URL Called", call.request().url() + "");
        try {
            ArrayList<LoginModel> result = call.execute().body();
            String ans = result.get(0).getAns();
            if(ans.equals("success")) {
                return  true;

            }
            Log.wtf("ans", ans);
        } catch (IOException e) {
            Log.wtf("error:" , e.toString());
            e.printStackTrace();
        }


//        call.enqueue(new Callback<ArrayList<LoginModel>> () {
//            @Override
//            public void onResponse(Call<ArrayList<LoginModel>> call, Response<ArrayList<LoginModel>> response) {
//                String desig = response.body().get(0).getDesignation();
//                String ans = response.body().get(0).getAns();
//                Log.wtf("on response", desig);
//                Log.wtf("on response", ans);
//                Toast.makeText(LoginActivity.this,desig + "  " + ans,Toast.LENGTH_LONG).show();
//                if(ans.equals("success")) {
//                    setChkgloabal();
//                }
//            }
//            @Override
//            public void onFailure(Call<ArrayList<LoginModel>> call, Throwable t) {
//                Log.wtf("on response Failure",t.toString());
//                Toast.makeText(LoginActivity.this, "Something went wrong.", Toast.LENGTH_SHORT).show();
//            }
//        });
        return false;
    }

}
