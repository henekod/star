package com.mayh.star.view.activity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author mayuhua
 * @date   2018/5/24
 *
 * @desc   viewPager适配器
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private List<Fragment> mFragments;

    public ViewPagerAdapter(FragmentManager fm, Context context, List<Fragment> fragment) {
        super(fm);
        this.mContext = context;
        this.mFragments = fragment;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
