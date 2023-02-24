package it.alessiaepicode.w7progetto;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import it.alessiaepicode.w7progetto.models.Allarme;
import it.alessiaepicode.w7progetto.models.Sonda;

class AllarmeTest {

	@Test
	void testGestisciAllarme() {
		// Creo una sonda con quantità di fumo superiore alla soglia e la inserisco in una lista
	    Sonda s = new Sonda(1, 0.0, 0.0, 6);
	    List<Sonda> sonde = Arrays.asList(s);
	    
	    // Creo un'istanza della classe Allarme
	    Allarme allarme = new Allarme();
	    
	    // Verifico che l'allarme scatti correttamente
	    ByteArrayOutputStream inConsole = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(inConsole));
	    
	    allarme.gestisciAllarme(sonde);
	    
	    String outputAtteso = "!!! Allarme della sonda 1 scattato. Livello di fumo troppo alto !!!";
	    assertTrue(inConsole.toString().contains(outputAtteso));
	    
	    // ByteArrayOutputStream e Sustem.setOut servono a prendere l'output della console e confrontarlo con l'output atteso
	}

}
