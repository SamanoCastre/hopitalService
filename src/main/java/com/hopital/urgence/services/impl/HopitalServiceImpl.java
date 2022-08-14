package com.hopital.urgence.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElement;
import com.hopital.urgence.entities.Disponibilite;
import com.hopital.urgence.entities.Hopital;
import com.hopital.urgence.exceptions.RechercheFailException;
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
	public Hopital rechercherHopital(String lieu, int specialite_id) throws Exception {
		
		try {
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
				throw new Exception("hopital null");
			}
			return hopital;
		}
		catch(Exception e) {
			throw new RechercheFailException( e.getMessage() + "\n hopital null pour les arguments suivants : {lieu:"+lieu + ",specialite_id:" + specialite_id + "}");
		}
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
