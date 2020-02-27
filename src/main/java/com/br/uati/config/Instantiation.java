package com.br.uati.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.br.uati.models.Proprietario;
import com.br.uati.repositories.ProprietarioRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private ProprietarioRepository proprietarioRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		proprietarioRepository.deleteAll();

		Proprietario proprietario = new Proprietario(null, "Fernando Bezerra", "37487129459", "349381837",
				"fernando@email.com");
		Proprietario proprietario2 = new Proprietario(null, "Gessika Maria", "12345678909", "983713837",
				"gessika@email.com");
		Proprietario proprietario3 = new Proprietario(null, "Tuca Andrade", "854573112893", "30393837",
				"tuca@email.com");
		
		proprietarioRepository.saveAll(Arrays.asList(proprietario, proprietario2, proprietario3));

	}

}
