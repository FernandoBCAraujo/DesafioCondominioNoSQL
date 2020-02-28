package com.br.uati.enums;

public enum StatusPagamentoDespesa {
	
	PAGO(1),
	AGUARDANDO_PAGAMENTO(2),
	NAO_PAGO(3);
	
	private int codigoEnum;
	
	private StatusPagamentoDespesa(int codigoEnum) {
		this.codigoEnum = codigoEnum;
	}

	public int getCodigoEnum() {
		return codigoEnum;
	}
	
	public static StatusPagamentoDespesa valueOf(int codigoEnum) {
		for (StatusPagamentoDespesa value: StatusPagamentoDespesa.values()) {
			if (value.getCodigoEnum() == codigoEnum) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código de pagamento inválido");
	}

}
