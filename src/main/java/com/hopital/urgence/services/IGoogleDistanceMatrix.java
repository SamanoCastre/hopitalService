package com.hopital.urgence.services;

import java.io.IOException;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;

public interface IGoogleDistanceMatrix {
	
	public DistanceMatrix getDistanceMatrix(String addressFrom, String ...addressTo) throws ApiException, InterruptedException, IOException;
	public String getClosestDestination(String addressFrom, String[] destinations) throws ApiException, InterruptedException, IOException;
}
