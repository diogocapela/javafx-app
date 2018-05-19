package com.diogocapela.javafxapp.models;

import java.io.Serializable;

public class Equipamento implements Serializable {

    private int id;
    private String descricao;
    private String tipoMovimento;
    private int areaRestritaAssociada;

    public Equipamento(int id, String descricao, String tipoMovimento, int areaRestritaAssociada) {
        this.id = id;
        this.descricao = descricao;
        this.tipoMovimento = tipoMovimento;
        this.areaRestritaAssociada = areaRestritaAssociada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(String tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public int getAreaRestritaAssociada() {
        return areaRestritaAssociada;
    }

    public void setAreaRestritaAssociada(int areaRestritaAssociada) {
        this.areaRestritaAssociada = areaRestritaAssociada;
    }

    @Override
    public String toString() {
        return "Equipamento{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", tipoMovimento='" + tipoMovimento + '\'' +
                ", areaRestritaAssociada=" + areaRestritaAssociada +
                '}';
    }

}