package com.diogocapela.javafxapp.models;

import java.io.Serializable;

public class AreaRestrita implements Serializable {

    private int id;
    private String descricao;
    private String localizacao;
    private int lotacaoMaxima;

    public AreaRestrita(int id, String descricao, String localizacao, int lotacaoMaxima) {
        this.id = id;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.lotacaoMaxima = lotacaoMaxima;
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

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getLotacaoMaxima() {
        return lotacaoMaxima;
    }

    public void setLotacaoMaxima(int lotacaoMaxima) {
        this.lotacaoMaxima = lotacaoMaxima;
    }

    @Override
    public String toString() {
        return "AreaRestrita{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", localizacao='" + localizacao + '\'' +
                ", lotacaoMaxima=" + lotacaoMaxima +
                '}';
    }

}