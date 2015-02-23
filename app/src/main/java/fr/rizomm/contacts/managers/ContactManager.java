package fr.rizomm.contacts.managers;

import java.util.ArrayList;
import java.util.List;

import fr.rizomm.contacts.model.Contact;
import lombok.Getter;

/**
 * Created by Maximilien on 23/02/2015.
 */
public class ContactManager {

    @Getter
    private List<Contact> contacts = new ArrayList<>();

    private void buildContactList() {
        contacts.add(Contact.builder().firstName("MARIE").lastName("Maximilien").mail("contact@mmarie.fr").phone("0605040708").build());
        contacts.add(Contact.builder().firstName("DOE").lastName("John").mail("jd@test.fr").phone("0505050505").build());
        contacts.add(Contact.builder().firstName("San").lastName("Goku").mail("sg@test.fr").phone("0404040404").build());
    }

    public ContactManager() {
        buildContactList();
    }

}
