package com.br.uati.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
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

	@DBRef(lazy = true)
	private List<Apartamento> apartamentos = new ArrayList<>();
	
	@DBRef(lazy = true)
	private List<Despesa> despesas = new ArrayList<>();

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

	public List<Apartamento> getApartamentos() {
		return apartamentos;
	}

	public void setApartamentos(List<Apartamento> apartamentos) {
		this.apartamentos = apartamentos;
	}

	public List<Despesa> getDespesas() {
		return despesas;
	}
	
	public void setDespesas(List<Despesa> despesas) {
		this.despesas = despesas;
	}
	
}