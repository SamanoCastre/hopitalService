package com.hopital.urgence.services;

import com.google.maps.model.DistanceMatrix;

public interface IGoogleDistanceMatrix {
	
	public DistanceMatrix getDistanceMatrix(String addressFrom, String ...addressTo) throws Exception;
	public String getClosestDestination(String addressFrom, String ...addressTo) throws Exception;
}
