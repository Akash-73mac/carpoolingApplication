package com.car.poolingSystem.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.car.poolingSystem.entityPack.RegistrationClass;

@Repository
public interface RegisterInterface extends JpaRepository <RegistrationClass,Integer> {

}
