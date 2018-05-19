package com.diogocapela.javafxapp.controllers;

import com.diogocapela.javafxapp.utils.Logger;
import com.diogocapela.javafxapp.utils.Utils;
import com.diogocapela.javafxapp.models.Colaborador;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ColaboradoresController extends BaseController implements Initializable {

    @FXML
    private TableView<Colaborador> tabela;
    @FXML
    private TableColumn<Colaborador, Integer> col1;
    @FXML
    private TableColumn<Colaborador, String> col2;
    @FXML
    private TableColumn<Colaborador, String> col3;
    @FXML
    private TableColumn<Colaborador, String> col4;
    @FXML
    private TextField id;
    @FXML
    private TextField nomeCompleto;
    @FXML
    private TextField nomeAbreviado;
    @FXML
    private TextField perfilAssociado;

    public void initialize(URL location, ResourceBundle resources) {
        Logger.log("ColaboradoresController: initialize()");
        Logger.log("ColaboradoresController: empresa = " + empresa);
        updateView();
    }

    private void updateView() {
        col1.setCellValueFactory(new PropertyValueFactory<>("id"));
        col2.setCellValueFactory(new PropertyValueFactory<>("nomeCompleto"));
        col3.setCellValueFactory(new PropertyValueFactory<>("nomeAbreviado"));
        col4.setCellValueFactory(new PropertyValueFactory<>("perfilAssociado"));
        tabela.setItems(FXCollections.observableArrayList(empresa.getRegistoColaboradores()));
    }

    private void clearInputs() {
        id.clear();
        nomeCompleto.clear();
        nomeAbreviado.clear();
    }


    @FXML
    protected void handleAddColaborador(ActionEvent event) {
        Logger.log("ColaboradoresController: handleAddColaborador()");
        try {
            empresa.addColaborador(new Colaborador(
                    Integer.parseInt(id.getText()),
                    nomeCompleto.getText(),
                    nomeAbreviado.getText(),
                    Integer.parseInt(perfilAssociado.getText())
            ));
            Utils.openAlert(Utils.INFORMATION, "Colaborador adicionado com sucesso.", null, Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            Utils.openAlert(Utils.ERROR, e.getLocalizedMessage(), null, Alert.AlertType.ERROR);
        }
        clearInputs();
        updateView();
    }


    @FXML
    protected void handleDeleteColaborador(ActionEvent event) {
        Logger.log("ColaboradoresController: handleDeleteColaborador()");
        try {
            empresa.deleteColaboradorById(
                    tabela.getSelectionModel().getSelectedItem().getId()
            );
            Utils.openAlert(Utils.INFORMATION, "Colaborador eliminado com sucesso.", null, Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            Utils.openAlert(Utils.ERROR, e.getLocalizedMessage(), null, Alert.AlertType.ERROR);
        }
        clearInputs();
        updateView();
    }

}