package com.hopital.urgence.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hopital.urgence.entities.Hopital;

public interface HopitalRepository extends MongoRepository<Hopital, Integer>{
	@SuppressWarnings("unchecked")
	public Hopital save(Hopital hopital);
	public Hopital findById(int hopitalid);
}
