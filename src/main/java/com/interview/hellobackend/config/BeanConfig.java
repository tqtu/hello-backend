package com.interview.hellobackend.config;

import com.interview.hellobackend.port.HealthPort;
import com.interview.hellobackend.port.UserPort;
import com.interview.hellobackend.service.HealthService;
import com.interview.hellobackend.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public HealthPort healthPort(HealthService healthService) {
        return healthService;
    }

    @Bean
    public UserPort userPort(UserService userService) {
        return userService;
    }
}

