package com.car.poolingSystem.entityPack;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity 
public class TripDetails {
	@Id
	@GeneratedValue
	private int tripId;
//		
	private Date bookingDate;

	private String depature;
	
	private String arrival;
	
	private short avalSeats;		
	
	private float distance;
	
	private int priceToTravel;
	
	private String status;
	
	private Short bookedSeats;
	
	
	public Short getBookedSeats() {
		return bookedSeats;
	}
	public void setBookedSeats(Short bookedSeats) {
		this.bookedSeats = bookedSeats;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	public int getPriceToTravel() {
		return priceToTravel;
	}
	public void setPriceToTravel(int priceToTravel) {
		this.priceToTravel = priceToTravel;
	}
	private String route ;
	
	@JsonBackReference(value="tripdetails")
	@ManyToOne
	@JoinColumn(name="UserId")
	private  UserDetails userdetails;
	
	@JsonBackReference("reference2")
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
	
	
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	
	
	
	public short getAvalSeats() {
		return avalSeats;
	}
	public void setAvalSeats(short avalSeats) {
		this.avalSeats = avalSeats;
	}
	public UserDetails getUserdetails() {
		return userdetails;
	}
	public void setUserdetails(UserDetails userdetails) {
		this.userdetails = userdetails;
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
				+ ", arrival=" + arrival + ", avalSeats=" + avalSeats + ", distance=" + distance + ", priceToTravel="
				+ priceToTravel + ", status=" + status + ", bookedSeats=" + bookedSeats + ", route=" + route
				+ ", userdetails=" + userdetails + ", cardet=" + cardet + "]";
	}

	

}
