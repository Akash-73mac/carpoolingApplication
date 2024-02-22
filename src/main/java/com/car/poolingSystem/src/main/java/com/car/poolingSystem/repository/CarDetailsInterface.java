package com.car.poolingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.car.poolingSystem.entityPack.CarDetails;

public interface CarDetailsInterface extends JpaRepository<CarDetails,Integer> {

}
