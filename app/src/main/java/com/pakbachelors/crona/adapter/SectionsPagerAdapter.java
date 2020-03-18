package com.pakbachelors.crona.adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.pakbachelors.crona.fragment.PlaceholderFragment;
import com.pakbachelors.crona.model.Checker;

import java.util.List;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private final Context mContext;
    private List<Checker> data;

    public SectionsPagerAdapter(Context context, FragmentManager fm, List<Checker> data) {
        super(fm);
        mContext = context;
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        //return PlaceholderFragment.newInstance(position,data.get(position));
        return new PlaceholderFragment(data.get(position));
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return data.size();
    }
}