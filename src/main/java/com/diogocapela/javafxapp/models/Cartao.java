package com.diogocapela.javafxapp.models;

import java.io.Serializable;

public class Cartao implements Serializable {

    private int id;
    private String dataEmissao;
    private String versao;
    private int colaboradorAssociado;

    public Cartao(int id, String dataEmissao, String versao, int colaboradorAssociado) {
        this.id = id;
        this.dataEmissao = dataEmissao;
        this.versao = versao;
        this.colaboradorAssociado = colaboradorAssociado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public int getColaboradorAssociado() {
        return colaboradorAssociado;
    }

    public void setColaboradorAssociado(int colaboradorAssociado) {
        this.colaboradorAssociado = colaboradorAssociado;
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "id=" + id +
                ", dataEmissao='" + dataEmissao + '\'' +
                ", versao='" + versao + '\'' +
                ", colaboradorAssociado=" + colaboradorAssociado +
                '}';
    }

}
