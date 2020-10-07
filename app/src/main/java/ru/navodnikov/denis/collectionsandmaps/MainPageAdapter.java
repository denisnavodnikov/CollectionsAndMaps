package ru.navodnikov.denis.collectionsandmaps;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MainPageAdapter extends FragmentPagerAdapter {
    public MainPageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new MyFragment();
        }
        else if (position==1){
            return new MyFragment();
        }
        return null;

    }

    @Override
    public int getCount() {
        return 2;
    }
}
