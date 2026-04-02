package com.interview.hellobackend.repository;

import com.interview.hellobackend.model.User;
import org.springframework.stereotype.Repository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private static final List<User> USERS = Arrays.asList(
        new User(1, "John Doe", "john@example.com", "john_doe", true),
        new User(2, "Jane Smith", "jane@example.com", "jane_smith", true),
        new User(3, "Bob Johnson", "bob@example.com", "bob_johnson", false),
        new User(4, "Alice Williams", "alice@example.com", "alice_williams", true),
        new User(5, "Charlie Brown", "charlie@example.com", "charlie_brown", false)
    );

    public List<User> findAll() {
        return USERS;
    }

    public Optional<User> findById(Integer id) {
        return USERS.stream()
            .filter(user -> user.getId().equals(id))
            .findFirst();
    }

    public User save(User user) {
        return user;
    }
}

