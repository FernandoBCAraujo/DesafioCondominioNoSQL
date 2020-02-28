package com.br.uati.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import com.br.uati.enums.StatusPagamentoDespesa;
import com.br.uati.models.Despesa;
import com.fasterxml.jackson.annotation.JsonFormat;

public class DespesaDTO {

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

	public DespesaDTO() {

	}
	
	public DespesaDTO(Despesa objDespesa) {
		
		this.idDespesa = objDespesa.getIdDespesa();
		this.proprietario = objDespesa.getProprietario();
		this.nomeDespesa = objDespesa.getNomeDespesa();
		this.valorDespesa = objDespesa.getValorDespesa();
		this.dataDespesa = objDespesa.getDataDespesa();
		this.dataVencimentoDespesa = objDespesa.getDataVencimentoDespesa();
		this.statusPagamentoDespesa = objDespesa.getStatusPagamentoDespesa().getCodigoEnum();
		this.tipoDespesa = objDespesa.getTipoDespesa();
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