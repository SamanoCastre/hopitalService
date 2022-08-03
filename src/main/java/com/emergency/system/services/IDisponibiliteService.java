package com.emergency.system.services;

import java.util.List;

import com.emergency.system.entities.Disponibilite;

public interface IDisponibiliteService {
	public Disponibilite incrementerLits(int hopital_id, int specialite_id);
	public Disponibilite decrementerLits(int hopital_id, int specialite_id);
	public Disponibilite getDisponibilite(int hopital_id, int specialite_id);
	public List<Disponibilite>findBySpecialiteId(int specialite_id);
}
