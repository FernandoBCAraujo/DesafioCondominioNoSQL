package com.br.uati.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.br.uati.dto.ProprietarioDTO;
import com.br.uati.enums.StatusPagamentoDespesa;
import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class Despesa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	String idDespesa;
	
	private ProprietarioDTO proprietario;
	
	private String nomeDespesa;
	
	private BigDecimal valorDespesa;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate dataDespesa;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate dataVencimentoDespesa;
	
	private Integer statusPagamentoDespesa;
	
	private String tipoDespesa;
	
	public Despesa() {
		
	}

	public Despesa(String idDespesa, ProprietarioDTO proprietario, String nomeDespesa, BigDecimal valorDespesa,
			LocalDate dataDespesa, LocalDate dataVencimentoDespesa, StatusPagamentoDespesa statusPagamentoDespesa,
			String tipoDespesa) {
		super();
		this.idDespesa = idDespesa;
		this.proprietario = proprietario;
		this.nomeDespesa = nomeDespesa;
		this.valorDespesa = valorDespesa;
		this.dataDespesa = dataDespesa;
		this.dataVencimentoDespesa = dataVencimentoDespesa;
		setStatusPagamentoDespesa(statusPagamentoDespesa);
		this.tipoDespesa = tipoDespesa;
	}

	public String getIdDespesa() {
		return idDespesa;
	}

	public void setIdDespesa(String idDespesa) {
		this.idDespesa = idDespesa;
	}

	public ProprietarioDTO getProprietario() {
		return proprietario;
	}

	public void setProprietario(ProprietarioDTO proprietario) {
		this.proprietario = proprietario;
	}

	public String getNomeDespesa() {
		return nomeDespesa;
	}

	public void setNomeDespesa(String nomeDespesa) {
		this.nomeDespesa = nomeDespesa;
	}

	public BigDecimal getValorDespesa() {
		return valorDespesa;
	}

	public void setValorDespesa(BigDecimal valorDespesa) {
		this.valorDespesa = valorDespesa;
	}

	public LocalDate getDataDespesa() {
		return dataDespesa;
	}

	public void setDataDespesa(LocalDate dataDespesa) {
		this.dataDespesa = dataDespesa;
	}

	public LocalDate getDataVencimentoDespesa() {
		return dataVencimentoDespesa;
	}

	public void setDataVencimentoDespesa(LocalDate dataVencimentoDespesa) {
		this.dataVencimentoDespesa = dataVencimentoDespesa;
	}

	public StatusPagamentoDespesa getStatusPagamentoDespesa() {
		return StatusPagamentoDespesa.valueOf(statusPagamentoDespesa);
	}

	public void setStatusPagamentoDespesa(StatusPagamentoDespesa statusPagamentoDespesa) {
		this.statusPagamentoDespesa = statusPagamentoDespesa.getCodigoEnum();
	}

	public String getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(String tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}
	
}