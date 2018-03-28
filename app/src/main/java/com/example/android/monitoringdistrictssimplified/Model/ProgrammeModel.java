package com.example.android.monitoringdistrictssimplified.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Shiv Kumar Aggarwal on 27-03-2018.
 */

//[{"pid":"1","name":"p1","description":"first programme"},{"pid":"2","name":"p2","description":"programme 2"}]

public class ProgrammeModel {
    @SerializedName("pid")
    String pid;
    @SerializedName("name")
    String name;
    @SerializedName("description")
    String description;

    public String getPid() {
        return pid;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
