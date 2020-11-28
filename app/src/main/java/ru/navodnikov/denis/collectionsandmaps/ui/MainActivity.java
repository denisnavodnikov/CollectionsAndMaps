package ru.navodnikov.denis.collectionsandmaps.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import ru.navodnikov.denis.collectionsandmaps.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.tool_bar));
        final ViewPager viewPager = findViewById(R.id.view_pager);
        final TabLayout tabLayout = findViewById(R.id.tab_layout);
        viewPager.setAdapter(new MainPageAdapter(getSupportFragmentManager(), this));
        tabLayout.setupWithViewPager(viewPager);

    }


}
