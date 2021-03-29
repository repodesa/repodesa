package com.ceiba.cuatroruedas.infraestructura.persistencia.repositorio;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ceiba.cuatroruedas.dominio.Agenda;
import com.ceiba.cuatroruedas.dominio.excepcion.MensajeExcepcion;
import com.ceiba.cuatroruedas.dominio.repositorio.IRepositorioAgenda;
import com.ceiba.cuatroruedas.infraestructura.persistencia.builder.AgendaBuilder;
import com.ceiba.cuatroruedas.infraestructura.persistencia.entidad.AgendaEntidad;
import com.ceiba.cuatroruedas.infraestructura.persistencia.repositorio.jpa.IRepositorioAgendaJpa;

@Repository
public class RepositorioAgendaPersiste implements IRepositorioAgenda, IRepositorioAgendaJpa {

	private static final Logger LOGGER = LoggerFactory.getLogger(RepositorioAgendaPersiste.class);

	private final EntityManager entityManager;

	public RepositorioAgendaPersiste(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public AgendaEntidad obtenerAgendaEntidadId(Long lgId) {
		Query aQuery = entityManager.createNamedQuery("Agenda.findById");
		aQuery.setParameter("id", lgId);
		List<AgendaEntidad> list = aQuery.getResultList();
		if (list.isEmpty()) {
			throw new MensajeExcepcion("Consulta no encontro registros.");
		}
		return list.get(0);
	}

	@Override
	public Agenda obtenerAgendaId(Long lgId) {
		LOGGER.info("Obteniendo uan Agenda desde la Persistencia. {}", lgId);
		AgendaEntidad entidad = obtenerAgendaEntidadId(lgId);
		LOGGER.info("Agenda := {}", entidad);
		return AgendaBuilder.pasarADominio(entidad);
	}

	@Override
	public List<Agenda> obtenerAgendaTotal() {
		List<AgendaEntidad> entidad = obtenerAgendaTotalEntidad();
		return AgendaBuilder.pasarAListaDominio(entidad);
	}

	@Override
	public void agregarAgenda(Agenda agenda) {
		/*
		 * Antes de relaizar la transacci�n en la base de datos ejecutamos una
		 * transformaci�n del objeto agenda.
		 */
		LOGGER.info("PERSISTIENDO LA AGENDA");
		entityManager.persist(AgendaBuilder.pasarAEntidad(agenda));
		LOGGER.info("REGISTRÓ LA AGENDA");
	}

	@Override
	public List<AgendaEntidad> obtenerAgendaTotalEntidad() {
		Query aQuery = entityManager.createNamedQuery("Agenda.findAll");
		@SuppressWarnings("unchecked")
		List<AgendaEntidad> listEntidads = aQuery.getResultList();
		return listEntidads;
	}

	@Override
	public List<AgendaEntidad> obtenerAgendaEntidadPorFecha(LocalDate ldFecha) {
		Query aQuery = entityManager.createNamedQuery("Agenda.findByFere");
		aQuery.setParameter("fecha", ldFecha);
		@SuppressWarnings("unchecked")
		List<AgendaEntidad> entidades = aQuery.getResultList();
		return entidades;
	}

	@Override
	public List<Agenda> obtenerAgendaPorFecha(LocalDate ldFecha) {
		List<AgendaEntidad> entidad = obtenerAgendaEntidadPorFecha(ldFecha);
		return AgendaBuilder.pasarAListaDominio(entidad);
	}

}
