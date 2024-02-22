package com.car.poolingSystem.controller;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.car.poolingSystem.entityPack.DriverDocuments;
import com.car.poolingSystem.entityPack.UserDetails;
import com.car.poolingSystem.service.LoginService;
import com.car.poolingSystem.service.RegisterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/api")
@CrossOrigin
public class RegistrationController {
	
	@Autowired
	RegisterService registerSer;
	@Autowired
	LoginService logSer;
	
	@PostMapping(value="/postUser")
	ResponseEntity<String> functionAddUser(@Valid @RequestBody UserDetails rec){
		return registerSer.addUser(rec);
	}
	
	
	@PostMapping(value="/postDriver",consumes= {MediaType.MULTIPART_FORM_DATA_VALUE})
	ResponseEntity<?> functionAddDriver(@RequestPart("user") UserDetails rec,@RequestPart("images")MultipartFile[] file){
		try {
			Set<DriverDocuments> images=processImage(file);
			rec.setDriverDocuments(images);
			return registerSer.addUser(rec);		
		}
		catch(Exception e){
			return registerSer.addUser(rec);	
		}
			
	}
	
	
	public Set<DriverDocuments> processImage(MultipartFile[] multiplefiles) throws IOException {
		Set<DriverDocuments> driverDocuments=new HashSet<>();
		for(MultipartFile file:multiplefiles) {
			DriverDocuments driverDocument=new DriverDocuments(file.getOriginalFilename(),file.getContentType(),file.getBytes());
			System.out.println(file.getOriginalFilename()+" "+file.getName());
			driverDocuments.add(driverDocument);
		}
		return driverDocuments;
	}
	
	
  	@GetMapping(value="/getEmail/{checkEmail}")
	ResponseEntity<?> getEmailRegistered(@PathVariable("checkEmail") String rec ){
  		
		return registerSer.checkEmailRegistered(rec);
	}
  	
  	@GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        return logSer.userLoginCheck(email, password);
    }
  	@GetMapping("/adminLogin")
    public ResponseEntity<?> adminLogin(@RequestParam String email, @RequestParam String password) {
        return logSer.checkAdminLogin(email, password);
    }
	

}
