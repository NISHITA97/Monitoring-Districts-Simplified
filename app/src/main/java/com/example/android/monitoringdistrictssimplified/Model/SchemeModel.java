package com.example.android.monitoringdistrictssimplified.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Shiv Kumar Aggarwal on 27-03-2018.
 */

//[{"description":"scheme1description","category":"category1","name":"scheme1"}]
public class SchemeModel {
    @SerializedName("description")
    String description;
    @SerializedName("category")
    String category;
    @SerializedName("name")
    String name;

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
}
