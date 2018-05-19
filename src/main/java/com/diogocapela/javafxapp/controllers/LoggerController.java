package com.diogocapela.javafxapp.controllers;

import com.diogocapela.javafxapp.utils.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class LoggerController extends BaseController implements Initializable {

    @FXML
    private ListView<String> listView;


    public void initialize(URL location, ResourceBundle resources) {
        Logger.log("LoggerController: initialize()");
        listView.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
        updateView();
    }

    private void updateView() {
        for (String data : Logger.getLogFileData()) {
            System.out.println("EEE" + data);
            listView.getItems().add(data);
        }
    }

}
