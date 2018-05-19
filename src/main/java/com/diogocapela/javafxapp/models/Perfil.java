package com.diogocapela.javafxapp.models;

import java.io.Serializable;
import java.util.List;

public class Perfil implements Serializable {

    private int id;
    private String descricao;
    private List<Integer> listaPeriodosAutorizacaoAssociados;

    public Perfil(int id, String descricao, List<Integer> listaPeriodosAutorizacaoAssociados) {
        this.id = id;
        this.descricao = descricao;
        this.listaPeriodosAutorizacaoAssociados = listaPeriodosAutorizacaoAssociados;
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

    public List<Integer> getListaPeriodosAutorizacaoAssociados() {
        return listaPeriodosAutorizacaoAssociados;
    }

    public void setListaPeriodosAutorizacaoAssociados(List<Integer> listaPeriodosAutorizacaoAssociados) {
        this.listaPeriodosAutorizacaoAssociados = listaPeriodosAutorizacaoAssociados;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", listaPeriodosAutorizacaoAssociados=" + listaPeriodosAutorizacaoAssociados +
                '}';
    }

}