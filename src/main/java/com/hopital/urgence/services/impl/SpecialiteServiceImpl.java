package com.hopital.urgence.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hopital.urgence.entities.Specialite;
import com.hopital.urgence.repositories.SpecialiteRepository;
import com.hopital.urgence.services.ISpecialiteService;

@Service
public class SpecialiteServiceImpl implements ISpecialiteService{
	@Autowired
	private SpecialiteRepository specialiteRepository; 
	
	@Override
	public List<Specialite> getSpecialites() throws Exception{
		return this.specialiteRepository.findAll();
	}

}
