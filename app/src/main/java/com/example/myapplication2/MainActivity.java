package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity implements ListFragment.OnItemSelectedListener {


    private View mView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mView = findViewById(R.id.top_container);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.top_container, new ListFragment())
                    .commit();

        }

    }
    public void onItemSelected(int data, int color){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.top_container,  SecondFragment.newInstance(data, color))
                .addToBackStack(null)
                .commit();
    }




}

