package org.gsnt.auttech.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class CriaOsController {

    @FXML
    private TextField txtPlaca;

    @FXML
    private Label lblNomeCliente;

    @FXML
    private Label lblVeiculo;

    @FXML
    private Button btCadVeiculo;

    @FXML
    private Button btCadastraCliente;

    @FXML
    private Button btGravar;

    @FXML
    private Button btCancel;

    @FXML
    private Button btFechar;

    @FXML
    private Button btClose;

    protected void btCloseButtonClick(){
        Stage stage = (Stage)btClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    private TextArea txaDescricao;

    @FXML
    private CheckBox cbRevisao;

    @FXML
    private CheckBox cbTrcOleo;

    @FXML
    private CheckBox cbMec;

    @FXML
    private CheckBox cbSusp;

    @FXML
    private CheckBox cbFreio;

    @FXML
    private CheckBox cbMotor;

    @FXML
    private CheckBox cbInjElet;

    @FXML
    private CheckBox cbElet;

    @FXML
    private CheckBox cbCaixa;

    @FXML
    private CheckBox cbAlinBalan;

    @FXML
    private CheckBox cbSocMec;

    @FXML
    private CheckBox cbSocElet;

    @FXML
    private CheckBox cbBusVei;

    @FXML
    private CheckBox cbGuincho;

    @FXML
    private CheckBox cbLevVei;

    @FXML
    private CheckBox cbCliente;



}
