package com.hopital.urgence.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.hopital.urgence.entities.Address;
import com.hopital.urgence.entities.Disponibilite;
import com.hopital.urgence.entities.Hopital;
import com.hopital.urgence.entities.Specialite;
import com.hopital.urgence.exceptions.DisponibiliteFailException;
import com.hopital.urgence.exceptions.DisponibiliteNotFoundException;
import com.hopital.urgence.repositories.DisponibiliteRepository;
import com.hopital.urgence.services.impl.DisponibiliteServiceImpl;


@SpringBootTest(properties = { "API_KEY=test" })
public class DisponibiliteServiceTest {
	
	@Mock
	private DisponibiliteRepository disponibiliteRepository;
	
	@InjectMocks
	private DisponibiliteServiceImpl disponibiliteService;
	
	private List<Disponibilite> disponibilitiesList;
	
	@BeforeEach
	public void init() {
		this.disponibilitiesList = new ArrayList<Disponibilite>();
		this.disponibilitiesList.add(new Disponibilite(1,new Hopital(2, "Test", new Address("1","place du Docteur Baylac","31059","Toulouse","France"), new Date()), new Specialite(2, "Anethsesie", "Anethsésie", new Date()), 15, new Date()));
	}
	
	
	@Test
	public void incrementerLitsTest() throws Exception {
		
		when(this.disponibiliteRepository.findByHopitalAndSpecialite(2, 2)).thenReturn(this.disponibilitiesList);
		
		Disponibilite disponibilite = this.disponibilitiesList.get(0);
		
		disponibilite.setLits(disponibilite.getLits() + 1);
		when(this.disponibiliteRepository.save(any(Disponibilite.class))).thenReturn(disponibilite);
		Disponibilite dispo = this.disponibiliteService.incrementerLits(2, 2);
		assertThat(dispo.getId()).isEqualTo(disponibilite.getId());
		assertThat(dispo.getLits()).isEqualTo(disponibilite.getLits());
	}
	
	@Test
	public void incrementerLitsDisponibiliteFailExceptionTest() throws Exception {
		when(this.disponibiliteRepository.findByHopitalAndSpecialite(anyInt(), anyInt())).thenReturn(this.disponibilitiesList);
		assertThrows(DisponibiliteFailException.class, ()->{this.disponibiliteService.incrementerLits(2, 2);});
	}
	
	
	@Test
	public void decrementerLitsTest() throws Exception {
		when(this.disponibiliteRepository.findByHopitalAndSpecialite(2, 2)).thenReturn(this.disponibilitiesList);
		
		Disponibilite disponibilite = this.disponibilitiesList.get(0);
		disponibilite.setLits(disponibilite.getLits() - 1);
		when(this.disponibiliteRepository.save(any(Disponibilite.class))).thenReturn(disponibilite);
		
		Disponibilite dispo = this.disponibiliteService.decrementerLits(2, 2);
		assertThat(dispo.getId()).isEqualTo(disponibilite.getId());
		assertThat(dispo.getLits()).isEqualTo(disponibilite.getLits());
	}
	
	@Test
	public void decrementerLitsDisponibiliteFailExceptionTest() throws Exception {
		when(this.disponibiliteRepository.findByHopitalAndSpecialite(anyInt(), anyInt())).thenReturn(this.disponibilitiesList);
		assertThrows(DisponibiliteFailException.class, ()->{this.disponibiliteService.decrementerLits(2, 2);});
	}
	
	@Test
	public void getDisponibiliteTest() throws Exception {
		when(this.disponibiliteRepository.findByHopitalAndSpecialite(anyInt(),anyInt())).thenReturn(this.disponibilitiesList);
		Disponibilite disponibilite = this.disponibiliteService.getDisponibilite(2, 2);
		assertThat(disponibilite).isNotNull();
	}
	
	@Test
	public void getDisponibiliteNotFoundExceptionTest() throws Exception {
		when(this.disponibiliteRepository.findByHopitalAndSpecialite(anyInt(),anyInt())).thenReturn(null);
		assertThrows(DisponibiliteNotFoundException.class, ()->{
			this.disponibiliteService.getDisponibilite(2, 2);
		});
	}
	
	@Test
	public void findBySpecialiteIdTest() throws Exception {
		when(this.disponibiliteRepository.findBySpecialiteId(anyInt())).thenReturn(this.disponibilitiesList);
		List<Disponibilite> liste = this.disponibiliteService.findBySpecialiteId(2);
		assertThat(liste).isEqualTo(this.disponibilitiesList);
	}
	
	@Test
	public void findBySpecialiteIdDisponibiliteNotFoundExceptionTest() throws Exception {
		when(this.disponibiliteRepository.findBySpecialiteId(anyInt())).thenReturn(null);
		assertThrows(DisponibiliteNotFoundException.class, ()->{
			this.disponibiliteService.findBySpecialiteId(2);
		});
	}
}
