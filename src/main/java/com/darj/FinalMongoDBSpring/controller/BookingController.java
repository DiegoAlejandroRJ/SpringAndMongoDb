package com.darj.FinalMongoDBSpring.controller;

import com.darj.FinalMongoDBSpring.dto.BookingDto;
import com.darj.FinalMongoDBSpring.exceptions.BookingNotFoundException;
import com.darj.FinalMongoDBSpring.exceptions.UserNotFoundException;
import com.darj.FinalMongoDBSpring.model.Booking;
import com.darj.FinalMongoDBSpring.service.BookingServiceMongoDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/v1/bookings/")
public class BookingController {

    private final BookingServiceMongoDb bookingService;

    public BookingController(@Autowired BookingServiceMongoDb bookingService){
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<Booking> createUser(@RequestBody Booking booking){
        Booking createBooking = bookingService.save(booking);
        URI createdBookingUri = URI.create("/v1/users/" + createBooking.getId());
        return ResponseEntity.created(createdBookingUri).body(createBooking);
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.all();
        return ResponseEntity.ok(bookings);
    }
    @GetMapping("{id}")
    public ResponseEntity<Booking> findById(@PathVariable String id) {
        Booking booking = bookingService.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
        return  ResponseEntity.ok(booking);
    }
    @PutMapping ("{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable ("id")String id, @RequestBody
    BookingDto bookingDto){
        try{
            Optional<Booking> optionalBooking = bookingService.findById(id);
            if(optionalBooking.isPresent()){
                Booking existingBooking = optionalBooking.get();
                existingBooking.setId(bookingDto.getId());
                existingBooking.setUserEmail(bookingDto.getUserEmail());
                bookingService.save(existingBooking);
                return ResponseEntity.ok(existingBooking);
            }else{
                throw new BookingNotFoundException(id);
            }
        } catch (UserNotFoundException e) {
            throw e;
        }catch (Exception e){
            throw new BookingNotFoundException(id);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable ("id") String id ){
        Optional<Booking> optionalBooking = bookingService.findById(id);
        if (optionalBooking.isEmpty()){
            throw new BookingNotFoundException(id);

        }
        bookingService.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }
}
