package com.diogocapela.javafxapp.models;

import com.diogocapela.javafxapp.exceptions.DuplicateException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Empresa implements Serializable {

    // Singleton Pattern Variable
    private static volatile Empresa uniqueInstance = new Empresa();

    // Instance Variables
    private List<AreaRestrita> registoAreasRestritas;
    private List<Cartao> registoCartoes;
    private List<Colaborador> registoColaboradores;
    private List<Equipamento> registoEquipamentos;
    private List<PeriodoAutorizacao> registoPeriodosAutorizacao;
    private List<Perfil> registoPerfis;

    private Empresa() {
        this.registoAreasRestritas = new ArrayList<>();
        this.registoCartoes = new ArrayList<>();
        this.registoColaboradores = new ArrayList<>();
        this.registoEquipamentos = new ArrayList<>();
        this.registoPeriodosAutorizacao = new ArrayList<>();
        this.registoPerfis = new ArrayList<>();
    }

    // Singleton Pattern Get Instance

    public static Empresa getInstance() {
        synchronized (Empresa.class) {
            if (uniqueInstance == null) {
                uniqueInstance = new Empresa();
            }
        }
        return uniqueInstance;
    }

    // Singleton Pattern Set Instance

    public static void setInstance(Empresa empresa) {
        uniqueInstance = empresa;
    }

    // AreaRestrita

    public List<AreaRestrita> getRegistoAreasRestritas() {
        return registoAreasRestritas;
    }

    public void setRegistoAreasRestritas(List<AreaRestrita> registoAreasRestritas) {
        this.registoAreasRestritas = registoAreasRestritas;
    }

    public void addAreaRestrita(AreaRestrita areaRestrita) throws DuplicateException {
        boolean duplicate = false;
        for (AreaRestrita ar : registoAreasRestritas) {
            if (ar.getId() == areaRestrita.getId()) {
                duplicate = true;
            }
        }
        if (!duplicate) {
            registoAreasRestritas.add(areaRestrita);
        } else throw new DuplicateException("Área Restrita");
    }

    public void deleteAreaRestritaById(int id) {
        AreaRestrita areaRestrita;
        Optional finder = registoAreasRestritas.stream().filter(o -> o.getId() == id).findFirst();
        if (finder.isPresent()) {
            areaRestrita = (AreaRestrita) finder.get();
            registoAreasRestritas.remove(areaRestrita);
        }
    }

    public AreaRestrita getAreaRestritaById(int id) {
        AreaRestrita areaRestrita;
        Optional finder = registoAreasRestritas.stream().filter(o -> o.getId() == id).findFirst();
        if (finder.isPresent()) {
            areaRestrita = (AreaRestrita) finder.get();
            return areaRestrita;
        }
        return null;
    }

    // Cartao

    public List<Cartao> getRegistoCartoes() {
        return registoCartoes;
    }

    public void setRegistoCartoes(List<Cartao> registoCartoes) {
        this.registoCartoes = registoCartoes;
    }

    public void addCartao(Cartao cartao) throws DuplicateException {
        boolean duplicate = false;
        for (Cartao c : registoCartoes) {
            if (c.getId() == cartao.getId()) {
                duplicate = true;
            }
        }
        if (!duplicate) {
            registoCartoes.add(cartao);
        } else throw new DuplicateException("Cartão");
    }

    public void deleteCartaoById(int id) {
        Cartao cartao;
        Optional finder = registoCartoes.stream().filter(o -> o.getId() == id).findFirst();
        if (finder.isPresent()) {
            cartao = (Cartao) finder.get();
            registoCartoes.remove(cartao);
        }
    }

    public Cartao getCartaoById(int id) {
        Cartao cartao;
        Optional finder = registoCartoes.stream().filter(o -> o.getId() == id).findFirst();
        if (finder.isPresent()) {
            cartao = (Cartao) finder.get();
            return cartao;
        }
        return null;
    }

    // Colaborador

    public List<Colaborador> getRegistoColaboradores() {
        return registoColaboradores;
    }

    public void setRegistoColaboradores(List<Colaborador> registoColaboradores) {
        this.registoColaboradores = registoColaboradores;
    }

    public void addColaborador(Colaborador colaborador) throws DuplicateException {
        boolean duplicate = false;
        for (Colaborador c : registoColaboradores) {
            if (c.getId() == colaborador.getId()) {
                duplicate = true;
            }
        }
        if (!duplicate) {
            registoColaboradores.add(colaborador);
        } else throw new DuplicateException("Colaborador");
    }

    public void deleteColaboradorById(int id) {
        Colaborador colaborador;
        Optional finder = registoColaboradores.stream().filter(o -> o.getId() == id).findFirst();
        if (finder.isPresent()) {
            colaborador = (Colaborador) finder.get();
            registoColaboradores.remove(colaborador);
        }
    }

    public Colaborador getColaboradorById(int id) {
        Colaborador colaborador;
        Optional finder = registoColaboradores.stream().filter(o -> o.getId() == id).findFirst();
        if (finder.isPresent()) {
            colaborador = (Colaborador) finder.get();
            return colaborador;
        }
        return null;
    }

    // Equipamento

    public List<Equipamento> getRegistoEquipamentos() {
        return registoEquipamentos;
    }

    public void setRegistoEquipamentos(List<Equipamento> registoEquipamentos) {
        this.registoEquipamentos = registoEquipamentos;
    }

    public void addEquipamento(Equipamento equipamento) throws DuplicateException {
        boolean duplicate = false;
        for (Equipamento e : registoEquipamentos) {
            if (e.getId() == equipamento.getId()) {
                duplicate = true;
            }
        }
        if (!duplicate) {
            registoEquipamentos.add(equipamento);
        } else throw new DuplicateException("Equipamento");
    }

    public void deleteEquipamentoById(int id) {
        Equipamento equipamento;
        Optional finder = registoEquipamentos.stream().filter(o -> o.getId() == id).findFirst();
        if (finder.isPresent()) {
            equipamento = (Equipamento) finder.get();
            registoEquipamentos.remove(equipamento);
        }
    }

    // PeriodoAutorizacao

    public List<PeriodoAutorizacao> getRegistoPeriodosAutorizacao() {
        return registoPeriodosAutorizacao;
    }

    public void setRegistoPeriodosAutorizacao(List<PeriodoAutorizacao> registoPeriodosAutorizacao) {
        this.registoPeriodosAutorizacao = registoPeriodosAutorizacao;
    }

    public void addPeriodoAutorizacao(PeriodoAutorizacao periodoAutorizacao) throws DuplicateException {
        boolean duplicate = false;
        for (PeriodoAutorizacao p : registoPeriodosAutorizacao) {
            if (p.getId() == periodoAutorizacao.getId()) {
                duplicate = true;
            }
        }
        if (!duplicate) {
            registoPeriodosAutorizacao.add(periodoAutorizacao);
        } else throw new DuplicateException("PeriodoAutorizacao");
    }

    public void deletePeriodoAutorizacaoById(int id) {
        PeriodoAutorizacao periodoAutorizacao;
        Optional finder = registoPeriodosAutorizacao.stream().filter(o -> o.getId() == id).findFirst();
        if (finder.isPresent()) {
            periodoAutorizacao = (PeriodoAutorizacao) finder.get();
            registoPeriodosAutorizacao.remove(periodoAutorizacao);
        }
    }

    public PeriodoAutorizacao getPeriodoAutorizacaoById(int id) {
        PeriodoAutorizacao periodoAutorizacao;
        Optional finder = registoPeriodosAutorizacao.stream().filter(o -> o.getId() == id).findFirst();
        if (finder.isPresent()) {
            periodoAutorizacao = (PeriodoAutorizacao) finder.get();
            return periodoAutorizacao;
        }
        return null;
    }


    // Perfil

    public List<Perfil> getRegistoPerfis() {
        return registoPerfis;
    }

    public void setRegistoPerfis(List<Perfil> registoPerfis) {
        this.registoPerfis = registoPerfis;
    }

    public void addPerfil(Perfil perfil) throws DuplicateException {
        boolean duplicate = false;
        for (Perfil p : registoPerfis) {
            if (p.getId() == perfil.getId()) {
                duplicate = true;
            }
        }
        if (!duplicate) {
            registoPerfis.add(perfil);
        } else throw new DuplicateException("Perfil");
    }

    public void deletePerfilById(int id) {
        Perfil perfil;
        Optional finder = registoPerfis.stream().filter(o -> o.getId() == id).findFirst();
        if (finder.isPresent()) {
            perfil = (Perfil) finder.get();
            registoPerfis.remove(perfil);
        }
    }

    public Perfil getPerfilById(int id) {
        Perfil perfil;
        Optional finder = registoPerfis.stream().filter(o -> o.getId() == id).findFirst();
        if (finder.isPresent()) {
            perfil = (Perfil) finder.get();
            return perfil;
        }
        return null;
    }

}
