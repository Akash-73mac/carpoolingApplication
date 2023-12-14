package com.car.poolingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.car.poolingSystem.entityPack.TripDetails;
import com.car.poolingSystem.repository.TripInterface;

@Service
public class TripService {
	@Autowired
	TripInterface Triprepo;
	
	public ResponseEntity<String> postTrip(@RequestBody TripDetails tripdt){
		System.out.println(tripdt);
		Triprepo.save(tripdt);
		return ResponseEntity.ok().body("Stored");
	}
	
	

}
