package com.hopital.urgence.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class HopitalServiceTest {
	
	@Autowired
	private IHopitalService hopitalService;
	
	@Test
	public void rechercherHopitalTest() throws Exception {
		assertEquals(this.hopitalService.rechercherHopital("31100 Toulouse", 2).getName(), "Hopital de Purpan");
	}
}
