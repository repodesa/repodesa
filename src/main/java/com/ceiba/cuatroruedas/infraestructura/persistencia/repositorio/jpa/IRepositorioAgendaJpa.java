package com.ceiba.cuatroruedas.infraestructura.persistencia.repositorio.jpa;

import java.time.LocalDate;
import java.util.List;

import com.ceiba.cuatroruedas.infraestructura.persistencia.entidad.AgendaEntidad;

public interface IRepositorioAgendaJpa {
	
	List<AgendaEntidad> obtenerAgendaTotalEntidad();
	
	AgendaEntidad obtenerAgendaEntidadId (Long strId);
	
	List<AgendaEntidad> obtenerAgendaEntidadPorFecha (LocalDate ldFecha);	
}
