package com.hopital.urgence.services.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hopital.urgence.entities.Disponibilite;
import com.hopital.urgence.exceptions.DisponibiliteFailException;
import com.hopital.urgence.exceptions.DisponibiliteNotFoundException;
import com.hopital.urgence.repositories.DisponibiliteRepository;
import com.hopital.urgence.services.IDisponibiliteService;

@Service
public class DisponibiliteServiceImpl implements IDisponibiliteService{
	
	@Autowired
	DisponibiliteRepository disponibiliteRepository;
	
	@Override
	public Disponibilite incrementerLits(int hopital_id, int specialite_id) throws Exception{
		try {
		
			Disponibilite disponibilite = this.getDisponibilite(hopital_id, specialite_id);
			try {
				disponibilite.setLits(disponibilite.getLits() + 1);
				disponibilite = this.disponibiliteRepository.save(disponibilite);
				if(disponibilite == null) {
					throw new Exception("disponibilité null");
				}
				return disponibilite;
			}
			catch(Exception e) {
				throw new DisponibiliteFailException(e.getMessage() + "Erreur lors de l'incrémentation du nombre de lits {hopital_id:" + hopital_id + ",specialite_id:" + specialite_id + "}");
			}
		}
		catch(Exception e) {
			throw e;
		}
	}

	@Override
	public Disponibilite decrementerLits(int hopital_id, int specialite_id) throws Exception{
		try {
			Disponibilite disponibilite = this.getDisponibilite(hopital_id, specialite_id);
			    
			try {
				disponibilite.setLits(disponibilite.getLits() - 1);
				disponibilite = this.disponibiliteRepository.save(disponibilite);
				if(disponibilite == null) {
					throw new Exception("disponibilité null");
				}
				return disponibilite;
			}
			catch(Exception e) {
				throw new DisponibiliteFailException(e.getMessage() + "\nErreur lors de la décrémentation du nombre de lits {hopital_id:" + hopital_id + ",specialite_id:" + specialite_id + "}");
			}
		}
		catch(Exception e) {
			throw e;
		}
	}

	@Override
	public Disponibilite getDisponibilite(int hopital_id, int specialite_id) throws Exception{
		try {
			 List<Disponibilite> disponibilites = this.disponibiliteRepository.findByHopitalAndSpecialite(hopital_id, specialite_id);
			if(disponibilites == null || disponibilites.size() == 0) {
				throw new DisponibiliteNotFoundException("Disponibilite null");
			}
			return disponibilites.get(0);
		}
		catch(Exception e) {
			throw new DisponibiliteNotFoundException(e.getMessage() + "\n aucune disponibilité pour les arguments suivants : {hopital_id:" + hopital_id + ",specialite_id:" + specialite_id + "}");
		}
	}
	

	@Override
	public List<Disponibilite> findBySpecialiteId(int specialite_id) throws Exception{
		try {
			List<Disponibilite> disponibilites = this.disponibiliteRepository.findBySpecialiteId(specialite_id);
			if(disponibilites.isEmpty()) {
				throw new DisponibiliteNotFoundException("List Disponibilites null");
			}
			return disponibilites;
		}
		catch(Exception e) {
			throw new DisponibiliteNotFoundException(e.getMessage() + "\n aucune disponibilité pour l'argument suivant : {specialite_id:" + specialite_id + "}");
		}
	}
}
