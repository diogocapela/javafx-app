package com.diogocapela.javafxapp.models;

import java.io.Serializable;

public class PeriodoAutorizacao implements Serializable {

    private int id;
    private String diaSemana;
    private String horaInicio;
    private String horaFim;
    private int equipamentoAssociado;

    public PeriodoAutorizacao(int id, String diaSemana, String horaInicio, String horaFim, int equipamentoAssociado) {
        this.id = id;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.equipamentoAssociado = equipamentoAssociado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public int getEquipamentoAssociado() {
        return equipamentoAssociado;
    }

    public void setEquipamentoAssociado(int equipamentoAssociado) {
        this.equipamentoAssociado = equipamentoAssociado;
    }

    @Override
    public String toString() {
        return "PeriodoAutorizacao{" +
                "id=" + id +
                ", diaSemana='" + diaSemana + '\'' +
                ", horaInicio='" + horaInicio + '\'' +
                ", horaFim='" + horaFim + '\'' +
                ", equipamentoAssociado=" + equipamentoAssociado +
                '}';
    }

}