package com.br.uati.dto;

import org.springframework.data.annotation.Id;

import com.br.uati.enums.StatusAlugado;
import com.br.uati.models.Apartamento;

public class ApartamentoDTO {
	
	@Id
	private String idApartamento;

	private String numeroApartamento;

	private ProprietarioDTO proprietario;

	private Integer statusAlugado;
	
	public ApartamentoDTO() {

	}
	
	public ApartamentoDTO(Apartamento objApartamento) {
		
		this.idApartamento = objApartamento.getIdApartamento();
		this.numeroApartamento = objApartamento.getNumeroApartamento();
		this.proprietario = objApartamento.getProprietario();
		this.statusAlugado = objApartamento.getStatusAlugado().getCodigoEnum();
		
	}

	public String getIdApartamento() {
		return idApartamento;
	}

	public void setIdApartamento(String idApartamento) {
		this.idApartamento = idApartamento;
	}

	public String getNumeroApartamento() {
		return numeroApartamento;
	}

	public void setNumeroApartamento(String numeroApartamento) {
		this.numeroApartamento = numeroApartamento;
	}

	public ProprietarioDTO getProprietario() {
		return proprietario;
	}

	public void setProprietario(ProprietarioDTO proprietario) {
		this.proprietario = proprietario;
	}

	public StatusAlugado getStatusAlugado() {
		return StatusAlugado.valueOf(statusAlugado);
	}

	public void setStatusAlugado(StatusAlugado statusAlugado) {
		this.statusAlugado = statusAlugado.getCodigoEnum();
	}

}
