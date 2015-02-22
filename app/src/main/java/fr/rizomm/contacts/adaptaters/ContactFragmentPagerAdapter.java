package fr.rizomm.contacts.adaptaters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import fr.rizomm.contacts.TitledFragment;

/**
 * Created by Maximilien on 05/02/2015.
 */
public class ContactFragmentPagerAdapter extends FragmentPagerAdapter {
    private final List<TitledFragment> fragments;

    public ContactFragmentPagerAdapter(FragmentManager fragmentManager, List<TitledFragment> fragments) {
        super(fragmentManager);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.fragments.get(position).getTitle();
    }
}
