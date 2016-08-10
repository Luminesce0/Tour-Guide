package com.omegaspockatari.tourguide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class FragmentsPagerAdapter extends FragmentPagerAdapter {

    public FragmentsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    private final String[] tabTitles = {"Home Page", "Hotels", "Dining", "Tours", "Activities"};

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        if (position == 0) {
            return new HomePageFragment();
        } else if (position == 1) {
            return new HotelsFragment();
        } else if (position == 2){
            return new DiningFragment();
        } else if (position == 3){
            return new TourFragment();
        } else {
            return new ActivityFragment();
        }
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}