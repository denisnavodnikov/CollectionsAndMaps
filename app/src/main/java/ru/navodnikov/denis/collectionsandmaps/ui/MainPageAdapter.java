package ru.navodnikov.denis.collectionsandmaps.ui;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.ui.benchmark.AbstractFragment;
import ru.navodnikov.denis.collectionsandmaps.ui.benchmark.Constants;

public class MainPageAdapter extends FragmentPagerAdapter {


    private String[] titles;

    public MainPageAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        titles = context.getResources().getStringArray(R.array.tab_title);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position== Constants.PAGE_COLLECTIONS){
            return AbstractFragment.newInstance(Constants.PAGE_COLLECTIONS);
        }
        else if (position== Constants.PAGE_MAPS){
            return AbstractFragment.newInstance(Constants.PAGE_MAPS);
        }
        return null;
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
