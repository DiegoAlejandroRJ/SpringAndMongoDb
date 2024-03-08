package com.darj.FinalMongoDBSpring.model;

import com.darj.FinalMongoDBSpring.dto.BookingDto;
import com.darj.FinalMongoDBSpring.dto.UserDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "booking_collection")
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String userName;
    private String userEmail;
    private Date createdBookingAt;
    private Date startingBookingDate;
    private Date finishingBookingDate;

    public Booking(String id, String userName, String userEmail, Date createdBookingAt, Date startingBookingDate, Date finishingBookingDate) {
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
        this.createdBookingAt = createdBookingAt;
        this.startingBookingDate = startingBookingDate;
        this.finishingBookingDate = finishingBookingDate;
    }

    public Booking(BookingDto bookingDto) {
        this.id = bookingDto.getId();
        this.userName = bookingDto.getUserName();
        this.userEmail = bookingDto.getUserEmail();
        this.createdBookingAt = bookingDto.getCreatedBookingAt();
        this.startingBookingDate = bookingDto.getStartingBookingDate();
        this.finishingBookingDate = bookingDto.getFinishingBookingDate();
    }


    public Date getStartingBookingDate() {
        return startingBookingDate;
    }

    public void setStartingBookingDate(Date startingBookingDate) {
        this.startingBookingDate = startingBookingDate;
    }

    public Date getCreatedBookingAt() {
        return createdBookingAt;
    }

    public void setCreatedBookingAt(Date createdBookingAt) {
        this.createdBookingAt = createdBookingAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getFinishingBookingDate() {
        return finishingBookingDate;
    }

    public void setFinishingBookingDate(Date finishingBookingDate) {
        this.finishingBookingDate = finishingBookingDate;
    }

    public void update(BookingDto bookingDto) {
        this.id = bookingDto.getId();
        this.userName = bookingDto.getUserName();
        this.userEmail = bookingDto.getUserEmail();
        this.createdBookingAt= bookingDto.getCreatedBookingAt();
        this.startingBookingDate= bookingDto.getStartingBookingDate();
        this.finishingBookingDate = bookingDto.getFinishingBookingDate();
    }

    @Override
    public String toString() {
        return "User Name{" +
                "id='" + id + '\'' +
                ", name='" + userName + '\'' +
                ", email='" + userEmail + '\'' +
                ", created booking at'" + createdBookingAt + '\'' +
                ", starting booking on'" + startingBookingDate + '\'' +
                ", finishing booking on'" + finishingBookingDate + '\'' +
                '}';
    }
}
