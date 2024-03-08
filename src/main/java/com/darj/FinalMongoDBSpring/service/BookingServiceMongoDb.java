package com.darj.FinalMongoDBSpring.service;

import com.darj.FinalMongoDBSpring.model.Booking;
import com.darj.FinalMongoDBSpring.model.User;
import com.darj.FinalMongoDBSpring.repository.BookingMongoRepository;
import com.darj.FinalMongoDBSpring.repository.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceMongoDb implements BookingService{
    private final BookingMongoRepository bookingMongoRepository;

    @Autowired
    public BookingServiceMongoDb(BookingMongoRepository bookingMongoRepository) {
        this.bookingMongoRepository = bookingMongoRepository;
    }

    @Override
    public Booking save(Booking booking) {
        //String idUser = user.getId();
        return bookingMongoRepository.save(booking);
    }

    @Override
    public Optional<Booking> findById(String id) {
        //User user = userMongoRepository.findById(id).get();
        return bookingMongoRepository.findById(id);
    }
    @Override
    public List<Booking> all() {
        List<Booking> bookingList = bookingMongoRepository.findAll();
        return bookingList;
    }
    @Override
    public void deleteById(String id) {
        Optional<Booking> optionalBooking = bookingMongoRepository.findById(id);
        if (optionalBooking.isEmpty()){
        }
        bookingMongoRepository.deleteById(id);
    }
    @Override
    public Booking update(Booking booking, String bookingId) {
        if (!booking.getId().equals(bookingId)){
            throw new IllegalArgumentException("User Id " + bookingId);
        }
        Booking updateBooking = bookingMongoRepository.save(booking);
        return bookingMongoRepository.save(booking);
    }

}
