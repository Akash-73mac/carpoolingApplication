package com.car.poolingSystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.car.poolingSystem.entityPack.CarDetails;
import com.car.poolingSystem.repository.CarDetailsInterface;
@Service
public class CarDetailsService {
	@Autowired
	CarDetailsInterface carRepo;
	
	public ResponseEntity<String> addCar(@RequestBody CarDetails cardetail){
		carRepo.save( cardetail);
		return ResponseEntity.ok().body("stored");
		
	}
	public ResponseEntity<Optional<CarDetails>> getCarDetails(int carid) {
		//carRepo.findById(carid);
		return ResponseEntity.ok().body(carRepo.findById(carid)) ;
	}
}
