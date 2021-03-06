package com.br.uati.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.br.uati.dto.ProprietarioDTO;
import com.br.uati.enums.StatusAlugado;

@Document
public class Apartamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String idApartamento;

	private String numeroApartamento;

	private ProprietarioDTO proprietario;

	private Integer statusAlugado;

	public Apartamento() {

	}

	public Apartamento(String idApartamento, String numeroApartamento, ProprietarioDTO proprietario,
			StatusAlugado statusAlugado) {
		super();
		this.idApartamento = idApartamento;
		this.numeroApartamento = numeroApartamento;
		this.proprietario = proprietario;
		setStatusAlugado(statusAlugado);
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