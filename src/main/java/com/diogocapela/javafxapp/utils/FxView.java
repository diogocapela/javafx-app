package com.diogocapela.javafxapp.utils;

import com.diogocapela.javafxapp.App;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.net.URL;

public class FxView {

    private Pane fxElement = null;

    public FxView(String fileName) {
        try {
            URL fileUrl = App.class.getResource("/views/" + fileName + ".fxml");
            if (fileUrl == null) {
                throw new java.io.FileNotFoundException("FxView: FXML file can't be found.");
            }
            fxElement = new FXMLLoader().load(fileUrl);

        } catch (Exception e) {
            Logger.log(e.getMessage());
        }
    }

    public Pane get() {
        return fxElement;
    }

}
