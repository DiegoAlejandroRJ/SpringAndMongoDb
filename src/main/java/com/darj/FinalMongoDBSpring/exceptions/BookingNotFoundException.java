package com.darj.FinalMongoDBSpring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BookingNotFoundException extends ResponseStatusException {
    public BookingNotFoundException(String id) {
        super(HttpStatus.NOT_FOUND, "Booking with ID: " + id + " not found");
    }
}
