package com.emergency.system.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emergency.system.entities.Specialite;
import com.emergency.system.services.ISpecialiteService;

@SuppressWarnings("finally")
@RefreshScope
@RestController
public class SpecialiteController {
	private Logger logger = LoggerFactory.getLogger(SpecialiteController.class);
	
	@Autowired
	ISpecialiteService specialiteService;
	
	@GetMapping("/specialites")
	public List<Specialite> getSpecialites() {
		List<Specialite> specialites = new ArrayList<Specialite>();
		try {
			specialites = this.specialiteService.getSpecialites();
		}
		catch(Exception e) {
			this.logger.error(e.getMessage());
		}
		finally {
			return specialites;
		}
	}
}
