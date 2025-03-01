package org.gsnt.auttech.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.gsnt.auttech.model.entities.Estados;
import org.gsnt.auttech.model.entities.PerfilFiscal;
import org.gsnt.auttech.model.entities.TipoEndereco;
import org.gsnt.auttech.model.entities.TipoTelefone;
import org.gsnt.auttech.util.DadosCombos;
import org.gsnt.auttech.util.MaskValid;

import java.net.URL;
import java.util.ResourceBundle;

public class CadClienteJController implements Initializable {

    private ObservableList<TipoTelefone> obsListTipoTelefone;
    private ObservableList<TipoEndereco> obsListTipoEndereco;
    private ObservableList<Estados> obsListEstados;
    private ObservableList<PerfilFiscal> obsListPerfilFiscal;
    private MaskValid maskValid = new MaskValid();

    protected DadosCombos dadosCombos = new DadosCombos();

    @FXML
    private DatePicker dpDataNasc;

    @FXML
    private TextArea txtObs;

    @FXML
    private ComboBox cbTipoEndereco;

    @FXML
    private ComboBox cbTipoTelefone;

    @FXML
    private void oncbTipoTelefone(){

        txtNumTelefone.clear();
        int opcao = 0;
        String opcao2 = "";
        opcao2 = cbTipoTelefone.getValue().toString();
        if (opcao2.equals("3") || opcao2.equals("5") || opcao2.equals("7") || opcao2.equals("8")){
            txtNumTelefone.setPromptText("(__)_____-____");
            maskValid.maskTel9Dig(txtNumTelefone);
        }else{
            txtNumTelefone.setPromptText("(__)____-____");
            maskValid.maskTel8Dig(txtNumTelefone);
        }

    }


    @FXML
    private ComboBox cbEstado;

    @FXML
    private ComboBox cbPerfilFiscal;

    @FXML
    private CheckBox cbAtivo;

    @FXML
    private TextField txtRazao;

    @FXML
    private TextField txtApelido;

    @FXML
    private TextField txtCNPJ;

    @FXML
    private TextField txtInsc;

    @FXML
    private TextField txtEnd;

    @FXML
    private TextField txtNum;

    @FXML
    private TextField txtBairro;

    @FXML
    private TextField txtCidade;

    @FXML
    private TextField txtComp;

    @FXML
    private TextField txtCep;

    @FXML
    private TextField txtNumTelefone;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextArea txaObs;

    @FXML
    private Button btGravar;

    @FXML
    private Button btEditar;

    @FXML
    private Button btExcluir;

    @FXML
    private Button btCancelar;

    @FXML
    private Button btClose;


    @FXML
    private Button btMaisTel;

    @FXML
    private Button btMaisEmail;

    @FXML
    private TableView tvTelefone;

    @FXML
    private TableColumn tcTipoTel;

    @FXML
    private TableColumn tcNumTel;

    @FXML
    private TableColumn tcMenosTel;

    @FXML
    private TableView tvEmail;

    @FXML
    private TableColumn tcTipoEmail;

    @FXML
    private TableColumn tcEmail;

    @FXML
    private TableColumn tcMenosEmail;

    @FXML
    private Button btCadCarros;

    @FXML
    private TableView tvVeiculos;

    @FXML
    private TableColumn tcPlaca;

    @FXML
    private TableColumn tcModelo;

    @FXML
    private TableColumn tcAbrirOs;

    @FXML
    private TableColumn tcCriarOrc;

    @FXML
    private TableColumn tcHistorico;

    @FXML
    private TableColumn tcDesvincula;

    @FXML
    private Accordion accDados;

    @FXML
    private TitledPane tpDadosBasicos;

