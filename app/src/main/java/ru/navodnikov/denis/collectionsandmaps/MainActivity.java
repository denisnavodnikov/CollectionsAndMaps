package ru.navodnikov.denis.collectionsandmaps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        MainPageAdapter pageAdapter = new MainPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageAdapter);

    }


}