package fr.rizomm.contacts;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import fr.rizomm.contacts.adaptaters.ContactFragmentPagerAdapter;
import fr.rizomm.contacts.adaptaters.ContactViewHolder;
import fr.rizomm.contacts.model.Contact;
import fr.rizomm.contacts.ui.activities.ContactDetailActivity;
import fr.rizomm.contacts.ui.activities.HomeActivity;
import fr.rizomm.contacts.ui.fragments.ContactDetailFragment;
import fr.rizomm.contacts.ui.fragments.ContactListFragment;
import fr.rizomm.contacts.ui.fragments.HelloFragment;
import fr.rizomm.contacts.ui.fragments.HomeFragment;

/**
 * Created by Maximilien on 22/02/2015.
 */
@Module(
        injects = {
                HomeActivity.class,
                ContactDetailActivity.class,
                HelloFragment.class,
                HomeFragment.class,
                ContactListFragment.class,
                ContactDetailFragment.class,
                ContactFragmentPagerAdapter.class,
                ContactViewHolder.class
        }
)
public class ContactModule {
    private ContactApplication application;

    public ContactModule(ContactApplication application) {
        this.application = application;
    }


    /**
     * Allow the application context to be injected but require that it be annotated with
     */
    @Provides @Singleton
    Context provideApplicationContext() {
        return application;
    }

    @Singleton
    @Provides
    public List<Contact> providesContacts() {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(Contact.builder().firstName("MARIE").lastName("Maximilien").mail("contact@mmarie.fr").phone("0605040708").build());
        contacts.add(Contact.builder().firstName("DOE").lastName("John").mail("jd@test.fr").phone("0505050505").build());
        contacts.add(Contact.builder().firstName("San").lastName("Goku").mail("sg@test.fr").phone("0404040404").build());
        return contacts;
    }
}
