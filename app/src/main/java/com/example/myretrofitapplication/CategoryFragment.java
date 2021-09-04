package com.example.myretrofitapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;

public class CategoryFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyPagerAdapter myPagerAdapter;

    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_category, container, false);
        tabLayout=v.findViewById(R.id.fragment_tab_layout_id);
        viewPager=v.findViewById(R.id.fragment_view_pager_id);
        myPagerAdapter=new MyPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(myPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return v;
    }

    public class MyPagerAdapter extends FragmentPagerAdapter {
        String[] txt={"Home","Business","Entertainment","General","Health","Science","Sports","Technology"};

        public MyPagerAdapter(@NonNull @NotNull FragmentManager fm) {
            super(fm);
        }


        @NonNull
        @NotNull
        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0: return new BoxFragment("home");
                case 1: return new BoxFragment("business");
                case 2: return new BoxFragment("entertainment");
                case 3: return new BoxFragment("general");
                case 4: return new BoxFragment("health");
                case 5: return new BoxFragment("science");
                case 6: return new BoxFragment("sports");
                case 7: return new BoxFragment("technology");
                default: return null;
            }
        }

        @Override
        public int getCount() {
            return txt.length;
        }

        @Nullable
        @org.jetbrains.annotations.Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return txt[position];
        }
    }
}