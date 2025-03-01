package org.gsnt.auttech.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ItensOsController {

    @FXML
    private TextField txtPlaca;

    @FXML
    private Button btVeiculo;

    @FXML
    private Button btCliente;

    @FXML
    private Label lblNumOs;

    @FXML
    private Label lblNomeCliente;

    @FXML
    private Label lblVeiculo;

    @FXML
    private TextArea txaObservacoes;

    @FXML
    private TextArea txaDescricao;

    @FXML
    private TabPane tpGeral;



    @FXML
    private Button btClose;

    @FXML
    private Button btFechar;

    @FXML
    protected void btCloseButtonClick(){
        Stage stage = (Stage)btClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button btCancel;

    @FXML
    private Button btGravar;

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

    @FXML
    private Tab tabPecas;

    @FXML
    private TableView tvPecas;

    @FXML
    private TextField txfReferenciaPecas;

    @FXML
    private TextField txfQuantidadePecas;

    @FXML
    private TableColumn tcReferenciaPecas;

    @FXML
    private TableColumn tcDescricaoPecas;

    @FXML
    private TableColumn tcValorPecas;

    @FXML
    private TableColumn tcQuantPecas;

    @FXML
    private TableColumn tcDescontoPecas;

    @FXML
    private TableColumn tcValorTotalPecas;

    @FXML
    private TableColumn tcExcluirPecas;

    @FXML
    private TableColumn tcUnidade;

    @FXML
    private TableColumn tcLiquido;



    @FXML
    private Tab tbMaoObra;

    @FXML
    private TextField txfRefernciaMaoObra;

    @FXML
    private TextField txfQuantidadeMaoObra;

    @FXML
    private TextField txfValorMaoObra;

    @FXML
    private TableView tvServicos;

    @FXML
    private TableColumn tcReferenciaMaoObra;

    @FXML
    private TableColumn tcDescricaoMaoObra;

    @FXML
    private TableColumn tcValorMaoObra;

    @FXML
    private TableColumn tcQuantMaoObra;

    @FXML
    private TableColumn tcDescontoMaoObra;

    @FXML
    private TableColumn tcValorTotalMaoObra;

    @FXML
    private TableColumn tcExcluirMaoObra;

    @FXML
    private TableColumn tcTecnico;

    @FXML
    private Label lblValorTotal;




    @FXML
    private Tab tabFinanceiro;

    @FXML
    private TableView tvFinanceiro;

    @FXML
    private ComboBox cbTipoParcelamento;

    @FXML
    private ComboBox cbParcelas;

    @FXML
    private TableColumn tcParcela;

    @FXML
    private TableColumn tcTipo;

    @FXML
    private TableColumn tcDataEmissao;

    @FXML
    private TableColumn tcDataVencimento;

    @FXML
    private TableColumn tcDataPagamento;

    @FXML
    private TableColumn tcSituacaoBancaria;

    @FXML
    private TableColumn tcStatus;

    @FXML
    private TableColumn tcBaixar;

    @FXML
    private TableColumn tcCancelar;









}
