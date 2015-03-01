package fr.rizomm.contacts.managers;

import java.util.ArrayList;
import java.util.List;

import fr.rizomm.contacts.model.Contact;
import lombok.Getter;

/**
 * Created by Maximilien on 23/02/2015.
 */
public class ContactManager {

    private List<Contact> contacts = new ArrayList<>();

    @Getter
    private Contact me;

    private void buildContactList() {
        contacts.add(Contact.builder().firstName("Gerard").lastName("ROBERT").mail("rg@domain.eu").phone("0605040708").build());
        contacts.add(Contact.builder().firstName("John").lastName("DOE").mail("jd@test.fr").phone("0505050505").build());
        contacts.add(Contact.builder().firstName("San").lastName("GOKU").mail("sg@test.fr").phone("0404040404").build());
    }

    private void buildMe() {
        me = Contact.builder().firstName("Maximilien").lastName("MARIE").mail("contact@mmarie.fr").phone("0605040708").build();
    }

    public ContactManager() {
        buildContactList();
        buildMe();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public List<Contact> getContacts() {
        return new ArrayList<>(contacts);
    }

}
