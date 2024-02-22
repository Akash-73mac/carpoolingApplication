package com.car.poolingSystem.entityPack;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name = "driverDocuments")
public class DriverDocuments {
	@Id
	@GeneratedValue
	@Column(name="DocumentId")
	private int DocId;
	private String name;
	private String type;
//	@Lob
	@Column(length=50000000)
	private byte[] drivingLicense;
//	@Lob
//	@Column(length=50000000)
//	private byte[] idProof;

		
	public DriverDocuments() {
		super();
	}
	public DriverDocuments( String name, String type, byte[] drivingLicense) {
		super();
		
		this.name = name;
		this.type = type;
		this.drivingLicense = drivingLicense;
		
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getDocId() {
		return DocId;
	}
	public void setDocId(int docId) {
		DocId = docId;
	}
	public byte[] getDrivingLicense() {
		return drivingLicense;
	}
	public void setDrivingLicense(byte[] drivingLicense) {
		this.drivingLicense = drivingLicense;
	}
	@Override
	public String toString() {
		return "DriverDocuments [DocId=" + DocId + ", name=" + name + ", type=" + type + ", drivingLicense="
				+ Arrays.toString(drivingLicense) + "]";
	}
	
	

}
