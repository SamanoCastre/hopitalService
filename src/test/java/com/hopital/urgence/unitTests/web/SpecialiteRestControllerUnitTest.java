package com.hopital.urgence.unitTests.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

import com.hopital.urgence.entities.Specialite;
import com.hopital.urgence.services.ISpecialiteService;
import com.hopital.urgence.web.SpecialiteRestController;

public class SpecialiteRestControllerUnitTest {
	
	private SpecialiteRestController specialiteRestController;
	private ISpecialiteService specialiteService;
	private List<Specialite>specialites = new ArrayList<Specialite>();
	
	@BeforeEach
	public void init() {
		this.specialiteService = Mockito.mock(ISpecialiteService.class);
		this.specialiteRestController = new SpecialiteRestController(specialiteService);
		this.specialites.add(new Specialite(2, "Anethsesie", "Anethsésie", new Date()));
		this.specialites.add(new Specialite(2, "Soins intensifs", "Anethsésie", new Date()));
	}
	
	@Test
	public void getSpecialitesValidTest() throws Exception {
		when(this.specialiteService.getSpecialites()).thenReturn(this.specialites);
		assertEquals(this.specialites, this.specialiteRestController.getSpecialites().getBody());
	}
	
	@Test
	public void getSpecialiteInvalidTest() throws Exception {
		when(this.specialiteService.getSpecialites()).thenThrow(Exception.class);
		assertEquals(this.specialiteRestController.getSpecialites().getStatusCode(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
