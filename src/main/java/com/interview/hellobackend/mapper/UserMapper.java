package com.interview.hellobackend.mapper;

import com.interview.hellobackend.model.User;
import com.interview.hellobackend.dto.UserResponse;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static List<UserResponse> toUserResponseList(List<User> users) {
        return users.stream()
            .map(UserMapper::toUserResponse)
            .collect(Collectors.toList());
    }

    public static UserResponse toUserResponse(User user) {
        return new UserResponse(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getUsername(),
            user.getActive()
        );
    }
}

