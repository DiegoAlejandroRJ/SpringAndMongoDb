package com.darj.FinalMongoDBSpring.dto;

import java.util.Date;

public class BookingDto {
    private String id;
    private String userName;
    private String userEmail;
    private Date createdBookingAt;
    private Date startingBookingDate;
    private Date finishingBookingDate;

    public BookingDto(String id, String userName, String userEmail, Date createdBookingAt, Date startingBookingDate, Date finishingBookingDate) {
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
        this.createdBookingAt = createdBookingAt;
        this.startingBookingDate = startingBookingDate;
        this.finishingBookingDate = finishingBookingDate;
    }


    public String getId(){return id;}
    public String getUserName(){ return userEmail; }
    public String getUserEmail(){ return userEmail; }
    public Date getCreatedBookingAt(){ return createdBookingAt; }
    public Date getStartingBookingDate(){ return startingBookingDate; }
    public Date getFinishingBookingDate() { return finishingBookingDate; }
}

