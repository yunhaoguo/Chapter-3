package com.example.chapter3.homework;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Author: yunhaoguo
 * Date: 2019-07-25
 * The adapter for view pager in friend list fragment
 */
public class MyViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    private static final String[] titles = {"好友列表", "我的好友"};

    public MyViewPagerAdapter(List<Fragment> fragments, FragmentManager fm) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
