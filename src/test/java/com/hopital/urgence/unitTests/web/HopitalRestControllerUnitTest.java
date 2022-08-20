package com.hopital.urgence.unitTests.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.hopital.urgence.entities.Address;
import com.hopital.urgence.entities.Disponibilite;
import com.hopital.urgence.entities.Hopital;
import com.hopital.urgence.entities.Specialite;
import com.hopital.urgence.services.IHopitalService;
import com.hopital.urgence.services.impl.HopitalServiceImpl;
import com.hopital.urgence.web.HopitalRestController;

public class HopitalRestControllerUnitTest {
	
	private HopitalRestController hopitalRestController;
	private IHopitalService hopitalService;
	private List<Disponibilite> disponibilitiesList;
	
	@BeforeEach
	public void init() {
		this.hopitalService = Mockito.mock(HopitalServiceImpl.class);
		this.hopitalRestController = new HopitalRestController(this.hopitalService);
		
		this.disponibilitiesList = new ArrayList<Disponibilite>();
		this.disponibilitiesList.add(
				new Disponibilite(
						1,
						new Hopital(2, "Hopital de Purpan", new Address("1","place du Docteur Baylac","31059","Toulouse","France"), new Date()), 
						new Specialite(2, "Anethsesie", "Anethsésie", new Date()), 15, new Date())
				);
		
		this.disponibilitiesList.add(
				new Disponibilite(
						2,
						new Hopital(3, "Hospitals Academics Paris Centre Ap-Hp", new Address("2","Rue du Faubourg Saint-Jacques","75014","Paris","France"), new Date()), 
						new Specialite(2, "Anethsesie", "Anethsésie", new Date()), 15, new Date())
				);
	}
	
	@Test
	public void rechercherHopitalValidUnitTest() throws Exception {
		Hopital expectedHopital = this.disponibilitiesList.get(0).getHopital();
		when(this.hopitalService.rechercherHopital(any(String.class), anyInt())).thenReturn(expectedHopital);
		assertEquals(expectedHopital, this.hopitalRestController.rechercherHopital("31100 Touluse", 2).getBody());
	}
}
