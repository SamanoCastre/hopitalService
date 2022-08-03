package com.emergency.system.services.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emergency.system.entities.Disponibilite;
import com.emergency.system.repositories.DisponibiliteRepository;
import com.emergency.system.services.IDisponibiliteService;

@Service
public class DisponibiliteServiceImpl implements IDisponibiliteService{
	
	@Autowired
	DisponibiliteRepository disponibiliteRepository;
	
	@Override
	public Disponibilite incrementerLits(int hopital_id, int specialite_id) {
		
		Disponibilite disponibilite = this.getDisponibilite(hopital_id, specialite_id);
		if(disponibilite != null) {
			disponibilite.setLits(disponibilite.getLits() + 1);
			this.disponibiliteRepository.save(disponibilite);
		}
		return disponibilite;
	}

	@Override
	public Disponibilite decrementerLits(int hopital_id, int specialite_id) {
		Disponibilite disponibilite = this.getDisponibilite(hopital_id, specialite_id);
		if(disponibilite != null) {
			disponibilite.setLits(disponibilite.getLits() - 1);
			this.disponibiliteRepository.save(disponibilite);
		}
		return disponibilite;
	}

	@Override
	public Disponibilite getDisponibilite(int hopital_id, int specialite_id) {
		return this.disponibiliteRepository.findByHopitalAndSpecialite(hopital_id, specialite_id).get(0);
	}

	@Override
	public List<Disponibilite> findBySpecialiteId(int specialite_id) {
		return this.disponibiliteRepository.findBySpecialiteId(specialite_id);
	}
    
}
