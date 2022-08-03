package com.emergency.system.services;

import com.emergency.system.entities.GoogleDistanceMatrixApiResponse;

public interface IGoogleDistanceMatrix {
	
	public GoogleDistanceMatrixApiResponse compute(String addressFrom, String addressTo);
	public long getDistance(GoogleDistanceMatrixApiResponse googleDistanceMatrixApiResponse) throws Exception;
}
