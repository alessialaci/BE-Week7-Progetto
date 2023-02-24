package it.alessiaepicode.w7progetto.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

// Subject
@Getter
@Setter
public class CentroDiControllo {

	private List<ProcessoDiControllo> processi = new ArrayList<>();
	
	List<Sonda> sonde;

	public void setSonda(List<Sonda> sonde) {
		this.sonde = sonde;
		notificaObservers();
	}
	
	public void aggiungiObserver(ProcessoDiControllo observer) {
		processi.add(observer);
	}
	
	public void rimuoviObserver(ProcessoDiControllo observer) {
		processi.remove(observer);
	}
	
	public void notificaObservers() {
		for (ProcessoDiControllo observer : processi) {
			observer.gestisciAllarme(sonde);
		}
	}

}
