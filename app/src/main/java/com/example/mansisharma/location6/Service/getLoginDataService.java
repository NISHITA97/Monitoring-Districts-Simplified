package com.example.mansisharma.location6.Service;
import com.example.mansisharma.location6.Model.LoginModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Nishita Aggarwal on 22-03-2018.
 */

public interface getLoginDataService {
    //https://sih-login-api.herokuapp.com/webapi/myresource/1/ashima
    ///http://localhost:8080/mavenproject1/webapi/myresource/1/ashima
    @GET("myresource/{username}/{password}")
    Call<ArrayList<LoginModel>> getLocationList(@Path("username") String username, @Path("password") String password);

}
