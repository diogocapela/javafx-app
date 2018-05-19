package com.diogocapela.javafxapp.controllers;

import com.diogocapela.javafxapp.utils.Logger;
import com.diogocapela.javafxapp.utils.Utils;
import com.diogocapela.javafxapp.models.Equipamento;
import com.diogocapela.javafxapp.models.PeriodoAutorizacao;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PeriodosAutorizacaoController extends BaseController implements Initializable {

    @FXML
    private TableView<PeriodoAutorizacao> tabela;
    @FXML
    private TableColumn<PeriodoAutorizacao, Integer> col1;
    @FXML
    private TableColumn<PeriodoAutorizacao, String> col2;
    @FXML
    private TableColumn<PeriodoAutorizacao, String> col3;
    @FXML
    private TableColumn<PeriodoAutorizacao, Integer> col4;
    @FXML
    private TableColumn<PeriodoAutorizacao, Integer> col5;
    @FXML
    private TextField id;
    @FXML
    private ChoiceBox diaSemana;
    @FXML
    private ChoiceBox horaInicio;
    @FXML
    private ChoiceBox horaFim;
    @FXML
    private ChoiceBox equipamentoAssociado;

    public void initialize(URL location, ResourceBundle resources) {
        Logger.log("PeriodosAutorizacaoController: initialize()");
        Logger.log("PeriodosAutorizacaoController: empresa = " + empresa);

        // Populate horaInicio ChoiceBox
        diaSemana.setItems(FXCollections.observableArrayList(Utils.LIST_OF_DAYS));

        // Populate horaInicio ChoiceBox
        horaInicio.setItems(FXCollections.observableArrayList(Utils.LIST_OF_TIMES));

        // Populate horaInicio ChoiceBox
        horaFim.setItems(FXCollections.observableArrayList(Utils.LIST_OF_TIMES));

        // Populate equipamentoAssociado ChoiceBox
        List<String> listaEquipamentos = new ArrayList<>();
        for (Equipamento e : empresa.getRegistoEquipamentos()) {
            listaEquipamentos.add(e.getId() + ": Descrição: " + e.getDescricao() + " | Movimento: " + e.getTipoMovimento() + " | Área Restrita: " + e.getAreaRestritaAssociada());
        }
        equipamentoAssociado.setItems(FXCollections.observableArrayList(listaEquipamentos));

        updateView();
    }

    private void updateView() {
        col1.setCellValueFactory(new PropertyValueFactory<>("id"));
        col2.setCellValueFactory(new PropertyValueFactory<>("diaSemana"));
        col3.setCellValueFactory(new PropertyValueFactory<>("horaInicio"));
        col4.setCellValueFactory(new PropertyValueFactory<>("horaFim"));
        col5.setCellValueFactory(new PropertyValueFactory<>("equipamentoAssociado"));
        tabela.setItems(FXCollections.observableArrayList(
                empresa.getRegistoPeriodosAutorizacao()
        ));
    }

    private void clearInputs() {
        id.clear();
        diaSemana.getSelectionModel().clearSelection();
        horaInicio.getSelectionModel().clearSelection();
        horaFim.getSelectionModel().clearSelection();
        equipamentoAssociado.getSelectionModel().clearSelection();
    }

    @FXML
    protected void handleAddPeriodoAutorizacao(ActionEvent event) {
        Logger.log("PeriodosAutorizacaoController: handleAddPeriodoAutorizacao()");
        try {
            empresa.addPeriodoAutorizacao(new PeriodoAutorizacao(
                    Integer.parseInt(id.getText()),
                    diaSemana.getValue().toString(),
                    horaInicio.getValue().toString(),
                    horaFim.getValue().toString(),
                    Integer.parseInt(equipamentoAssociado.getValue().toString().split(":")[0])
            ));
            Utils.openAlert(Utils.INFORMATION, "Período de Autorização adicionado com sucesso.", null, Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            Utils.openAlert(Utils.ERROR, e.getLocalizedMessage(), null, Alert.AlertType.ERROR);
        }
        clearInputs();
        updateView();
    }

    @FXML
    protected void handleDeletePeriodoAutorizacao(ActionEvent event) {
        Logger.log("PeriodosAutorizacaoController: handleDeletePeriodoAutorizacao()");
        try {
            empresa.deletePeriodoAutorizacaoById(
                    tabela.getSelectionModel().getSelectedItem().getId()
            );
            Utils.openAlert(Utils.INFORMATION, "Período de Autorização eliminado com sucesso.", null, Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            Utils.openAlert(Utils.ERROR, e.getLocalizedMessage(), null, Alert.AlertType.ERROR);
        }
        clearInputs();
        updateView();
    }

}