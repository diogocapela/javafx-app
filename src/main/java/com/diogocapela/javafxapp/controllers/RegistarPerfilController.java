package com.diogocapela.javafxapp.controllers;

import com.diogocapela.javafxapp.models.Perfil;
import com.diogocapela.javafxapp.utils.Logger;
import com.diogocapela.javafxapp.models.PeriodoAutorizacao;
import com.diogocapela.javafxapp.utils.Utils;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RegistarPerfilController extends BaseController implements Initializable {

    @FXML
    private TableView<Perfil> tabela;
    @FXML
    private TableColumn<Perfil, String> col1;
    @FXML
    private TableColumn<Perfil, Integer> col2;

    @FXML
    private VBox inputListaPeriodosAutorizacao;

    @FXML
    private TextField id;

    @FXML
    private TextField descricao;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Logger.log("PerfisController: initialize()");
        Logger.log("PerfisController: empresa = " + empresa);
        updateView();
    }

    private void updateView() {
        populateListaPeriodosAutorizacao();
        populateListaPerfis();
    }

    private void clearInputs() {
        id.clear();
        descricao.clear();
        for (Object node : inputListaPeriodosAutorizacao.getChildren()) {
            if (node instanceof CheckBox) {
                if (((CheckBox) node).isSelected()) {
                    ((CheckBox) node).setSelected(false);
                }
            }
        }
    }

    private void populateListaPeriodosAutorizacao() {
        for (PeriodoAutorizacao p : empresa.getRegistoPeriodosAutorizacao()) {
            CheckBox checkBox = new CheckBox(p.getId() + ": " + p.getDiaSemana() + " " + p.getHoraInicio() + " - " + p.getHoraFim() + " Equipamento: " + p.getEquipamentoAssociado());
            checkBox.setMinWidth(350);
            inputListaPeriodosAutorizacao.getChildren().add(checkBox);
        }
    }

    private void populateListaPerfis() {
        col1.setCellValueFactory(new PropertyValueFactory<>("id"));
        col2.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tabela.setItems(FXCollections.observableArrayList(empresa.getRegistoPerfis()));
    }

    @FXML
    private void handleAddPerfil() {
        Logger.log("PerfisController: handleAddPerfil()");
        List<Integer> listaPeriodosAutorizacaoSeleccionados = new ArrayList<>();
        for (Object node : inputListaPeriodosAutorizacao.getChildren()) {
            if (node instanceof CheckBox) {
                if (((CheckBox) node).isSelected()) {
                    listaPeriodosAutorizacaoSeleccionados.add(Integer.parseInt(((CheckBox) node).getText().split(":")[0]));
                }
            }
        }
        try {
            empresa.addPerfil(new Perfil(
                    Integer.parseInt(id.getText()),
                    descricao.getText(),
                    listaPeriodosAutorizacaoSeleccionados
            ));
            Utils.openAlert(Utils.INFORMATION, "Perfil adicionado com sucesso.", null, Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            Utils.openAlert(Utils.ERROR, e.getLocalizedMessage(), null, Alert.AlertType.ERROR);
        }
        clearInputs();
        updateView();
    }

}
