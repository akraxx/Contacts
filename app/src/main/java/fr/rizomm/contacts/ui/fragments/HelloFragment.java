package fr.rizomm.contacts.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.rizomm.contacts.R;
import fr.rizomm.contacts.TitledFragment;

/**
 * Created by Maximilien on 22/02/2015.
 */
public class HelloFragment extends TitledFragment {
    @Override
    public View onViewInflated(View view, LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return view;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_hello;
    }

    @Override
    public String getTitle() {
        return "Hello";
    }
}
