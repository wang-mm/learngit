package com.example.gouwu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class animal {
    private int imageId;
    private String name;
    private String introduce;

    public animal(int imageId,String name,String introduce){
        this.imageId = imageId;
        this.name = name;
        this.introduce = introduce;
    }
    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getIntroduce() {
        return introduce;
    }
}