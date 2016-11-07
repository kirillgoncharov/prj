package com.netcracker.devcourses.sd4.persistence.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Konstantin on 21.10.16.
 */
@Entity
@Table(name = "Flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "arrivalTime")
    private Date arrivalTime;

    @Column(name = "departureTime")
    private Date departureTime;

    @ManyToOne
    @JoinColumn(name = "arrivalAirportId")
    private Airport arrivalAirport;

    @ManyToOne
    @JoinColumn(name = "departureAirportId")
    private Airport departureAirport;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }
}
