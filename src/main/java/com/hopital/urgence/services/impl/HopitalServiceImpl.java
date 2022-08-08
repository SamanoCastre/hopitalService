package com.hopital.urgence.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hopital.urgence.entities.Disponibilite;
import com.hopital.urgence.entities.Hopital;
import com.hopital.urgence.services.IDisponibiliteService;
import com.hopital.urgence.services.IGoogleDistanceMatrix;
import com.hopital.urgence.services.IHopitalService;

@Service
public class HopitalServiceImpl implements IHopitalService{
	
	@Autowired
	private IDisponibiliteService disponibiliteService;
	
	@Autowired
	private IGoogleDistanceMatrix distanceService;
	
	@Override
	public Hopital rechercherHopital(String lieu, int specialiteId) throws Exception {
		
		List<Disponibilite> listDisponibilites = this.disponibiliteService.findBySpecialiteId(specialiteId);
		String addresseLaPlusProche = this.distanceService.getClosestDestination(lieu, this.getDestinations(listDisponibilites));		
		
		Hopital hopital = null;
		int compteurDisponibilite = 0;
		
		while (hopital == null && compteurDisponibilite < listDisponibilites.size()) {
			Disponibilite disponibilite = listDisponibilites.get(compteurDisponibilite);
			
			if(addresseLaPlusProche.contains(disponibilite.getHopital().getAddress().getVille()) && 
					addresseLaPlusProche.contains(disponibilite.getHopital().getAddress().getPays()))
			{
				hopital = disponibilite.getHopital();
			}
			compteurDisponibilite++;
		}
		return hopital;
	}
	
	private String[] getDestinations(List<Disponibilite> listDisponibilites) {
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
