package com.car.poolingSystem.entityPack;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;

@Entity
public class RoutesDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idNumber_seq")
    @SequenceGenerator(name = "idNumber_seq", sequenceName = "idNumber_sequence", allocationSize = 1)
	private int idNumber;
	@NotBlank
	private String routenumber;
	@NotBlank		
	 private String places;
//	Set<String> = new LinkedHashSet<>()
	private String Status;
	public int getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}
	public String getRoutenumber() {
		return routenumber;
	}
	public void setRoutenumber(String routenumber) {
		this.routenumber = routenumber;
	}
	
	
	public String getPlaces() {
		return places;
	}
	public void setPlaces(String places) {
		this.places = places;
	}
	public String isStatus() {
		return Status;
	}
	public void setStatus(String status2) {
		Status = status2;
	}
	@Override
	public String toString() {
		return "RoutesDetails [idNumber=" + idNumber + ", routenumber=" + routenumber + ", places=" + places
				+ ", Status=" + Status + "]";
	}
	
	
	

}
