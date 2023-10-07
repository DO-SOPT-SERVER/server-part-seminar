package com.server.dosopt.seminar.dto;

import lombok.Getter;

public class HealthCheckResponse {

    private static final String STATUS = "OK";
    private String status;

    public HealthCheckResponse() {
        this.status = STATUS;
    }
}
