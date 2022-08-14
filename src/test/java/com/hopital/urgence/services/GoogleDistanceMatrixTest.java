package com.hopital.urgence.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.hopital.urgence.services.impl.GoogleDistanceMatrixImpl;

@SpringBootTest(properties = { "API_KEY=test" })
public class GoogleDistanceMatrixTest {
	
	@InjectMocks
	private IGoogleDistanceMatrix googleDistanceMatrix = new GoogleDistanceMatrixImpl();
	
	@Test
	public void getClosestDestinationTest() throws Exception {
		String[] destinations = {"31400 Toulouse", "31059 Toulouse"};
		
		assertThrows(IllegalStateException.class, ()-> {
			this.googleDistanceMatrix.getClosestDestination("31100 Toulouse", destinations);
		});
	}
}
