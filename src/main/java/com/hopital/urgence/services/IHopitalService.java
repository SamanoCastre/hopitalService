package com.hopital.urgence.services;

import com.hopital.urgence.entities.Hopital;

public interface IHopitalService {
	
	public Hopital rechercherHopital(String lieu, int specialisation) throws Exception;
}
