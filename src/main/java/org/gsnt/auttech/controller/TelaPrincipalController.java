package org.gsnt.auttech.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.gsnt.auttech.TelaPrincipal;
import org.gsnt.auttech.model.dao.service.ClienteService;
import org.gsnt.auttech.model.entities.Agenda;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class TelaPrincipalController implements Initializable {


    @FXML
    protected TitledPane tpAgenda;

    @FXML
    protected TableView tvAgenda;

    @FXML
    protected TableColumn<Agenda, Date> tcData;

    @FXML
    protected TableColumn<Agenda, Date> tcHora;

    @FXML
    protected TableColumn<Agenda, String> tcPlaca;

    @FXML
    protected TableColumn<Agenda, String> tcNome;

    @FXML
    protected TableColumn<Agenda, String> tcVeiculo;

    @FXML
    protected TableColumn<Agenda, String> tcAssisDes;

    @FXML
    protected TableColumn<Agenda, Boolean> tcSocMec;

    @FXML
    protected TableColumn<Agenda, Boolean> tcSocElet;

    @FXML
    protected TableColumn<Agenda, Boolean> tcGuincho;

    @FXML
    protected TableColumn<Agenda, Boolean> tcBuscar;

    @FXML
    protected TableColumn<Agenda, Boolean> tcSocorro;

    @FXML
    protected TableColumn<Agenda, String> tcStatus;



    // Inicio da table view(Veículo a serem iniciados)

    @FXML
    protected TitledPane tpFuturos;

    @FXML
    protected TableView tvFuturos;

    @FXML
    protected TitledPane tpEmOrcamento;

//    @FXML
//    protected TableView tvEmOrcamento;

    @FXML
    protected TitledPane tpServicos;

//    @FXML
//    protected TableView tvServicos;

    @FXML
    protected TitledPane tpProntos;

//    @FXML
//    protected TableView tvProntos;

    @FXML
    protected Button btClose;

    @FXML
    protected void btCloseButtonClick() {
        System.exit(0);
    }

    @FXML
    protected Button btIconified;

    @FXML
    protected void btIconifiedButtonClick() {
    }

    @FXML
    protected Button btAgenda;

    @FXML
    protected void btAgendaButtonClick() {
        loadView("/org/gsnt/auttech/Agenda.fxml",x->{});
    }

    @FXML
    protected Button btCliente;

    @FXML
    protected void btClienteButtonClick() {
        loadView("/org/gsnt/auttech/TipoPessoa.fxml",x->{});
    }

    @FXML
    protected Button btVeiculo;

    @FXML
    protected void btVeiculoButtonClick() {
        loadView("/org/gsnt/auttech/CadVeiculo.fxml",x->{});
    }

    @FXML
    protected Button btListaClientes;

    @FXML
    protected void btListaClientesButtonClick(){
        try {
            loadView("/org/gsnt/auttech/ListaCliente.fxml", (ListaClienteController cliController) -> {
                cliController.setClienteService(new ClienteService());
                cliController.updateTableView();
            });
        }catch (Exception d){
            System.out.println(d);
        }
    }

    @FXML
    protected Button btCancAgenda;

    @FXML
    protected Button btReceberVeic;

    @FXML
    protected Button btEnvioSocorro;

    @FXML
    protected Button btAbrirOS;

    @FXML
    protected Button btCancOS;

    @FXML
    protected Button btDirTecnico;

    @FXML
    protected Button btAltOrc;

    @FXML
    protected Button btAutrzOrc;

    @FXML
    protected Button btCnclOrc;

    @FXML
    protected Button btAlteraOS;

    @FXML
    protected Button btCncOS;

    @FXML
    protected Button btFnlzServ;

    @FXML
    protected Button btFnlzOS;

    @FXML
    private Accordion accServicos;

    @Override
    public void initialize(URL url, ResourceBundle rB) {

        accServicos.setExpandedPane(tpAgenda);

    }

    private synchronized<T> void loadView(String absoluteName, Consumer<T> inicializingAction) {
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

            T controller = loader.getController();
            inicializingAction.accept(controller);

            stage1.showAndWait();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }




}
