package fr.rizomm.contacts.adaptaters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import fr.rizomm.contacts.R;
import fr.rizomm.contacts.model.Contact;


public class ContactViewHolder {

    @Inject
    Context context;

    private View personView;

    @InjectView(R.id.firstname_textview)
    TextView firstNameTextView;

    @InjectView(R.id.lastname_textview)
    TextView lastNameTextView;

    public ContactViewHolder(Context context) {
        this.context = context;

        createView();
    }

    private void createView() {
        personView = LayoutInflater.from(context).inflate(R.layout.contact_item, null);
        ButterKnife.inject(this, personView);
    }

    public void updateView(Contact contact) {
        firstNameTextView.setText(contact.getFirstName());
        lastNameTextView.setText(contact.getLastName());
    }

    public View getView() {
        return personView;
    }

}
