package com.server.dosopt.seminar.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class HealthCheckResponse {

    private static final String STATUS = "OK";
    private String status;

    public HealthCheckResponse() {
        this.status = STATUS;
    }
}
