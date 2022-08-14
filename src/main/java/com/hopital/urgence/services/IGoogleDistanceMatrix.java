package com.hopital.urgence.services;

import java.util.ArrayList;
import java.util.List;

import com.google.maps.model.DistanceMatrix;
import com.hopital.urgence.entities.Disponibilite;

public interface IGoogleDistanceMatrix {
	
	public DistanceMatrix getDistanceMatrix(String addressFrom, String ...addressTo) throws Exception;
	public String getClosestDestination(String addressFrom, String[] destinations) throws Exception;
}
