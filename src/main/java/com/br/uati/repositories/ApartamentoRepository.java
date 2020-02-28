package com.br.uati.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.br.uati.models.Apartamento;

@Repository
public interface ApartamentoRepository extends MongoRepository<Apartamento, Integer> {
	
	Optional<Apartamento> findByIdApartamento(String idApartamento);

}