package com.br.uati.enums;

public enum StatusAlugado {
	
	ALUGADO(1),
	DESALUGADO(2);
	
	private int codigoEnum;
	
	private StatusAlugado(int codigoEnum) {
		this.codigoEnum = codigoEnum;
	}

	public int getCodigoEnum() {
		return codigoEnum;
	}
	
	public static StatusAlugado valueOf(int codigoEnum) {
		for (StatusAlugado value: StatusAlugado.values()) {
			if (value.getCodigoEnum() == codigoEnum) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código de alugado inválido");
	}
	
}
