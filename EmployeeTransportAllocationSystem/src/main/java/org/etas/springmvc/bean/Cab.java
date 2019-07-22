package org.etas.springmvc.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy = false)
@Table(name = "CAB")
public class Cab {

    @Id
    @Column(name = "cabId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    int cabId;

    @Column(name = "registrationNumber")
    String registrationNumber;

    @Column(name = "driverId")
    int driverId;

    @Column(name = "cabStatus")
    boolean cabStatus;

    @Column(name = "comments")
    String comments;

    @Column(name = "vacancy")
    @NotNull
    @Size(min = 1, max = 4)
    String vacancy;

    public Cab() {
        super();
    }

    public Cab(int cabId, String registrationNumber, int driverId, boolean cabStatus, String comments, String vacancy) {
        super();
        this.cabId = cabId;
        this.registrationNumber = registrationNumber;
        this.driverId = driverId;
        this.cabStatus = cabStatus;
        this.comments = comments;
        this.vacancy = vacancy;
    }

    public int getCabId() {
        return this.cabId;
    }

    public void setCabId(int cabId) {
        this.cabId = cabId;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public boolean isCabStatus() {
        return cabStatus;
    }

    public void setCabStatus(boolean cabStatus) {
        this.cabStatus = cabStatus;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getVacancy() {
        return vacancy;
    }

    public void setVacancy(String vacancy) {
        this.vacancy = vacancy;
    }

}
