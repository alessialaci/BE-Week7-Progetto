package it.alessiaepicode.w7progetto.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Sonda {
	
    private int idSonda;
    private double latitudine;
    private double longitudine;
    private int quantitaFumo;
    
}
