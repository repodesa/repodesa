package com.ceiba.cuatroruedas.dominio.servicio.agenda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.ceiba.cuatroruedas.dominio.Agenda;
import com.ceiba.cuatroruedas.infraestructura.persistencia.repositorio.RepositorioAgendaPersiste;

public class ServicioObtenerAgendaTest {

	private static final Long LGID = 100L;
	private static final List<Agenda> LISTA_AGENDAS = new ArrayList<Agenda>();
	private static List<Agenda> LISTA_AGENDAS_ESPERADAS = new ArrayList<Agenda>();
	private static List<Agenda> LISTA_AGENDA_NULA = null;

	private static Agenda AGENDA = null, AGENDA_ESPERADA = null, AGENDA_NULA = null;
	private final Long AGENCODI = 100l;
	private final String AGENVEHI = "10";
	private final String AGENCLIE = "20";
	private final String AGENRECI = "Yefri Gomez";
	private final LocalDate AGENFEEN = LocalDate.now();
	private final LocalDate AGENFESA = LocalDate.now();
	private final Double AGENVALO = 1000.0;

	@InjectMocks
	private ServicioObtenerAgenda servicioObtenerAgenda;

	@Mock
	private RepositorioAgendaPersiste agendaPersiste;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		AGENDA = new Agenda(AGENCODI, AGENVEHI, AGENCLIE, AGENRECI, AGENFEEN, AGENFESA, AGENVALO);
		AGENDA_ESPERADA = new Agenda(AGENCODI, AGENVEHI, AGENCLIE, AGENRECI, AGENFEEN, AGENFESA, AGENVALO);
	}

	@Test
	public void obtenerListadoAgendaTotalTest() {
		Mockito.when(agendaPersiste.obtenerAgendaTotal()).thenReturn(LISTA_AGENDAS);
		LISTA_AGENDAS_ESPERADAS = servicioObtenerAgenda.listar();
		assertNotNull(LISTA_AGENDAS_ESPERADAS);
	}

	@Test
	public void obtenerListadoAgendaTotalNuloTest() {
		Mockito.when(agendaPersiste.obtenerAgendaTotal()).thenReturn(null);
		LISTA_AGENDA_NULA = servicioObtenerAgenda.listar();
		assertNull(LISTA_AGENDA_NULA);
	}

	@Test
	public void obtenerAgendaPorIdTest() {
		Mockito.when(agendaPersiste.obtenerAgendaId(LGID)).thenReturn(AGENDA);
		AGENDA_ESPERADA = servicioObtenerAgenda.listarId(LGID);
		assertNotNull(AGENDA_ESPERADA);
		assertEquals(AGENDA_ESPERADA.getAgencodi(), AGENDA.getAgencodi());
		assertEquals(AGENDA_ESPERADA.getAgenvehi(), AGENDA.getAgenvehi());
		assertEquals(AGENDA_ESPERADA.getAgenclie(), AGENDA.getAgenclie());
		assertEquals(AGENDA_ESPERADA.getAgenreci(), AGENDA.getAgenreci());
		assertEquals(AGENDA_ESPERADA.getAgenfeen(), AGENDA.getAgenfeen());
		assertEquals(AGENDA_ESPERADA.getAgenfesa(), AGENDA.getAgenfesa());
		assertEquals(AGENDA_ESPERADA.getAgenvalo(), AGENDA.getAgenvalo());
	}
	
	@Test
	public void obtenerAgendaPorIdNoExisteTest() {
		Mockito.when(agendaPersiste.obtenerAgendaId(LGID)).thenReturn(AGENDA_NULA);
		AGENDA_ESPERADA = servicioObtenerAgenda.listarId(LGID);
		assertNull(AGENDA_ESPERADA);
	}

}