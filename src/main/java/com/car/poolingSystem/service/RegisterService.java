package com.car.poolingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.car.poolingSystem.entityPack.RegistrationClass;
import com.car.poolingSystem.repository.RegisterInterface;

@Service
public class RegisterService {
	@Autowired
	RegisterInterface regRepo;
	
	 public ResponseEntity<String> addUser(@RequestBody RegistrationClass RegValues ){
		 
		 if(RegValues.getFirstName().length()>10)
		 {
			 return ResponseEntity.ok().body("First must less than 10");
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
		 regRepo.save(RegValues);
		 return ResponseEntity.ok().body("Stored");
	 }

}

