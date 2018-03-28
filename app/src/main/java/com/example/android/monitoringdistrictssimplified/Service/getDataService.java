package com.example.android.monitoringdistrictssimplified.Service;

import com.example.android.monitoringdistrictssimplified.Model.LoginModel;
import com.example.android.monitoringdistrictssimplified.Model.ProgrammeModel;
import com.example.android.monitoringdistrictssimplified.Model.SchemeModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Nishita Aggarwal on 22-03-2018.
 */

public interface getDataService {
    //https://sih-login-api.herokuapp.com/webapi/myresource/1/ashima
    ///http://localhost:8080/mavenproject1/webapi/myresource/1/ashima
    @GET("myresource/{username}/{password}")
    Call<ArrayList<LoginModel>> getLocationList(@Path("username") String username, @Path("password") String password);

    //http://localhost:8080/mavenproject1/webapi/programmee
    @GET("programmee")
    Call<ArrayList<ProgrammeModel>> getProgrammeList();

    @GET("programmee/{pid}")
    Call<ArrayList<SchemeModel>> getSchemes(@Path("pid")String pid);

}
