package com.br.uati.dto;

import org.springframework.data.annotation.Id;

import com.br.uati.models.Proprietario;

public class ProprietarioDTO {
	
	@Id
	private String idProprietario;
	private String nomeProprietario;
	private String cpf;
	private String numeroTelefone;
	private String email;
	
	public ProprietarioDTO() {
		
	}
	
	public ProprietarioDTO(Proprietario objProprietario) {
		
		this.idProprietario = objProprietario.getIdProprietario();
		this.nomeProprietario = objProprietario.getNomeProprietario();
		this.cpf = objProprietario.getCpf();
		this.numeroTelefone = objProprietario.getNumeroTelefone();
		this.email = objProprietario.getEmail();
		
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

}
