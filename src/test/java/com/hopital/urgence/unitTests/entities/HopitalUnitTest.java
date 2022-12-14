package com.hopital.urgence.unitTests.entities;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.hopital.urgence.entities.Address;
import com.hopital.urgence.entities.Hopital;

@SpringBootTest(properties = { "API_KEY=test" })
public class HopitalUnitTest {
	Hopital hopital;
	
	@BeforeEach
	public void init() {
		this.hopital = new Hopital(1, "Hopital de Purpan", new Address("1","place du Docteur Baylac","31059","Toulouse","France"), new Date());
	}

	@Test
	public void createValidHopital() {
		Hopital testedHopital = new Hopital();
		testedHopital.setId(this.hopital.getId());
		testedHopital.setName(this.hopital.getName());
		testedHopital.setAddress(this.hopital.getAddress());
		testedHopital.setDateCreation(this.hopital.getDateCreation());
		
		assertThat(testedHopital.getId()).isEqualTo(this.hopital.getId());
		assertThat(testedHopital.getName()).isEqualTo(this.hopital.getName());
		assertThat(testedHopital.getAddress()).isEqualTo(this.hopital.getAddress());
		assertThat(testedHopital.getDateCreation()).isEqualTo(this.hopital.getDateCreation());
		assertThat(testedHopital.toString()).isEqualTo(this.hopital.toString());
	}
}
