package org.gsnt.auttech.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.gsnt.auttech.TelaPrincipal;

import javax.swing.text.TableView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaPrincipalController implements Initializable {


    @FXML
    protected TitledPane tpAgenda;

//    @FXML
//    protected TableView tvAgenda;

    @FXML
    protected TitledPane tpFuturos;

//    @FXML
//    protected TableView tvFuturos;

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
        loadView("/org/gsnt/auttech/Agenda.fxml");
    }



    @FXML
    protected Button btCliente;

    @FXML
    protected void btClienteButtonClick() {

        loadView("/org/gsnt/auttech/TipoPessoa.fxml");

    }



    @FXML
    protected Button btVeiculo;

    @FXML
    protected void btVeiculoButtonClick() {
        loadView("/org/gsnt/auttech/CadVeiculo.fxml");
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
