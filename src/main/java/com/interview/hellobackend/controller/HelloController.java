package com.interview.hellobackend.controller;

import com.interview.hellobackend.dto.HealthResponse;
import com.interview.hellobackend.dto.UserResponse;
import com.interview.hellobackend.mapper.UserMapper;
import com.interview.hellobackend.port.HealthPort;
import com.interview.hellobackend.port.UserPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HelloController {

    @Autowired
    private HealthPort healthPort;

    @Autowired
    private UserPort userPort;

    @GetMapping("/health")
    public HealthResponse health() {
        return healthPort.getHealth();
    }

    @GetMapping("/users")
    public List<UserResponse> getUsers() {
        return UserMapper.toUserResponseList(userPort.getAllUsers());
    }

    @GetMapping("/users/{id}")
    public UserResponse getUserById(@PathVariable Integer id) {
        return UserMapper.toUserResponse(userPort.getUserById(id));
    }
}

