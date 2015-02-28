package fr.rizomm.contacts.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnItemClick;
import fr.rizomm.contacts.BaseActivity;
import fr.rizomm.contacts.R;
import fr.rizomm.contacts.managers.ContactManager;
import fr.rizomm.contacts.model.Contact;

/**
 * Created by Maximilien on 28/02/2015.
 */
public class AddContactActivity extends BaseActivity {

    @InjectView(R.id.add_contact_firstname_input)
    EditText firstNameEditText;
    @InjectView(R.id.add_contact_lastname_input)
    EditText lastNameEditText;
    @InjectView(R.id.add_contact_phone_input)
    EditText phoneEditText;
    @InjectView(R.id.add_contact_email_input)
    EditText mailEditText;

    @InjectView(R.id.add_contact_save_button)
    Button saveButton;

    @Inject
    ContactManager contactManager;


    @Override
    protected void onBaseActivityCreate(Bundle savedInstanceState) {
        getSupportActionBar().setTitle("Ajout");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OnClick(R.id.add_contact_save_button)
    public void onSaveButtonClick(View v) {
        saveNewContact();
    }

    public void saveNewContact() {
        String firstName = firstNameEditText.getText().toString();
        contactManager.addContact(Contact.builder()
                .firstName(firstName)
                .lastName(lastNameEditText.getText().toString())
                .mail(mailEditText.getText().toString())
                .phone(phoneEditText.getText().toString())
                .build());

        Intent intent = new Intent();
        intent.putExtra("firstName", firstName);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.toolbar_button_validate) {
            saveNewContact();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_contact, menu);
        return true;
    }

    @Override
    public int getContentView() {
        return R.layout.activity_add_contact;
    }
}
