package com.ceiba.cuatroruedas.infraestructura.controlador;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.cuatroruedas.aplicacion.comando.ComandoAgenda;
import com.ceiba.cuatroruedas.aplicacion.manejadores.ManejadorCrearAgenda;
import com.ceiba.cuatroruedas.aplicacion.manejadores.ManejadorObtenerAgenda;
import com.ceiba.cuatroruedas.dominio.Agenda;
import com.ceiba.cuatroruedas.dominio.excepcion.MensajeExcepcion;


@RestController
@RequestMapping("/agenda")
public class ControladorAgenda {

	private static final Logger LOGGER = LoggerFactory.getLogger(ControladorAgenda.class);

	private ManejadorCrearAgenda manejadorCrearAgenda;
	private ManejadorObtenerAgenda manejadorObtenerAgenda;

	public ControladorAgenda(ManejadorCrearAgenda manejadorCrearAgenda, ManejadorObtenerAgenda manejadorObtenerAgenda) {
		this.manejadorCrearAgenda = manejadorCrearAgenda;
		this.manejadorObtenerAgenda = manejadorObtenerAgenda;
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping({ "/", "/listar" })       
	public List<Agenda> listarAgenda() {
		LOGGER.info("Entrando a listar todos los registros.");
		return this.manejadorObtenerAgenda.listarTodo();
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("listar/{id}")
	public Agenda listarAgendaId(@PathVariable(name = "id") Long lgId) throws MensajeExcepcion {
		LOGGER.info("Entrando a listar el registro {}.", lgId);
		return this.manejadorObtenerAgenda.listarId(lgId);
	}

	@PostMapping("/add")
	@Transactional
	public void agregarAgenda(@RequestBody ComandoAgenda comandoAgenda) throws MensajeExcepcion {
		LOGGER.info("Preparando para agregar el registro {}.", comandoAgenda);
		this.manejadorCrearAgenda.ejecutar(comandoAgenda);
	}
}
