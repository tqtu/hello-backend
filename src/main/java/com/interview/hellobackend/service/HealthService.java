package com.interview.hellobackend.service;

import com.interview.hellobackend.dto.HealthResponse;
import com.interview.hellobackend.port.HealthPort;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class HealthService implements HealthPort {

    @Override
    public HealthResponse getHealth() {
        return new HealthResponse(
            "UP",
            "Hello Backend API is running!",
            LocalDateTime.now()
        );
    }
}

