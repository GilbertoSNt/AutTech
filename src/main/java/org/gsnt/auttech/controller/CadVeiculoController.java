package org.gsnt.auttech.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.gsnt.auttech.model.entities.MarcaVeiculo;
import org.gsnt.auttech.model.entities.ModeloVeiculo;
import org.gsnt.auttech.util.DadosCombos;

import java.net.URL;
import java.util.ResourceBundle;

public class CadVeiculoController implements Initializable {

    private int cad = 0;

    private String nome = "";

    public CadVeiculoController(){}

    public CadVeiculoController(int cad, String nome){

        this.cad = cad;
        this.nome = nome;

    }

    private DadosCombos dadosCombos = new DadosCombos();

    private ObservableList<MarcaVeiculo> obsListTipoMArca;

    private ObservableList<ModeloVeiculo> obsListModeloVeiculo;


    @FXML
    protected Button btClose;

    @FXML
    protected void btCloseButtonClick(){
        Stage stage = (Stage)btClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected Button btImportar;

    @FXML
    protected Button btProcurar;

    @FXML
    protected TextField txtPlaca;

    @FXML
    protected ComboBox<MarcaVeiculo> cbMarca;

    @FXML
    private void hiddencbMarca(){

        MarcaVeiculo marca = cbMarca.getSelectionModel().getSelectedItem();
        carregarComboModelo(marca.getCod());
        cbModelo.show();

    }


    //Carrega ComboBox Marca
    private void carregarComboMarca( ){

        obsListTipoMArca = FXCollections.observableList(dadosCombos.marcaVeiculo());
        cbMarca.setItems(obsListTipoMArca);
        Callback<ListView<MarcaVeiculo>, ListCell<MarcaVeiculo>> factory = lv -> new ListCell<MarcaVeiculo>() {
            @Override
            protected void updateItem(MarcaVeiculo marca, boolean empty) {
                super.updateItem(marca, empty);
                setText(empty ? "" : marca.getMarcaVeiculo());
            }
        };
        cbMarca.setCellFactory(factory);
        cbMarca.setButtonCell(factory.call(null));

    }

    @FXML
    protected ComboBox<ModeloVeiculo> cbModelo;

    @FXML
    private void hiddencbModelo(){
        txtChassi.requestFocus();
    }

    //Carrega ComboBox Modelos
    private void carregarComboModelo(int id){

        obsListModeloVeiculo = FXCollections.observableList(dadosCombos.modeloVeiculo(id));
        cbModelo.setItems(obsListModeloVeiculo);
        Callback<ListView<ModeloVeiculo>, ListCell<ModeloVeiculo>> factory = lv -> new ListCell<ModeloVeiculo>() {
           @Override
           protected void updateItem(ModeloVeiculo modelo, boolean empty){
               super.updateItem(modelo, empty);
               setText(empty ? "" : modelo.getModelo());
           }
        };
        cbModelo.setCellFactory(factory);
        cbModelo.setButtonCell(factory.call(null));

    }

    @FXML
    protected TextField txtChassi;

    @FXML
    protected TextField txtMotor;

    @FXML
    protected CheckBox ckTurbo;

    @FXML
    protected CheckBox ckLinha;

    @FXML
    protected CheckBox ckV;

    @FXML
    protected TextField txtAno;

    @FXML
    protected TextField txtAnoMod;

    @FXML
    protected TextField txtRenavan;

    @FXML
    protected TextField txtCv;

    @FXML
    protected TextField txtCodCli;

    @FXML
    protected TextField txtNomeCli;

    @FXML
    protected CheckBox ckArC;

    @FXML
    protected CheckBox ckArQ;

    @FXML
    protected CheckBox ckDirE;

    @FXML
    protected CheckBox ckDirH;

    @FXML
    protected CheckBox ckVidro;

    @FXML
    protected CheckBox ckTrava;

    @FXML
    protected CheckBox ckAlarme;

    @FXML
    protected CheckBox ckTeto;

    @FXML
    protected CheckBox ckABS;

    @FXML
    protected CheckBox ckAirBag;

    @FXML
    protected CheckBox ckTracao;

    @FXML
    protected Button btGravar;

    @FXML
    protected Button btAlterar;

    @FXML
    protected Button btDesativar;

    @FXML
    protected Button btHistorico;

    @FXML
    protected Button btCancelar;

    private void controlTab(){
        if(this.cad != 0){
            txtCodCli.setText(""+this.cad);
            txtNomeCli.setText(this.nome);
        }
        btImportar.setDisable(true);

        txtPlaca.setPromptText("___-____");

        txtPlaca.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                cbMarca.show();
            }
        });

        cbMarca.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ESCAPE){
                txtPlaca.requestFocus();
            }
        });

        cbModelo.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ESCAPE){
                cbMarca.show();
            }
        });

        txtChassi.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtMotor.requestFocus();
            } else if (KeyEvent.getCode() == KeyCode.ESCAPE) {
                cbModelo.show();
            }
        });

        txtMotor.setOnKeyPressed((KeyEvent)->{
            if(KeyEvent.getCode() == KeyCode.ENTER){
                txtCv.requestFocus();
            } else if (KeyEvent.getCode() == KeyCode.ESCAPE) {
                txtChassi.requestFocus();
            }
        });

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        carregarComboMarca();
        controlTab();


    }
}
