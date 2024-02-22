package com.car.poolingSystem.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.car.poolingSystem.entityPack.BookingDetails;
import com.car.poolingSystem.entityPack.TripDetails;
import com.car.poolingSystem.repository.BookingDetailsInterface;
import com.car.poolingSystem.repository.TripInterface;

@Service
public class BookingDetailsService {

	@Autowired
	BookingDetailsInterface bookRepo;

	@Autowired
	TripInterface tripdev;
	
	public ResponseEntity<?> postBookingDetails(@RequestBody BookingDetails bookingDetails){
		Optional<TripDetails> tripdetail=tripdev.findById(bookingDetails.getTripId());
		if(bookingDetails.getSeatsBooked()==0) {
				Map<String,String> response=new HashMap<String,String>();
				response.put("seats", "seat count not given");
				return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			
		}
		else if(bookingDetails.getSeatsBooked()<0) {
			Map<String,String> response=new HashMap<String,String>();
			response.put("seats", "negative is not accepted");
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		else if(bookingDetails.getSeatsBooked()>tripdetail.get().getAvalSeats()) {
			System.out.println(tripdetail.get().getAvalSeats());
			Map<String,String> response=new HashMap<String,String>();
			response.put("seats", "Only "+tripdetail.get().getAvalSeats()+" are avalaible");
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}
		else {
		
				TripDetails tripUpdat=tripdetail.get();
				short currentSeat=tripdetail.get().getAvalSeats();
				short updatedSeats=(short) (currentSeat-bookingDetails.getSeatsBooked());
				if(updatedSeats==0) {
					tripUpdat.setStatus("closed");
				}
				tripUpdat.setAvalSeats(updatedSeats);
				tripdev.save(tripUpdat);
				Map<String,String> response=new HashMap<String,String>();
				bookRepo.save(bookingDetails);
				response.put("message", "seats booked successfully");
				return  ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
		}
	}
	
	public ResponseEntity<?> getIndividualRider(int Id){
	 List<BookingDetails> myBookings=bookRepo.findAll();
	 List<Object> myDetails=new ArrayList<>(); 
	 	int i=1;
		for(BookingDetails details :myBookings) {
		if(details.getRiderId()==Id) {
			Map<String,Object> response=new HashMap<>();
			try {
				Optional<TripDetails> tripdetail =tripdev.findById(details.getTripId());
				response.put("from",tripdetail.get().getArrival());
				response.put("to",tripdetail.get().getDepature());
				response.put("carName",tripdetail.get().getCardet().getModel());
				response.put("seats",details.getSeatsBooked());
				response.put("date",tripdetail.get().getBookingDate());
				response.put("Index", i);
				response.put("amount",String.valueOf(details.getSeatsBooked()*tripdetail.get().getPriceToTravel()));
				i++;
				myDetails.add(response);	
			}
			catch(NoSuchElementException e) {
			System.out.println(e.getMessage());	
			}
			
		}
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(myDetails);
	}
	
}
