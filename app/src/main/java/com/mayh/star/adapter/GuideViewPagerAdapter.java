package com.mayh.star.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by mayanhua on 2018/5/20.
 * <p>
 * 引导页适配器
 */

public class GuideViewPagerAdapter extends PagerAdapter {
    private List<View> views;

    public GuideViewPagerAdapter(List<View> view) {
        super();
        this.views = view;
    }

    @Override
    public int getCount() {
        if (views != null)
            return views.size();
        return 0;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView(views.get(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ((ViewPager) container).addView(views.get(position), 0);
        return views.get(position);
    }
}
