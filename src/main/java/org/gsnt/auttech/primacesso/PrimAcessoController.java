package org.gsnt.auttech.primacesso;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.gsnt.auttech.entitiesgenerics.Empresa;

import java.net.URL;
import java.util.ResourceBundle;

public class PrimAcessoController implements Initializable {

    @FXML
    private RadioButton rbJuridico;

    @FXML
    private RadioButton rbFisico;

    @FXML
    private TextField txtCnpj;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtUser;

    @FXML
    private TextField txtSenha;

    @FXML
    private TextField txtConfirmarSenha;

    @FXML
    private ComboBox<Empresa> cbUnidade;

    @FXML
    private RadioButton rbDono;

    @FXML
    private RadioButton rbGerente;

    @FXML
    private Button btGravar;

    @FXML
    private Button btCancelar;

    private ToggleGroup rd1 = new ToggleGroup();

    private ToggleGroup rd2 = new ToggleGroup();

    private void salva(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        grupos();
    }

    private void grupos(){
        rbDono.setToggleGroup(rd1);
        rbGerente.setToggleGroup(rd1);

        rbFisico.setToggleGroup(rd2);
        rbJuridico.setToggleGroup(rd2);
    }
}
