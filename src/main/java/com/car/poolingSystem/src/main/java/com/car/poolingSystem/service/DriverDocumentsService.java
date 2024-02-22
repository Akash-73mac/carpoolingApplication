package com.car.poolingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.poolingSystem.entityPack.DriverDocuments;
import com.car.poolingSystem.repository.DriverDocumentsInterface;

@Service
public class DriverDocumentsService {
	@Autowired 
	DriverDocumentsInterface docRepo;
	public DriverDocuments docSave(DriverDocuments driveDoc) {
		return docRepo.save(driveDoc);	
	}
	
}
