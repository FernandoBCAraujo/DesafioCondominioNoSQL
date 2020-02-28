package com.br.uati.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.uati.dto.ProprietarioDTO;
import com.br.uati.models.Apartamento;
import com.br.uati.models.Despesa;
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
	
	@GetMapping(value = "/{idProprietario}/apartamentos")
	public ResponseEntity<List<Apartamento>> findApartamentos(@PathVariable String idProprietario) {
		Proprietario objProprietario = proprietarioService.findByIdProprietario(idProprietario);
		return ResponseEntity.ok().body(objProprietario.getApartamentos());
	}
	
	@GetMapping(value = "/{idProprietario}/despesas")
	public ResponseEntity<List<Despesa>> findDespesas(@PathVariable String idProprietario) {
		Proprietario objProprietario = proprietarioService.findByIdProprietario(idProprietario);
		return ResponseEntity.ok().body(objProprietario.getDespesas());
	}

	@PostMapping
	public ResponseEntity<Void> insertProprietarioDTO(@RequestBody ProprietarioDTO objProprietarioDTO) {
		Proprietario objProprietario = proprietarioService.fromProprietarioDTO(objProprietarioDTO);
		objProprietario = proprietarioService.insertProprietario(objProprietario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idProprietario}")
				.buildAndExpand(objProprietario.getIdProprietario()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value = "/{idProprietario}")
	public ResponseEntity<Void> deleteProprietario(@PathVariable String idProprietario) {
		proprietarioService.deleteProprietario(idProprietario);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{idProprietario}")
	public ResponseEntity<Void> updateProprietarioDTO(@RequestBody ProprietarioDTO objProprietarioDTO,
			@PathVariable String idProprietario) {
		Proprietario objProprietario = proprietarioService.fromProprietarioDTO(objProprietarioDTO);
		objProprietario.setIdProprietario(idProprietario);
		objProprietario = proprietarioService.updateProprietario(objProprietario);
		return ResponseEntity.noContent().build();
	}
}