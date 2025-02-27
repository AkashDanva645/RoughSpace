package contact_management.repository;

import contact_management.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepo {

    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void deleteUser(String id) {}

    public void updateUser(String id) {}
}
