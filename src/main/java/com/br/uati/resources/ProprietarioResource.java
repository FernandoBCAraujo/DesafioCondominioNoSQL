package com.br.uati.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.uati.dto.ProprietarioDTO;
import com.br.uati.models.Proprietario;
import com.br.uati.services.ProprietarioService;

@RestController
@RequestMapping(value = "/proprietarios")
public class ProprietarioResource {

	@Autowired
	private ProprietarioService proprietarioService;

	@GetMapping
	public ResponseEntity<List<ProprietarioDTO>> findAll() {
		List<Proprietario> listaProprietarios = proprietarioService.findAll();
		List<ProprietarioDTO> listaProprietarioDTO = listaProprietarios.stream().map(x -> new ProprietarioDTO(x))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listaProprietarioDTO);
	}
	
	@GetMapping(value = "/{idProprietario}")
	public ResponseEntity<Proprietario> findByIdProprietario(@PathVariable String idProprietario) {
		Proprietario objProprietario = proprietarioService.findByIdProprietario(idProprietario);
		return ResponseEntity.ok().body(objProprietario);
	}

}
