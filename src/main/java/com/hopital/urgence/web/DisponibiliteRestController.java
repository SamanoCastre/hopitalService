package com.hopital.urgence.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hopital.urgence.entities.Disponibilite;
import com.hopital.urgence.services.IDisponibiliteService;

@SuppressWarnings("finally")
@RefreshScope
@RestController
public class DisponibiliteRestController {
	Logger logger = LoggerFactory.getLogger(DisponibiliteRestController.class);
	@Autowired
	IDisponibiliteService disponibiliteService;
	
	@PutMapping("/disponibilite/incrementer")
	public Disponibilite incrementerLits(@RequestParam("hopital_id") int hopital_id, @RequestParam("specialite_id") int specialite_id) {
		Disponibilite disponibilite = null;
		
		try {
			if(hopital_id<0 || specialite_id <0) {
				throw new Exception("l'hopital ou la specialite n'a pas été renseigné");
			}
		    disponibilite = this.disponibiliteService.incrementerLits(hopital_id, specialite_id);
		}
		catch(Exception e) {
			this.logger.error(e.getMessage());
		}
		finally {
			return disponibilite; 
		}
	}
	
	@PutMapping("/disponibilite/decrementer")
	public Disponibilite decrementerLits(@RequestParam("hopital_id") int hopital_id, @RequestParam("specialite_id") int specialite_id) {
		Disponibilite disponibilite = null;
		
		try {
			if(hopital_id<0 || specialite_id <0) {
				throw new Exception("l'hopital ou la specialite n'a pas été renseigné");
			}
		    disponibilite = this.disponibiliteService.decrementerLits(hopital_id, specialite_id);
		
		}
		catch(Exception e) {
			this.logger.error(e.getMessage());
		}
		finally {
			return disponibilite; 
		}
	}
	
	@GetMapping("/disponibilite")
	public Disponibilite getDisponibilite(@RequestParam("hopital_id") int hopital_id, @RequestParam("specialite_id") int specialite_id ) {
		Disponibilite disponibilite = null;
		try {
			if(hopital_id<0 || specialite_id <0) {
				throw new Exception("DisponibiliteRequestDTO invalid");
			}
			disponibilite = this.disponibiliteService.getDisponibilite(hopital_id, specialite_id);
		}
		catch(Exception e) {
			this.logger.error(e.getMessage());
		}
		finally {
			return disponibilite;
		}
	}
}
