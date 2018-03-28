package com.example.mansisharma.location6.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nishita Aggarwal on 22-03-2018.
 */

public class LoginModel {
    @SerializedName("designation")
    String designation;
    @SerializedName("ans")
    String ans;

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getAns() {
        return ans;
    }
}
