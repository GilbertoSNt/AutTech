package org.gsnt.auttech.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import org.gsnt.auttech.model.entities.entitiesgenerics.DadosGenericos;
import org.gsnt.auttech.util.DadosCombos;

import java.net.URL;
import java.util.ResourceBundle;

public class OsInternaController implements Initializable {


    private ObservableList<DadosGenericos> obsTipoProcura;


    private DadosCombos dadosCombos;

    @FXML
    protected ComboBox<DadosGenericos> cbBusca;

    @FXML
    protected Label lblInstrucao;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        obsTipoProcura = FXCollections.observableList(dadosCombos.tipoProcura());
        cbBusca.setItems(obsTipoProcura);
        Callback<ListView<DadosGenericos>, ListCell<DadosGenericos>> factory = lv -> new ListCell<DadosGenericos>(){
            @Override
            protected void updateItem(DadosGenericos dados, boolean empty){
                super.updateItem(dados, empty);
                setText(empty ? "" : dados.getDado());
            }
        };
        cbBusca.setCellFactory(factory);
        cbBusca.setButtonCell(factory.call(null));

    }

}
