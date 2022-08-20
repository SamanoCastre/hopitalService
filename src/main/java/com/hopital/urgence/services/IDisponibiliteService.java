package com.hopital.urgence.services;

import java.util.List;

import com.hopital.urgence.entities.Disponibilite;
import com.hopital.urgence.exceptions.ResourceNotUpdatedException;
import com.hopital.urgence.exceptions.NoDataFoundException;
import com.hopital.urgence.exceptions.ResourceNotFoundException;

public interface IDisponibiliteService {
	public Disponibilite incrementerLits(int hopital_id, int specialite_id) throws ResourceNotUpdatedException, ResourceNotFoundException;
	public Disponibilite decrementerLits(int hopital_id, int specialite_id) throws ResourceNotUpdatedException, ResourceNotFoundException;
	public Disponibilite getDisponibilite(int hopital_id, int specialite_id) throws ResourceNotFoundException ;
	public List<Disponibilite>findBySpecialiteId(int specialite_id) throws NoDataFoundException;
}
