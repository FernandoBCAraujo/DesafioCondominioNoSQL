package com.br.uati.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.br.uati.models.Despesa;

@Repository
public interface DespesaRepository extends MongoRepository<Despesa, String> {
	
	Optional<Despesa> findByIdDespesa(String idDespesa);

}