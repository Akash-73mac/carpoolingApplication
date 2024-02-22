package com.car.poolingSystem.DTO;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonSetter;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

public class RoutesDetailsDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idNumber_seq")
    @SequenceGenerator(name = "idNumber_seq", sequenceName = "idNumber_sequence", allocationSize = 1)
	private int idNumber;
	private String routenumber;

	 private List<Map<String,String>> placesArray ;
//	private List<Boolean>status;
	public int getIdNumber() {
		return idNumber;
	}
//	public List<Boolean> getStatus() {
//		return status;
//	}
//	public void setStatus(List<Boolean> status) {
//		this.status = status;
//	}
	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}
	public String getRoutenumber() {
		return routenumber;
	}
	public void setRoutenumber(String routenumber) {
		this.routenumber = routenumber;
	}
	
	public List<Map<String, String>> getPlacesArray() {
		return placesArray;
	}
//	public void setPlaces(Set<String> places) {
//		this.places = places;
//	}
//	public boolean isStatus() {
//		return Status;
//	}
//	public void setStatus(boolean status) {
//		Status = status;
//	}
//	@Override
//	public String toString() {
//		return "RoutesDetails [idNumber=" + idNumber + ", routenumber=" + routenumber + ", places=" + placesArray
//				+ ", Status=" + Status + "]";
//	}
	@JsonSetter("placesArray")
//    @JsonDeserialize(as = ArrayList.class)
    public void setPlacesArray(List<Map<String, String>> placesArray) {
        this.placesArray = placesArray;
    }
	

}