    @FXML
    protected void btCloseButtonClick(){
        Stage stage = (Stage)btClose.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //dados do combo tipo endereço
        obsListTipoEndereco = FXCollections.observableList(dadosCombos.tipoEndereco());
        cbTipoEndereco.setItems(obsListTipoEndereco);
        Callback<ListView<TipoEndereco>, ListCell<TipoEndereco>> factory = lv -> new ListCell<TipoEndereco>(){
            @Override
            protected void updateItem(TipoEndereco tipo, boolean empty){
                super.updateItem(tipo,empty);
                setText(empty ?"":tipo.getTipo());
            }
        };
        cbTipoEndereco.setCellFactory(factory);
        cbTipoEndereco.setButtonCell(factory.call(null));

        //dados do combo perfil fiscal

        obsListPerfilFiscal = FXCollections.observableList(dadosCombos.perfilFiscal());
        cbPerfilFiscal.setItems(obsListPerfilFiscal);
        Callback<ListView<PerfilFiscal>, ListCell<PerfilFiscal>> factoryFiscal = lv -> new ListCell<PerfilFiscal>(){
            @Override
            protected void updateItem(PerfilFiscal tipo1, boolean empty){
                super.updateItem(tipo1,empty);
                setText(empty ?"":tipo1.getTipo());
            }
        };
        cbPerfilFiscal.setCellFactory(factoryFiscal);
        cbPerfilFiscal.setButtonCell(factoryFiscal.call(null));

        //dados do combo tipo telefone
        obsListTipoTelefone = FXCollections.observableList(dadosCombos.tipoTelefoneJ());
        cbTipoTelefone.setItems(obsListTipoTelefone);

        Callback<ListView<TipoTelefone>, ListCell<TipoTelefone>> factoryTelefone = lv -> new ListCell<TipoTelefone>(){
            @Override
            protected void updateItem(TipoTelefone tipoTelefone, boolean empty){
                super.updateItem(tipoTelefone,empty);
                setText(empty ?"":tipoTelefone.getTipotelefone());
            }
        };

        cbTipoTelefone.setCellFactory(factoryTelefone);
        cbTipoTelefone.setButtonCell(factoryTelefone.call(null));

        //dados do combo estado
        obsListEstados = FXCollections.observableList(dadosCombos.dadoEstados());
        cbEstado.setItems(obsListEstados);

        Callback<ListView<Estados>, ListCell<Estados>> factoryEstados = lv -> new ListCell<Estados>(){
            @Override
            protected void updateItem(Estados estado, boolean empty){
                super.updateItem(estado,empty);
                setText(empty ?"":estado.getSigla());
            }
        };

        txtRazao.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtApelido.requestFocus();
            }
        });

        txtApelido.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                cbPerfilFiscal.requestFocus();
            } else if (KeyEvent.getCode() == KeyCode.ESCAPE) {
                txtRazao.requestFocus();
            }
        });

        cbPerfilFiscal.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtCNPJ.requestFocus();
            } else if (KeyEvent.getCode() == KeyCode.ESCAPE) {
                cbPerfilFiscal.requestFocus();
            }
        });
    //acertar função
        txtCNPJ.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtInsc.requestFocus();
            } else if (KeyEvent.getCode() == KeyCode.ESCAPE) {
                cbPerfilFiscal.requestFocus();
            }
        });

        txtInsc.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                dpDataNasc.requestFocus();
            } else if (KeyEvent.getCode() == KeyCode.ESCAPE) {
                txtCNPJ.requestFocus();
            }
        });

        dpDataNasc.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                cbTipoEndereco.requestFocus();
            } else if (KeyEvent.getCode() == KeyCode.ESCAPE) {
                txtInsc.requestFocus();
            }
        });

        cbTipoEndereco.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtEnd.requestFocus();
            } else if (KeyEvent.getCode() == KeyCode.ESCAPE) {
                dpDataNasc.requestFocus();
            }
        });

        txtEnd.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtNum.requestFocus();
            } else if (KeyEvent.getCode() == KeyCode.ESCAPE) {
                cbTipoEndereco.requestFocus();
            }
        });

        txtNum.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtBairro.requestFocus();
            } else if (KeyEvent.getCode() == KeyCode.ESCAPE) {
                txtEnd.requestFocus();
            }
        });

        txtBairro.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtCidade.requestFocus();
            } else if (KeyEvent.getCode() == KeyCode.ESCAPE) {
                txtNum.requestFocus();
            }
        });

        txtCidade.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                cbEstado.requestFocus();
            } else if (KeyEvent.getCode() == KeyCode.ESCAPE) {
                txtBairro.requestFocus();
            }
        });

        cbEstado.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtComp.requestFocus();
            } else if (KeyEvent.getCode() == KeyCode.ESCAPE) {
                txtCidade.requestFocus();
            }
        });

        txtCep.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txaObs.requestFocus();
            } else if (KeyEvent.getCode() == KeyCode.ESCAPE) {
                txtComp.requestFocus();
            }
        });

        cbEstado.setCellFactory(factoryEstados);
        cbEstado.setButtonCell(factoryEstados.call(null));

        txtCNPJ.setPromptText("__.___.___/____-__");
        maskValid.maskCNPJ(txtCNPJ);

        txtCep.setPromptText("__.___-___");
        maskValid.maskkCEP(txtCep);

        dpDataNasc.setPromptText("__/__/____");
        maskValid.maskData(dpDataNasc);

        accDados.setExpandedPane(tpDadosBasicos);

        txtRazao.requestFocus();
    }
}
