package com.ceiba.cuatroruedas.dominio;

import java.time.LocalDate;

import com.ceiba.cuatroruedas.dominio.excepcion.MensajeExcepcion;

public class Agenda {
	
	private final Long agencodi;
	private final String agenvehi;
	private final String agenclie;
	private final String agenreci;
	private LocalDate agenfere;
	private LocalDate agenfeen;
	private LocalDate agenfesa;
	private Double agenvalo;

	public Agenda(Long agencodi, String agenvehi, String agenclie, String agenreci, LocalDate agenfeen, LocalDate agenfesa, Double agenvalo) {		
		this.agencodi = agencodi;
		this.agenvehi = agenvehi;
		this.agenclie = agenclie;
		this.agenreci = agenreci;
		this.agenfere = LocalDate.now();
		fechaEntradaMayorQueFechaRegistro(agenfeen);
		fechaSalidaMayorQueFechaRegistro (agenfesa);
		fechaSalidaMayorFechaEntrada(agenfeen, agenfesa);
		valorDiferenteNuloMayorCero(agenvalo);
	}

	private void fechaSalidaMayorFechaEntrada(LocalDate agenfeen, LocalDate agenfesa) {
		if (agenfesa.isBefore(agenfeen)) {
			throw new MensajeExcepcion("La fecha de salida debe ser mayor a la fecha de entrada.");
		}		
	}
	
	private void fechaEntradaMayorQueFechaRegistro(LocalDate agenfeen) {
		if (agenfeen.isBefore(agenfere)) {
			throw new MensajeExcepcion("El sistema solo permite Agendar citas en fechas superiores a hoy.");
		}
		this.agenfeen = agenfeen;
	}
	
	private void fechaSalidaMayorQueFechaRegistro(LocalDate agenfesa) {
		if (agenfesa.isBefore(agenfere)) {
			throw new MensajeExcepcion("El sistema solo permite fechas de salidas superiores a hoy.");
		}
		this.agenfesa = agenfesa;
	}

	private void valorDiferenteNuloMayorCero(Double valocita) {
		if (valocita == null) {
			throw new MensajeExcepcion("Defina un valor para la Cita mayor a Cero(0).");
		} else if (valocita <= 0) {
			throw new MensajeExcepcion("El Valor de la cita NO puede ser igual o menor a Cero (0)");
		}
		this.agenvalo = valocita;
	}

	public Long getAgencodi() {
		return agencodi;
	}

	public String getAgenvehi() {
		return agenvehi;
	}

	public String getAgenclie() {
		return agenclie;
	}

	public String getAgenreci() {
		return agenreci;
	}

	public LocalDate getAgenfere() {
		return agenfere;
	}

	public LocalDate getAgenfeen() {
		return agenfeen;
	}

	public LocalDate getAgenfesa() {
		return agenfesa;
	}

	public Double getAgenvalo() {
		return agenvalo;
	}

	public void setAgenfeen(LocalDate agenfeen) {
		this.agenfeen = agenfeen;
	}

	public void setAgenfesa(LocalDate agenfesa) {
		this.agenfesa = agenfesa;
	}

	public void setAgenvalo(Double agenvalo) {
		this.agenvalo = agenvalo;
	}

	@Override
	public String toString() {
		return "Agenda [agencodi=" + agencodi + ", agenvehi=" + agenvehi + ", agenclie=" + agenclie + ", agenreci="
				+ agenreci + ", agenfere=" + agenfere + ", agenfeen=" + agenfeen + ", agenfesa=" + agenfesa
				+ ", agenvalo=" + agenvalo + "]";
	}

}
