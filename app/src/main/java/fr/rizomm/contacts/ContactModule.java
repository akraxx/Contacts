package fr.rizomm.contacts;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import fr.rizomm.contacts.adaptaters.ContactFragmentPagerAdapter;
import fr.rizomm.contacts.adaptaters.ContactViewHolder;
import fr.rizomm.contacts.managers.ContactManager;
import fr.rizomm.contacts.ui.activities.AddContactActivity;
import fr.rizomm.contacts.ui.activities.ContactDetailActivity;
import fr.rizomm.contacts.ui.activities.HomeActivity;
import fr.rizomm.contacts.ui.fragments.ContactListFragment;
import fr.rizomm.contacts.ui.fragments.DrawerFragment;
import fr.rizomm.contacts.ui.fragments.HelloFragment;
import fr.rizomm.contacts.ui.fragments.HomeFragment;

/**
 * Created by Maximilien on 22/02/2015.
 */
@Module(
        injects = {
                HomeActivity.class,
                ContactDetailActivity.class,
                AddContactActivity.class,
                HelloFragment.class,
                HomeFragment.class,
                DrawerFragment.class,
                ContactListFragment.class,
                ContactFragmentPagerAdapter.class,
                ContactViewHolder.class
        }
)
public class ContactModule {

    @Singleton
    @Provides
    public ContactManager providesContactManager() {
        return new ContactManager();
    }
}
