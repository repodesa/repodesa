package com.ceiba.cuatroruedas.aplicacion.manejadores;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.cuatroruedas.aplicacion.comando.ComandoAgenda;
import com.ceiba.cuatroruedas.aplicacion.fabrica.FabricaAgenda;
import com.ceiba.cuatroruedas.dominio.Agenda;
import com.ceiba.cuatroruedas.dominio.servicio.agenda.ServicioCrearAgenda;

@Service
public class ManejadorCrearAgenda {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ManejadorCrearAgenda.class);
	
	private final ServicioCrearAgenda servicioCrearAgenda;
	private final FabricaAgenda fabricaAgenda;

	public ManejadorCrearAgenda(ServicioCrearAgenda servicioCrearAgenda, FabricaAgenda fabricaAgenda) {
		this.servicioCrearAgenda = servicioCrearAgenda;
		this.fabricaAgenda = fabricaAgenda;
	}

	@Transactional
	public void ejecutar(ComandoAgenda comandoAgenda) {
		LOGGER.info("Preparando la creación del registro de la ComandoAgenda {}",comandoAgenda);
		Agenda agenda = this.fabricaAgenda.crearAgenda(comandoAgenda);
		
		LOGGER.info("Registro Agenda {}",agenda);
		servicioCrearAgenda.ejecutar(agenda);
	}
}
