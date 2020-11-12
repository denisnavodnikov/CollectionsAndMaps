package ru.navodnikov.denis.collectionsandmaps.ui;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.core.Collections;
import ru.navodnikov.denis.collectionsandmaps.core.Maps;
import ru.navodnikov.denis.collectionsandmaps.ui.benchmark.AbstractFragment;
import ru.navodnikov.denis.collectionsandmaps.ui.benchmark.CollectionsFragment;
import ru.navodnikov.denis.collectionsandmaps.ui.benchmark.MapsFragment;

public class MainPageAdapter extends FragmentPagerAdapter {

    public static final int PAGE_COLLECTIONS = 0;
    public static final int PAGE_MAPS = 1;

    private String[] titles;

    public MainPageAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm);
        titles = context.getResources().getStringArray(R.array.tab_title);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==PAGE_COLLECTIONS){
            return AbstractFragment.newInstance(PAGE_COLLECTIONS);
        }
        else if (position==PAGE_MAPS){
            return AbstractFragment.newInstance(PAGE_MAPS);
        }
        return new CollectionsFragment();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }


}
