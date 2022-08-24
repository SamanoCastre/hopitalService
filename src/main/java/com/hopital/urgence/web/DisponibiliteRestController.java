package com.hopital.urgence.web;


import javax.validation.constraints.Min;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hopital.urgence.entities.Disponibilite;
import com.hopital.urgence.exceptions.ResourceNotUpdatedException;
import com.hopital.urgence.exceptions.ResourceNotFoundException;
import com.hopital.urgence.services.IDisponibiliteService;

@Validated 
@RestController
public class DisponibiliteRestController {
	
	IDisponibiliteService disponibiliteService;
	
	public DisponibiliteRestController(IDisponibiliteService disponibiliteService) {
		this.disponibiliteService = disponibiliteService;
	}
	
	/**
	 * 
	 * @param hopital_id
	 * @param specialite_id
	 * @return
	 * @throws ResourceNotUpdatedException
	 * @throws ResourceNotFoundException
	 */
	@PutMapping(path="/disponibilite/incrementer", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Disponibilite> incrementerLits(
			  @RequestParam("hopital_id") @Min(1) int hopital_id, 
			  @RequestParam("specialite_id") @Min(1) int specialite_id) 
					  throws ResourceNotUpdatedException, ResourceNotFoundException {
		   
		return new ResponseEntity<Disponibilite>(
				   this.disponibiliteService.incrementerLits(hopital_id, specialite_id), 
				   HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * @param hopital_id
	 * @param specialite_id
	 * @return
	 * @throws ResourceNotUpdatedException
	 * @throws ResourceNotFoundException
	 * @throws Exception
	 */
	@PutMapping(path="/disponibilite/decrementer", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Disponibilite> decrementerLits(
			 @RequestParam("hopital_id") @Min(1) int hopital_id, 
			  @RequestParam("specialite_id") @Min(1) int specialite_id) 
					throws ResourceNotUpdatedException, ResourceNotFoundException, Exception {
		
		return new ResponseEntity<Disponibilite>(
				this.disponibiliteService.decrementerLits(hopital_id, specialite_id), 
				HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * @param hopital_id
	 * @param specialite_id
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping(path="/disponibilite", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Disponibilite> getDisponibilite(
			 @RequestParam("hopital_id") @Min(1) int hopital_id, 
			 @RequestParam("specialite_id") @Min(1) int specialite_id ) 
					 throws ResourceNotFoundException {
		
			return new ResponseEntity<Disponibilite>(
					this.disponibiliteService.getDisponibilite(hopital_id, specialite_id), 
					HttpStatus.OK);
		}
}
