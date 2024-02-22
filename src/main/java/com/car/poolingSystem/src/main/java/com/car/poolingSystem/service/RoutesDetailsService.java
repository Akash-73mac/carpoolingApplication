package com.car.poolingSystem.service;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.car.poolingSystem.DTO.RoutesDetailsDTO;
import com.car.poolingSystem.entityPack.RoutesDetails;
import com.car.poolingSystem.repository.RoutesDetailsinterface;

@Service
public class RoutesDetailsService {
	@Autowired
	RoutesDetailsinterface RoutesRepo;
	@Autowired
	private ModelMapper modelMapper;

	
 public ResponseEntity<?> addRoutes(@RequestBody RoutesDetailsDTO routeDetails  ){
	 List<Map<String, String>> placesSet = routeDetails.getPlacesArray();

	 for(Map<String, String> route:placesSet) { 
		   String places = route.get("places");
		    String status =  route.get("status");

		    System.out.println("Places: " + places);
		    System.out.println("Status: " + status);
		    RoutesDetails route1= modelMapper.map(routeDetails,RoutesDetails.class  );
			 route1.setRoutenumber(routeDetails.getRoutenumber());
			 route1.setPlaces(places);
			 route1.setStatus(status);
			 RoutesRepo.save(route1); 	
		 }
	 
//	 public boolean checkRouteNunmber( String rec) {
//			System.out.println(RoutesRepo.findByEmail(rec));
// 
//			Optional<RoutesDetails> routesPresent = RoutesRepo.findByEmail(rec);
//				if(routesPresent.isPresent()){
//					
//					return true;			
//				}
//				else {
//					return false;
//				} 
//	 }
		 
		
//		 route1.setPlaces(route);
		
//	     route1.setStatus(routeDetails.isStatus());
	    
	 
	 
//	 System.out.println(routeDetails.getPlaces());
//	
//	 
//	 Set<String> placesSet = routeDetails.getPlaces();
//	 Set<String> tempset = null;
//	 for(String route:placesSet) { 
//		 tempset = new HashSet<String>();
//		 RoutesDetails routesDetails1 = new RoutesDetails();
//		 tempset.add(route);
//		 routesDetails1.setPlaces(tempset);
//		 routesDetails1.setRoutenumber(routeDetails.getRoutenumber());
//		 routesDetails1.setStatus(routeDetails.isStatus());
//		 
//
//		 this.RoutesRepo.save(routesDetails1);
//		
// }
	 
//	 placesSet.add(route);
//	 routedetails.setPlaces(placesSet);
	 
//	 System.out.println(route);	
	 
//	 RoutesDetails routeDetails = new RoutesDetails();
	 
//	 System.out.println(placesSet);
//	 routeDetails.setPlaces(placesSet);
//	 RoutesRepo.save(route1);
	 
	return ResponseEntity.ok().body("response");
 }
 
}
