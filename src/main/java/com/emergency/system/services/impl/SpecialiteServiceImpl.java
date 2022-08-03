package com.emergency.system.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emergency.system.entities.Specialite;
import com.emergency.system.repositories.SpecialiteRepository;
import com.emergency.system.services.ISpecialiteService;

@Service
public class SpecialiteServiceImpl implements ISpecialiteService{
	@Autowired
	private SpecialiteRepository specialiteRepository; 
	
	@Override
	public List<Specialite> getSpecialites() {
		return this.specialiteRepository.findAll();
	}

}
