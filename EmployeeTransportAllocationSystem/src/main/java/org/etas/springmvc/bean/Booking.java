package org.etas.springmvc.bean;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy = false)
@Table(name = "BOOKING")
public class Booking {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    int id;

    @Column(name = "sourceLocation")
    String sourceLocation;

    @Column(name = "dateTimeOfJourney")
    Timestamp dateTimeOfJourney;

    @Column(name = "employeeId")
    String empoyeeId;

    @Column(name = "bookingStatusOfJourney")
    boolean bookingStatusOfJourney;
    
    @Column(name = "cab_id")
    int cab_id;

    public Booking() {
        super();
    }

    public Booking(int id, String sourceLocation, Timestamp dateTimeOfJourney, String empoyeeId, boolean bookingStatusOfJourney,int cab_id) {
        super();
        this.id = id;
        this.sourceLocation = sourceLocation;
        this.dateTimeOfJourney = dateTimeOfJourney;
        this.empoyeeId = empoyeeId;
        this.bookingStatusOfJourney = bookingStatusOfJourney;
        this.cab_id=cab_id;
    }

    public boolean isBookingStatusOfJourney() {
        return bookingStatusOfJourney;
    }

    public void setBookingStatusOfJourney(boolean bookingStatusOfJourney) {
        this.bookingStatusOfJourney = bookingStatusOfJourney;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmpoyeeId() {
        return empoyeeId;
    }

    public void setEmpoyeeId(String empoyeeId) {
        this.empoyeeId = empoyeeId;
    }

    
    public int getCab_id() {
        return cab_id;
    }

    
    public void setCab_id(int cab_id) {
        this.cab_id = cab_id;
    }
}
