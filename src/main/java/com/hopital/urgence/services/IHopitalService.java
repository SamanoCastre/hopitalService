package com.hopital.urgence.services;

import java.util.List;

import com.hopital.urgence.entities.Disponibilite;
import com.hopital.urgence.entities.Hopital;

public interface IHopitalService {
	
	public Hopital rechercherHopital(String lieu, int specialite_id)  throws Exception;
	public String[] getDestinations(List<Disponibilite> listDisponibilites) throws Exception;
}
