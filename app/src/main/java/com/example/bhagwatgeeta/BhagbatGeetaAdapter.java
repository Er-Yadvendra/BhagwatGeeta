package com.example.bhagwatgeeta;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class BhagbatGeetaAdapter  extends FragmentPagerAdapter {
    List<Fragment> mFragmentList = new ArrayList<>();

    public BhagbatGeetaAdapter(FragmentManager fm, List<Fragment> mFragmentList) {
        super(fm);
        this.mFragmentList =mFragmentList;
    }


    @Override
    public Fragment getItem(int position) {

        return mFragmentList.get(position);

    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }
}
