package com.ceiba.cuatroruedas.infraestructura.configuracion.conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexionJPA {

    private static final String BIBLIOTECA = "test";

    private static EntityManagerFactory entityManagerFactory;

    public ConexionJPA() {
        Persistence.createEntityManagerFactory(BIBLIOTECA);
    }

    public EntityManager createEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
