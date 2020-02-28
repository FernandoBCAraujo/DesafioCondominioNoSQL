package com.br.uati.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.uati.models.Despesa;
import com.br.uati.repositories.DespesaRepository;
import com.br.uati.services.exception.ObjectNotFoundException;

@Service
public class DespesaService {

	@Autowired
	private DespesaRepository despesaRepository;

	public List<Despesa> findAll() {
		return despesaRepository.findAll();
	}

	public Despesa findByIdDespesa(String idDespesa) {
		Optional<Despesa> objDespesa = despesaRepository.findByIdDespesa(idDespesa);

		return objDespesa.orElseThrow(() -> new ObjectNotFoundException(
				"Despesa com id -> " + idDespesa + " <-, não foi encontrado."));
	}

//	public Despesa insertDespesa(Despesa objDespesa) {
//		return despesaRepository.insert(objDespesa);
//	}
//	
//	public void deleteDespesa(String idDespesa) {
//		Despesa objDespesa = findByIdDespesa(idDespesa);
//		despesaRepository.delete(objDespesa);
//	}
//	
//	public Despesa updateDespesa(Despesa objDespesa) {
//		Despesa newObjDespesa = findByIdDespesa(objDespesa.getIdDespesa());
//		updateData(newObjDespesa, objDespesa);
//		return despesaRepository.save(newObjDespesa);
//	}

//	private void updateData(Despesa newObjDespesa, Despesa objDespesa) {
//		newObjDespesa.setCpf(objDespesa.getCpf());
//		newObjDespesa.setNomeDespesa(objDespesa.getNomeDespesa());
//		newObjDespesa.setEmail(objDespesa.getEmail());
//		newObjDespesa.setNumeroTelefone(objDespesa.getNumeroTelefone());
//	}

//	public Despesa fromDespesaDTO(DespesaDTO objDespesaDTO) {
//		return new Despesa(objDespesaDTO.getIdDespesa(), objDespesaDTO.getNomeDespesa(),
//				objDespesaDTO.getCpf(), objDespesaDTO.getNumeroTelefone(), objDespesaDTO.getEmail());
//	}

}