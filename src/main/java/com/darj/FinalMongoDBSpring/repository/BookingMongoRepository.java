package com.darj.FinalMongoDBSpring.repository;

import com.darj.FinalMongoDBSpring.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingMongoRepository extends MongoRepository<Booking, String> {

}