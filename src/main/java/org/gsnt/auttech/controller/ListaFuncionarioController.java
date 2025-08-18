package org.gsnt.auttech.controller;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.gsnt.auttech.model.entities.Funcionario;
import org.gsnt.auttech.util.Botoes;
import org.gsnt.auttech.util.MaskValid;

import java.net.URL;
import java.util.ResourceBundle;

public class ListaFuncionarioController implements Initializable {


    @FXML
    private Button btClose;

    @FXML
    private void onCloseButtonClick(){
        Stage stage = (Stage)btClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    private TextField txtDado;

    @FXML
    private Button btPesquisa;


    protected RadioButton rbNome;

    @FXML
    protected RadioButton rbParteNome;

    @FXML
    protected RadioButton rbCPF;

    @FXML
    protected RadioButton rbCNPJ;

    @FXML
    protected TableView<Funcionario> tableViewListFuncionario;

    @FXML
    public TableColumn<Funcionario, Integer> tcCodigo;

    @FXML
    public TableColumn<Funcionario, String> tcNome;

    @FXML
    public TableColumn<Funcionario, String > tcTipo;

    @FXML
    protected TableColumn<Funcionario, Funcionario> tcBtEditar;

    @FXML
    protected TableColumn<Funcionario, Funcionario> tcBtExcluir;

    @FXML
    protected TableColumn<Funcionario, Funcionario> tcBtAcessar;

    @FXML
    protected Button buttonNovo;

    @FXML
    protected Button btSelecionar;

    @FXML
    private void onBtSelecionar(){

        // falta seleção aqui


        onCloseButtonClick();
    }

    @FXML
    protected Button btClose1;

    private void radio() {
        ToggleGroup radioGroup = new ToggleGroup();
        rbNome.setToggleGroup(radioGroup);
        rbParteNome.setToggleGroup(radioGroup);
        rbCNPJ.setToggleGroup(radioGroup);
        rbCPF.setToggleGroup(radioGroup);
    }


    private void buttonColumnAcessar(){
        tcBtAcessar.setCellValueFactory(param-> new ReadOnlyObjectWrapper<>(param.getValue()));
        tcBtAcessar.setCellFactory(param -> new TableCell<Funcionario, Funcionario>(){

            private final Botoes buttonAcessar = new Botoes("#70c3a7");

            @Override
            protected void updateItem(Funcionario funcionario, boolean empty){

                super.updateItem(funcionario,empty);

                if(funcionario == null){
                    setGraphic(null);
                    return;
                }
                setGraphic(buttonAcessar);
                //     buttonAcessar.setOnAction(event ->);
            }
        } );
    }

    private void buttonColumnEdit(){
        tcBtEditar.setCellValueFactory(param-> new ReadOnlyObjectWrapper<>(param.getValue()));
        tcBtEditar.setCellFactory(param -> new TableCell<Funcionario, Funcionario>(){

            private final Botoes editButton = new Botoes("#ecec53");

            @Override
            protected void updateItem(Funcionario funcionario, boolean empty){

                super.updateItem(funcionario,empty);
                if(funcionario == null){
                    setGraphic(null);
                    return;
                }
                setGraphic(editButton);
                //   editButton.setOnAction(event ->);
            }
        } );
    }

    private void buttonColumnExclui(){
        tcBtExcluir.setCellValueFactory(param-> new ReadOnlyObjectWrapper<>(param.getValue()));
        tcBtExcluir.setCellFactory(param -> new TableCell<Funcionario, Funcionario>(){

            private final Botoes excluiButton = new Botoes("#cd5c5c");

            @Override
            protected void updateItem(Funcionario funcionario, boolean empty){

                super.updateItem(funcionario,empty);

                if(funcionario == null){
                    setGraphic(null);
                    return;
                }
                setGraphic(excluiButton);
                //     excluiButton.setOnAction(event->);
            }
        } );
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        radio();
    }
}
