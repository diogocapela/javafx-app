package com.diogocapela.javafxapp.controllers;

import com.diogocapela.javafxapp.models.*;
import com.diogocapela.javafxapp.utils.Logger;
import com.diogocapela.javafxapp.utils.Utils;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AcederAreaRestritaController extends BaseController implements Initializable {

    @FXML
    ChoiceBox cartaoChoiceBox;

    @FXML
    ChoiceBox equipamentoChoiceBox;

    @FXML
    ChoiceBox diaChoiceBox;

    @FXML
    ChoiceBox horaChoiceBox;

    @FXML
    Label colaboradorInfo;

    @FXML
    Label areaRestritaInfo;

    @FXML
    Label perfilInfo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Logger.log("AcederAreaRestritaController: initialize()");
        Logger.log("AcederAreaRestritaController: empresa = " + empresa);
        populateCartaoChoiceBox();
        populateEquipamentoChoiceBox();
        populateDiaChoiceBox();
        populateHoraChoiceBox();
    }


    @FXML
    private void handleAcederAreaRestrita() {

            int cartaoID = Integer.parseInt(cartaoChoiceBox.getValue().toString().split(":")[0]);
            int colaboradorID = Integer.parseInt(cartaoChoiceBox.getValue().toString().split("ID: ")[1]);

            int equipamentoID = Integer.parseInt(equipamentoChoiceBox.getValue().toString().split(":")[0]);
            int areaRestritaID = Integer.parseInt(equipamentoChoiceBox.getValue().toString().split("ID: ")[1]);

            String diaAcesso = diaChoiceBox.getValue().toString();

            int horaAcesso = Integer.parseInt(horaChoiceBox.getValue().toString().split(":")[0]);
            int minutoAcesso = Integer.parseInt(horaChoiceBox.getValue().toString().split(":")[1]);

            Colaborador colaborador = empresa.getColaboradorById(colaboradorID);

            Perfil perfil = empresa.getPerfilById(colaborador.getPerfilAssociado());

            AreaRestrita areaRestrita = empresa.getAreaRestritaById(areaRestritaID);


            colaboradorInfo.setText("Colaborador do Cartão:\nID: " + colaborador.getId() + "\nNome Completo: " + colaborador.getNomeCompleto() + "\nNome Abreviado: " + colaborador.getNomeAbreviado());

            perfilInfo.setText("Perfil do Colaborador:\nID: " + perfil.getId() + "\nDescrição: " + perfil.getDescricao());

            areaRestritaInfo.setText("Área Restrita do Equipamento:\nID: "+ areaRestrita.getId() + "\nDescrição: " + areaRestrita.getDescricao() + "\nLocalização: " + areaRestrita.getLocalizacao() + "\nLotação Máxima: " + areaRestrita.getLotacaoMaxima());

            boolean autorizado = false;

            for(int id : perfil.getListaPeriodosAutorizacaoAssociados()) {
                PeriodoAutorizacao periodoAutorizacao = empresa.getPeriodoAutorizacaoById(id);
                String pDia = periodoAutorizacao.getDiaSemana();
                int pHoraInicio =  Integer.parseInt(periodoAutorizacao.getHoraInicio().split(":")[0]);
                int pMinutoInicio =  Integer.parseInt(periodoAutorizacao.getHoraInicio().split(":")[1]);
                int pHoraFim =  Integer.parseInt(periodoAutorizacao.getHoraFim().split(":")[0]);
                int pMinutoFim =  Integer.parseInt(periodoAutorizacao.getHoraFim().split(":")[1]);



                if(pDia.equals(diaAcesso) &&
                        pHoraInicio <= horaAcesso &&
                        pHoraFim >= horaAcesso) {

                    autorizado = true;
                }
            }



            if(autorizado) {
                Utils.openAlert(Utils.INFORMATION, "Acesso garantido!", null, Alert.AlertType.INFORMATION);
            } else {
                Utils.openAlert(Utils.ERROR, "Acesso recusado!", null, Alert.AlertType.ERROR);
            }

    }


    private void populateCartaoChoiceBox() {
        List<String> listaCartoes = new ArrayList<>();
        for (Cartao o : empresa.getRegistoCartoes()) {
            listaCartoes.add(o.getId() + ": Data Emissão: " + o.getDataEmissao() + " | Versão: " + o.getVersao() + " | Colaborador ID: " + o.getColaboradorAssociado());
        }
        cartaoChoiceBox.setItems(FXCollections.observableArrayList(listaCartoes));
    }


    private void populateEquipamentoChoiceBox() {
        List<String> listaEquipamentos = new ArrayList<>();
        for (Equipamento o : empresa.getRegistoEquipamentos()) {
            listaEquipamentos.add(o.getId() + ": Descrição: " + o.getDescricao() + " | Movimento: " + o.getTipoMovimento() + " | Área Restrita ID: " + o.getAreaRestritaAssociada());
        }
        equipamentoChoiceBox.setItems(FXCollections.observableArrayList(listaEquipamentos));
    }

    private void populateDiaChoiceBox() {
        diaChoiceBox.setItems(FXCollections.observableArrayList(Utils.LIST_OF_DAYS));
    }

    private void populateHoraChoiceBox() {
        horaChoiceBox.setItems(FXCollections.observableArrayList(Utils.LIST_OF_TIMES));
    }

}

