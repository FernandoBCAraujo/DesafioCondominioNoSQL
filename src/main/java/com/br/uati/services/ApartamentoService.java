package com.br.uati.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.uati.models.Apartamento;
import com.br.uati.repositories.ApartamentoRepository;
import com.br.uati.services.exception.ObjectNotFoundException;

@Service
public class ApartamentoService {

	@Autowired
	private ApartamentoRepository apartamentoRepository;

	public List<Apartamento> findAll() {
		return apartamentoRepository.findAll();
	}

	public Apartamento findByIdApartamento(String idApartamento) {
		Optional<Apartamento> objApartamento = apartamentoRepository.findByIdApartamento(idApartamento);

		return objApartamento.orElseThrow(() -> new ObjectNotFoundException(
				"Apartamento com id -> " + idApartamento + " <-, não foi encontrado."));
	}

//	public Apartamento insertApartamento(Apartamento objApartamento) {
//		return apartamentoRepository.insert(objApartamento);
//	}
//	
//	public void deleteApartamento(String idApartamento) {
//		Apartamento objApartamento = findByIdApartamento(idApartamento);
//		apartamentoRepository.delete(objApartamento);
//	}
//	
//	public Apartamento updateApartamento(Apartamento objApartamento) {
//		Apartamento newObjApartamento = findByIdApartamento(objApartamento.getIdApartamento());
//		updateData(newObjApartamento, objApartamento);
//		return apartamentoRepository.save(newObjApartamento);
//	}

//	private void updateData(Apartamento newObjApartamento, Apartamento objApartamento) {
//		newObjApartamento.setCpf(objApartamento.getCpf());
//		newObjApartamento.setNomeApartamento(objApartamento.getNomeApartamento());
//		newObjApartamento.setEmail(objApartamento.getEmail());
//		newObjApartamento.setNumeroTelefone(objApartamento.getNumeroTelefone());
//	}

//	public Apartamento fromApartamentoDTO(ApartamentoDTO objApartamentoDTO) {
//		return new Apartamento(objApartamentoDTO.getIdApartamento(), objApartamentoDTO.getNomeApartamento(),
//				objApartamentoDTO.getCpf(), objApartamentoDTO.getNumeroTelefone(), objApartamentoDTO.getEmail());
//	}

}