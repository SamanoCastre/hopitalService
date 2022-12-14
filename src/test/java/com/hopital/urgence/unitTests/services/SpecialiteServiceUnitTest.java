package com.hopital.urgence.unitTests.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.hopital.urgence.entities.Specialite;
import com.hopital.urgence.repositories.SpecialiteRepository;
import com.hopital.urgence.services.ISpecialiteService;
import com.hopital.urgence.services.impl.SpecialiteServiceImpl;

@SpringBootTest(properties = { "API_KEY=test" })
public class SpecialiteServiceUnitTest {
	@Mock
	SpecialiteRepository specialiteRepository;
	
	@InjectMocks
	private ISpecialiteService specialiteService = new SpecialiteServiceImpl();
	
	@Test
	public void getSpecialitesTest() throws Exception {
		List<Specialite>specialites = new ArrayList<Specialite>();
		specialites.add(new Specialite(2,"Test", "GroupeTest", new Date()));
		when(this.specialiteRepository.findAll()).thenReturn(specialites);
		assertThat(this.specialiteService.getSpecialites()).asList();
	}
}
