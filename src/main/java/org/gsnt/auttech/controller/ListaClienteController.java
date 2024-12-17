package org.gsnt.auttech.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.gsnt.auttech.model.entities.Cliente;
import java.net.URL;
import java.util.ResourceBundle;

public class ListaClienteController implements Initializable {

    @FXML
    protected TextField textFieldText;

    @FXML
    protected Button buttonPesquisa;

    @FXML
    protected RadioButton rbNome;

    @FXML
    protected RadioButton rbParteNome;

    @FXML
    protected RadioButton rbCPF;

    @FXML
    protected RadioButton rbCNPJ;

    @FXML
    protected TableView<Cliente> tableViewListClient;

    @FXML
    protected TableColumn<Cliente, Integer> tcCodigo;

    @FXML
    protected TableColumn<Cliente, String> tcNome;

    @FXML
    protected TableColumn<Cliente, String> tcApelido;

    @FXML
    protected TableColumn<Cliente, Cliente> tcBtEditar;

    @FXML
    protected TableColumn<Cliente, Cliente> tcBtExcluir;

    @FXML
    protected TableColumn<Cliente, Cliente> tcBtAcessar;

    @FXML
    protected Button buttonNovo;

    @FXML
    protected Button buttonFecha;

    @FXML
    protected Button buttonFecha1;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ToggleGroup radioGroup = new ToggleGroup();
        rbNome.setToggleGroup(radioGroup);
        rbParteNome.setToggleGroup(radioGroup);
        rbCNPJ.setToggleGroup(radioGroup);
        rbCPF.setToggleGroup(radioGroup);


    }
}
