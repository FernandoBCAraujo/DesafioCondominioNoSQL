package com.br.uati.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.uati.models.Proprietario;
import com.br.uati.repositories.ProprietarioRepository;
import com.br.uati.services.exception.ObjectNotFoundException;

@Service
public class ProprietarioService {

	@Autowired
	private ProprietarioRepository proprietarioRepository;

	public List<Proprietario> findAll() {
		return proprietarioRepository.findAll();
	}

	public Proprietario findByIdProprietario(String idProprietario) {
		Optional<Proprietario> objProprietario = proprietarioRepository.findByIdProprietario(idProprietario);
		
		return objProprietario.orElseThrow(
				() -> new ObjectNotFoundException("Proprietario com id ->" + idProprietario + "<-, não foi encontrado."));
	}

}
