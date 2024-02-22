package com.car.poolingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.car.poolingSystem.entityPack.DriverDocuments;


@Repository
public interface DriverDocumentsInterface extends JpaRepository <DriverDocuments,Integer>{

}
