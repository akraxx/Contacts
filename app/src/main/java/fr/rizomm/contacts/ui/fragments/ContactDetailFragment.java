package fr.rizomm.contacts.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.InjectView;
import fr.rizomm.contacts.BaseFragment;
import fr.rizomm.contacts.R;
import fr.rizomm.contacts.managers.ContactManager;
import fr.rizomm.contacts.model.Contact;


public class ContactDetailFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String ARG_CONTACT = "ARG_CONTACT";

    @InjectView(R.id.firstname_textview_details)
    TextView firstNameTextView;
    @InjectView(R.id.lastname_textview_details)
    TextView lastameTextView;
    @InjectView(R.id.mail_textview_details)
    TextView mailTextView;
    @InjectView(R.id.phone_textview_details)
    TextView phoneTextView;

    @Inject
    ContactManager contactManager;

    private Contact mContact;

    public ContactDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getActivity().getIntent() != null) {
            mContact = contactManager.getContacts().get(getActivity().getIntent().getIntExtra(ARG_CONTACT, 0));
        }
    }

    @Override
    public View onViewInflated(View view, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(mContact != null) {
            firstNameTextView.setText(mContact.getFirstName());
            lastameTextView.setText(mContact.getLastName());
            mailTextView.setText(mContact.getMail());
            phoneTextView.setText(mContact.getPhone());
        }

        return view;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_contact_detail;
    }
}
