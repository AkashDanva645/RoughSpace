package contact_management.repository;

import contact_management.entities.Contact;

import java.util.ArrayList;
import java.util.List;


public class ContactRepo {

    List<Contact> contacts = new ArrayList<>();

    public void save(Contact contact) {
        contacts.add(contact);
    }

    public List<Contact> findByOwner(String ownerId) {
        List<Contact> ownerContacts = new ArrayList<>();
        for (Contact c: contacts) {
            if (c.getOwnerUserId().equals(ownerId)) {
                ownerContacts.add(c);
            }
        }
        return ownerContacts;
    }
}
