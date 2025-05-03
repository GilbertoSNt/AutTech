package org.gsnt.auttech.controller;


import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.gsnt.auttech.db.DbException;
import org.gsnt.auttech.model.dao.service.ClienteService;
import org.gsnt.auttech.model.entities.Cliente;
import org.gsnt.auttech.util.Botoes;
import org.gsnt.auttech.util.Moka;

import java.net.URL;
import java.util.ResourceBundle;

public class ListaClienteController implements Initializable {

    @FXML
    protected TextField txtDado;

    @FXML
    protected Button btPesquisa;

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
    public TableColumn<Cliente, Integer> tcCodigo;

    @FXML
    public TableColumn<Cliente, String> tcNome;

    @FXML
    public TableColumn<Cliente, String > tcApelido;

    @FXML
    protected TableColumn<Cliente, Cliente> tcBtEditar;

    @FXML
    protected TableColumn<Cliente, Cliente> tcBtExcluir;

    @FXML
    protected TableColumn<Cliente, Cliente> tcBtAcessar;

    @FXML
    protected Button buttonNovo;

    @FXML
    protected Button btSelecionar;

    @FXML
    private void onBtSelecionar(){

       // falta seleção aqui


        btCloseButtonClick();
    }

    @FXML
    protected Button btClose1;

    @FXML
    protected Button btClose;

    @FXML
    protected void btCloseButtonClick(){
        Stage stage = (Stage)btClose.getScene().getWindow();
        stage.close();
    }


    private void radio(){
        ToggleGroup radioGroup = new ToggleGroup();
        rbNome.setToggleGroup(radioGroup);
        rbParteNome.setToggleGroup(radioGroup);
        rbCNPJ.setToggleGroup(radioGroup);
        rbCPF.setToggleGroup(radioGroup);

    }

    //implementação da tableview
    protected ClienteService clienteService;

    public void setClienteService(ClienteService cli){
        this.clienteService = cli;
    }

    protected ObservableList<Cliente> obsListCliente;



    public void updateTableView() {
        try {
            if (clienteService == null) {
                throw new IllegalStateException("Cliente estava nulo");
            }

            obsListCliente = FXCollections.observableArrayList(clienteService.findAllTest());
            tableViewListClient.setItems(obsListCliente);
        }catch (Exception a){
            throw new DbException(a.getMessage());
        }
    }

    private void initializeNodes(){

        try {
            tcCodigo.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("cod"));
            tcNome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
            tcApelido.setCellValueFactory(new PropertyValueFactory<Cliente, String>("apelido"));
            buttonColumnEdit();
            buttonColumnAcessar();
            buttonColumnExclui();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        radio();
        initializeNodes();


    }

    private void buttonColumnAcessar(){
        tcBtAcessar.setCellValueFactory(param-> new ReadOnlyObjectWrapper<>(param.getValue()));
        tcBtAcessar.setCellFactory(param -> new TableCell<Cliente, Cliente>(){

            private final Botoes buttonAcessar = new Botoes("#70c3a7");

            @Override
            protected void updateItem(Cliente cliente, boolean empty){

                super.updateItem(cliente,empty);

                if(cliente == null){
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
        tcBtEditar.setCellFactory(param -> new TableCell<Cliente, Cliente>(){

            private final Botoes editButton = new Botoes("#ecec53");

            @Override
            protected void updateItem(Cliente cliente, boolean empty){

                super.updateItem(cliente,empty);
                if(cliente == null){
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
        tcBtExcluir.setCellFactory(param -> new TableCell<Cliente, Cliente>(){

            private final Botoes excluiButton = new Botoes("#cd5c5c");

            @Override
            protected void updateItem(Cliente cliente, boolean empty){

                super.updateItem(cliente,empty);

                if(cliente == null){
                    setGraphic(null);
                    return;
                }
                setGraphic(excluiButton);
           //     excluiButton.setOnAction(event->);
            }
        } );
    }

    public Cliente getClienteSelecionado(){

        Cliente cliente = new Cliente();
        cliente.setCod(tableViewListClient.getSelectionModel().getSelectedItem().getCod());
        cliente.setNome(tableViewListClient.getSelectionModel().getSelectedItem().getNome());
        cliente.setApelido(tableViewListClient.getSelectionModel().getSelectedItem().getApelido());

        return cliente;

    }


}
