package contact_management.use_cases;

import contact_management.entities.Contact;
import contact_management.repository.ContactRepo;

import java.util.List;


public class GetUserContacts {

    private ContactRepo repo;

    public GetUserContacts(ContactRepo repo) {
        this.repo = repo;
    }

    public List<Contact> execute(String userId) {
        return this.repo.findByOwner(userId);
    }
}
