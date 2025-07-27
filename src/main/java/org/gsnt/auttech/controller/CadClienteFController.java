package org.gsnt.auttech.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import org.gsnt.auttech.TelaPrincipal;
import org.gsnt.auttech.model.entities.entitiesgenerics.*;
import org.gsnt.auttech.util.DadosCombos;
import org.gsnt.auttech.util.MaskValid;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CadClienteFController implements Initializable {

    private ObservableList<TipoTelefone> obsListTipoTelefone;
    private ObservableList<TipoEndereco> obsListTipoEndereco;
    private ObservableList<Estados> obsListEstados;
    private ObservableList<TiposEmail> obsListEmail;
    private ObservableList<PerfilFiscal> obsListPerfilFiscal;

    protected MaskValid maskValid = new MaskValid();
    protected DadosCombos dadosCombos = new DadosCombos();

    private int v = 0;

    @FXML
    private TitledPane tpDadosBasicos;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtApelido;

    @FXML
    protected DatePicker dpDataNasc;

    @FXML
    private void hiddendpDataNasc(){
        cbTipoEndereco.show();
    }

    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtRg;

    @FXML
    private ComboBox cbTipoEndereco;

    @FXML
    private void hiddencbTipoEndereco(){
        txtEnd.requestFocus();
    }

    @FXML
    private ComboBox cbTipoTelefone;

    @FXML
    private void hiddencbTipoTelefone(){
        txtNumTelefone.requestFocus();
    }

    @FXML
    private void oncbTipoTelefone(){

        txtNumTelefone.clear();
        int opcao = 0;
        String opcao2 = "";
        opcao2 = cbTipoTelefone.getValue().toString();
        if (opcao2.equals("1") || opcao2.equals("3") || opcao2.equals("5") || opcao2.equals("6") || opcao2.equals("7")){
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
    private void hiddencbEstado(){
        txtComplemento.requestFocus();
    }

    @FXML
    private ComboBox cbTipoEmail;

    @FXML
    private void hiddencbEmail(){
        txtEmail.requestFocus();
    }

    @FXML
    private ComboBox cbPerfilFiscal;

    @FXML
    private void hiddencbPerfilFiscal(){
        txtCpf.requestFocus();
    }

    @FXML
    private TextField txtEnd;

    @FXML
    private TextField txtNum;

    @FXML
    private TextField txtBairro;

    @FXML
    private TextField txtCidade;

    @FXML
    private TextField txtComplemento;

    @FXML
    private TextField txtCep;

    @FXML
    private TextField txtNumTelefone;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextArea txaObs;

    @FXML
    private AnchorPane apDados;

    @FXML
    private TableView tvTelefone;

    @FXML
    private TableView tvEmail;

    @FXML
    private TableView tvLogs;

    @FXML
    private TextField txtUser;

    @FXML
    private TextField txtSenha;

    @FXML
    private Button btMaisEmail;

    @FXML
    private Button btMaisTelefone;

    @FXML
    private Button btCadVeiculo;

    @FXML
    private void onbtCadVeiculo(){
        loadView("/org/gsnt/auttech/CadVeiculo.fxml");
        Stage stage = (Stage)btCadVeiculo.getScene().getWindow();
    }

    @FXML
    private Button btClose;

    @FXML
    private Button btGravar;

    @FXML
    private Button btEditar;

    @FXML
    private Button btDesativar;

    @FXML
    private Button btCancelar;

    @FXML
    protected void btCancelarOnButtonClick(){
        Stage stage = (Stage)btClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button btGravaUser;

    @FXML
    protected void btCloseButtonClick(){
        Stage stage = (Stage)btClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    private CheckBox cbAtivo;

    @FXML
    private TableColumn tcLogData;

    @FXML
    private TableColumn tcLogHora;

    @FXML
    private TableColumn tcLogPlaca;

    @FXML
    private TableColumn tcLogAcao;

    @FXML
    private TableColumn tvVcPlaca;

    @FXML
    private TableColumn tvVcModelo;

    @FXML
    private TableColumn tvVcBtAbrirOs;

    @FXML
    private TableColumn tvVcBtCriarOrc;

    @FXML
    private TableColumn tvVcBtHistorico;

    @FXML
    private TableColumn tvVcBtDesvincular;

    @FXML
    private TableColumn tvTelefTipo;

    @FXML
    private TableColumn tvTelefnumero;

    @FXML
    private TableColumn tvTelefBtExcluir;

    @FXML
    private TableColumn tvEmailTipo;

    @FXML
    private TableColumn tvEmailEmail;

    @FXML
    private TableColumn tvEmailBtExcluir;

    @FXML
    private Accordion accDados;

    @FXML
    private Label labelAlertaCPF;

    private void botoesAtivos(Boolean a){

        if (a){
            btDesativar.setDisable(a);
            btEditar.setDisable(a);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //dados do combo tipo endereço
        obsListTipoEndereco = FXCollections.observableList(dadosCombos.tipoEndereco());
        cbTipoEndereco.setItems(obsListTipoEndereco);
        Callback<ListView<TipoEndereco>, ListCell<TipoEndereco>> factory = lv -> new ListCell<TipoEndereco>() {
            @Override
            protected void updateItem(TipoEndereco tipo, boolean empty) {
                super.updateItem(tipo, empty);
                setText(empty ? "" : tipo.getTipo());
            }
        };
        cbTipoEndereco.setCellFactory(factory);
        cbTipoEndereco.setButtonCell(factory.call(null));

        obsListPerfilFiscal = FXCollections.observableList(dadosCombos.perfilFiscal());
        cbPerfilFiscal.setItems(obsListPerfilFiscal);
        Callback<ListView<PerfilFiscal>, ListCell<PerfilFiscal>> factoryFiscal = lv -> new ListCell<PerfilFiscal>() {
            @Override
            protected void updateItem(PerfilFiscal tipo1, boolean empty) {
                super.updateItem(tipo1, empty);
                setText(empty ? "" : tipo1.getTipo());
            }
        };
        cbPerfilFiscal.setCellFactory(factoryFiscal);
        cbPerfilFiscal.setButtonCell(factoryFiscal.call(null));

        //dados do combo tipo telefone
        obsListTipoTelefone = FXCollections.observableList(dadosCombos.tipoTelefone());
        cbTipoTelefone.setItems(obsListTipoTelefone);
        Callback<ListView<TipoTelefone>, ListCell<TipoTelefone>> factoryTelefone = lv -> new ListCell<TipoTelefone>() {
            @Override
            protected void updateItem(TipoTelefone tipoTelefone, boolean empty) {
                super.updateItem(tipoTelefone, empty);
                setText(empty ? "" : tipoTelefone.getTipotelefone());
            }
        };
        cbTipoTelefone.setCellFactory(factoryTelefone);
        cbTipoTelefone.setButtonCell(factoryTelefone.call(null));

        //dados do combo estado
        obsListEstados = FXCollections.observableList(dadosCombos.dadoEstados());
        cbEstado.setItems(obsListEstados);
        Callback<ListView<Estados>, ListCell<Estados>> factoryEstados = lv -> new ListCell<Estados>() {
            @Override
            protected void updateItem(Estados estado, boolean empty) {
                super.updateItem(estado, empty);
                setText(empty ? "" : estado.getSigla());
            }
        };
        cbEstado.setCellFactory(factoryEstados);
        cbEstado.setButtonCell(factoryEstados.call(null));

        //dados do combo tipo endereço de e-mail
        obsListEmail = FXCollections.observableList(dadosCombos.tipoEmail());
        cbTipoEmail.setItems(obsListEmail);
        Callback<ListView<TiposEmail>, ListCell<TiposEmail>> factoryEmail = lv -> new ListCell<TiposEmail>() {
            @Override
            protected void updateItem(TiposEmail tipoEm, boolean empty) {
                super.updateItem(tipoEm, empty);
                setText(empty ? "" : tipoEm.getEmail());
            }
        };
        cbTipoEmail.setCellFactory(factoryEmail);
        cbTipoEmail.setButtonCell(factoryEmail.call(null));

        //Mascaras
        maskValid.maskData(dpDataNasc);
        dpDataNasc.setPromptText("__/__/____");

        maskValid.maskkCEP(txtCep);
        txtCep.setPromptText("__.___-___");

        maskValid.maskCPF(txtCpf);
        txtCpf.setPromptText("___.___.___-__");

        txtNome.setOnKeyPressed((KeyEvent)->{
           if(KeyEvent.getCode() == KeyCode.ENTER){
               txtApelido.requestFocus();
           }
        });

        txtApelido.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                cbPerfilFiscal.show();
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                txtNome.requestFocus();
            }
        });

        cbPerfilFiscal.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ESCAPE){
                txtApelido.requestFocus();
            }
        });

        txtCpf.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER && maskValid.isCPF(txtCpf.getText())){
                if (maskValid.isCPF(txtCpf.getText())){
                    txtRg.requestFocus();
                    labelAlertaCPF.setVisible(false);
                }else{
                    labelAlertaCPF.setVisible(true);
                }
            }else if(KeyEvent.getCode() == KeyCode.ESCAPE){
                cbPerfilFiscal.show();
            } else if (KeyEvent.getCode() == KeyCode.ENTER && maskValid.isCPF(txtCpf.getText())!=true) {
                labelAlertaCPF.setVisible(true);
            }
        });

        txtRg.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                dpDataNasc.requestFocus();
            } else if (KeyEvent.getCode() == KeyCode.ESCAPE) {
                txtCpf.requestFocus();
            }
        });

        dpDataNasc.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                cbTipoEndereco.show();
            }else if (KeyEvent.getCode() == KeyCode.ESCAPE) {
                txtRg.requestFocus();
            }
        });

        cbTipoEndereco.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ESCAPE){
                dpDataNasc.show();
            }
        });

        txtEnd.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtNum.requestFocus();
            } else if (KeyEvent.getCode() == KeyCode.ESCAPE) {
                cbTipoEndereco.show();
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
                cbEstado.show();
            } else if (KeyEvent.getCode() == KeyCode.ESCAPE) {
                txtBairro.requestFocus();
            }
        });

        cbEstado.setOnKeyPressed((KeyEvent)->{
            if (KeyEvent.getCode() == KeyCode.ESCAPE) {
                txtCidade.requestFocus();
            }
        });

        txtComplemento.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtCep.requestFocus();
            } else if (KeyEvent.getCode() == KeyCode.ESCAPE) {
                cbEstado.show();
            }
        });

        txtCep.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txaObs.requestFocus();
            } else if (KeyEvent.getCode() == KeyCode.ESCAPE) {
                txtComplemento.requestFocus();
            }
        });

        labelAlertaCPF.setVisible(false);
        accDados.setExpandedPane(tpDadosBasicos);

        txtNome.requestFocus();

    }

    private void loadView(String absoluteName) {
        try {
            FXMLLoader loader = new FXMLLoader(TelaPrincipal.class.getResource(absoluteName));
            Scene secundaryScene = new Scene(loader.load());
            Stage stage1 = new Stage();
            stage1.setIconified(false);
            stage1.setResizable(false);
            stage1.setTitle("");
            stage1.initStyle(StageStyle.UNDECORATED);
            stage1.initModality(Modality.APPLICATION_MODAL);
            stage1.initOwner(TelaPrincipal.getMainScene().getWindow());
            stage1.setScene(secundaryScene);
            stage1.showAndWait();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
