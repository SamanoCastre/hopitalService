package com.hopital.urgence.unitTests.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.hopital.urgence.entities.Address;
import com.hopital.urgence.entities.Disponibilite;
import com.hopital.urgence.entities.Hopital;
import com.hopital.urgence.entities.Specialite;
import com.hopital.urgence.services.IDisponibiliteService;
import com.hopital.urgence.services.impl.DisponibiliteServiceImpl;
import com.hopital.urgence.web.DisponibiliteRestController;

public class DisponibiliteRestControllerUnitTest {
	
	private IDisponibiliteService disponibiliteService;
	private DisponibiliteRestController disponibiliteRestController;
	private Disponibilite disponibilite;
	
	@BeforeEach
	public void init() {
        this.disponibiliteService = Mockito.mock(DisponibiliteServiceImpl.class);
		this.disponibiliteRestController = new DisponibiliteRestController(disponibiliteService);
		this.disponibilite = 
				new Disponibilite(
						1,
						new Hopital(2, "Test", new Address("1","place du Docteur Baylac","31059","Toulouse","France"), new Date()), 
						new Specialite(2, "Anethsesie", "Anethsésie", new Date()), 15, new Date()
				);
	}
	
	@Test
	public void getDisponibiliteValidUnitTest() throws Exception {
		when(this.disponibiliteService.getDisponibilite(anyInt(), anyInt())).thenReturn(this.disponibilite);
		assertEquals(this.disponibilite,this.disponibiliteRestController.getDisponibilite(2, 2).getBody());
	}
	
	@Test
	public void incrementerLitsValidUnitTest() throws Exception {
		int newLits = this.disponibilite.getLits() + 1;
		this.disponibilite.setLits(newLits);
		when(this.disponibiliteService.incrementerLits(anyInt(), anyInt())).thenReturn(disponibilite);
		assertEquals(newLits, this.disponibiliteRestController.incrementerLits(2, 2).getBody().getLits());
	}
	
	@Test
	public void decrementerLitsValidTest() throws Exception {
		int newLits = this.disponibilite.getLits() - 1;
		this.disponibilite.setLits(newLits);
		when(this.disponibiliteService.decrementerLits(anyInt(), anyInt())).thenReturn(disponibilite);
		assertEquals(newLits, this.disponibiliteRestController.decrementerLits(2, 2).getBody().getLits());
	}
}
