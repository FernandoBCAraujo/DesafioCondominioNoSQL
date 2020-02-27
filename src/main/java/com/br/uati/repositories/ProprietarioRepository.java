package com.br.uati.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.br.uati.models.Proprietario;

@Repository
public interface ProprietarioRepository extends MongoRepository<Proprietario, Integer> {
	
	Optional<Proprietario> findByIdProprietario(String idProprietario);

}
