package ru.navodnikov.denis.collectionsandmaps;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MainPageAdapter extends FragmentPagerAdapter {
    private static final int PAGE_COLLECTIONS = 0;
    private static final int PAGE_MAPS = 1;
    private String[] titles;

    public MainPageAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm);
        titles = context.getResources().getStringArray(R.array.tab_title);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==PAGE_COLLECTIONS){
            return createMyFragment(MyFragment.TYPE_COLLECTIONS);
        }
        else if (position==PAGE_MAPS){
            return createMyFragment(MyFragment.TYPE_MAPS);
        }
        return new Fragment();

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
    private static MyFragment createMyFragment(int type){
        MyFragment fragment = new MyFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(MyFragment.TYPE_KEY, type);
        fragment.setArguments(bundle);
        return  fragment;
    }

}
