package fr.rizomm.contacts.ui.activities;

import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.InjectView;
import fr.rizomm.contacts.BaseActivity;
import fr.rizomm.contacts.R;
import fr.rizomm.contacts.managers.ContactManager;
import fr.rizomm.contacts.model.Contact;

/**
 * Created by Maximilien on 22/02/2015.
 */
public class ContactDetailActivity extends BaseActivity {
    public static final String ARG_CONTACT = "ARG_CONTACT";

    @InjectView(R.id.details_firstname_textview)
    TextView firstNameTextView;
    @InjectView(R.id.details_lastname_textview)
    TextView lastameTextView;
    @InjectView(R.id.details_mail_textview)
    TextView mailTextView;
    @InjectView(R.id.details_phone_textview)
    TextView phoneTextView;

    @Inject
    ContactManager contactManager;

    @Override
    protected void onBaseActivityCreate(Bundle savedInstanceState) {
        getSupportActionBar().setTitle("Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Contact mContact = null;

        if (getIntent() != null) {
            mContact = contactManager.getContacts().get(getIntent().getIntExtra(ARG_CONTACT, 0)-1);
        }

        if(mContact != null) {
            firstNameTextView.setText(mContact.getFirstName());
            lastameTextView.setText(mContact.getLastName());
            mailTextView.setText(mContact.getMail());
            phoneTextView.setText(mContact.getPhone());
        }
    }

    @Override
    public int getContentView() {
        return R.layout.activity_contact_details;
    }
}
