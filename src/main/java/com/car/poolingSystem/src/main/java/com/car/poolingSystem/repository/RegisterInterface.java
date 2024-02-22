package com.car.poolingSystem.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.car.poolingSystem.entityPack.UserDetails;

@Repository
public interface RegisterInterface extends JpaRepository <UserDetails,Integer> {
	 
//    @Query("SELECT email FROM RegistrationClass r WHERE r.email = :email") 
	    Optional<UserDetails> findByEmail(String email);
        Optional<UserDetails> findByPassword(String password);
}
