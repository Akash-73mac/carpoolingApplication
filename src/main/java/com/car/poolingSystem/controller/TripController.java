package com.car.poolingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.poolingSystem.entityPack.TripDetails;
import com.car.poolingSystem.service.TripService;

@RestController
@RequestMapping(value="/trip")
public class TripController {
	@Autowired
	TripService tripSev;
	@PostMapping(value="/book")
	ResponseEntity <String> bookStrip(@RequestBody TripDetails tripdet){
		return tripSev.postTrip(tripdet) ;
	}
	
	

}
