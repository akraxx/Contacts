package fr.rizomm.contacts.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import javax.inject.Inject;

import butterknife.InjectView;
import butterknife.OnItemClick;
import fr.rizomm.contacts.ContactApplication;
import fr.rizomm.contacts.R;
import fr.rizomm.contacts.TitledFragment;
import fr.rizomm.contacts.adaptaters.ContactListAdaptater;
import fr.rizomm.contacts.listeners.ContactListener;
import fr.rizomm.contacts.managers.ContactManager;
import fr.rizomm.contacts.ui.activities.ContactDetailActivity;

/**
 * Created by Maximilien on 22/02/2015.
 */
public class ContactListFragment extends TitledFragment implements ContactListener {

    ContactListAdaptater adaptater;

    @Inject
    ContactManager contactManager;

    @InjectView(R.id.contact_list)
    ListView contactListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((ContactApplication) getActivity().getApplication()).inject(this);
    }

    @Override
    public View onViewInflated(View view, LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        adaptater = new ContactListAdaptater(this.getActivity(), contactManager);

        contactListView.setAdapter(adaptater);

        return view;
    }

    @OnItemClick(R.id.contact_list)
    public void onContactListItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent nextScreen = new Intent(getActivity(), ContactDetailActivity.class);
        nextScreen.putExtra(ContactDetailActivity.ARG_CONTACT, position);
        startActivity(nextScreen);
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_contact_list;
    }

    @Override
    public String getTitle() {
        return "Contacts";
    }

    @Override
    public void onContactAdded() {
        adaptater.notifyDataSetChanged();
    }
}
