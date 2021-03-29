package com.ceiba.cuatroruedas.dominio.repositorio;

import java.time.LocalDate;
import java.util.List;

import com.ceiba.cuatroruedas.dominio.Agenda;

public interface IRepositorioAgenda {

	List<Agenda> obtenerAgendaTotal();
	
    Agenda obtenerAgendaId (Long strId);

    void agregarAgenda (Agenda agenda);
    
    List<Agenda> obtenerAgendaPorFecha (LocalDate ldFecha);
}
