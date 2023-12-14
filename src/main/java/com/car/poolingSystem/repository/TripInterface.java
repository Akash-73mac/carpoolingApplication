package com.car.poolingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.car.poolingSystem.entityPack.TripDetails;

public interface TripInterface extends JpaRepository<TripDetails,Integer>{

}
