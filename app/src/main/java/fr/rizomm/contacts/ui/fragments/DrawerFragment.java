package fr.rizomm.contacts.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.InjectView;
import butterknife.OnItemClick;
import fr.rizomm.contacts.BaseFragment;
import fr.rizomm.contacts.R;
import fr.rizomm.contacts.adaptaters.ContactListAdaptater;
import fr.rizomm.contacts.managers.ContactManager;
import fr.rizomm.contacts.ui.activities.ContactDetailActivity;

/**
 * Fragment used for managing interactions for and presentation of a navigation drawer.
 * See the <a href="https://developer.android.com/design/patterns/navigation-drawer.html#Interaction">
 * design guidelines</a> for a complete explanation of the behaviors implemented here.
 */
public class DrawerFragment extends BaseFragment {

    @Inject
    ContactManager contactManager;

    @Inject
    ContactListAdaptater adaptater;

    @InjectView(R.id.drawer_contact_list)
    ListView contactListView;

    public DrawerFragment() {
    }


    @Override
    public View onViewInflated(View view, LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View header = inflater.inflate(R.layout.profile_header, null);
        ((TextView)header.findViewById(R.id.drawer_me_lastname)).setText(contactManager.getMe().getLastName());
        ((TextView)header.findViewById(R.id.drawer_me_firstname)).setText(contactManager.getMe().getFirstName());

        contactListView.addHeaderView(header, null, false);
        contactListView.setAdapter(adaptater);
        return view;
    }

    @OnItemClick(R.id.drawer_contact_list)
    public void onContactListItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent nextScreen = new Intent(getActivity(), ContactDetailActivity.class);
        // Position -1 because we added an header
        nextScreen.putExtra(ContactDetailActivity.ARG_CONTACT, position - 1);
        startActivity(nextScreen);
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_drawer;
    }
}
