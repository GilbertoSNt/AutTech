package org.gsnt.auttech.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AgendaController {



    @FXML
    protected TextField txtVeiculo;

    @FXML
    protected TextField txtPlaca;

    @FXML
    protected TextField txtNome;

    @FXML
    protected TextField txtTelefone;

    @FXML
    protected Button btClose;

    @FXML
    protected void btCloseButtonClick(){
        Stage stage = (Stage)btClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected Button btGravar;

    @FXML
    protected Button btCancel;

    @FXML
    protected Button btFechar;

    @FXML
    protected CheckBox cbRevisao;

    @FXML
    protected CheckBox cbTrcOleo;

    @FXML
    protected CheckBox cbMec;

    @FXML
    protected CheckBox cbSusp;

    @FXML
    protected CheckBox cbFreio;

    @FXML
    protected CheckBox cbMotor;

    @FXML
    protected CheckBox cbInjElet;

    @FXML
    protected CheckBox cbElet;

    @FXML
    protected CheckBox cbCaixa;

    @FXML
    protected CheckBox cbAlinBalan;

}
