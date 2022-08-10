package com.hopital.urgence.services;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpecialiteServiceTest {
	@Autowired
	private ISpecialiteService specialiteService;
	
	@Test
	public void getSpecialitesTest() {
		assertThat(this.specialiteService.getSpecialites()).asList();
	}
	

}
