package com.diogocapela.javafxapp.controllers;

import com.diogocapela.javafxapp.utils.Logger;
import com.diogocapela.javafxapp.utils.Utils;
import com.diogocapela.javafxapp.models.AreaRestrita;
import com.diogocapela.javafxapp.models.Equipamento;

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

public class EquipamentosController extends BaseController implements Initializable {

    @FXML
    private TableView<Equipamento> tabela;
    @FXML
    private TableColumn<Equipamento, Integer> col1;
    @FXML
    private TableColumn<Equipamento, String> col2;
    @FXML
    private TableColumn<Equipamento, String> col3;
    @FXML
    private TableColumn<Equipamento, Integer> col4;
    @FXML
    private TextField id;
    @FXML
    private TextField descricao;
    @FXML
    private ChoiceBox tipoMovimento;
    @FXML
    private ChoiceBox areaRestritaId;

    public void initialize(URL location, ResourceBundle resources) {
        Logger.log("EquipamentosController: initialize()");
        Logger.log("EquipamentosController: empresa = " + empresa);

        // Populate Tipo de Movimento ChoiceBox
        tipoMovimento.setItems(FXCollections.observableArrayList("Entrada", "Saída"));

        // Populate Área Restrita ChoiceBox
        List<String> listaAreasRestritas = new ArrayList<>();
        for (AreaRestrita ar : empresa.getRegistoAreasRestritas()) {
            listaAreasRestritas.add(ar.getId() + ": Localização: " + ar.getLocalizacao() + " | Descrição: " + ar.getDescricao() + " | Lotação Máxima: " + ar.getLotacaoMaxima());
        }
        areaRestritaId.setItems(FXCollections.observableArrayList(listaAreasRestritas));

        updateView();
    }

    private void updateView() {
        col1.setCellValueFactory(new PropertyValueFactory<>("id"));
        col2.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        col3.setCellValueFactory(new PropertyValueFactory<>("tipoMovimento"));
        col4.setCellValueFactory(new PropertyValueFactory<>("areaRestritaAssociada"));
        tabela.setItems(FXCollections.observableArrayList(
                empresa.getRegistoEquipamentos()
        ));
    }

    private void clearInputs() {
        id.clear();
        descricao.clear();
        tipoMovimento.getSelectionModel().clearSelection();
        areaRestritaId.getSelectionModel().clearSelection();
    }

    @FXML
    protected void handleAddEquipamento(ActionEvent event) {
        Logger.log("EquipamentosController: handleAddEquipamento()");
        try {
            empresa.addEquipamento(new Equipamento(
                    Integer.parseInt(id.getText()),
                    descricao.getText(),
                    tipoMovimento.getValue().toString(),
                    Integer.parseInt(areaRestritaId.getValue().toString().split(":")[0])
            ));
            Utils.openAlert(Utils.INFORMATION, "Equipamento adicionado com sucesso.", null, Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            Utils.openAlert(Utils.ERROR, e.getLocalizedMessage(), null, Alert.AlertType.ERROR);
        }
        clearInputs();
        updateView();
    }

    @FXML
    protected void handleDeleteEquipamento(ActionEvent event) {
        Logger.log("EquipamentosController: handleDeleteEquipamento()");
        try {
            empresa.deleteEquipamentoById(
                    tabela.getSelectionModel().getSelectedItem().getId()
            );
            Utils.openAlert(Utils.INFORMATION, "Equipamento eliminado com sucesso.", null, Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            Utils.openAlert(Utils.ERROR, e.getLocalizedMessage(), null, Alert.AlertType.ERROR);
        }
        clearInputs();
        updateView();
    }

}