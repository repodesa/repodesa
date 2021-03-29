package com.ceiba.cuatroruedas.aplicacion.comando;

import java.time.LocalDate;

public class ComandoAgenda {

	private Long coagcodi;
	private String coagvehi;
	private String coagclie;
	private String coagreci;
	private LocalDate coagfeen;
	private LocalDate coagfesa;
	private Double coagvalo;

	public ComandoAgenda() {
	}

	public ComandoAgenda(String coagvehi, String coagclie, String coagreci, LocalDate coagfeen, LocalDate coagfesa, Double coagvalo) {
		this.coagvehi = coagvehi;
		this.coagclie = coagclie;
		this.coagreci = coagreci;
		this.coagfeen = coagfeen;
		this.coagfesa = coagfesa;
		this.coagvalo = coagvalo;
	}

	public Long getCoagcodi() {
		return coagcodi;
	}

	public String getCoagvehi() {
		return coagvehi;
	}

	public String getCoagclie() {
		return coagclie;
	}

	public String getCoagreci() {
		return coagreci;
	}

	public LocalDate getCoagfeen() {
		return coagfeen;
	}

	public LocalDate getCoagfesa() {
		return coagfesa;
	}

	public Double getCoagvalo() {
		return coagvalo;
	}

	@Override
	public String toString() {
		return "ComandoAgenda [coagcodi=" + coagcodi + ", coagvehi=" + coagvehi + ", coagclie=" + coagclie
				+ ", coagreci=" + coagreci + ", coagfeen=" + coagfeen + ", coagfesa=" + coagfesa + ", coagvalo="
				+ coagvalo + "]";
	}
}
