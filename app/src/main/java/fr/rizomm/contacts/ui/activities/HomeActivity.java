package fr.rizomm.contacts.ui.activities;

import android.os.Bundle;

import fr.rizomm.contacts.BaseActivity;
import fr.rizomm.contacts.R;

/**
 * Created by Maximilien on 22/02/2015.
 */
public class HomeActivity extends BaseActivity {

    @Override
    public void onBaseActivityCreate(Bundle savedInstanceState) {

    }

    @Override
    public int getContentView() {
        return R.layout.activity_contact_list;
    }


}
