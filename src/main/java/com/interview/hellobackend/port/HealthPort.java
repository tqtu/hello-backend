package com.interview.hellobackend.port;

import com.interview.hellobackend.dto.HealthResponse;

public interface HealthPort {
    HealthResponse getHealth();
}

