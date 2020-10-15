package ru.navodnikov.denis.collectionsandmaps.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import ru.navodnikov.denis.collectionsandmaps.R;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private int currentPosition = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar((Toolbar) findViewById(R.id.tool_bar));

        final ViewPager viewPager = findViewById(R.id.view_pager);
        final TabLayout tabLayout = findViewById(R.id.tab_layout);
        viewPager.setAdapter(new MainPageAdapter(getSupportFragmentManager(), this));

        viewPager.addOnPageChangeListener(this);

        tabLayout.setupWithViewPager(viewPager);


    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        if(position==0){
            currentPosition = 1;
            Log.d("position", "Position = "+currentPosition);
        }
        else if(position==1){
            currentPosition = 2;
            Log.d("position", "Position = "+currentPosition);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
