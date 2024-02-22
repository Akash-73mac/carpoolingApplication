package com.car.poolingSystem.service;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.car.poolingSystem.entityPack.UserDetails;
import com.car.poolingSystem.repository.DriverDocumentsInterface;
import com.car.poolingSystem.repository.RegisterInterface;

@Service
public class RegisterService {
	@Autowired
	RegisterInterface regRepo;

	@Autowired 
	DriverDocumentsInterface docRepo;
	 public ResponseEntity<String> addUser(@RequestBody UserDetails RegValues ){
		 
		 if(RegValues.getFirstName().length()>10)
		 {
			 return ResponseEntity.ok().body("First nan must less than 10");
		 }
		String encrypt= RegValues.getPassword();
		String enVAR="";
		for(int i=0;i<=encrypt.length()-1;i++)
		{
			char rand= (char) ((char)((int)encrypt.charAt(i)+3-65)%26+65);
			enVAR+=rand;
			System.out.println(enVAR); 
		}
		 RegValues.setPassword(enVAR);
		 System.out.println(encrypt);
		 System.out.println(RegValues);
		 if(checkEmail(RegValues.getEmail())) {
			 Map<String, Object> emailexist =new HashMap<>();
		  	emailexist.put("message", true);
				return ResponseEntity.ok().body("emailexist");	 
		 }
		 else {
			 if(RegValues.getAge()<=0) {
				 return ResponseEntity.ok().body("Stored");
			 }
			 else {
				 regRepo.save(RegValues);	
//				 docRepo.save(RegValues);  
//				 DriverDocuments driverDocuments = new DriverDocuments();
				 
				 return ResponseEntity.ok().body("Stored");
			 }
			 
		 }
		 	
	 }
	 
	 public boolean checkEmail( String rec) {
			System.out.println(regRepo.findByEmail(rec));
			Optional<UserDetails> registration = regRepo.findByEmail(rec);
				if(registration.isPresent()){
					return true;
				}
				else {
					return false;
				} 
	 }
	
	public ResponseEntity<?> checkEmailRegistered( String rec) {
		System.out.println(regRepo.findByEmail(rec));
		Optional<UserDetails> registration = regRepo.findByEmail(rec);
		Map<String, Object> response =new HashMap<>();
		try{
				if(registration.isPresent()){
				
		  		response.put("message", true);
//				return ResponseEntity.ok().body(response);
			}
			else {
//				Map<String, Object> response =new HashMap<>();
		  		response.put("message", false);
				

			} 
		}catch(StackOverflowError e){
			
		}
		return ResponseEntity.ok().body(response);
		}
	
	
}

