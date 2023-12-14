package com.car.poolingSystem.entityPack;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity 
public class TripDetails {
	@Id
	@GeneratedValue
	private int tripId;
	private Date bookingDate;
	private String depature;
	private String arrival;
	private Short avalSeats;
	private Short duration;
	private int route ;
	@OneToOne(cascade =CascadeType.ALL)
	@JoinColumn(name="UserId")
	private RegistrationClass registrationClass;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="carid")
	private CarDetails cardet;
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getDepature() {
		return depature;
	}
	public void setDepature(String depature) {
		this.depature = depature;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public Short getAvalSeats() {
		return avalSeats;
	}
	public void setAvalSeats(Short avalSeats) {
		this.avalSeats = avalSeats;
	}
	public Short getDuration() {
		return duration;
	}
	public void setDuration(Short duration) {
		this.duration = duration;
	}
	public int getRoute() {
		return route;
	}
	public void setRoute(int route) {
		this.route = route;
	}
	public RegistrationClass getRegistrationClass() {
		return registrationClass;
	}
	public void setRegistrationClass(RegistrationClass registrationClass) {
		this.registrationClass = registrationClass;
	}
	public CarDetails getCardet() {
		return cardet;
	}
	public void setCardet(CarDetails cardet) {
		this.cardet = cardet;
	}
	@Override
	public String toString() {
		return "TripDetails [tripId=" + tripId + ", bookingDate=" + bookingDate + ", depature=" + depature
				+ ", arrival=" + arrival + ", avalSeats=" + avalSeats + ", duration=" + duration + ", route=" + route
				+ ", registrationClass=" + registrationClass + ", cardet=" + cardet + "]";
	}
	
	
	
	
	


}
