package com.example.myapplication2;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;


public class DataSource  {

    private static final List<MyData> mData= new ArrayList<>();
    static int DEFAULT_SIZE = 100;
    private static DataSource sInstance;
    Context mContext;


    public DataSource() {




        for (int i = 1; i <= DEFAULT_SIZE; i++) {
            String title = String.valueOf(i);
            mData.add(new MyData(title));
        }
    }

    public static void push(){
        mData.add(new MyData(String.valueOf(++DEFAULT_SIZE)));
    }

    public List<MyData> getData() {
        return mData;
    }

    public synchronized static DataSource getInstance() {
        if (sInstance == null) {
            sInstance = new DataSource();
        }
        return sInstance;
    }

    public static class MyData {

        public MyData(String title) {
            mTitle = title;
        }

        String mTitle;
    }
}
