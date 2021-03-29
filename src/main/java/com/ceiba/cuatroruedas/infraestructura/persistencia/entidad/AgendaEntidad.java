package com.ceiba.cuatroruedas.infraestructura.persistencia.entidad;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity(name = "Agenda")
@NamedQuery(name = "Agenda.findAll", query = "SELECT agenda FROM Agenda agenda")
@NamedQuery(name = "Agenda.findById", query = "SELECT agenda FROM Agenda agenda WHERE agenda.agencodi = :id")
@NamedQuery(name = "Agenda.findByFere", query = "SELECT agenda FROM Agenda agenda WHERE agenda.agenfeen = :fecha")
@NamedQuery(name = "Agenda.findDateRange", query = "SELECT agenda FROM Agenda agenda WHERE :fecha BETWEEN agenda.agenfeen AND agenda.agenfesa")
public class AgendaEntidad {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long agencodi;
	@Column
	private String agenvehi;
	@Column
	private String agenclie;
	@Column
	private String agenreci;
	@Column
	private LocalDate agenfere;
	@Column
	private LocalDate agenfeen;
	@Column
	private LocalDate agenfesa;
	@Column
	private Double agenvalo;

	public AgendaEntidad() {

	}

	public AgendaEntidad(Long agencodi, String agenvehi, String agenclie, String agenreci, LocalDate agenfeen, LocalDate agenfesa, Double agenvalo) {
		this.agencodi = agencodi;
		this.agenvehi = agenvehi;
		this.agenclie = agenclie;
		this.agenreci = agenreci;
		this.agenfere = LocalDate.now();
		this.agenfeen = agenfeen;
		this.agenfesa = agenfesa;
		this.agenvalo = agenvalo;
	}

	public Long getAgencodi() {
		return agencodi;
	}

	public void setAgencodi(Long agencodi) {
		this.agencodi = agencodi;
	}

	public String getAgenvehi() {
		return agenvehi;
	}

	public void setAgenvehi(String agenvehi) {
		this.agenvehi = agenvehi;
	}

	public String getAgenclie() {
		return agenclie;
	}

	public void setAgenclie(String agenclie) {
		this.agenclie = agenclie;
	}

	public String getAgenreci() {
		return agenreci;
	}

	public void setAgenreci(String agenreci) {
		this.agenreci = agenreci;
	}

	public LocalDate getAgenfere() {
		return agenfere;
	}

	public void setAgenfere(LocalDate agenfere) {
		this.agenfere = agenfere;
	}

	public LocalDate getAgenfeen() {
		return agenfeen;
	}

	public void setAgenfeen(LocalDate agenfeen) {
		this.agenfeen = agenfeen;
	}

	public LocalDate getAgenfesa() {
		return agenfesa;
	}

	public void setAgenfesa(LocalDate agenfesa) {
		this.agenfesa = agenfesa;
	}

	public Double getAgenvalo() {
		return agenvalo;
	}

	public void setAgenvalo(Double agenvalo) {
		this.agenvalo = agenvalo;
	}
}
