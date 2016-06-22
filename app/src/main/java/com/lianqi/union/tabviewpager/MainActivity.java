package com.lianqi.union.tabviewpager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {

    private static final String[] DATA =new String[]{"hello","world","and","android","and","java","des"} ;
    private TabLayout tabLayout;
    private ViewPager tabVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabVp = (ViewPager) findViewById(R.id.tab_vp);
        // 构造一个TabPagerAdapter对象
        TabPagerAdapter  adapter = new TabPagerAdapter(getSupportFragmentManager());
        // 设置TabLayout模式
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        // 设置从PagerAdapter中获取Tab
        tabLayout.setTabsFromPagerAdapter(adapter);
        // 设置Tab的选择监听
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // 每当我们选择了一个Tab就将ViewPager滚动至对应的Page
                tabVp.setCurrentItem(tab.getPosition(), true);
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        // 构造一个TabLayoutOnPageChangeListener对象
        TabLayout.TabLayoutOnPageChangeListener listener =
                new TabLayout.TabLayoutOnPageChangeListener(tabLayout);
        // 设置ViewPager页面改变后的监听
        tabVp.addOnPageChangeListener(listener);
        // 设置ViewPager的适配器
        tabVp.setAdapter(adapter);
    }

    private class TabPagerAdapter extends FragmentPagerAdapter {
        public TabPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public int getCount() {
            return DATA.length;
        }
        @Override
        public Fragment getItem(int position) {
            return PageFragment.newInstance(DATA[position]);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return DATA[position];
        }
    }
}
