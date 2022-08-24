package com.hopital.urgence.web;

import java.io.IOException;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.maps.errors.ApiException;
import com.hopital.urgence.entities.Hopital;
import com.hopital.urgence.services.IHopitalService;

@Validated 
@RestController
public class HopitalRestController {
	
	private IHopitalService hopitalService;
	
	public HopitalRestController(IHopitalService hopitalService) {
		this.hopitalService = hopitalService;
	}
	
	/**
	 * 
	 * @param lieuIncident
	 * @param specialite
	 * @return
	 * @throws ApiException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@GetMapping(path="/hopital", produces=MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Hopital> rechercherHopital( 
			@RequestParam("lieuIncident") @NotEmpty String lieuIncident, 
			 @RequestParam("specialite") @Min(1) int specialite) throws ApiException, InterruptedException, IOException {
			return new ResponseEntity<Hopital>(this.hopitalService.rechercherHopital(lieuIncident, specialite), HttpStatus.OK);
	} 
}

