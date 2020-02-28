package com.br.uati.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.uati.dto.ApartamentoDTO;
import com.br.uati.models.Apartamento;
import com.br.uati.services.ApartamentoService;

@RestController
@RequestMapping(value = "/apartamentos")
public class ApartamentoResource {

	@Autowired
	private ApartamentoService apartamentoService;

	@GetMapping
	public ResponseEntity<List<ApartamentoDTO>> findAll() {
		List<Apartamento> listaApartamentos = apartamentoService.findAll();
		List<ApartamentoDTO> listaApartamentoDTO = listaApartamentos.stream().map(x -> new ApartamentoDTO(x))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listaApartamentoDTO);
	}

	@GetMapping(value = "/{idApartamento}")
	public ResponseEntity<Apartamento> findByIdApartamento(@PathVariable String idApartamento) {
		Apartamento objApartamento = apartamentoService.findByIdApartamento(idApartamento);
		return ResponseEntity.ok().body(objApartamento);
	}
	
//	@GetMapping(value = "/{idApartamento}/apartamentos")
//	public ResponseEntity<List<Apartamento>> findApartamentos(@PathVariable String idApartamento) {
//		Apartamento objApartamento = apartamentoService.findByIdApartamento(idApartamento);
//		return ResponseEntity.ok().body(objApartamento.getApartamentos());
//	}
//
//	@PostMapping
//	public ResponseEntity<Void> insertApartamentoDTO(@RequestBody ApartamentoDTO objApartamentoDTO) {
//		Apartamento objApartamento = apartamentoService.fromApartamentoDTO(objApartamentoDTO);
//		objApartamento = apartamentoService.insertApartamento(objApartamento);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idApartamento}")
//				.buildAndExpand(objApartamento.getIdApartamento()).toUri();
//		return ResponseEntity.created(uri).build();
//	}
//
//	@DeleteMapping(value = "/{idApartamento}")
//	public ResponseEntity<Void> deleteApartamento(@PathVariable String idApartamento) {
//		apartamentoService.deleteApartamento(idApartamento);
//		return ResponseEntity.noContent().build();
//	}
//
//	@PutMapping(value = "/{idApartamento}")
//	public ResponseEntity<Void> updateApartamentoDTO(@RequestBody ApartamentoDTO objApartamentoDTO,
//			@PathVariable String idApartamento) {
//		Apartamento objApartamento = apartamentoService.fromApartamentoDTO(objApartamentoDTO);
//		objApartamento.setIdApartamento(idApartamento);
//		objApartamento = apartamentoService.updateApartamento(objApartamento);
//		return ResponseEntity.noContent().build();
//	}
}