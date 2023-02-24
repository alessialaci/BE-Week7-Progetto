package it.alessiaepicode.w7progetto.models;

import java.util.List;

// Concrete Observer
public class Allarme implements ProcessoDiControllo {

	@Override
	public void gestisciAllarme(List<Sonda> sonde) {
		System.out.println("------------------------- Controllo allarmi: -------------------------");
		
		for(Sonda sonda : sonde) {
			if(sonda.getQuantitaFumo() > 5) {
				System.out.println("!!! Allarme della sonda " + sonda.getIdSonda() + " scattato. Livello di fumo troppo alto !!!");
				
				System.out.println("URL: http://host/alarm?=idsonda=" + sonda.getIdSonda() 
				+ "&lat=" + sonda.getLatitudine() 
				+ "&lon=" + sonda.getLongitudine() 
				+ "&smokelevel=" + sonda.getQuantitaFumo());
				
				System.out.println("----------------------------------------------------------------------");
			}
		}
	}

}
