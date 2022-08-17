package com.hopital.urgence.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hopital.urgence.entities.Disponibilite;
import com.hopital.urgence.services.IDisponibiliteService;

@RestController
public class DisponibiliteRestController {
	Logger logger = LoggerFactory.getLogger(DisponibiliteRestController.class);
	
	IDisponibiliteService disponibiliteService;
	
	public DisponibiliteRestController(IDisponibiliteService disponibiliteService) {
		this.disponibiliteService = disponibiliteService;
	}
	
	@PutMapping(path="/disponibilite/incrementer", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Disponibilite> incrementerLits(@RequestParam("hopital_id") int hopital_id, @RequestParam("specialite_id") int specialite_id) {
		
		try {
			if(hopital_id < 1 || specialite_id  < 1) {
				throw new Exception("l'hopital ou la specialite n'a pas été renseigné");
			}
		    return new ResponseEntity<Disponibilite>(this.disponibiliteService.incrementerLits(hopital_id, specialite_id), HttpStatus.CREATED);
		}
		catch(Exception e) {
			this.logger.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		}
	}
	
	@PutMapping(path="/disponibilite/decrementer", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Disponibilite> decrementerLits(@RequestParam("hopital_id") int hopital_id, @RequestParam("specialite_id") int specialite_id) {
		
		try {
			if(hopital_id < 1 || specialite_id  < 1) {
				throw new Exception("l'hopital ou la specialite n'a pas été renseigné");
			}
			return new ResponseEntity<Disponibilite>(this.disponibiliteService.decrementerLits(hopital_id, specialite_id), HttpStatus.CREATED);
		
		}
		catch(Exception e) {
			this.logger.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		}
	}
	
	@GetMapping(path="/disponibilite", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Disponibilite> getDisponibilite(@RequestParam("hopital_id") int hopital_id, @RequestParam("specialite_id") int specialite_id ) {
		
		try {
			if(hopital_id < 1 || specialite_id < 1) {
				throw new Exception("hopital ou specialite invalid");
			}
			return new ResponseEntity<Disponibilite>(this.disponibiliteService.getDisponibilite(hopital_id, specialite_id), HttpStatus.OK);
			
		}
		catch(Exception e) {
			this.logger.error(e.getMessage());
			return new ResponseEntity<Disponibilite>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
