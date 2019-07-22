package org.etas.springmvc.bean;

import java.sql.Timestamp;

public class BookingRequestStatus {

    int id;
    boolean requestStatus;
    String comments;
    int bookingId;
    String sourceLocation;
    Timestamp dateTimeOfJourney;
    Timestamp requestCreationDate;
    // requestGenerator

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isRequestStatus() {
        return this.requestStatus;
    }

    public void setRequestStatus(boolean requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getSourceLocation() {
        return sourceLocation;
    }

    public void setSourceLocation(String sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    public Timestamp getDateTimeOfJourney() {
        return dateTimeOfJourney;
    }

    public void setDateTimeOfJourney(Timestamp dateTimeOfJourney) {
        this.dateTimeOfJourney = dateTimeOfJourney;
    }

    public Timestamp getRequestCreationDate() {
        return requestCreationDate;
    }

    public void setRequestCreationDate(Timestamp requestCreationDate) {
        this.requestCreationDate = requestCreationDate;
    }

    public BookingRequestStatus() {
        super();
    }

    public BookingRequestStatus(int id, boolean requestStatus, String comments, int bookingId, String sourceLocation,
            Timestamp dateTimeOfJourney, Timestamp requestCreationDate) {
        super();
        this.id = id;
        this.requestStatus = requestStatus;
        this.comments = comments;
        this.bookingId = bookingId;
        this.sourceLocation = sourceLocation;
        this.dateTimeOfJourney = dateTimeOfJourney;
        this.requestCreationDate = requestCreationDate;
    }

}
