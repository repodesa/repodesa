package com.ceiba.cuatroruedas.dominio;

import java.time.LocalDate;

public class Cliente {
    private final String cliecldi;
    private final String clieNudo;
    private final String cliePrno;
    private final String clieSeno;
    private final String cliePrap;
    private final String clieSeap;
    private final String clieDire;
    private final LocalDate cliefere;

    public Cliente(String cliecldi, String clieNudo, String cliePrno, String clieSeno, String cliePrap, String clieSeap, String clieDire) {
        this.cliecldi = cliecldi;
        this.clieNudo = clieNudo;
        this.cliePrno = cliePrno;
        this.clieSeno = clieSeno;
        this.cliePrap = cliePrap;
        this.clieSeap = clieSeap;
        this.clieDire = clieDire;
        this.cliefere = LocalDate.now();
    }

    public String getCliecldi() {
        return cliecldi;
    }

    public String getClieNudo() {
        return clieNudo;
    }

    public String getCliePrno() {
        return cliePrno;
    }

    public String getClieSeno() {
        return clieSeno;
    }

    public String getCliePrap() {
        return cliePrap;
    }

    public String getClieSeap() {
        return clieSeap;
    }

    public String getClieDire() {
        return clieDire;
    }

    public LocalDate getCliefere() {
        return cliefere;
    }
}
