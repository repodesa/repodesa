package com.ceiba.cuatroruedas.infraestructura.configuracion.sistema;

import javax.persistence.EntityManager;

import com.ceiba.cuatroruedas.infraestructura.configuracion.conexion.ConexionJPA;

public class SistemaDePersistencia {

    private final EntityManager entityManager;

    public SistemaDePersistencia() {
        this.entityManager = new ConexionJPA().createEntityManager();
    }

    public void iniciar() {
        entityManager.getTransaction().begin();
    }

    public void terminar() {
        entityManager.getTransaction().commit();
    }
}
