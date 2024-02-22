package com.car.poolingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.poolingSystem.entityPack.BookingDetails;
import com.car.poolingSystem.service.BookingDetailsService;

@RestController
@RequestMapping(value="/api")
@CrossOrigin
public class BookingDetailsController {
	@Autowired
	BookingDetailsService bookService;
	
	@PostMapping(value="/booking")
	ResponseEntity <?> postBooking(@RequestBody BookingDetails bookingDeatils){
		return bookService.postBookingDetails(bookingDeatils);	
	}
	
	@GetMapping(value="/myRides/{riderid}")
	ResponseEntity<?> getMyBooking(@PathVariable("riderid") Integer riderid ){
		System.out.println(riderid);
		return bookService.getIndividualRider(riderid);
	}
 }
