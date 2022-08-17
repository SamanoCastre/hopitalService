package com.hopital.urgence.unitTests.services;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.hopital.urgence.services.IGoogleDistanceMatrix;
import com.hopital.urgence.services.impl.GoogleDistanceMatrixImpl;

@SpringBootTest(properties = { "API_KEY=test" })
public class GoogleDistanceMatrixUnitTest {
	
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
