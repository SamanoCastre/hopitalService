package com.hopital.urgence.integrationTests;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.hopital.urgence.entities.Address;
import com.hopital.urgence.entities.Hopital;
import com.hopital.urgence.services.IHopitalService;
import com.hopital.urgence.web.HopitalRestController;

@WebMvcTest(HopitalRestController.class)
public class HopitalRestControllerIntegrationTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean 
	private IHopitalService hopitalService;
	
	private Hopital hopital;
	
	@BeforeEach 
	public void init() {
		this.hopital =  new Hopital(2, "Hopital de Purpan", new Address("1","place du Docteur Baylac","31059","Toulouse","France"), new Date());
	}
	
	@Test
	public void rechercherHopitalValidTest() throws Exception {
		
		when(this.hopitalService.rechercherHopital(any(String.class), anyInt())).thenReturn(this.hopital);
		this.mockMvc.perform(MockMvcRequestBuilders.get("/hopital")
				.param("lieuIncident", "31100 Toulouse")
				.param("specialite", "2"))
		        .andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Hopital de Purpan"));
	}
	
	@Test
	public void rechercherHopitalInvalidTest() throws Exception {
		when(this.hopitalService.rechercherHopital(any(String.class), anyInt())).thenReturn(this.hopital);
		this.mockMvc.perform(MockMvcRequestBuilders.get("/hopital")
				.param("lieuIncident", "31100 Toulouse")
				.param("specialite", "0"))
		        .andExpect(status().isInternalServerError());
	}

}
