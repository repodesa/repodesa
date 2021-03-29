package com.ceiba.cuatroruedas.dominio.servicio.agenda;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ceiba.cuatroruedas.dominio.Agenda;
import com.ceiba.cuatroruedas.infraestructura.persistencia.repositorio.RepositorioAgendaPersiste;

@Component
public class ServicioObtenerAgenda {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ServicioObtenerAgenda.class);
	private RepositorioAgendaPersiste agendaPersiste;
		
	public ServicioObtenerAgenda(RepositorioAgendaPersiste agendaPersiste) {
		this.agendaPersiste = agendaPersiste;
	}

	public List<Agenda> listar (){	
		LOGGER.info("Listando toda la Lista desde el Sericio");
        return agendaPersiste.obtenerAgendaTotal();
    }
	
    public Agenda listarId (Long lgIdAgenda){
    	LOGGER.info("Obteniendo una Agenda desde el Sericio");
        return agendaPersiste.obtenerAgendaId(lgIdAgenda);
    }
}
