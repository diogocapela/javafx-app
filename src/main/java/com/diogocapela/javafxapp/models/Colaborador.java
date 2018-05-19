package com.diogocapela.javafxapp.models;

import java.io.Serializable;

public class Colaborador implements Serializable {

    private int id;
    private String nomeCompleto;
    private String nomeAbreviado;
    private int perfilAssociado;

    public Colaborador(int id, String nomeCompleto, String nomeAbreviado, int perfilAssociado) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.nomeAbreviado = nomeAbreviado;
        this.perfilAssociado = perfilAssociado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeAbreviado() {
        return nomeAbreviado;
    }

    public void setNomeAbreviado(String nomeAbreviado) {
        this.nomeAbreviado = nomeAbreviado;
    }

    public int getPerfilAssociado() {
        return perfilAssociado;
    }

    public void setPerfilAssociado(int perfilAssociado) {
        this.perfilAssociado = perfilAssociado;
    }

    @Override
    public String toString() {
        return "Colaborador{" +
                "id=" + id +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", nomeAbreviado='" + nomeAbreviado + '\'' +
                ", perfilAssociado=" + perfilAssociado +
                '}';
    }

}