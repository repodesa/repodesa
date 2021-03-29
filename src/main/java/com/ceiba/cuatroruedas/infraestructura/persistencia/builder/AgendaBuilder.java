package com.ceiba.cuatroruedas.infraestructura.persistencia.builder;

import java.util.ArrayList;
import java.util.List;

import com.ceiba.cuatroruedas.dominio.Agenda;
import com.ceiba.cuatroruedas.infraestructura.persistencia.entidad.AgendaEntidad;

public final class AgendaBuilder {

	private AgendaBuilder() {
	}

	/**
	 * 
	 * @param agendaEntity
	 * @return
	 */
	public static Agenda pasarADominio(AgendaEntidad agendaEntity) {
		/**
		 * REVISAR: Validar que el parámetro de entrada no sea nulo.
		 */
		return new Agenda(agendaEntity.getAgencodi(), agendaEntity.getAgenvehi(), agendaEntity.getAgenclie(),
				agendaEntity.getAgenreci(), agendaEntity.getAgenfeen(), agendaEntity.getAgenfesa(),
				agendaEntity.getAgenvalo());
	}

	/**
	 * 
	 * @param agenda
	 * @return
	 */
	public static AgendaEntidad pasarAEntidad(Agenda agenda) {
		/**
		 * REVISAR: Validar que el parámetro de entrada no sea nulo.
		 */
		return new AgendaEntidad(agenda.getAgencodi(), agenda.getAgenvehi(), agenda.getAgenclie(), agenda.getAgenreci(),
				agenda.getAgenfeen(), agenda.getAgenfesa(), agenda.getAgenvalo());
	}

	public static List<Agenda> pasarAListaDominio(List<AgendaEntidad> agendaEntidad) {
		/**
		 * REVISAR: Validar que el parámetro de entrada no sea nulo. Pasar la sentencia
		 * a luna lambda
		 */
		List<Agenda> agenda = new ArrayList<>();
		for (AgendaEntidad entidad : agendaEntidad) {
			agenda.add(pasarADominio(entidad));
		}
		return agenda;
	}
}