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
import org.gsnt.auttech.util.DadosCombos2;

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

    private DadosCombos2 dadosCombos = new DadosCombos2();

    private ObservableList<MarcaVeiculo> obsListTipoMArca;


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
    protected ComboBox cbMarca;

    @FXML
    private void hiddencbMarca(){
        cbModelo.show();
    }

    @FXML
    protected ComboBox cbModelo;

    @FXML
    private void hiddencbModelo(){
        txtChassi.requestFocus();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
}
