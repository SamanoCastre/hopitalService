package com.hopital.urgence.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hopital.urgence.entities.Specialite;
import com.hopital.urgence.services.ISpecialiteService;

@RestController
public class SpecialiteRestController {
	private Logger logger = LoggerFactory.getLogger(SpecialiteRestController.class);
	
	ISpecialiteService specialiteService;
	
	public SpecialiteRestController(ISpecialiteService specialiteService) {
		this.specialiteService = specialiteService;
	}
	
	@GetMapping("/specialites")
	public ResponseEntity<List<Specialite>> getSpecialites() {
		try {
			return new ResponseEntity<List<Specialite>>(this.specialiteService.getSpecialites(), HttpStatus.OK);
		}
		catch(Exception e) {
			this.logger.error(e.getMessage());
			return new ResponseEntity<List<Specialite>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
