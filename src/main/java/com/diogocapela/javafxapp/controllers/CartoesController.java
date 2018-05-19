package com.diogocapela.javafxapp.controllers;

import com.diogocapela.javafxapp.utils.Logger;
import com.diogocapela.javafxapp.utils.Utils;
import com.diogocapela.javafxapp.models.Cartao;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class CartoesController extends BaseController implements Initializable {

    @FXML
    private TableView<Cartao> tabela;
    @FXML
    private TableColumn<Cartao, Integer> col1;
    @FXML
    private TableColumn<Cartao, String> col2;
    @FXML
    private TableColumn<Cartao, String> col3;
    @FXML
    private TableColumn<Cartao, String> col4;
    @FXML
    private TextField id;
    @FXML
    private TextField dataEmissao;
    @FXML
    private TextField versao;
    @FXML
    private TextField colaboradorAssociado;

    public void initialize(URL location, ResourceBundle resources) {
        Logger.log("CartoesController: initialize()");
        Logger.log("CartoesController: empresa = " + empresa);
        updateView();
    }

    private void updateView() {
        col1.setCellValueFactory(new PropertyValueFactory<>("id"));
        col2.setCellValueFactory(new PropertyValueFactory<>("dataEmissao"));
        col3.setCellValueFactory(new PropertyValueFactory<>("versao"));
        col4.setCellValueFactory(new PropertyValueFactory<>("colaboradorAssociado"));
        tabela.setItems(FXCollections.observableArrayList(empresa.getRegistoCartoes()));
    }

    private void clearInputs() {
        id.clear();
        dataEmissao.clear();
        versao.clear();
        colaboradorAssociado.clear();
    }


    @FXML
    protected void handleAddCartao(ActionEvent event) {
        Logger.log("CartoesController: handleAddCartao()");
        try {
            empresa.addCartao(new Cartao(
                    Integer.parseInt(id.getText()),
                    dataEmissao.getText(),
                    versao.getText(),
                    Integer.parseInt(colaboradorAssociado.getText())
            ));
            Utils.openAlert(Utils.INFORMATION, "Cartão adicionado com sucesso.", null, Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            Utils.openAlert(Utils.ERROR, e.getLocalizedMessage(), null, Alert.AlertType.ERROR);
        }
        clearInputs();
        updateView();
    }


    @FXML
    protected void handleDeleteCartao(ActionEvent event) {
        Logger.log("CartoesController: handleDeleteCartao()");
        try {
            empresa.deleteCartaoById(
                    tabela.getSelectionModel().getSelectedItem().getId()
            );
            Utils.openAlert(Utils.INFORMATION, "Cartão eliminado com sucesso.", null, Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            Utils.openAlert(Utils.ERROR, e.getLocalizedMessage(), null, Alert.AlertType.ERROR);
        }
        clearInputs();
        updateView();
    }

}
