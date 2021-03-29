package com.ceiba.cuatroruedas.dominio;

import java.time.LocalDate;

public class Vehiculo {
    private final String vehimarc;
    private final String vehitive;
    private final String vehiplac;
    private final String vehicolo;
    private final String vehicili;
    private final Cliente vehiclie;
    private LocalDate vehifere;

    public Vehiculo(String vehimarc, String vehitive, String vehiplac, String vehicolo, String vehicili, Cliente vehiclie) {
        this.vehimarc = vehimarc;
        this.vehitive = vehitive;
        this.vehiplac = vehiplac;
        this.vehicolo = vehicolo;
        this.vehicili = vehicili;
        this.vehiclie = vehiclie;
        this.vehifere = LocalDate.now();        
    }

    public String getVehimarc() {
        return vehimarc;
    }

    public String getVehitive() {
        return vehitive;
    }

    public String getVehiplac() {
        return vehiplac;
    }

    public String getVehicolo() {
        return vehicolo;
    }

    public String getVehicili() {
        return vehicili;
    }

    public Cliente getVehiclie() {
        return vehiclie;
    }

    public LocalDate getVehifere() {
        return vehifere;
    }
}
