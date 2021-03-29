package com.ceiba.cuatroruedas.dominio;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ceiba.cuatroruedas.dominio.excepcion.MensajeExcepcion;

public class AgendaTest {

	private static final Long AGENCODI = (long) 100;
	private static final String AGENVEHI = "10";
	private static final String AGENCLIE = "1";
	private static final String AGENRECI = "Pedro Perez";
	private static LocalDate AGENFEEN = LocalDate.of(2021, 03, 29);
	private static LocalDate AGENFESA = LocalDate.of(2021, 03, 30);
	private static Double AGENVALO = 100.0;

	private Agenda AGENDA = null;

	@Before
	public void setUp() throws Exception {
		AGENDA = null;
	}
	
	@Test(expected = MensajeExcepcion.class)
	public void fechaEntradaMenorQueFechaSalidaTest() throws MensajeExcepcion {
		AGENFEEN = LocalDate.of(2021, 03, 30);
		AGENFESA = LocalDate.of(2021, 03, 29);
		AGENVALO = 10000.0;
		AGENDA = new Agenda(AGENCODI, AGENVEHI, AGENCLIE, AGENRECI, AGENFEEN, AGENFESA, AGENVALO);
	}

	@Test(expected = MensajeExcepcion.class)
	public void fechaEntradaMayorQueFechaRegistroTest() throws MensajeExcepcion {
		AGENFEEN = LocalDate.of(2021, 01, 04);
		AGENVALO = 10000.0;
		AGENDA = new Agenda(AGENCODI, AGENVEHI, AGENCLIE, AGENRECI, AGENFEEN, AGENFESA, AGENVALO);
		Assert.fail();
	}

	@Test(expected = MensajeExcepcion.class)
	public void fechaSalidaMayorFechaEntradaTest() throws MensajeExcepcion {
		AGENFEEN = LocalDate.of(2021, 03, 29);
		AGENFESA = LocalDate.of(2021, 03, 28);		
		AGENVALO = 10000.0;
		AGENDA = new Agenda(AGENCODI, AGENVEHI, AGENCLIE, AGENRECI, AGENFEEN, AGENFESA, AGENVALO);
		Assert.fail();
	}	

	@Test(expected = MensajeExcepcion.class)
	public void valorAgendaNuloTest() throws MensajeExcepcion {
		AGENVALO = null;
		AGENDA = new Agenda(AGENCODI, AGENVEHI, AGENCLIE, AGENRECI, AGENFEEN, AGENFESA, AGENVALO);
		Assert.fail();
	}

	@Test(expected = MensajeExcepcion.class)
	public void valorAgendaCeroTest() throws MensajeExcepcion {
		AGENVALO = (double) 0.0;
		AGENDA = new Agenda(AGENCODI, AGENVEHI, AGENCLIE, AGENRECI, AGENFEEN, AGENFESA, AGENVALO);
		Assert.fail();
	}
	
	@Test(expected = MensajeExcepcion.class)
	public void valorAgendaMayorACeroTest() throws MensajeExcepcion {
		AGENDA = new Agenda(AGENCODI, AGENVEHI, AGENCLIE, AGENRECI, AGENFEEN, AGENFESA, AGENVALO);
	}	
	
}