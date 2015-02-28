package fr.rizomm.contacts.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import fr.rizomm.contacts.BaseFragment;
import fr.rizomm.contacts.R;
import fr.rizomm.contacts.TitledFragment;
import fr.rizomm.contacts.adaptaters.ContactFragmentPagerAdapter;
import fr.rizomm.contacts.listeners.ContactListener;
import fr.rizomm.contacts.ui.slidingtab.SlidingTabLayout;

/**
 * Created by Maximilien on 22/02/2015.
 */
public class HomeFragment extends BaseFragment implements ContactListener {

    @InjectView(R.id.view_pager)
    ViewPager contactListViewPager;

    @InjectView(R.id.sliding_tabs)
    SlidingTabLayout slidingTabLayout;

    private ContactListFragment contactListFragment;

    @Override
    public View onViewInflated(View view, LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        List<TitledFragment> tabs = new ArrayList<>();

        contactListFragment = (ContactListFragment)Fragment.instantiate(getActivity(), ContactListFragment.class.getName());

        tabs.add((TitledFragment)Fragment.instantiate(getActivity(), HelloFragment.class.getName()));
        tabs.add(contactListFragment);

        ContactFragmentPagerAdapter adapter = new ContactFragmentPagerAdapter(getChildFragmentManager(), tabs);

        contactListViewPager.setAdapter(adapter);
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setViewPager(contactListViewPager);
        return view;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_home;
    }

    @Override
    public void onContactAdded() {
        contactListFragment.onContactAdded();
    }
}
