package com.br.uati.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.uati.dto.DespesaDTO;
import com.br.uati.models.Despesa;
import com.br.uati.services.DespesaService;

@RestController
@RequestMapping(value = "/despesas")
public class DespesaResource {

	@Autowired
	private DespesaService despesaService;

	@GetMapping
	public ResponseEntity<List<DespesaDTO>> findAll() {
		List<Despesa> listaDespesas = despesaService.findAll();
		List<DespesaDTO> listaDespesaDTO = listaDespesas.stream().map(x -> new DespesaDTO(x))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDespesaDTO);
	}

	@GetMapping(value = "/{idDespesa}")
	public ResponseEntity<Despesa> findByIdDespesa(@PathVariable String idDespesa) {
		Despesa objDespesa = despesaService.findByIdDespesa(idDespesa);
		return ResponseEntity.ok().body(objDespesa);
	}
	
//	@GetMapping(value = "/{idDespesa}/despesas")
//	public ResponseEntity<List<Despesa>> findDespesas(@PathVariable String idDespesa) {
//		Despesa objDespesa = despesaService.findByIdDespesa(idDespesa);
//		return ResponseEntity.ok().body(objDespesa.getDespesas());
//	}
//
//	@PostMapping
//	public ResponseEntity<Void> insertDespesaDTO(@RequestBody DespesaDTO objDespesaDTO) {
//		Despesa objDespesa = despesaService.fromDespesaDTO(objDespesaDTO);
//		objDespesa = despesaService.insertDespesa(objDespesa);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idDespesa}")
//				.buildAndExpand(objDespesa.getIdDespesa()).toUri();
//		return ResponseEntity.created(uri).build();
//	}
//
//	@DeleteMapping(value = "/{idDespesa}")
//	public ResponseEntity<Void> deleteDespesa(@PathVariable String idDespesa) {
//		despesaService.deleteDespesa(idDespesa);
//		return ResponseEntity.noContent().build();
//	}
//
//	@PutMapping(value = "/{idDespesa}")
//	public ResponseEntity<Void> updateDespesaDTO(@RequestBody DespesaDTO objDespesaDTO,
//			@PathVariable String idDespesa) {
//		Despesa objDespesa = despesaService.fromDespesaDTO(objDespesaDTO);
//		objDespesa.setIdDespesa(idDespesa);
//		objDespesa = despesaService.updateDespesa(objDespesa);
//		return ResponseEntity.noContent().build();
//	}
}