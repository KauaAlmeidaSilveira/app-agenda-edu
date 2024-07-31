package com.agendaedu.schedule_service.services.exceptions;

public class InvalidCredentialsExceptions extends RuntimeException {
    public InvalidCredentialsExceptions(String msg) {
        super(msg);
    }
}
