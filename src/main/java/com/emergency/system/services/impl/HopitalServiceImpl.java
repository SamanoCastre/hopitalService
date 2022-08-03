package com.emergency.system.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emergency.system.entities.Disponibilite;
import com.emergency.system.entities.GoogleDistanceMatrixApiResponse;
import com.emergency.system.entities.Hopital;
import com.emergency.system.services.IDisponibiliteService;
import com.emergency.system.services.IGoogleDistanceMatrix;
import com.emergency.system.services.IHopitalService;

@Service
public class HopitalServiceImpl implements IHopitalService{
	
	@Autowired
	private IDisponibiliteService disponibiliteService;
	
	@Autowired
	private IGoogleDistanceMatrix distanceService;
	 
	

	@Override
	public Hopital rechercherHopital(String lieu, int specialiteId) {
		
		List<Disponibilite> listDisponibilites = this.disponibiliteService.findBySpecialiteId(specialiteId);
		
		Hopital hopital = null;
		long distance = -1;
		
		for (Disponibilite disponibilite : listDisponibilites) {
			try {
				GoogleDistanceMatrixApiResponse googleDistanceMatrixApiResponse = distanceService.compute(lieu, disponibilite.getHopital().getAddress().getCodePostal() + " " + disponibilite.getHopital().getAddress().getVille()+", "+ disponibilite.getHopital().getAddress().getPays());
				
				long distanceEnCours = distanceService.getDistance(googleDistanceMatrixApiResponse);
				
				if(distance <0 || distanceEnCours < distance ) {
					distance = distanceEnCours;
					hopital = disponibilite.getHopital();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return hopital;
	}
}
