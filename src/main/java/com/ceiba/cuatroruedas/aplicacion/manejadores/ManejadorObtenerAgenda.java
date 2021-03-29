package com.ceiba.cuatroruedas.aplicacion.manejadores;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ceiba.cuatroruedas.dominio.Agenda;
import com.ceiba.cuatroruedas.dominio.servicio.agenda.ServicioObtenerAgenda;

@Service
public class ManejadorObtenerAgenda {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ManejadorObtenerAgenda.class);
	private final ServicioObtenerAgenda servicioObtenerAgenda;

	public ManejadorObtenerAgenda(ServicioObtenerAgenda servicioObtenerAgenda) {
		this.servicioObtenerAgenda = servicioObtenerAgenda;
	}

	public List<Agenda> listarTodo() {
		LOGGER.info("Preparando para Listar toda la Agenda");
		return this.servicioObtenerAgenda.listar();
	}

	public Agenda listarId(Long lgAgendaId) {
		LOGGER.info("Preparando para Listar Agenda con el parámetros {} ",lgAgendaId);
		return this.servicioObtenerAgenda.listarId(lgAgendaId);
	}
}
