package com.hopital.urgence.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.hopital.urgence.entities.Address;
import com.hopital.urgence.entities.Disponibilite;
import com.hopital.urgence.entities.Hopital;
import com.hopital.urgence.entities.Specialite;
import com.hopital.urgence.repositories.DisponibiliteRepository;
import com.hopital.urgence.services.impl.DisponibiliteServiceImpl;


@SpringBootTest
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
	public void incrementerLitsTest() {
		
		when(this.disponibiliteRepository.findByHopitalAndSpecialite(2, 2)).thenReturn(this.disponibilitiesList);
		
		Disponibilite disponibilite = this.disponibilitiesList.get(0);
		
		disponibilite.setLits(disponibilite.getLits() + 1);
		when(this.disponibiliteRepository.save(any(Disponibilite.class))).thenReturn(disponibilite);
		Disponibilite dispo = this.disponibiliteService.incrementerLits(2, 2);
		assertThat(dispo.getId()).isEqualTo(disponibilite.getId());
		assertThat(dispo.getLits()).isEqualTo(disponibilite.getLits());
	}
	
	@Test
	public void decrementerLitsTest() {
		when(this.disponibiliteRepository.findByHopitalAndSpecialite(2, 2)).thenReturn(this.disponibilitiesList);
		
		Disponibilite disponibilite = this.disponibilitiesList.get(0);
		disponibilite.setLits(disponibilite.getLits() - 1);
		when(this.disponibiliteRepository.save(any(Disponibilite.class))).thenReturn(disponibilite);
		
		Disponibilite dispo = this.disponibiliteService.decrementerLits(2, 2);
		assertThat(dispo.getId()).isEqualTo(disponibilite.getId());
		assertThat(dispo.getLits()).isEqualTo(disponibilite.getLits());
	}
	
	@Test
	public void getDisponibiliteTest() {
		when(this.disponibiliteRepository.findByHopitalAndSpecialite(anyInt(),anyInt())).thenReturn(this.disponibilitiesList);
		Disponibilite disponibilite = this.disponibiliteService.getDisponibilite(2, 2);
		assertThat(disponibilite).isNotNull();
	}
	
	@Test
	public void findBySpecialiteIdTest() {
		when(this.disponibiliteRepository.findBySpecialiteId(anyInt())).thenReturn(this.disponibilitiesList);
		List<Disponibilite> liste = this.disponibiliteService.findBySpecialiteId(2);
		assertThat(liste).isEqualTo(this.disponibilitiesList);
	}
}
