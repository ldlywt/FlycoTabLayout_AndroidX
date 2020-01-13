package com.flyco.tablayoutsamples.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.flyco.tablayout.DiyTabLayout;
import com.flyco.tablayout.TabItemBean;
import com.flyco.tablayoutsamples.R;
import com.flyco.tablayoutsamples.adapter.ViewPage2Adapter;

import java.util.ArrayList;
import java.util.List;

public class DiyItemActivity extends AppCompatActivity {
    private final String[] mTitles = {
            "热门", "iOS", "Android", "前端", "后端", "设计", "工具资源"};

    private final String[] mColors = {
            "#FF359A", "#01814A", "#0000E3", "#3D7878", "#9999CC", "#CE0000", "#FFFF37"};

    private ArrayList<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diy_item);
        DiyTabLayout tabLayout = findViewById(R.id.diy_tab_layout);
        ViewPager2 viewPager2 = findViewById(R.id.vp);

        for (String title : mTitles) {
            mFragments.add(SimpleCardFragment.getInstance(title));
        }
        ViewPage2Adapter adapter = new ViewPage2Adapter(this, mFragments);
        viewPager2.setAdapter(adapter);
        List<TabItemBean> tabList = new ArrayList<>();

        for (String title : mTitles) {
            TabItemBean bean = new TabItemBean();
            bean.setTitle(title);
            bean.setTitleColor(randomColor(mColors));
            bean.setTitleSelectedColor(randomColor(mColors));
            bean.setIndicatorColor(randomColor(mColors));
            tabList.add(bean);
        }
        tabLayout.setViewPager(viewPager2, tabList);

    }

    private String randomColor(String[] array) {
        int index = (int) (Math.random() * array.length);
        return array[index];
    }
}
