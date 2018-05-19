package com.diogocapela.javafxapp.controllers;

import com.diogocapela.javafxapp.utils.Logger;
import com.diogocapela.javafxapp.utils.Utils;
import com.diogocapela.javafxapp.models.AreaRestrita;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class AreasRestritasController extends BaseController implements Initializable {

    @FXML
    private TableView<AreaRestrita> tabela;
    @FXML
    private TableColumn<AreaRestrita, Integer> col1;
    @FXML
    private TableColumn<AreaRestrita, String> col2;
    @FXML
    private TableColumn<AreaRestrita, String> col3;
    @FXML
    private TableColumn<AreaRestrita, Integer> col4;
    @FXML
    private TextField id;
    @FXML
    private TextField descricao;
    @FXML
    private TextField localizacao;
    @FXML
    private TextField lotacaoMaxima;

    public void initialize(URL location, ResourceBundle resources) {
        Logger.log("AreasRestritasController: initialize()");
        Logger.log("AreasRestritasController: empresa = " + empresa);
        updateView();
    }

    private void updateView() {
        col1.setCellValueFactory(new PropertyValueFactory<>("id"));
        col2.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        col3.setCellValueFactory(new PropertyValueFactory<>("localizacao"));
        col4.setCellValueFactory(new PropertyValueFactory<>("lotacaoMaxima"));

        tabela.setItems(FXCollections.observableArrayList(
                empresa.getRegistoAreasRestritas()
        ));
    }

    private void clearInputs() {
        id.clear();
        descricao.clear();
        localizacao.clear();
        lotacaoMaxima.clear();
    }

    @FXML
    protected void handleAddAreaRestrita(ActionEvent event) {
        Logger.log("AreasRestritasController: handleAddColaborador()");
        try {
            empresa.addAreaRestrita(new AreaRestrita(
                    Integer.parseInt(id.getText()),
                    descricao.getText(),
                    localizacao.getText(),
                    Integer.parseInt(lotacaoMaxima.getText())
            ));
            Utils.openAlert(Utils.INFORMATION, "Área Restrita adicionada com sucesso.", null, Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            Utils.openAlert(Utils.ERROR, e.getLocalizedMessage(), null, Alert.AlertType.ERROR);
        }
        clearInputs();
        updateView();
    }

    @FXML
    protected void handleDeleteAreaRestrita(ActionEvent event) {
        Logger.log("AreasRestritasController: handleDeleteColaborador()");
        try {
            empresa.deleteAreaRestritaById(
                    tabela.getSelectionModel().getSelectedItem().getId()
            );
            Utils.openAlert(Utils.INFORMATION, "Área Restrita eliminada com sucesso.", null, Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            Utils.openAlert(Utils.ERROR, e.getLocalizedMessage(), null, Alert.AlertType.ERROR);
        }
        clearInputs();
        updateView();
    }

}
