package com.ceiba.cuatroruedas.dominio.servicio.agenda;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ceiba.cuatroruedas.dominio.Agenda;
import com.ceiba.cuatroruedas.dominio.excepcion.MensajeExcepcion;
import com.ceiba.cuatroruedas.infraestructura.persistencia.repositorio.RepositorioAgendaPersiste;
import com.ceiba.cuatroruedas.utilidades.Constantes;
import com.ceiba.cuatroruedas.utilidades.Utilidades;

@Component
public class ServicioCrearAgenda {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServicioCrearAgenda.class);
	private RepositorioAgendaPersiste agendaPersiste;

	public ServicioCrearAgenda(RepositorioAgendaPersiste agendaPersiste) {
		this.agendaPersiste = agendaPersiste;
	}

	@SuppressWarnings("unlikely-arg-type")
	public void ejecutar(Agenda agenda) {
		/**
		 * El sistema debe permitir agendar por día la cantidad de 10 citas, si esa
		 * cantidad de citas es superada en un día, se debería agendar la cita para el
		 * siguiente día hábil.
		 */
		if (agendaPersiste.obtenerAgendaPorFecha(agenda.getAgenfeen()).size() > Constantes.CANTIDAD_CITAS_DIARIAS) {
			LOGGER.info("Limite de cita superadas en el día");
			agenda.setAgenfeen(agenda.getAgenfeen().plusDays(1));
			agenda.setAgenfesa(agenda.getAgenfesa().plusDays(1));
		}

		/**
		 * Regla 6. El sistema debe impedir que el cliente/propietario programe citas
		 * los días Sabados y domingos, para este caso se debe sugerir el día habil
		 * siguiente.
		 */

		agenda.setAgenfeen(agenda.getAgenfeen().plusDays(Utilidades.validaDiasHabiles(agenda.getAgenfeen())));
		agenda.setAgenfesa(agenda.getAgenfesa().plusDays(Utilidades.validaDiasHabiles(agenda.getAgenfesa())));
		LOGGER.info("Fecha Entrada {} Fecha Salida {}", agenda.getAgenfeen(), agenda.getAgenfesa());
		/**
		 * Regla 5. Si el cliente/propietario agenda una cita para un día festivo, el
		 * sistema debe incrementar al doble el valor del servicio.
		 */
		if (Utilidades.esDiaFestivo(agenda.getAgenfeen())) {
			agenda.setAgenvalo(agenda.getAgenvalo() * Constantes.INCREMENTO_VALOR_DIA_FESTIVO);
			LOGGER.info("Valor de la cita incrementado {} ", agenda.getAgenvalo());
		}
		/**
		 * Regla 2. El sistema debe impedir que un vehículo registre mas de 1 cita en la
		 * misma fecha.
		 */
		agendaPersiste.obtenerAgendaPorFecha(LocalDate.now()).forEach(a -> {
			if (a.getAgenvehi().contains(agenda.getAgenvehi())) {
				throw new MensajeExcepcion("El vehículo ya tiene agendado una cita para la misma fecha.");
			}
		});

		agendaPersiste.agregarAgenda(agenda);
	}
}
