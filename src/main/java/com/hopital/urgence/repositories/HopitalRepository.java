package com.hopital.urgence.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hopital.urgence.entities.Hopital;
import com.hopital.urgence.entities.Specialite;

public interface HopitalRepository extends MongoRepository<Hopital, Integer>{
	public Hopital save(Hopital hopital);
	public Hopital findById(int hopitalid);
}
