package com.hopital.urgence.services;

import java.io.IOException;

import com.google.maps.errors.ApiException;
import com.hopital.urgence.entities.Hopital;

public interface IHopitalService {
	
	public Hopital rechercherHopital(String lieu, int specialite_id) throws ApiException, InterruptedException, IOException;
}
