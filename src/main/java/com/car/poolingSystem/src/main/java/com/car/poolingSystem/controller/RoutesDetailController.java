package com.car.poolingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.poolingSystem.DTO.RoutesDetailsDTO;
import com.car.poolingSystem.service.RoutesDetailsService;

@RestController
@RequestMapping(value="/api")
@CrossOrigin
public class RoutesDetailController {
	@Autowired
	RoutesDetailsService routeService;
	
	@PostMapping(value="/postRoutes")
	public ResponseEntity<?> postRides(@RequestBody RoutesDetailsDTO routes){
		return  routeService.addRoutes(routes);
	}

}
