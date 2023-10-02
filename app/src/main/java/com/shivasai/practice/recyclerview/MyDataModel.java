package com.shivasai.practice.recyclerview;

public class MyDataModel {

    private final int imageResource;
    private final String text;

    public MyDataModel(int imageResource, String text) {
        this.imageResource = imageResource;
        this.text = text;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getText() {
        return text;
    }
}

