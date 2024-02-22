package com.car.poolingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.poolingSystem.entityPack.TripDetails;
import com.car.poolingSystem.service.TripService;

@RestController
@RequestMapping(value="/trip")
@CrossOrigin
public class TripController {
	@Autowired
	TripService tripSev;
	
	@PostMapping(value="/book")
	ResponseEntity <?> bookStrip(@RequestBody TripDetails tripdet){
		return tripSev.postTrip(tripdet) ;
	}
	@GetMapping(value="/displayTrips")
	ResponseEntity<?> getAllTrips(TripDetails tripdet){
		return tripSev.getAllTripDetails(tripdet) ;
	}
	
	@GetMapping(value="/individualDriverTrip/{driverId}")
	ResponseEntity<?> getIndividualTrips(@PathVariable("driverId") Integer dId){
		System.out.println(dId);
		return tripSev.getInndividualPosts(dId);
	}
		
	
	@DeleteMapping(value="/deleteMyPost/{tripid}")
		ResponseEntity<?> deleteIndividualTrips(@PathVariable("tripid") Integer dId){
			System.out.println(dId);
			return tripSev.deleteIndividualPosts(dId);
		}
	

	@GetMapping(value="/closeMyPost/{closeId}")
	ResponseEntity <?> closeMyPost(@PathVariable("closeId") Integer dId){
	System.out.println(dId);
		return tripSev.closeIndividualTrip(dId) ;
	}
		
		
}
