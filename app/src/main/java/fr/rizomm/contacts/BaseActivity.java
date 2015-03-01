package fr.rizomm.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import fr.rizomm.contacts.ui.activities.AddContactActivity;

public abstract class BaseActivity extends ActionBarActivity implements InjectableResource {

    private static final int ADD_CONTACT_REQUEST = 0;
    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Perform injection so that when this call returns all dependencies will be available for use.
        ((ContactApplication) getApplication()).inject(this);

        setContentView(getContentView());
        ButterKnife.inject(this);

        setSupportActionBar(toolbar);

        onBaseActivityCreate(savedInstanceState);
    }

    protected abstract void onBaseActivityCreate(Bundle savedInstanceState);

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.toolbar_menu_help:
                Toast.makeText(this, "Aide", Toast.LENGTH_SHORT).show();
                break;
            case R.id.toolbar_menu_parameters:
                Toast.makeText(this, "Paramètres", Toast.LENGTH_SHORT).show();
                break;
            case R.id.toolbar_button_add:
                addNewContactIntent();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    public void addNewContactIntent() {
        Intent intent = new Intent(this, AddContactActivity.class);
        startActivityForResult(intent, ADD_CONTACT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == ADD_CONTACT_REQUEST && resultCode == RESULT_OK) {
            String firstName = data.getStringExtra("firstName");
            Toast.makeText(this, firstName + " has been added to the list", Toast.LENGTH_SHORT).show();
            onContactAdded();
        }
    }

    public void onContactAdded() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
