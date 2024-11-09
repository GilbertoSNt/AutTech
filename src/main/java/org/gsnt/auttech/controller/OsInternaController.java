package org.gsnt.auttech.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class OsInternaController implements Initializable {

    @FXML
    protected Label lblCli;

    @FXML
    protected Label lblPlaca;

    @FXML
    protected Label lblModelo;

    @FXML
    protected TextField txtCodigoPeca;

    @FXML
    protected TextField txtQuantidadePecas;

    @FXML
    protected Button btGravarPecas;

    @FXML
    protected Button btExcluirPecas;

    @FXML
    protected TextField txtCodigoServico;

    @FXML
    protected TextField txtQuantidadeServico;

    @FXML
    protected Button btGravarServico;

    @FXML
    protected Button btExcluirServico;

    @FXML
    protected TableView tvPecas;

    @FXML
    protected TableView tvServicos;

    @FXML
    protected TableColumn tcCodigoPecas;

    @FXML
    protected Label lblTotalPecas;

    @FXML
    protected Label lblTotalServico;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
