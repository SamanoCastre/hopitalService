package com.hopital.urgence.services.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.maps.errors.ApiException;
import com.hopital.urgence.entities.Disponibilite;
import com.hopital.urgence.entities.Hopital;
import com.hopital.urgence.exceptions.NoDataFoundException;
import com.hopital.urgence.services.IDisponibiliteService;
import com.hopital.urgence.services.IGoogleDistanceMatrix;
import com.hopital.urgence.services.IHopitalService;

@Service
public class HopitalServiceImpl implements IHopitalService{
	
	
	@Autowired
	private IGoogleDistanceMatrix distanceService;
	
	@Autowired
	private IDisponibiliteService disponibiliteService;
	
	@Override
	public Hopital rechercherHopital(String lieu, int specialite_id) throws ApiException, InterruptedException, IOException {
		
		List<Disponibilite> listDisponibilites = this.disponibiliteService.findBySpecialiteId(specialite_id);
			
		String addresseLaPlusProche = this.distanceService.getClosestDestination(lieu, this.getDestinations(listDisponibilites));	
			
		Hopital hopital = null;
		int compteurDisponibilite = 0;
			
		while (hopital == null && compteurDisponibilite < listDisponibilites.size()) {
			Disponibilite disponibilite = listDisponibilites.get(compteurDisponibilite);
			
			if(addresseLaPlusProche != null 
					&& addresseLaPlusProche.contains(disponibilite.getHopital().getAddress().getVille()) 
					&& addresseLaPlusProche.contains(disponibilite.getHopital().getAddress().getPays()))
			{
				hopital = disponibilite.getHopital();
			}
			compteurDisponibilite++;
		}
		if(hopital == null) {
			throw new NoDataFoundException("Aucun hopital n'a été trouvé lors de la recherche");
		}
		return hopital;
	}
   
	public String[] getDestinations(List<Disponibilite> listDisponibilites) {
		String[] destinations = new String[listDisponibilites.size()];
		
		for (int i = 0; i < listDisponibilites.size(); i++) {
			Disponibilite disponibilite = listDisponibilites.get(i);
			StringBuilder sb = new StringBuilder();
			sb.append(disponibilite.getHopital().getAddress().getCodePostal());
			sb.append(" ");
			sb.append(disponibilite.getHopital().getAddress().getVille());
			sb.append(", ");
			sb.append(disponibilite.getHopital().getAddress().getPays());
			destinations[i] = sb.toString();
		}
		return destinations;
	}
}
