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
	
	private Disponibilite disponibilite;
	
	@BeforeEach
	public void init() {
		this.disponibilite = new Disponibilite(1,new Hopital(2, "Test", null, new Date()), new Specialite(2, "Anethsesie", "Anethsésie", new Date()), 15, new Date());
	}
	
	
	@Test
	public void incrementerLitsTest() {
		List<Disponibilite> list = new ArrayList<Disponibilite>();
		list.add(this.disponibilite);
		
		when(this.disponibiliteRepository.findByHopitalAndSpecialite(2, 2)).thenReturn(list);
		
		this.disponibilite.setLits(this.disponibilite.getLits() + 1);
		when(this.disponibiliteRepository.save(any(Disponibilite.class))).thenReturn(this.disponibilite);
		
		Disponibilite dispo = this.disponibiliteService.incrementerLits(2, 2);
		assertThat(dispo.getId()).isEqualTo(this.disponibilite.getId());
		assertThat(dispo.getLits()).isEqualTo(this.disponibilite.getLits());
	}
	
	@Test
	public void decrementerLitsTest() {
		List<Disponibilite> list = new ArrayList<Disponibilite>();
		list.add(this.disponibilite);
		
		when(this.disponibiliteRepository.findByHopitalAndSpecialite(2, 2)).thenReturn(list);
		
		this.disponibilite.setLits(this.disponibilite.getLits() - 1);
		when(this.disponibiliteRepository.save(any(Disponibilite.class))).thenReturn(this.disponibilite);
		
		Disponibilite dispo = this.disponibiliteService.decrementerLits(2, 2);
		assertThat(dispo.getId()).isEqualTo(this.disponibilite.getId());
		assertThat(dispo.getLits()).isEqualTo(this.disponibilite.getLits());
	}
	
	
}
