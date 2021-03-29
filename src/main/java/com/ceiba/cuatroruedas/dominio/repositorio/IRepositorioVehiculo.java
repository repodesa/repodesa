package com.ceiba.cuatroruedas.dominio.repositorio;

import com.ceiba.cuatroruedas.dominio.Vehiculo;

public interface IRepositorioVehiculo {

    Vehiculo obtenerVehiculoPlaca ();

    void agregarVehiculo ();
}
