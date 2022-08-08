package com.hopital.urgence;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.hopital.urgence.web.DisponibiliteRestController;
import com.hopital.urgence.web.HopitalRestController;
import com.hopital.urgence.web.SpecialiteRestController;

@SpringBootTest

class HopitalServiceApplicationTest {
	@Autowired
	private HopitalRestController hopitalRestController;
	
	@Autowired
	private DisponibiliteRestController disponibiliteRestController;
	
	@Autowired
	private SpecialiteRestController specialiteRestController;
	
	@Test
	void contextLoads() {
		assertThat(this.hopitalRestController).isNotNull();
		assertThat(this.disponibiliteRestController).isNotNull();
		assertThat(this.specialiteRestController).isNotNull();
	}
}
