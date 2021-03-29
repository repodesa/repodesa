package com.ceiba.cuatroruedas.dominio.excepcion;

public class MensajeExcepcion extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MensajeExcepcion(String message) {
		super(message);
	}
}
