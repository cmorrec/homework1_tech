package com.example.myapplication2;



import java.util.ArrayList;



public class DataSource  {

    public static final ArrayList<String> mData= new ArrayList<>();
    private static DataSource sInstance;
    static int mSize;



    private DataSource(int size) {
        for (int i = 1; i <= size; i++) {
            String title = String.valueOf(i);
            mData.add(title);
        }
    }


    public static void push(){
        mData.add(String.valueOf(++mSize));
    }

    public ArrayList<String> getData() {
        return mData;
    }

    public synchronized static DataSource getInstance(int size) {
        if (sInstance == null) {
            mSize=size;
            sInstance = new DataSource(mSize);
        }
        return sInstance;
    }
/*
    public static class MyData {

        public MyData(String title) {
            mTitle = title;
        }

        String mTitle;
    }*/
}
