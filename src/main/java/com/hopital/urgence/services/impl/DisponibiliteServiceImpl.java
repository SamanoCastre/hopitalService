package com.hopital.urgence.services.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hopital.urgence.entities.Disponibilite;
import com.hopital.urgence.exceptions.ResourceNotUpdatedException;
import com.hopital.urgence.exceptions.NoDataFoundException;
import com.hopital.urgence.exceptions.NoMoreBedFoundException;
import com.hopital.urgence.exceptions.ResourceNotFoundException;
import com.hopital.urgence.repositories.DisponibiliteRepository;
import com.hopital.urgence.services.IDisponibiliteService;

@Service
public class DisponibiliteServiceImpl implements IDisponibiliteService{
	
	@Autowired
	DisponibiliteRepository disponibiliteRepository;
	
	@Override
	public Disponibilite incrementerLits(int hopital_id, int specialite_id) throws ResourceNotUpdatedException, ResourceNotFoundException {
		
			Disponibilite disponibilite = this.getDisponibilite(hopital_id, specialite_id);
			disponibilite.setLits(disponibilite.getLits() + 1);
			disponibilite = this.disponibiliteRepository.save(disponibilite);
			if(disponibilite == null) {
				throw new ResourceNotUpdatedException("Erreur lors de la mise à jour de la disponibilité");
			}
			return disponibilite;	
	}

	@Override
	public Disponibilite decrementerLits(int hopital_id, int specialite_id) throws ResourceNotUpdatedException, ResourceNotFoundException {
	
		Disponibilite disponibilite = this.getDisponibilite(hopital_id, specialite_id); 
		if(disponibilite.getLits() <= 0) {
			throw new NoMoreBedFoundException("Aucun lit n'est disponible pour l'hopital " + hopital_id + " et specialite_id : " + specialite_id);
		}
		disponibilite.setLits(disponibilite.getLits() - 1);
		disponibilite = this.disponibiliteRepository.save(disponibilite);
		if(disponibilite == null) {
			throw new ResourceNotUpdatedException("Erreur lors de la mise à jour de la disponibilité");
		}
		return disponibilite;
	}

	@Override
	public Disponibilite getDisponibilite(int hopital_id, int specialite_id) throws ResourceNotFoundException {
		
		List<Disponibilite> disponibilites = this.disponibiliteRepository.findByHopitalAndSpecialite(hopital_id, specialite_id);
		if(disponibilites == null || disponibilites.size() == 0) {
			throw new ResourceNotFoundException("Disponibilite null");
		}
		return disponibilites.get(0);
	}
	

	@Override
	public List<Disponibilite> findBySpecialiteId(int specialite_id) throws NoDataFoundException{
		
		List<Disponibilite> disponibilites = this.disponibiliteRepository.findBySpecialiteId(specialite_id);
		if(disponibilites.isEmpty()) {
			throw new NoDataFoundException("List disponibilités null");
		}
		return disponibilites;
	}
}
