package com.interview.hellobackend.port;

import com.interview.hellobackend.model.User;
import java.util.List;

public interface UserPort {
    List<User> getAllUsers();
    User getUserById(Integer id);
    User createUser(User user);
}

