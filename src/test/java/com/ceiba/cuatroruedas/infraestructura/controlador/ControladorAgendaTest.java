package com.ceiba.cuatroruedas.infraestructura.controlador;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.ceiba.cuatroruedas.aplicacion.comando.ComandoAgenda;
import com.ceiba.cuatroruedas.aplicacion.manejadores.ManejadorCrearAgenda;
import com.ceiba.cuatroruedas.aplicacion.manejadores.ManejadorObtenerAgenda;
import com.ceiba.cuatroruedas.dominio.Agenda;
import com.ceiba.cuatroruedas.dominio.excepcion.MensajeExcepcion;

public class ControladorAgendaTest {

	private static List<Agenda> LISTA_AGENDA = null;
	private static List<Agenda> LISTA_AGENDA_ESPERADA = null;
	private static Agenda AGENDA = null, AGENDA_ESPERADA = null;
	private final Long AGENCODI = 100l;
	private final String AGENVEHI = "10";
	private final String AGENCLIE = "20";
	private final String AGENRECI = "Yefri Gomez";
	private final LocalDate AGENFESA = LocalDate.of(2021, 04, 02);
	private final Double AGENVALO = 1000.0;
	private static ComandoAgenda COMANDO_AGENDA = null;

	@InjectMocks
	private ControladorAgenda controladorAgenda;
	@Mock
	private ManejadorObtenerAgenda manejadorObtenerAgenda;
	@Mock
	private ManejadorCrearAgenda manejadorCrearAgenda;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		AGENDA = new Agenda(AGENCODI, AGENVEHI, AGENCLIE, AGENRECI, AGENFESA, AGENFESA, AGENVALO);
		LISTA_AGENDA = new ArrayList<>();
		LISTA_AGENDA.add(AGENDA);
		LISTA_AGENDA_ESPERADA = new ArrayList<>();
		LISTA_AGENDA_ESPERADA.add(AGENDA);
		COMANDO_AGENDA = new ComandoAgenda();
	}

	@Test
	public void listarAgendaTest() {
		Mockito.when(manejadorObtenerAgenda.listarTodo()).thenReturn(LISTA_AGENDA);
		LISTA_AGENDA_ESPERADA = controladorAgenda.listarAgenda();
		assertTrue(LISTA_AGENDA_ESPERADA.size() > 0);
	}

	@Test
	public void listarAgendaPorIdTest() {
		Mockito.when(manejadorObtenerAgenda.listarId(AGENCODI)).thenReturn(AGENDA);
		AGENDA_ESPERADA = controladorAgenda.listarAgendaId(AGENCODI);
		assertNotNull(AGENDA_ESPERADA);
	}

	@Test(expected = Exception.class)
	public void agragrAgendaTest() throws Exception {
		Mockito.doThrow(Exception.class).when(manejadorCrearAgenda).ejecutar(Mockito.any(ComandoAgenda.class));
		controladorAgenda.agregarAgenda(COMANDO_AGENDA);
	}
}