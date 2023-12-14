package com.car.poolingSystem.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.poolingSystem.entityPack.RegistrationClass;
import com.car.poolingSystem.service.RegisterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/api")
public class RegistrationController {
	
	@Autowired
	RegisterService registerSer;
	
	@PostMapping(value="/postUser")
	ResponseEntity<String> functionAddUser(@Valid @RequestBody RegistrationClass rec){
		System.out.println(rec);
		return registerSer.addUser(rec);
	}



}
