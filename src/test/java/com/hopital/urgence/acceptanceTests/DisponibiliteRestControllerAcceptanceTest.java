package com.hopital.urgence.acceptanceTests;
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
public class DisponibiliteRestControllerAcceptanceTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getDisponibiliteValidTest() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/disponibilite")
				.param("hopital_id", "2")
				.param("specialite_id", "2"))
		        .andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$").hasJsonPath());
	}
	
	@Test
	public void getDisponibiliteInvalidTest() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/disponibilite")
				.param("hopital_id", "0")
				.param("specialite_id", "0"))
		        .andExpect(status().isInternalServerError())
				.andExpect(MockMvcResultMatchers.jsonPath("$").doesNotExist());
	}
	
	@Test
	public void incrementerLitsValidTest() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.put("/disponibilite/incrementer")
				.param("hopital_id", "2")
				.param("specialite_id", "2"))
		        .andExpect(status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$").hasJsonPath());
	}
	
	@Test
	public void incrementerLitsInvalidTest() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.put("/disponibilite/incrementer")
				.param("hopital_id", "0")
				.param("specialite_id", "0"))
		        .andExpect(status().isNotModified())
		        .andExpect(MockMvcResultMatchers.jsonPath("$").doesNotExist());
	}
	
	@Test
	public void decrementerLitsValidTest() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.put("/disponibilite/decrementer")
				.param("hopital_id", "2")
				.param("specialite_id", "2"))
		        .andExpect(status().isCreated())
		        .andExpect(MockMvcResultMatchers.jsonPath("$").hasJsonPath());
	}
	
	@Test
	public void decrementerLitsInvalidTest() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.put("/disponibilite/decrementer")
				.param("hopital_id", "0")
				.param("specialite_id", "0"))
		        .andExpect(status().isNotModified())
		        .andExpect(MockMvcResultMatchers.jsonPath("$").doesNotExist());
	}
}
