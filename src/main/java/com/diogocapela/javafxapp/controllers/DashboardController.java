package com.diogocapela.javafxapp.controllers;

import com.diogocapela.javafxapp.utils.Logger;
import com.diogocapela.javafxapp.utils.Utils;
import com.diogocapela.javafxapp.models.*;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DashboardController extends BaseController implements Initializable {


    @FXML
    private ChoiceBox serealizedFileChoicebox;

    @FXML
    private ChoiceBox textFileChoicebox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Logger.log("DashboardController: initialize()");
        Logger.log("DashboardController: empresa = " + empresa);
        updateView();
    }

    private void updateView() {
        serealizedFileChoicebox.getSelectionModel().clearSelection();
        populateChoiceBoxWithSerializedFiles();
        populateChoiceBoxWithTextFilesOptions();
    }

    @FXML
    public void handleSerializeData() {
        Logger.log("DashboardController: handleSerializeData()");
        try {
            serealizeData();
        } catch (Exception e) {
            Utils.openAlert(Utils.ERROR, e.getLocalizedMessage(), null, Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void handleDeserializeData() {
        Logger.log("DashboardController: handleDeserializeData()");
        try {
            String filename = serealizedFileChoicebox.getValue().toString();
            deserealizeData(filename);
        } catch (Exception e) {
            Utils.openAlert(Utils.ERROR, e.getLocalizedMessage(), null, Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void handleLoadChoosenFile() {
        Logger.log("DashboardController: handleLoadChoosenFile()");
        try {
            String choice = textFileChoicebox.getValue().toString();
            switch (choice) {
                case "Todos os Ficheiros":
                    loadAllTextFiles();
                    break;
                case "Áreas Restritas":
                    loadAreasRestritas();
                    break;
                case "Cartões":
                    loadCartoes();
                    break;
                case "Colaboradores":
                    loadColaboradores();
                    break;
                case "Equipamentos":
                    loadEquipamentos();
                    break;
                case "Períodos de Autorização":
                    loadPeriodosAutorizacao();
                    break;
            }
        } catch (Exception e) {
            Utils.openAlert(Utils.ERROR, e.getLocalizedMessage(), null, Alert.AlertType.ERROR);
        }
    }

    private void populateChoiceBoxWithTextFilesOptions() {
        textFileChoicebox.setItems(FXCollections.observableArrayList(
                "Todos os Ficheiros", "Áreas Restritas", "Cartões", "Colaboradores", "Equipamentos", "Períodos de Autorização"
        ));
    }


    private void populateChoiceBoxWithSerializedFiles() {
        File folder = new File("./src/main/resources/database/serialized");
        File[] listOfFiles = folder.listFiles();
        List<String> serealizedFilenames = new ArrayList<>();
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                serealizedFilenames.add(listOfFile.getName());
            } else if (listOfFile.isDirectory()) {
                // do nothing
            }
        }
        serealizedFileChoicebox.setItems(FXCollections.observableArrayList(
                serealizedFilenames
        ));
    }

    public void loadAllTextFiles() {
        Logger.log("DashboardController: loadAllTextFiles()");
        loadAreasRestritas();
        loadCartoes();
        loadColaboradores();
        loadEquipamentos();
        loadPeriodosAutorizacao();
        Utils.openAlert(Utils.INFORMATION, "All text files loaded successful.", null, Alert.AlertType.INFORMATION);
    }

    public void loadAreasRestritas() {
        Logger.log("DashboardController: loadAreasRestritas()");
        List<ArrayList<String>> data = Utils.getDataFromFile("./src/main/resources/database/text/areas_restritas.txt");
        for (ArrayList<String> d : data) {
            AreaRestrita areaRestrita = new AreaRestrita(
                    Integer.parseInt(d.get(0)),
                    d.get(1),
                    d.get(2),
                    Integer.parseInt(d.get(3))
            );
            try {
                Empresa.getInstance().addAreaRestrita(areaRestrita);
            } catch (Exception e) {
                Utils.openAlert(Utils.ERROR, e.getLocalizedMessage(), null, Alert.AlertType.ERROR);
            }
        }
    }

    public void loadCartoes() {
        Logger.log("DashboardController: loadCartoes()");
        List<ArrayList<String>> data = Utils.getDataFromFile("./src/main/resources/database/text/cartoes.txt");
        for (ArrayList<String> d : data) {
            Cartao cartao = new Cartao(
                    Integer.parseInt(d.get(0)),
                    d.get(1),
                    d.get(2),
                    Integer.parseInt(d.get(3))
            );
            try {
                Empresa.getInstance().addCartao(cartao);
            } catch (Exception e) {
                Utils.openAlert(Utils.ERROR, e.getLocalizedMessage(), null, Alert.AlertType.ERROR);
            }
        }
    }

    public void loadColaboradores() {
        Logger.log("DashboardController: loadColaboradores()");
        List<ArrayList<String>> data = Utils.getDataFromFile("./src/main/resources/database/text/colaboradores.txt");
        for (ArrayList<String> d : data) {
            Colaborador colaborador = new Colaborador(
                    Integer.parseInt(d.get(0)),
                    d.get(1),
                    d.get(2),
                    Integer.parseInt(d.get(3))
            );
            try {
                Empresa.getInstance().addColaborador(colaborador);
            } catch (Exception e) {
                Utils.openAlert(Utils.ERROR, e.getLocalizedMessage(), null, Alert.AlertType.ERROR);
            }
        }
    }

    public void loadEquipamentos() {
        Logger.log("DashboardController: loadEquipamentos()");
        List<ArrayList<String>> data = Utils.getDataFromFile("./src/main/resources/database/text/equipamentos.txt");
        for (ArrayList<String> d : data) {
            Equipamento equipamento = new Equipamento(
                    Integer.parseInt(d.get(0)),
                    d.get(1),
                    d.get(2),
                    Integer.parseInt(d.get(3))
            );
            try {
                Empresa.getInstance().addEquipamento(equipamento);
            } catch (Exception e) {
                Utils.openAlert(Utils.ERROR, e.getLocalizedMessage(), null, Alert.AlertType.ERROR);
            }
        }
    }

    public void loadPeriodosAutorizacao() {
        Logger.log("DashboardController: loadPeriodosAutorizacao()");
        List<ArrayList<String>> data = Utils.getDataFromFile("./src/main/resources/database/text/periodos_autorizacao.txt");
        for (ArrayList<String> d : data) {
            PeriodoAutorizacao periodoAutorizacao = new PeriodoAutorizacao(
                    Integer.parseInt(d.get(0)),
                    d.get(1),
                    d.get(2),
                    d.get(3),
                    Integer.parseInt(d.get(4))
            );
            try {
                Empresa.getInstance().addPeriodoAutorizacao(periodoAutorizacao);
            } catch (Exception e) {
                Utils.openAlert(Utils.ERROR, e.getLocalizedMessage(), null, Alert.AlertType.ERROR);
            }
        }
    }

    private void serealizeData() {
        String timestamp = Utils.getTimestampString();
        try (FileOutputStream fos = new FileOutputStream("./src/main/resources/database/serialized/" + timestamp + ".bin"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(empresa);
            Utils.openAlert(Utils.INFORMATION, "Data saved (serialized) with success.", "Saved on file " + timestamp + ".bin.", Alert.AlertType.INFORMATION);
            updateView();
        } catch (Exception e) {
            Utils.openAlert(Utils.ERROR, e.getLocalizedMessage(), null, Alert.AlertType.ERROR);
        }
    }

    private void deserealizeData(String filename) {
        try (FileInputStream fis = new FileInputStream("./src/main/resources/database/serialized/" + filename); ObjectInputStream ois = new ObjectInputStream(fis)) {
            Empresa empresaCopy = (Empresa) ois.readObject();
            Empresa.setInstance(empresaCopy);
            Utils.openAlert(Utils.INFORMATION, "Data loaded (deserialized) with success.", "Loaded from file " + filename + ".", Alert.AlertType.INFORMATION);
            updateView();
        } catch (Exception e) {
            Utils.openAlert(Utils.ERROR, e.getLocalizedMessage(), null, Alert.AlertType.ERROR);
        }
    }


}