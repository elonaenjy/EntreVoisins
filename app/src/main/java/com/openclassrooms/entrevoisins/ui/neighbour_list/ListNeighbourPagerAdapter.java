package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ListNeighbourPagerAdapter extends FragmentPagerAdapter {

    public ListNeighbourPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * getItem is called to instantiate the fragment for the given page.
     * @param position
     * @return
     */
    @Override
    public NeighbourFragment getItem(int position) {
        if(position==0)
            return NeighbourFragment.newInstance(false);
        else
            return NeighbourFragment.newInstance(true);
    }

    /**
     * get the number of pages
     * @return
     */
    @Override
    public int getCount() {
        return 2;
    }
}