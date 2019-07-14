package com.flyco.tablayoutsamples.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.flyco.tablayout.ScrollTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.flyco.tablayout.widget.MsgView;
import com.flyco.tablayoutsamples.R;
import com.flyco.tablayoutsamples.utils.FragmentUtils;

import java.util.ArrayList;
import java.util.Collections;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class ScrollTabActivity extends AppCompatActivity implements OnTabSelectListener {
    private final String[] mTitles = {
            "热门", "iOS", "Android"
            , "前端", "后端", "设计", "工具资源"
    };
    private Context mContext = this;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private int mCurrentIndex;
    private ArrayList<String> mTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_tab);

        for (String title : mTitles) {
            mFragments.add(SimpleCardFragment.getInstance(title));
        }
        ScrollTabLayout tabLayout_1 = findViewById(R.id.tablayout);

        mTabs= new ArrayList<>();
        Collections.addAll(mTabs, mTitles);
        tabLayout_1.setIndicatorBackDrawable(ContextCompat.getDrawable(this, R.drawable.shape_rounded_rectangle_green));
//        tabLayout_1.setIndicatorWidthAndHeight(20,5);
        tabLayout_1.setLayout(R.layout.layout_scroll_tab_custom);
        tabLayout_1.setTabs(mTabs);
        tabLayout_1.notifyDataSetChanged();
        tabLayout_1.setOnTabSelectListener(this);
        FragmentUtils.add(getSupportFragmentManager(), mFragments, R.id.fl_content, mCurrentIndex);

        tabLayout_1.showDot(4);

        tabLayout_1.showMsg(3, 5);
        tabLayout_1.setMsgMargin(3, 0, 10);
        MsgView rtv_2_3 = tabLayout_1.getMsgView(3);
        if (rtv_2_3 != null) {
            rtv_2_3.setBackgroundColor(Color.parseColor("#6D8FB0"));
        }

        tabLayout_1.showMsg(5, 5);
        tabLayout_1.setMsgMargin(5, 0, 10);
    }

    @Override
    public void onTabSelect(int position) {
        FragmentUtils.showHide(mCurrentIndex = position, mFragments);
        Toast.makeText(mContext, "onTabSelect&position--->" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTabReselect(int position) {
        Toast.makeText(mContext, "onTabReselect&position--->" + position, Toast.LENGTH_SHORT).show();
    }

}
