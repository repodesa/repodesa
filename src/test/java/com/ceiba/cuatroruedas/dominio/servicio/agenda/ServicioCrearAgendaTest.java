package com.ceiba.cuatroruedas.dominio.servicio.agenda;

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
import com.ceiba.cuatroruedas.dominio.excepcion.MensajeExcepcion;
import com.ceiba.cuatroruedas.infraestructura.persistencia.repositorio.RepositorioAgendaPersiste;

public class ServicioCrearAgendaTest {

	private static List<Agenda> LISTA_AGENDA_PROGRAMADA_MAXIMO_DIARIO = null;
	private static List<Agenda> LISTA_AGENDA_PROGRAMADA = null;
	private static Agenda AGENDA = null;
	private final Long AGENCODI = 100l;
	private final String AGENVEHI = "10";
	private final String AGENCLIE = "20";
	private final String AGENRECI = "Yefri Gomez";
	private final LocalDate AGENFESA = LocalDate.of(2021, 04, 02);
	private final Double AGENVALO = 1000.0;

	private static final LocalDate FECHA_FESTIVO = LocalDate.of(2021, 04, 01);

	@InjectMocks
	private ServicioCrearAgenda servicioCrearAgenda;

	@Mock
	private RepositorioAgendaPersiste repositorioAgendaPersiste;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		AGENDA = new Agenda(AGENCODI, AGENVEHI, AGENCLIE, AGENRECI, FECHA_FESTIVO, AGENFESA, AGENVALO);		
	}
	
	private List<Agenda> cargaAgendaMaximaDiarias() {
		LISTA_AGENDA_PROGRAMADA_MAXIMO_DIARIO = new ArrayList<>();
		for (int i = 0; i <= 11; i++) {
			LISTA_AGENDA_PROGRAMADA_MAXIMO_DIARIO.add(AGENDA);
			AGENDA = new Agenda(AGENCODI + 1, AGENVEHI + "-" + i, AGENCLIE + "-" + i, AGENRECI, FECHA_FESTIVO, AGENFESA, AGENVALO + 5240);
		}
		return LISTA_AGENDA_PROGRAMADA_MAXIMO_DIARIO;
	}
	
	private List<Agenda> cargaAgendaDuplicadaVehiculo() {		
		LISTA_AGENDA_PROGRAMADA = new ArrayList<>();
		for (int i = 0; i <= 1; i++) {
			LISTA_AGENDA_PROGRAMADA.add(AGENDA);
			AGENDA = new Agenda(AGENCODI + 1, AGENVEHI, AGENCLIE, AGENRECI, FECHA_FESTIVO, AGENFESA, AGENVALO + 5240);
			System.out.println(AGENDA.toString());
		}
		return LISTA_AGENDA_PROGRAMADA;
	}

	@Test
	public void agregaAgendaDiaFestivoTest() {
		servicioCrearAgenda.ejecutar(AGENDA);
	}

	@Test
	public void agregarAgendaConFechasNoHabilTest() {
		cargaAgendaMaximaDiarias();
		Mockito.when(repositorioAgendaPersiste.obtenerAgendaPorFecha(LocalDate.of(2021, 04, 01))).thenReturn(LISTA_AGENDA_PROGRAMADA_MAXIMO_DIARIO);
		servicioCrearAgenda.ejecutar(AGENDA);
	}

	@Test(expected = MensajeExcepcion.class)
	public void agregarAgendaDuplicadaPorVehiculoElMismoDiaTest() throws MensajeExcepcion {
		cargaAgendaDuplicadaVehiculo();
		Mockito.when(repositorioAgendaPersiste.obtenerAgendaPorFecha(LocalDate.now())).thenReturn(LISTA_AGENDA_PROGRAMADA);
		servicioCrearAgenda.ejecutar(AGENDA);
	}
}