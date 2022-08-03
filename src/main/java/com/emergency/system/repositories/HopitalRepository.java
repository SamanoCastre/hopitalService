package com.emergency.system.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.emergency.system.entities.Hopital;
import com.emergency.system.entities.Specialite;

public interface HopitalRepository extends MongoRepository<Hopital, Integer>{
	public Hopital save(Hopital hopital);
	public Hopital findById(int hopitalid);
}
