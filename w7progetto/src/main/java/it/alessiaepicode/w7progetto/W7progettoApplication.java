package it.alessiaepicode.w7progetto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.alessiaepicode.w7progetto.models.Allarme;
import it.alessiaepicode.w7progetto.models.CentroDiControllo;
import it.alessiaepicode.w7progetto.models.Sonda;

@SpringBootApplication
public class W7progettoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(W7progettoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		statoSonde();
	}

	private void statoSonde() {
		Random random = new Random();
		
		Sonda s1 = new Sonda(1, random.nextDouble(-90, 90), random.nextDouble(-90, 90), random.nextInt(1, 10));
		Sonda s2 = new Sonda(2, random.nextDouble(-90, 90), random.nextDouble(-90, 90), random.nextInt(1, 10));
		Sonda s3 = new Sonda(3, random.nextDouble(-90, 90), random.nextDouble(-90, 90), random.nextInt(1, 10));
		Sonda s4 = new Sonda(4, random.nextDouble(-90, 90), random.nextDouble(-90, 90), random.nextInt(1, 10));
		
		List<Sonda> sonde = new ArrayList<>(Arrays.asList(s1, s2, s3, s4));
		
		CentroDiControllo c1 = new CentroDiControllo();
		c1.aggiungiObserver(new Allarme());
		
		c1.setSonda(sonde);
	}
	
}
