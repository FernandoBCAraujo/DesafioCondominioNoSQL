package com.br.uati.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.uati.dto.ProprietarioDTO;
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

		return objProprietario.orElseThrow(() -> new ObjectNotFoundException(
				"Proprietario com id -> " + idProprietario + " <-, não foi encontrado."));
	}

	public Proprietario insertProprietario(Proprietario objProprietario) {
		return proprietarioRepository.insert(objProprietario);
	}
	
	public void deleteProprietario(String idProprietario) {
		Proprietario objProprietario = findByIdProprietario(idProprietario);
		proprietarioRepository.delete(objProprietario);
	}
	
	public Proprietario updateProprietario(Proprietario objProprietario) {
		Proprietario newObjProprietario = findByIdProprietario(objProprietario.getIdProprietario());
		updateData(newObjProprietario, objProprietario);
		return proprietarioRepository.save(newObjProprietario);
	}

	private void updateData(Proprietario newObjProprietario, Proprietario objProprietario) {
		newObjProprietario.setCpf(objProprietario.getCpf());
		newObjProprietario.setNomeProprietario(objProprietario.getNomeProprietario());
		newObjProprietario.setEmail(objProprietario.getEmail());
		newObjProprietario.setNumeroTelefone(objProprietario.getNumeroTelefone());
	}

	public Proprietario fromProprietarioDTO(ProprietarioDTO objProprietarioDTO) {
		return new Proprietario(objProprietarioDTO.getIdProprietario(), objProprietarioDTO.getNomeProprietario(),
				objProprietarioDTO.getCpf(), objProprietarioDTO.getNumeroTelefone(), objProprietarioDTO.getEmail());
	}

}