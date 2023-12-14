package com.car.poolingSystem.entityPack;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class CarDetails {
	@Id
	@GeneratedValue
	private int carID;
	private String model;
	private String plateNumber;
	private String insurance;
	private String rc;
	private int capacity;
	@OneToOne(cascade =CascadeType.ALL)
	@JoinColumn(name= "userID")
	private  RegistrationClass registerID;
	@JsonManagedReference
	@OneToMany(mappedBy="cardet",cascade = CascadeType.ALL)
	private List<TripDetails> tripdetails ;
	

	public List<TripDetails> getTrdet() {
		return tripdetails;
	}
	public void setTrdet(List<TripDetails> trdet) {
		this.tripdetails = trdet;
	}
	public int getCarID() {
		return carID;
	}
	public void setCarID(int carID) {
		this.carID = carID;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	public String getRc() {
		return rc;
	}
	public void setRc(String rc) {
		this.rc = rc;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public RegistrationClass getRegisterID() {
		return registerID;
	}
	public void setRegisterID(RegistrationClass registerID) {
		this.registerID = registerID;
	}
//	@Override
//	public String toString() {
//		return "CarDetails [carID=" + carID + ", model=" + model + ", plateNumber=" + plateNumber + ", insurance="
//				+ insurance + ", rc=" + rc + ", capacity=" + capacity + ", registerID=" + registerID + "]";
//	}
//	
	@Override
	public String toString() {
		return "CarDetails [carID=" + carID + ", model=" + model + ", plateNumber=" + plateNumber + ", insurance="
				+ insurance + ", rc=" + rc + ", capacity=" + capacity + ", registerID=" + registerID + ", trdet="
				+ tripdetails + "]";
	}
	

}
