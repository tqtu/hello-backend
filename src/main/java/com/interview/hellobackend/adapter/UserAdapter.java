package com.interview.hellobackend.adapter;

import com.interview.hellobackend.model.User;
import com.interview.hellobackend.dto.UserResponse;

public class UserAdapter {

    public static UserResponse toUserResponse(User user) {
        if (user == null) return null;

        return new UserResponse(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getUsername(),
            user.getActive()
        );
    }

    public static User toUser(UserResponse userResponse) {
        if (userResponse == null) return null;

        return new User(
            userResponse.getId(),
            userResponse.getName(),
            userResponse.getEmail(),
            userResponse.getUsername(),
            userResponse.getActive()
        );
    }
}

