package com.emergency.system.services;

import com.emergency.system.entities.Hopital;

public interface IHopitalService {
	
	public Hopital rechercherHopital(String lieu, int specialisation);
}
