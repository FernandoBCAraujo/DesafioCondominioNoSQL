package com.br.uati.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Proprietario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String idProprietario;
	private String nomeProprietario;
	private String cpf;
	private String numeroTelefone;
	private String email;
//	private List<Apartamento> listaApartamentos;
	
	public Proprietario() {
		
	}

	public Proprietario(String idProprietario, String nomeProprietario, String cpf, String numeroTelefone,
			String email) {
		super();
		this.idProprietario = idProprietario;
		this.nomeProprietario = nomeProprietario;
		this.cpf = cpf;
		this.numeroTelefone = numeroTelefone;
		this.email = email;
//		this.listaApartamentos = listaApartamentos;
	}

	public String getIdProprietario() {
		return idProprietario;
	}

	public void setIdProprietario(String idProprietario) {
		this.idProprietario = idProprietario;
	}

	public String getNomeProprietario() {
		return nomeProprietario;
	}

	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public List<Apartamento> getListaApartamentos() {
//		return listaApartamentos;
//	}
//
//	public void setListaApartamentos(List<Apartamento> listaApartamentos) {
//		this.listaApartamentos = listaApartamentos;
//	}
	
}
