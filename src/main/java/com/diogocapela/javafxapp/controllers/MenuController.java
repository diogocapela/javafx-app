package com.diogocapela.javafxapp.controllers;

import com.diogocapela.javafxapp.App;

import com.diogocapela.javafxapp.utils.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    protected void openDashboard(ActionEvent event) {
        App.showPage("dashboard");
    }

    @FXML
    protected void openAreasRestritas(ActionEvent event) {
        App.showPage("areasRestritas");
    }

    @FXML
    protected void openCartoes(ActionEvent event) {
        App.showPage("cartoes");
    }

    @FXML
    protected void openColaboradores(ActionEvent event) {
        App.showPage("colaboradores");
    }

    @FXML
    protected void openEquipamentos(ActionEvent event) {
        App.showPage("equipamentos");
    }

    @FXML
    protected void openPeriodosAutorizacao(ActionEvent event) {
        App.showPage("periodosAutorizacao");
    }

    @FXML
    protected void openRegistarPerfil(ActionEvent event) {
        App.showPage("registarPerfil");
    }

    @FXML
    protected void openAcederAreaRestrita(ActionEvent event) {
        App.showPage("acederAreaRestrita");
    }

    @FXML
    protected void openLogger(ActionEvent event) {
        App.showPage("logger");
    }

    @FXML
    protected void exitApp(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Logger.log("MenuController: initialize()");
    }

}