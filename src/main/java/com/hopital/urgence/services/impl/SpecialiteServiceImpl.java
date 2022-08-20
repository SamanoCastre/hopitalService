package com.hopital.urgence.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hopital.urgence.entities.Specialite;
import com.hopital.urgence.exceptions.NoDataFoundException;
import com.hopital.urgence.repositories.SpecialiteRepository;
import com.hopital.urgence.services.ISpecialiteService;

@Service
public class SpecialiteServiceImpl implements ISpecialiteService{
	@Autowired
	private SpecialiteRepository specialiteRepository; 
	
	@Override
	public List<Specialite> getSpecialites() throws NoDataFoundException{
		List<Specialite> list = this.specialiteRepository.findAll();
		if(list.isEmpty()) throw new NoDataFoundException("Aucune spécialité n'a été trouvée dans la base de donnée");
		return list;
	}

}
