package com.car.poolingSystem.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.car.poolingSystem.entityPack.UserDetails;
import com.car.poolingSystem.repository.RegisterInterface;
@Service	
public class LoginService {
	@Autowired
	RegisterInterface regRepo;

	
	public ResponseEntity<?> userLoginCheck(String email,String password){
		String encrypt= password;
		String enVAR="";
		for(int i=0;i<=encrypt.length()-1;i++)
		{
			char rand= (char) ((char)((int)encrypt.charAt(i)+3-65)%26+65);
			enVAR+=rand;
			System.out.println(enVAR); 
		}
		
		Optional<UserDetails> Email =regRepo.findByEmail(email);
		if(Email.isPresent()) {
			UserDetails register=Email.get();
			if(register.getPassword().equals(enVAR)) {
				Map<String, Object> response =new HashMap<>();
		  		response.put("message", "success");
		  		response.put("riderFirstName", register.getFirstName());
		  		response.put("riderLastName", register.getLastName());
		  		response.put("riderAge", register.getAge());
		  		response.put("riderEmail", register.getEmail());
		  		response.put("riderPhoneNumber",register.getPhoneNumber());
		  		response.put("role",register.getRole());
		  		response.put("userId",register.getUserId());
		  		if(register.getRole().equals("driver")) {
		  			
		  			response.put("carId",register.getCarDetails().getCarID ());
		  			response.put("model",register.getCarDetails().getModel());
		  			
		  		}
				return ResponseEntity.ok().body(response);
			}
			else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("incorrect password");
			}
			
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UserNot found");
		}
		
		
		
	}
	public ResponseEntity<?> checkAdminLogin(String email,String password){
		Optional<UserDetails> Email =regRepo.findByEmail(email);
		if(Email.isPresent()) {
			UserDetails register=Email.get();
			if(register.getPassword().equals(password)) {
				Map<String, Object> response =new HashMap<>();
		  		response.put("message", "success");
				return ResponseEntity.ok().body(response);
			}
			else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("incorrect password");
			}
			
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UserNot found");
		}
			
	}	
}
