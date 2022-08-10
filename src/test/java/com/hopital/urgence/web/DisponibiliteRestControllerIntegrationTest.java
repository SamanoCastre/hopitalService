package com.hopital.urgence.web;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.hopital.urgence.entities.Address;
import com.hopital.urgence.entities.Disponibilite;
import com.hopital.urgence.entities.Hopital;
import com.hopital.urgence.entities.Specialite;
import com.hopital.urgence.services.IDisponibiliteService;

@SpringBootTest
@AutoConfigureMockMvc
public class DisponibiliteRestControllerIntegrationTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean 
	private IDisponibiliteService disponibiliteService;
	
	private Disponibilite disponibilite;
	
	@BeforeEach 
	public void init() {
		this.disponibilite = new Disponibilite(1,new Hopital(2, "Test", new Address("1","place du Docteur Baylac","31059","Toulouse","France"), new Date()), new Specialite(2, "Anethsesie", "Anethsésie", new Date()), 15, new Date());
	}
	
	@Test
	public void getDisponibiliteValidTest() throws Exception {
		when(this.disponibiliteService.getDisponibilite(disponibilite.getHopital().getId(), disponibilite.getSpecialite().getId())).thenReturn(disponibilite);
		this.mockMvc.perform(MockMvcRequestBuilders.get("/disponibilite")
				.param("hopital_id", "2")
				.param("specialite_id", "2"))
		        .andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.hopital.id").value(this.disponibilite.getHopital().getId()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.specialite.id").value(this.disponibilite.getSpecialite().getId()));
	}
	
	@Test
	public void getDisponibiliteInvalidTest() throws Exception {
		when(this.disponibiliteService.getDisponibilite(disponibilite.getHopital().getId(), disponibilite.getSpecialite().getId())).thenReturn(disponibilite);
		this.mockMvc.perform(MockMvcRequestBuilders.get("/disponibilite")
				.param("hopital_id", "0")
				.param("specialite_id", "0"))
		        .andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$").doesNotExist());
	}
	
	@Test
	public void incrementerLitsValidTest() throws Exception {
		this.disponibilite.setLits(this.disponibilite.getLits() + 1);
		when(this.disponibiliteService.incrementerLits(this.disponibilite.getHopital().getId(), this.disponibilite.getSpecialite().getId())).thenReturn(disponibilite);
		
		this.mockMvc.perform(MockMvcRequestBuilders.put("/disponibilite/incrementer")
				.param("hopital_id", "2")
				.param("specialite_id", "2"))
		        .andExpect(status().isOk())
		        .andExpect(MockMvcResultMatchers.jsonPath("$.hopital.id").value(this.disponibilite.getHopital().getId()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.specialite.id").value(this.disponibilite.getSpecialite().getId()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.lits").value("16"));
	}
	
	@Test
	public void incrementerLitsInvalidTest() throws Exception {
		this.disponibilite.setLits(this.disponibilite.getLits() + 1);
		when(this.disponibiliteService.incrementerLits(this.disponibilite.getHopital().getId(), this.disponibilite.getSpecialite().getId())).thenReturn(disponibilite);
		
		this.mockMvc.perform(MockMvcRequestBuilders.put("/disponibilite/incrementer")
				.param("hopital_id", "0")
				.param("specialite_id", "0"))
		        .andExpect(status().isOk())
		        .andExpect(MockMvcResultMatchers.jsonPath("$").doesNotExist());
	}
	
	@Test
	public void decrementerLitsValidTest() throws Exception {
		this.disponibilite.setLits(this.disponibilite.getLits() - 1);
		when(this.disponibiliteService.decrementerLits(this.disponibilite.getHopital().getId(), this.disponibilite.getSpecialite().getId())).thenReturn(disponibilite);
		
		this.mockMvc.perform(MockMvcRequestBuilders.put("/disponibilite/decrementer")
				.param("hopital_id", "2")
				.param("specialite_id", "2"))
		        .andExpect(status().isOk())
		        .andExpect(MockMvcResultMatchers.jsonPath("$.hopital.id").value(this.disponibilite.getHopital().getId()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.specialite.id").value(this.disponibilite.getSpecialite().getId()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.lits").value("14"));
	}
	
	@Test
	public void decrementerLitsInvalidTest() throws Exception {
		this.disponibilite.setLits(this.disponibilite.getLits() - 1);
		when(this.disponibiliteService.decrementerLits(this.disponibilite.getHopital().getId(), this.disponibilite.getSpecialite().getId())).thenReturn(disponibilite);
		
		this.mockMvc.perform(MockMvcRequestBuilders.put("/disponibilite/decrementer")
				.param("hopital_id", "0")
				.param("specialite_id", "0"))
		        .andExpect(status().isOk())
		        .andExpect(MockMvcResultMatchers.jsonPath("$").doesNotExist());
	}
}
