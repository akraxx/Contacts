package fr.rizomm.contacts.ui.activities;

import android.os.Bundle;

import fr.rizomm.contacts.DrawerActivity;
import fr.rizomm.contacts.R;
import fr.rizomm.contacts.ui.fragments.HomeFragment;

/**
 * Created by Maximilien on 22/02/2015.
 */
public class HomeActivity extends DrawerActivity {

    @Override
    public void onBaseActivityCreate(Bundle savedInstanceState) {

    }

    @Override
    public int getContentView() {
        return R.layout.activity_contact_list;
    }

    @Override
    public void onContactAdded() {
        HomeFragment homeFragment = (HomeFragment)getSupportFragmentManager().findFragmentById(R.id.contact_list);
        homeFragment.onContactAdded();
    }
}
