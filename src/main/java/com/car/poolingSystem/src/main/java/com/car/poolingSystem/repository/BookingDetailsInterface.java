package com.car.poolingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.car.poolingSystem.entityPack.BookingDetails;


public interface BookingDetailsInterface extends JpaRepository<BookingDetails,Integer>{
	
//		List<BookingDetails> findByUserId(int riderId);
	
}
