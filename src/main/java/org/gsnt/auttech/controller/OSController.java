package org.gsnt.auttech.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class OSController {

    @FXML
    private Button btClose;

    protected void btCloseButtonClick(){
        Stage stage = (Stage)btClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button btFechar;

    protected void btFecharButtonClick(){
        Stage stage = (Stage)btFechar.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button btVeiculo;

    @FXML
    private Label lblNomeCliente;

    @FXML
    private Button btCliente;

    @FXML
    private Button btGravar;

    @FXML
    private Button btCancel;

    @FXML
    private Button btFinalizar;

    @FXML
    private Label lblVeiculo;

    @FXML
    private Tab tabCambio;

    @FXML
    private TextField txfReferenciaPecas;

    @FXML
    private TextField txfDescricaoPecas;

    @FXML
    private TextField txfQuantidadePecas;

    @FXML
    private TextField txtPrecoPecas;

    @FXML
    private ComboBox cbTipoServicos;

    @FXML
    private TextField txfQuantidadeServicos;

    @FXML
    private TextField txfValorServicos;

    @FXML
    private TextField txfDescricaoServicos;



    //
    //TableView Peças
    //
    @FXML
    private TableView tvPecas;

    @FXML
    private TableColumn tcReferenciaPecas;

    @FXML
    private TableColumn tcDescricaoPecas;

    @FXML
    private TableColumn tcQuantPecas;

    @FXML
    private TableColumn tcUnidade;

    @FXML
    private TableColumn tcValorPecas;

    @FXML
    private TableColumn tcDescontoPecas;

    @FXML
    private TableColumn tcLiquido;

    @FXML
    private TableColumn tcValorTotalPecas;

    @FXML
    private TableColumn tcExcluirPecas;

    @FXML
    private Label lbltotalPecas;

    //
    //TableView Serviços
    //
    @FXML
    private TableView tvServicos;

    @FXML
    private TableColumn tcReferenciaMaoObra;

    @FXML
    private TableColumn tcDescricaoMaoObra;

    @FXML
    private TableColumn tcQuantMaoObra;

    @FXML
    private TableColumn tcValorMaoObra;

    @FXML
    private TableColumn tcDescontoMaoObra;

    @FXML
    private TableColumn tcValorTotalMaoObra;

    @FXML
    private TableColumn tcTecnico;

    @FXML
    private TableColumn tcExcluirMaoObra;

    @FXML
    private Label lblTotalServicos;

    //
    //tvFinanceiro
    //
    @FXML
    private TableView tvFinanceiro;

    @FXML
    private TableColumn tcParcela;

    @FXML
    private TableColumn tcTipo;

    @FXML
    private TableColumn tcSituacaoBancaria;

    @FXML
    private TableColumn tcDataEmissao;

    @FXML
    private TableColumn tcDataVencimento;

    @FXML
    private TableColumn tcDataPagamento;

    @FXML
    private TableColumn tcStatus;

    @FXML
    private TableColumn tcBaixar;

    @FXML
    private TableColumn tcCancelar;

    @FXML
    private TableColumn tcValor;

    @FXML
    private Label lblTotal2;

    @FXML
    private ComboBox cbTipoParcelamento;

    @FXML
    private ComboBox cbParcelas;

    @FXML
    private TextArea txaDescricao;

    @FXML
    private TextArea txaObservacoes;

}
