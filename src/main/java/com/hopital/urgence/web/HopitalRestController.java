package com.hopital.urgence.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hopital.urgence.entities.Hopital;
import com.hopital.urgence.services.IHopitalService;

@RestController
public class HopitalRestController {
	Logger logger = LoggerFactory.getLogger(HopitalRestController.class);
	
	private IHopitalService hopitalService;
	
	public HopitalRestController(IHopitalService hopitalService) {
		this.hopitalService = hopitalService;
	}
	
	@GetMapping(path="/hopital", produces=MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Hopital> rechercherHopital(@RequestParam("lieuIncident") String lieuIncident, @RequestParam("specialite") int specialite) {
		
		try { 
			if(lieuIncident == null || specialite <=0) { 
			  throw new Exception("Le lieu incident ou spécialité incorrect"); 
			} 
			return new ResponseEntity<Hopital>(this.hopitalService.rechercherHopital(lieuIncident, specialite), HttpStatus.OK);
	  	}
	  	catch(Exception e) { 
	  		this.logger.error(e.getMessage()); 
	  		return new ResponseEntity<Hopital>(HttpStatus.INTERNAL_SERVER_ERROR);
	  	} 
	} 
}

