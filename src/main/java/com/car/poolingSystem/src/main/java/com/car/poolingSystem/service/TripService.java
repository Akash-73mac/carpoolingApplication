package com.car.poolingSystem.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.car.poolingSystem.entityPack.TripDetails;
import com.car.poolingSystem.repository.TripInterface;

@Service
public class TripService {
	@Autowired
	TripInterface Triprepo;
	
	
	public ResponseEntity<?> postTrip(@RequestBody TripDetails tripdt){
		if(tripdt.getArrival().isEmpty() || 
				tripdt.getDepature().isEmpty()||
				tripdt.getBookingDate()==null ||
				tripdt.getAvalSeats()==0) {
			Map<String,String> tripSta=new HashMap<String,String>();
			tripSta.put("msg", "fill all fields");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(tripSta);
		}
		else {

			tripdt.setStatus("active");
			tripdt.setBookedSeats(tripdt.getAvalSeats());
			List<TripDetails> toFindActive=Triprepo.findAll();
			for(TripDetails individualFindAvtive:toFindActive) {
				if(individualFindAvtive.getStatus().equals("active") && individualFindAvtive.getUserdetails().getUserId()==tripdt.getUserdetails().getUserId()) {
					Map<String,String> tripSta=new HashMap<String,String>();
					tripSta.put("msg", "please close the previous trip");
					return ResponseEntity.status(HttpStatus.ACCEPTED).body(tripSta);	
				}
				
			}
			Map<String,String> tripSta2=new HashMap<String,String>();
			tripSta2.put("msg", " trip posted successfully");
				Triprepo.save(tripdt);
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(tripSta2);
			
		}
		
	}
	
	public ResponseEntity<?> getAllTripDetails(TripDetails tripdt){
		List<TripDetails> allResponse=new ArrayList<>();
		List<Object> allResponse1=new ArrayList<>();
	       allResponse=	Triprepo.findAll();
	       
	       int i=0;
	       for(TripDetails objectData:allResponse) {
	    	   if(objectData.getAvalSeats()>0 && objectData.getStatus().equals("active")) {
	    		   Map<String, Object> response =new HashMap<>();
			       Map<Integer, Object> response1 =new HashMap<>();
		    	   response.put("DriverName",objectData.getUserdetails().getFirstName()+" "+
		           objectData.getUserdetails().getFirstName());
		    	   System.out.println(objectData.getUserdetails().getFirstName()+" "+
		    	   objectData.getUserdetails().getFirstName());
		    	   response.put("Depature",objectData.getDepature());
		    	   response.put("Arrival",objectData.getArrival());
		    	   response.put("Seats",objectData.getAvalSeats());
		    	   response.put("via", objectData.getRoute());
		    	   response.put("carModel",objectData.getCardet().getModel());
		    	   response.put("prize", objectData.getPriceToTravel());
		    	   response.put("Distance", objectData.getDistance());
		    	   response.put("driverId",objectData.getUserdetails().getUserId());
		    	   response.put("trip", objectData.getTripId());
		    	   response1.put(i,response);
		    	   allResponse1.add(response);
		    	   i++;
   
	    	   }
	    	 
      }

		return ResponseEntity.ok().body(allResponse1);
				
	}
	
	public ResponseEntity<?> getInndividualPosts(Integer id){
		System.out.println(id);
		List<TripDetails> driverData=new ArrayList<>();
		List<Object> driverData1=new ArrayList<>();
		int j=1;
	    driverData=Triprepo.findAll();
	    for(TripDetails driverTrip:driverData)
	    {
	    	 Map<String, Object> response =new HashMap<>();
		       Map<Integer, Object> response1 =new HashMap<>();
		       if(driverTrip.getUserdetails().getUserId()==id) {
		    	   response.put("from", driverTrip.getDepature());
			       response.put("to", driverTrip.getArrival());
			       response.put("date", driverTrip.getBookingDate());
			       response.put("price", driverTrip.getPriceToTravel());
			       response.put("index",j);
			       response.put("seats",driverTrip.getBookedSeats());
			       if(driverTrip.getAvalSeats()==0) {
			    	   response.put("booked",driverTrip.getBookedSeats()); 
			       }
			       else {
			    	   response.put("booked",Math.abs( driverTrip.getBookedSeats()-driverTrip.getAvalSeats()));  
			       }
			       response.put("trip", driverTrip.getTripId());
			       response.put("status", driverTrip.getStatus());
			       response1.put(j, response);
			       driverData1.add(response);
			       j++;
		       }
		      
	    }
	System.out.println(driverData1);
	return ResponseEntity.ok().body(driverData1); 
	}
	
	public ResponseEntity<?> deleteIndividualPosts(Integer id){
		System.out.println(id);
		Triprepo.deleteById(id);
		Map<String,String> response=new HashMap<>();
		response.put("msg","post deleted Successfully");
		return  ResponseEntity.status(HttpStatus.ACCEPTED).body(response) ;
	}
	 public ResponseEntity<?> closeIndividualTrip(Integer id){
		 Optional<TripDetails> tripcloseData=Triprepo.findById(id);
		 try {
			 System.out.println(tripcloseData.get().getStatus()); 
			 TripDetails proces= tripcloseData.get();
			 proces.setStatus("closed");
			 Triprepo.save(proces);
		 }catch(StackOverflowError e) {
			 System.err.println(e.getMessage());
		 }
		 Map<String,String> response=new HashMap<>();
			response.put("msg","trip closed Successfully");
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(response) ;
	 }
	 
}
