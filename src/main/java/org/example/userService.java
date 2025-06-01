package org.example;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class userService {

    private List<User> users = new ArrayList<>();

    public List<User> getAllUsers() {
        return users;
    }

    public void saveUser(User user) {
        // Проста логіка з додаванням id, якщо потрібно
        user.setId((long) (users.size() + 1));
        users.add(user);
    }

    public void deleteUser(Long id) {
        users.removeIf(u -> u.getId().equals(id));
    }
}
