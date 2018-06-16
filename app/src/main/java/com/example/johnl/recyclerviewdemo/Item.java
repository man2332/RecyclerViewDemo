package com.example.johnl.recyclerviewdemo;

//Create a class to represent each item in the recycler view
public class Item {
    private int mResourceId;
    private String mText1;
    private String mText2;

    public Item(int mResourceId, String mText1, String mText2) {
        this.mResourceId = mResourceId;
        this.mText1 = mText1;
        this.mText2 = mText2;
    }

    public int getmResourceId() {
        return mResourceId;
    }

    public String getmText1() {
        return mText1;
    }

    public String getmText2() {
        return mText2;
    }
}
