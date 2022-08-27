package com.hopital.urgence.services.impl;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElement;
import com.google.maps.model.TravelMode;
import com.hopital.urgence.services.IDistanceMatrix;

@Service
public class GoogleDistanceMatrixImpl implements IDistanceMatrix {
	
	@Value("${google.distance.api.key}")
    private String API_KEY;
	
	
    public GoogleDistanceMatrixImpl() {
    	
	}
    
    @Override
    public DistanceMatrix getDistanceMatrix(String addressFrom, String ...addressTo) throws ApiException, InterruptedException, IOException  {
    	
    	final GeoApiContext context = new GeoApiContext.Builder().apiKey(API_KEY).build();
		DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(context); 
		String[] addresses = new String[1];
		addresses[0] = addressFrom;
		   DistanceMatrix distanceMatrix = req.origins(addresses)
		       .destinations(addressTo)
		       .mode(TravelMode.DRIVING)
		       //.avoid(RouteRestriction.HIGHWAYS)
		       .language("fr-FR")
		       .await();
		return distanceMatrix;
    }
    
    @Override
    public String getClosestDestination(String addressFrom, String[] destinationsTo) throws ApiException, InterruptedException, IOException {
    	
    	DistanceMatrix distanceMatrix = this.getDistanceMatrix(addressFrom, destinationsTo);
		DistanceMatrixElement[] elements = distanceMatrix.rows[0].elements;
		String[] destinations = distanceMatrix.destinationAddresses;
		
		long plusPetiteDistance = -1;
		String addresseCorrespondante =  "";
		
		for (int i = 0; i < destinations.length; i++) {
			if(plusPetiteDistance == -1 || elements[i].distance.inMeters < plusPetiteDistance) {
				plusPetiteDistance = elements[i].distance.inMeters;
				addresseCorrespondante = destinations[i];
			}
		}
		return addresseCorrespondante;
	}
}
