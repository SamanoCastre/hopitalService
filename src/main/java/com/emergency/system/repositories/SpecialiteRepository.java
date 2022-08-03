package com.emergency.system.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.emergency.system.entities.Specialite;

public interface SpecialiteRepository extends MongoRepository<Specialite, Integer>{
	
	public List<Specialite> findByName(String name);
	
	public Specialite findById(int specialiteId);
	
	public Specialite save(Specialite specialite);

}
