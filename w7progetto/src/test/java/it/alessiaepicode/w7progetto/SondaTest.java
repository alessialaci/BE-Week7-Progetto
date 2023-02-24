package it.alessiaepicode.w7progetto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import it.alessiaepicode.w7progetto.models.Sonda;

@SpringBootTest
class SondaTest {
	
	Sonda sonda = new Sonda(1, 45.1234, 12.5678, 6);

	@Test
	void testGetIdSonda() {
		assertEquals(1, sonda.getIdSonda());
	}

	@Test
	void testGetLatitudine() {
		assertEquals(45.1234, sonda.getLatitudine(), 0.0001);
	}

	@Test
	void testGetLongitudine() {
		assertEquals(12.5678, sonda.getLongitudine(), 0.0001);
	}

	@Test
	void testGetQuantitaFumo() {
		assertEquals(6, sonda.getQuantitaFumo());
	}

}
