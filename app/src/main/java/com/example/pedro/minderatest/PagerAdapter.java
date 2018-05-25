package com.example.pedro.minderatest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter{

    int numberTabs;

    public PagerAdapter(FragmentManager fm, int NumberOftabs){
        super(fm);
        this.numberTabs = NumberOftabs;
    }

    @Override
    public Fragment getItem(int position) {
        return Tab.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return numberTabs;
    }
}
