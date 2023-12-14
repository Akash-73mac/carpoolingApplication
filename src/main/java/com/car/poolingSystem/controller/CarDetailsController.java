package com.car.poolingSystem.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.poolingSystem.entityPack.CarDetails;
import com.car.poolingSystem.service.CarDetailsService;

@RestController
@RequestMapping(value="/car")
public class CarDetailsController {
	 @Autowired
	  CarDetailsService carServ;
	 
	@PostMapping(value="/postCar")
	ResponseEntity <String> carPost(@RequestBody CarDetails carDet){
		return carServ.addCar(carDet);
	}
	@GetMapping(value="/getCar/{carid}")
	ResponseEntity<Optional<CarDetails>> getCar(@PathVariable("carid")  int carid){
		return  carServ.getCarDetails(carid);
	}

}
