package com.emergency.system.services.impl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.emergency.system.entities.GoogleDistanceMatrixApiResponse;
import com.emergency.system.services.IGoogleDistanceMatrix;

@Service
public class GoogleDistanceMatrixImpl implements IGoogleDistanceMatrix {
	
	@Value("${API_KEY}")
    private String API_KEY;
	
	@Value("${DISTANCE_MATRIX_URI}")
    private String DISTANCE_MATRIX_URI;
	
	
    public GoogleDistanceMatrixImpl() {
		
	}
    
    public GoogleDistanceMatrixApiResponse compute(String addressFrom, String addressTo) {
    	try {
    		RestTemplate restTemplate = new RestTemplate();
	    	UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(DISTANCE_MATRIX_URI).queryParam("key",API_KEY).queryParam("origins", addressFrom).queryParam("destinations", addressTo);
	    	
	    	return  restTemplate.getForObject(builder.toUriString(), GoogleDistanceMatrixApiResponse.class);
    	}
    	catch(Exception e) {
    		throw e;
    	}
    }

	@Override
	public long getDistance(GoogleDistanceMatrixApiResponse googleDistanceMatrixApiResponse) throws Exception {
		try {
			return Long.parseLong(googleDistanceMatrixApiResponse.getRows().get(0).getElements().get(0).getDistance().getValue());
		}
		catch(Exception e) {
			throw e;
		}
	}
}
