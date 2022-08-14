package com.hopital.urgence.services;

import java.util.List;

import com.hopital.urgence.entities.Disponibilite;

public interface IDisponibiliteService {
	public Disponibilite incrementerLits(int hopital_id, int specialite_id) throws Exception;
	public Disponibilite decrementerLits(int hopital_id, int specialite_id) throws Exception;
	public Disponibilite getDisponibilite(int hopital_id, int specialite_id) throws Exception;
	public List<Disponibilite>findBySpecialiteId(int specialite_id) throws Exception;
}
