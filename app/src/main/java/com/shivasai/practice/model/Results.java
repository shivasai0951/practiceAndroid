package com.shivasai.practice.model;

import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("realname")
    public String superName;


    public Results(String name) {
        this.superName = name;
    }

    public String getName() {
        return superName;
    }
}
