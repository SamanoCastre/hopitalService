package com.hopital.urgence.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hopital.urgence.entities.Specialite;
import com.hopital.urgence.services.ISpecialiteService;

@RefreshScope
@RestController
public class SpecialiteRestController {
	private Logger logger = LoggerFactory.getLogger(SpecialiteRestController.class);
	
	@Autowired
	ISpecialiteService specialiteService;
	
	@GetMapping("/specialites")
	public List<Specialite> getSpecialites() {
		try {
			return this.specialiteService.getSpecialites();
		}
		catch(Exception e) {
			this.logger.error(e.getMessage());
		}
		return null;
	}
}
