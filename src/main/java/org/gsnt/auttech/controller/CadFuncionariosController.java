package org.gsnt.auttech.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class CadFuncionariosController implements Initializable {


    @FXML
    protected Button btClose;

    @FXML
    protected void onBtClose(){
        Stage stage = (Stage)btClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected Button btGravar;

    @FXML
    protected Button btEditar;

    @FXML
    protected Button btDesativar;

    @FXML
    protected Button btCancelar;

    @FXML
    protected TextField txtNome;

    @FXML
    protected TextField txtCpf;

    @FXML
    protected TextField txtRg;

    @FXML
    protected DatePicker dpDataNasc;

    @FXML
    protected ComboBox cbTipoEndereco;

    @FXML
    protected TextField txtEnd;

    @FXML
    protected TextField txtNum;

    @FXML
    protected TextField txtComplemento;

    @FXML
    protected TextField txtBairro;

    @FXML
    protected TextField txtCidade;

    @FXML
    protected ComboBox cbEstado;

    @FXML
    protected TextField txtCep;

    @FXML
    protected TextArea txaObs;

    @FXML
    protected DatePicker dpAdmissao;

    @FXML
    protected DatePicker dpDesligamento;

    @FXML
    protected TextField txtNumCartProf;

    @FXML
    protected TextField txtDataEmis;

    @FXML
    protected TextField txtFuncao;

    @FXML
    protected TextField txtCargo;

    @FXML
    protected TextArea txaObsProf;

    @FXML
    protected CheckBox cbCaixaMec;

    @FXML
    protected CheckBox cbCaixaAut;

    @FXML
    protected CheckBox cbEletrica;

    @FXML
    protected CheckBox cbFreio;

    @FXML
    protected CheckBox cbInjDiesel;

    @FXML
    protected CheckBox cbInjFlex;

    @FXML
    protected CheckBox cbMotorDiesel;

    @FXML
    protected CheckBox cbMotorFlex;

    @FXML
    protected CheckBox cbPneu;

    @FXML
    protected CheckBox cbSuspensao;

    @FXML
    protected CheckBox cbSocorro;

    @FXML
    protected CheckBox cbVeicEletrico;

    @FXML
    protected CheckBox cbMotoristaLeva;

    @FXML
    protected CheckBox cbMotoristaGuincho;

    @FXML
    protected RadioButton rbAdm;

    @FXML
    protected RadioButton rbProd;

    @FXML
    protected RadioButton rbAdmAux;

    @FXML
    protected RadioButton rbProdAux;

    @FXML
    protected RadioButton rbApre;

    @FXML
    protected Label labelAlertaCPF;

    @FXML
    protected TextField txtTelefone;

    @FXML
    protected TextField txtMae;

    @FXML
    protected TextField txtPai;

    @FXML
    protected TextField txtEsposa;

    @FXML
    protected TextField txtQuantFilho;

    @FXML
    protected TextField txtTelefoneConjuge;

    @FXML
    protected RadioButton rbMasculino;

    @FXML
    protected RadioButton rbFeminino;

    @FXML
    protected CheckBox cbComissao;

    @FXML
    protected TextField txtComissaoPecas;

    @FXML
    protected TextField txtComissaoServico;

    @FXML
    protected TextField txtSalario;

    protected void radio(){
        ToggleGroup radioGroup = new ToggleGroup();
        rbAdm.setToggleGroup(radioGroup);
        rbProd.setToggleGroup(radioGroup);
        rbProdAux.setToggleGroup(radioGroup);
        rbAdmAux.setToggleGroup(radioGroup);
        rbApre.setToggleGroup(radioGroup);

        ToggleGroup radioGroup2 = new ToggleGroup();
        rbFeminino.setToggleGroup(radioGroup2);
        rbMasculino.setToggleGroup(radioGroup2);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelAlertaCPF.setVisible(false);
        radio();
    }
}
