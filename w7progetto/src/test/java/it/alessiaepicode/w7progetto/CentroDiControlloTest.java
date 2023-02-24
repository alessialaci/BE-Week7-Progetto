package it.alessiaepicode.w7progetto;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import it.alessiaepicode.w7progetto.models.Allarme;
import it.alessiaepicode.w7progetto.models.CentroDiControllo;
import it.alessiaepicode.w7progetto.models.Sonda;

class CentroDiControlloTest {

	@Test
	void testAggiungiObserver() {
		// Creo una nuova istanza di CentroDiControllo e un nuovo Observer
		CentroDiControllo cdc = new CentroDiControllo();
		Allarme observer = new Allarme();
	    
	    // Verifico che inizialmente la lista di processi non abbia nessun observer
	    assertEquals(0, cdc.getProcessi().size());
	    
	    // Aggiungo un nuovo observer alla lista
	    cdc.aggiungiObserver(observer);
	    
	    // Verifico che la lista dei processi sia stata aggiornata correttamente
	    assertEquals(1, cdc.getProcessi().size());
	    assertTrue(cdc.getProcessi().contains(observer));
	}

	@Test
	void testRimuoviObserver() {
		CentroDiControllo cdc = new CentroDiControllo();
		Allarme allarme1 = new Allarme();
		Allarme allarme2 = new Allarme();
				   
		// Aggiungo gli observer alla lista
		cdc.aggiungiObserver(allarme1);
		cdc.aggiungiObserver(allarme2);
				   
		// Verifico che la lista degli observer contenga effettivamente gli observer
		assertEquals(2, cdc.getProcessi().size());
				   
		// Rimuovo il primo observer dalla lista
		cdc.rimuoviObserver(allarme1);
				   
		// Verifico che la lista degli observer non contenga più il primo observer
		assertEquals(1, cdc.getProcessi().size());
		assertTrue(!cdc.getProcessi().contains(allarme1));
	}

	@Test
	void testNotificaObservers() {
	    // Creo due sonde con livello di fumo superiore e inferiore alla soglia e li aggiungo ad una lista
	    Sonda sonda1 = new Sonda(1, 45.1234, 9.4567, 6);
	    Sonda sonda2 = new Sonda(2, 45.6789, 9.0123, 3);
	    List<Sonda> sonde = Arrays.asList(sonda1, sonda2);
	    
	    // Creo un mock dell'Observer Allarme e un nuovo CentroDiControllo
	    Allarme allarme = mock(Allarme.class);
	    CentroDiControllo cdc = new CentroDiControllo();
	    
	    // Aggiungo l'Observer Allarme all'oggetto CentroDiControllo
	    cdc.aggiungiObserver(allarme);
	    
	    // Setto la lista di sonde
	    cdc.setSonda(sonde);
	    
	    // Verifico che il metodo gestisciAllarme dell'Observer Allarme sia stato chiamato una volta
	    verify(allarme, times(1)).gestisciAllarme(sonde);
	    
		// Per questo test c'è bisogno di utilizzare Mock in questo modo è possibile testare il comportamento della classe
		// CentroDiControllo senza dover dipendere dall'effettivo funzionamento dell'oggetto Allarme
	}

}
