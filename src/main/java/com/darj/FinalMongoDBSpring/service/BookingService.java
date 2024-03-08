package com.darj.FinalMongoDBSpring.service;

import com.darj.FinalMongoDBSpring.model.Booking;
import com.darj.FinalMongoDBSpring.model.User;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    Booking save(Booking booking);

    Optional<Booking> findById(String id);

    List<Booking> all();

    void deleteById(String id);

    Booking update(Booking booking, String userId);
}
