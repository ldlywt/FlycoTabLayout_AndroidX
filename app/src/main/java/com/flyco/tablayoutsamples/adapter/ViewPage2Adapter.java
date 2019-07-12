package com.flyco.tablayoutsamples.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

/**
 * author : wutao
 * e-mail : wutao@himango.cn
 * time   : 2019/07/12
 * desc   :
 * version: 1.0
 */
public class ViewPage2Adapter extends FragmentStateAdapter {

    private List<Fragment> mFragments;

    public ViewPage2Adapter(@NonNull FragmentActivity fragmentActivity, List<Fragment> fragments) {
        super(fragmentActivity);
        mFragments = fragments;

    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getItemCount() {
        return mFragments.size();
    }
}

