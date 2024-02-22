package com.car.poolingSystem.entityPack;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class BookingDetails {
	@Id
	@GeneratedValue
	private int bookingId;
	private int driverId;
	private int riderId;
	
	private int tripId;
	private int seatsBooked;
	private String status;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	
	public int getRiderId() {
		return riderId;
	}
	public void setRiderId(int riderId) {
		this.riderId = riderId;
	}
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	public int getSeatsBooked() {
		return seatsBooked;
	}
	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BookingDetails [bookingId=" + bookingId + ", driverId=" + driverId + ", riderId=" + riderId
				+ ", tripId=" + tripId + ", seatsBooked=" + seatsBooked + ", status=" + status + "]";
	}
	

}
