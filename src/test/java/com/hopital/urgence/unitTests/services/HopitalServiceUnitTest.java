package com.hopital.urgence.unitTests.services;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.hopital.urgence.entities.Address;
import com.hopital.urgence.entities.Disponibilite;
import com.hopital.urgence.entities.Hopital;
import com.hopital.urgence.entities.Specialite;
import com.hopital.urgence.exceptions.NoDataFoundException;
import com.hopital.urgence.services.IDisponibiliteService;
import com.hopital.urgence.services.IGoogleDistanceMatrix;
import com.hopital.urgence.services.IHopitalService;
import com.hopital.urgence.services.impl.HopitalServiceImpl;

@SpringBootTest(properties = { "API_KEY=test" })
public class HopitalServiceUnitTest {
	
	@Mock
	private IGoogleDistanceMatrix distanceService;
	
	@Mock
	private IDisponibiliteService disponibiliteService;
	
	@InjectMocks
	private IHopitalService hopitalService = new HopitalServiceImpl();
	
	
	@Test
	public void rechercherHopitalTest() throws Exception {
		
		List<Disponibilite> disponibilitiesList = new ArrayList<Disponibilite>();
		disponibilitiesList.add(new Disponibilite(1,new Hopital(2, "Hopital de Purpan", new Address("1","place du Docteur Baylac","31059","Toulouse","France"), new Date()), new Specialite(2, "Anethsesie", "Anethsésie", new Date()), 15, new Date()));
		disponibilitiesList.add(new Disponibilite(2,new Hopital(3, "Hopital de Rangueil", new Address("2","Avenue de rangueil","3400","Toulouse","France"), new Date()), new Specialite(2, "Anethsesie", "Anethsésie", new Date()), 15, new Date()));
		
		when(this.disponibiliteService.findBySpecialiteId(anyInt())).thenReturn(disponibilitiesList);
		
		assertThrows(NoDataFoundException.class, () -> { this.hopitalService.rechercherHopital("31100 Toulouse", 2);});
	}
}
