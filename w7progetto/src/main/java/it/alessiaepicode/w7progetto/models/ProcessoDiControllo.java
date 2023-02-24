package it.alessiaepicode.w7progetto.models;

import java.util.List;

// Observer
public interface ProcessoDiControllo {
	
	void gestisciAllarme(List<Sonda> sonde);
	
}
