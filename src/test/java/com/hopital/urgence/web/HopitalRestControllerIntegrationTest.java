package com.hopital.urgence.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class HopitalRestControllerIntegrationTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void rechercherHopitalValidTest() throws Exception {
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/hopital")
				.param("lieuIncident", "31100 Toulouse")
				.param("specialite", "2"))
		        .andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Hopital de Purpan"));
	}
	
	@Test
	public void rechercherHopitalInvalidTest() throws Exception {
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/hopital")
				.param("lieuIncident", "31100 Toulouse")
				.param("specialite", "0"))
		        .andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$").doesNotExist());
	}

}
