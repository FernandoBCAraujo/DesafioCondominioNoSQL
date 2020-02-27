package com.br.uati.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Apartamento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	
	private String numeroApartamento;
	
//	private Proprietario proprietario;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumeroApartamento() {
		return numeroApartamento;
	}
	public void setNumeroApartamento(String numeroApartamento) {
		this.numeroApartamento = numeroApartamento;
	}
//	public Proprietario getProprietario() {
//		return proprietario;
//	}
//	public void setProprietario(Proprietario proprietario) {
//		this.proprietario = proprietario;
//	}
	
}
