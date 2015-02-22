package fr.rizomm.contacts.adaptaters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import javax.inject.Inject;

import fr.rizomm.contacts.model.Contact;

/**
 * Created by Maximilien on 22/02/2015.
 */
public class ContactListAdaptater extends BaseAdapter {
    @Inject
    List<Contact> contacts;

    @Inject
    Context context;

    public ContactListAdaptater() {

    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Contact getItem(int position) {
        return contacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View cellView = convertView;
        Contact person = contacts.get(position);
        ContactViewHolder viewHolder;

        if(cellView == null) {
            viewHolder = new ContactViewHolder(context);
            cellView = viewHolder.getView();
            cellView.setTag(viewHolder);
        }

        viewHolder = (ContactViewHolder) cellView.getTag();
        viewHolder.updateView(person);
        return cellView;
    }
}
