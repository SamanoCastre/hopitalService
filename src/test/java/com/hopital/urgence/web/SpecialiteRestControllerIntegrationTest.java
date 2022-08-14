package com.hopital.urgence.web;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.hopital.urgence.entities.Specialite;
import com.hopital.urgence.services.ISpecialiteService;

@SpringBootTest(properties = { "API_KEY=test" })
@AutoConfigureMockMvc
public class SpecialiteRestControllerIntegrationTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean 
	private ISpecialiteService specialiteService;
	
	
	@Test
	public void getSpecialites() throws Exception {
		//Given
		List<Specialite> specialites = new ArrayList<Specialite>();
		specialites.add(new Specialite(2, "Anethsesie", "Anethsésie", new Date()));
		
		//When
        when(this.specialiteService.getSpecialites()).thenReturn(specialites);
		
        //Then
		this.mockMvc.perform(MockMvcRequestBuilders.get("/specialites"))
		        .andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(specialites.get(0).getId()));
	}
}
