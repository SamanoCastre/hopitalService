package com.hopital.urgence.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hopital.urgence.entities.Specialite;
import com.hopital.urgence.services.ISpecialiteService;

@Validated 
@RestController
public class SpecialiteRestController {
	
	private ISpecialiteService specialiteService;
	
	public SpecialiteRestController(ISpecialiteService specialiteService) {
		this.specialiteService = specialiteService;
	}
	
	@GetMapping("/specialites")
	public ResponseEntity<List<Specialite>> getSpecialites() throws Exception {
		return new ResponseEntity<List<Specialite>>(this.specialiteService.getSpecialites(), HttpStatus.OK);
	}
}
