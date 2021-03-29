package com.ceiba.cuatroruedas.aplicacion.fabrica;

import com.ceiba.cuatroruedas.aplicacion.comando.ComandoAgenda;
import com.ceiba.cuatroruedas.dominio.Agenda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FabricaAgenda {
	private static final Logger LOGGER = LoggerFactory.getLogger(FabricaAgenda.class);

	public Agenda crearAgenda(ComandoAgenda comandoAgenda) {
		LOGGER.info("Creando la instancia de la Agenda desde la Fabrica {}", comandoAgenda);
		return new Agenda(comandoAgenda.getCoagcodi(), comandoAgenda.getCoagvehi(), comandoAgenda.getCoagclie(),
				comandoAgenda.getCoagreci(), comandoAgenda.getCoagfeen(), comandoAgenda.getCoagfesa(),
				comandoAgenda.getCoagvalo());
	}
}
